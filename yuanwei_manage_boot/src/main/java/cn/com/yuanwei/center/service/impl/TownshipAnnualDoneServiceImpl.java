package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.CheckMonthVo;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.Township;
import cn.com.yuanwei.center.entity.TownshipAnnualDone;
import cn.com.yuanwei.center.entity.TownshipAnnualDoneExample;
import cn.com.yuanwei.center.entity.TownshipAnnualDoneExample.Criteria;
import cn.com.yuanwei.center.entity.TownshipAnnualDoneVo;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.TownshipAnnualDoneMapper;
import cn.com.yuanwei.center.mapper.TownshipMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.TownshipAnnualDoneService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.TownshipAnnualDoneReq;
import cn.com.yuanwei.center.web.response.TownshipAnnualDoneLtResp;

@Service
@Transactional
public class TownshipAnnualDoneServiceImpl implements TownshipAnnualDoneService {
	@Autowired
	private TownshipAnnualDoneMapper townshipAnnualDoneMapper;
	@Autowired
	private TownshipMapper townshipMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(TownshipAnnualDone townshipAnnualDone) throws Exception {
		
		/**
		 * 计算参数：
		 * year 必须
		 * township 可选
		 * month 系统计算
		 */
		Integer year = townshipAnnualDone.getYear();
		Integer townshipId = townshipAnnualDone.getTownshipId();
		Calendar ca = Calendar.getInstance();
		Integer currMonth = ca.get(Calendar.MONTH)+1;
		Integer month = currMonth;
		UserInfo userInfo = LoginUserThread.getUser();
		Integer createBy = userInfo.getId();
		Date createTime = ca.getTime();
		
		//校验年度任务
		Integer count = townshipAnnualDoneMapper.selectCountAnnualTask(year);
		if(!ValidateUtil.isEmpty(count)&&count.compareTo(0)>0){
			throw new Exception(count+"个乡镇没有年度任务信息");
		}
		//校验导入统计局社消零数据
		CheckMonthVo vo = townshipAnnualDoneMapper.selectCountRealReport(year);
		if(!ValidateUtil.isEmpty(vo)){
			Integer months = vo.getMonths();
			Integer maxMath = vo.getMaxMonth();
			if(months.compareTo(0)==0){
				throw new Exception("未获取到导入统计局社消零数据");
			}
			if(months.compareTo(maxMath-1)!=0){
				throw new Exception("考核时间段社消零数据不完整");
			}
			month = maxMath;
		}
		
		//清除同年的考核数据
		List<Township> townships = townshipMapper.selectByExample(null);
		List<Integer> ids = new ArrayList<Integer>();
		for (Township township : townships) {
			ids.add(township.getId());
		}
		TownshipAnnualDoneExample example = new TownshipAnnualDoneExample();
		example.createCriteria().andTownshipIdIn(ids).andYearEqualTo(year);
		townshipAnnualDoneMapper.deleteByExample(example);
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("year", year);
		param.put("townshipId", townshipId);
		param.put("month", month);
		//获取当前年度的汇总数据
		List<TownshipAnnualDoneVo> list = townshipAnnualDoneMapper.selectTownshipAnnualDoneList(param);
		if(ValidateUtil.isEmpty(list)){
			throw new Exception("未获取到导入统计局社消零数据");
		}
		//获取上年同期的汇总数据
		param.put("year", year-1);
		List<TownshipAnnualDoneVo> preList = townshipAnnualDoneMapper.selectTownshipAnnualDoneList(param);
		if(ValidateUtil.isEmpty(preList)){
			throw new Exception("未获取到同期导入统计局社消零数据");
		}
		//构造镇乡年度任务完成情况列表
		List<TownshipAnnualDone> doneList = new ArrayList<TownshipAnnualDone>();
		BigDecimal zero = new BigDecimal("0");
		BigDecimal one = new BigDecimal("1");
		BigDecimal hundred = new BigDecimal("100");
		for (TownshipAnnualDoneVo doneVo : list) {
			Integer townId = doneVo.getTownshipId();
			BigDecimal totalTask = new BigDecimal(doneVo.getTotalTask().toString());
			BigDecimal addTask = new BigDecimal(doneVo.getAddTask().toString());
			BigDecimal realAdd = new BigDecimal(doneVo.getRealAdd().toString());
			BigDecimal totalApply = new BigDecimal(doneVo.getTotalApply().toString());
			BigDecimal retailSalesDone = doneVo.getRetailSalesDone();
			BigDecimal salesDone = doneVo.getSalesDone();
			//初始化并设置完成总量
			TownshipAnnualDone done = new TownshipAnnualDone(doneVo);
			BeanUtils.copyProperties(doneVo, done);
			done.setYear(year);
			//计算销售额、零售额的增速及综合增速；
			for (TownshipAnnualDoneVo preDoneVo : preList) {
				done.setRetailSalesGrowth(zero);
				done.setSalesGrowth(zero);
				done.setOverallGrowth(zero);
				if(townId.compareTo(preDoneVo.getTownshipId())==0){
					BigDecimal preRetailSalesDone = new BigDecimal(preDoneVo.getRetailSalesDone().toString());
					BigDecimal preSalesDone = new BigDecimal(preDoneVo.getSalesDone().toString());
					BigDecimal retailSalesGrowth = retailSalesDone.divide(preRetailSalesDone,4,BigDecimal.ROUND_HALF_UP).subtract(one);
					BigDecimal salesGrowth = salesDone.divide(preSalesDone,4,BigDecimal.ROUND_HALF_UP).subtract(one);
					done.setRetailSalesGrowth(retailSalesGrowth.multiply(hundred));
					done.setSalesGrowth(salesGrowth.multiply(hundred));
					//综合增速 辖内增速＝限上企业零售额增速*0.6+限上企业销售额增速*0.4
					BigDecimal overallGrowth = retailSalesGrowth.multiply(new BigDecimal("0.6")).add(salesGrowth.multiply(new BigDecimal("0.4"))).setScale(4, BigDecimal.ROUND_HALF_UP);
					done.setOverallGrowth(overallGrowth.multiply(hundred));
					break;
				}
			}
			//完成进度=(限上企业零售额+限上企业销售额)/总目标额
			BigDecimal doneRatio = retailSalesDone.add(salesDone).divide(totalTask,4,BigDecimal.ROUND_HALF_UP);
			done.setDoneRatio(doneRatio);
			//入库得分 实际得分＝(实际入库数/任务数)*60+(实际申报数/任务数)*40+(超额完成数*20)
			BigDecimal overfulfilledAdd = new BigDecimal("0");
			if(realAdd.compareTo(addTask)>0){
				overfulfilledAdd = realAdd.subtract(addTask);
			}
			BigDecimal addScore = realAdd.divide(addTask,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("60")).add(totalApply.divide(addTask,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("40"))).add(overfulfilledAdd.multiply(new BigDecimal("20")));
			done.setOverfulfilledAdd(overfulfilledAdd.intValue());
			done.setAddScore(addScore.intValue());
			doneList.add(done);
		}
		if(doneList.size()==0){
			throw new Exception("未获取到相关数据，考核失败");
		}
		/**
		 * 对任务完成情况列表排序、计算排位、排位得分
		 */
		for (int i = 0; i < 4; i++) {
			sortList(doneList, i);
			calcQualifying(doneList, i);
			calcPoint(doneList, i);
		}
		
		//计算总得分
		for (TownshipAnnualDone done : doneList) {
			Integer totalPoint = done.getGrossPoint()+done.getTaskPoint()+done.getGrowthPoint()+done.getAddPoint();
			done.setTotalPoint(totalPoint);
		}
		//保存数据
		for (TownshipAnnualDone done : doneList) {
			done.setCreateBy(createBy);
			done.setCreateTime(createTime);
			done.setTownshipName(townshipMapper.selectByPrimaryKey(done.getTownshipId()).getName());
			townshipAnnualDoneMapper.insertSelective(done);
		}
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(), "新增镇乡年度考核信息"));
		return doneList.size();
	}

	@Override
	public Integer update(TownshipAnnualDone townshipAnnualDone) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(), "更新镇乡年度考核信息"));
		return townshipAnnualDoneMapper.updateByPrimaryKey(townshipAnnualDone);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除镇乡年度考核信息"));
		}
		TownshipAnnualDoneExample example = new TownshipAnnualDoneExample();
		example.createCriteria().andIdIn(ids);
		return townshipAnnualDoneMapper.deleteByExample(example);
	}
	
	@Override
	public TownshipAnnualDone queryById(Integer id){
		return townshipAnnualDoneMapper.selectByPrimaryKey(id);
	}
	@Override
	public TownshipAnnualDoneLtResp queryList(TownshipAnnualDoneReq req) throws Exception {
		Integer id = req.getId();
		Integer townshipId = req.getTownshipId();
		String townshipName = req.getTownshipName();
		Integer year = req.getYear();
		BigDecimal retailSalesDone = req.getRetailSalesDone();
		BigDecimal salesDone = req.getSalesDone();
		BigDecimal grossDone = req.getGrossDone();
		BigDecimal doneRatio = req.getDoneRatio();
		BigDecimal retailSalesGrowth = req.getRetailSalesGrowth();
		BigDecimal salesGrowth = req.getSalesGrowth();
		BigDecimal overallGrowth = req.getOverallGrowth();
		Integer totalApply = req.getTotalApply();
		Integer realAdd = req.getRealAdd();
		Integer overfulfilledAdd = req.getOverfulfilledAdd();
		Integer addScore = req.getAddScore();
		Integer grossQualifying = req.getGrossQualifying();
		Integer progressQualifying = req.getProgressQualifying();
		Integer growthQualifying = req.getGrowthQualifying();
		Integer addQualifying = req.getAddQualifying();
		Integer grossPoint = req.getGrossPoint();
		Integer growthPoint = req.getGrowthPoint();
		Integer taskPoint = req.getTaskPoint();
		BigDecimal perPointValue = req.getPerPointValue();
		BigDecimal allowance = req.getAllowance();
		Integer addPoint = req.getAddPoint();
		Integer totalPoint = req.getTotalPoint();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		TownshipAnnualDoneExample example = new TownshipAnnualDoneExample();
		example.setOrderByClause(" year desc,total_point desc");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(townshipId)){
			c.andTownshipIdEqualTo(townshipId);
		}
		if(!ValidateUtil.isEmpty(townshipName)){
			c.andTownshipNameLike("%"+townshipName+"%");
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(retailSalesDone)){
			c.andRetailSalesDoneEqualTo(retailSalesDone);
		}
		if(!ValidateUtil.isEmpty(salesDone)){
			c.andSalesDoneEqualTo(salesDone);
		}
		if(!ValidateUtil.isEmpty(grossDone)){
			c.andGrossDoneEqualTo(grossDone);
		}
		if(!ValidateUtil.isEmpty(doneRatio)){
			c.andDoneRatioEqualTo(doneRatio);
		}
		if(!ValidateUtil.isEmpty(retailSalesGrowth)){
			c.andRetailSalesGrowthEqualTo(retailSalesGrowth);
		}
		if(!ValidateUtil.isEmpty(salesGrowth)){
			c.andSalesGrowthEqualTo(salesGrowth);
		}
		if(!ValidateUtil.isEmpty(overallGrowth)){
			c.andOverallGrowthEqualTo(overallGrowth);
		}
		if(!ValidateUtil.isEmpty(totalApply)){
			c.andTotalApplyEqualTo(totalApply);
		}
		if(!ValidateUtil.isEmpty(realAdd)){
			c.andRealAddEqualTo(realAdd);
		}
		if(!ValidateUtil.isEmpty(overfulfilledAdd)){
			c.andOverfulfilledAddEqualTo(overfulfilledAdd);
		}
		if(!ValidateUtil.isEmpty(addScore)){
			c.andAddScoreEqualTo(addScore);
		}
		if(!ValidateUtil.isEmpty(grossQualifying)){
			c.andGrossQualifyingEqualTo(grossQualifying);
		}
		if(!ValidateUtil.isEmpty(progressQualifying)){
			c.andProgressQualifyingEqualTo(progressQualifying);
		}
		if(!ValidateUtil.isEmpty(growthQualifying)){
			c.andGrowthQualifyingEqualTo(growthQualifying);
		}
		if(!ValidateUtil.isEmpty(addQualifying)){
			c.andAddQualifyingEqualTo(addQualifying);
		}
		if(!ValidateUtil.isEmpty(grossPoint)){
			c.andGrossPointEqualTo(grossPoint);
		}
		if(!ValidateUtil.isEmpty(growthPoint)){
			c.andGrowthPointEqualTo(growthPoint);
		}
		if(!ValidateUtil.isEmpty(taskPoint)){
			c.andTaskPointEqualTo(taskPoint);
		}
		if(!ValidateUtil.isEmpty(perPointValue)){
			c.andPerPointValueEqualTo(perPointValue);
		}
		if(!ValidateUtil.isEmpty(allowance)){
			c.andAllowanceEqualTo(allowance);
		}
		if(!ValidateUtil.isEmpty(addPoint)){
			c.andAddPointEqualTo(addPoint);
		}
		if(!ValidateUtil.isEmpty(totalPoint)){
			c.andTotalPointEqualTo(totalPoint);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<TownshipAnnualDone> page = (Page<TownshipAnnualDone>) townshipAnnualDoneMapper.selectByExample(example);
		TownshipAnnualDoneLtResp resp = new TownshipAnnualDoneLtResp();
		resp.setCount(page.getTotal());
		resp.setTownshipAnnualDoneLt(page.getResult());
		return resp;
	}
	
	/**
	 * 按指定字段计算排位得分
	 * @param sortedList
	 * @param pointBy 0:完成总量 1:完成进度 2:综合增速 3: 入库得分
	 */
	private static void calcPoint(List<TownshipAnnualDone> sortedList,int pointBy) {
		TownshipAnnualDone lastDone = sortedList.get(sortedList.size()-1);
		if(pointBy == 0){
			Integer maxQualifying = lastDone.getGrossQualifying();
			for (TownshipAnnualDone done : sortedList) {
				done.setGrossPoint(maxQualifying-done.getGrossQualifying()+1);
			}
		}else if(pointBy == 1){
			Integer maxQualifying = lastDone.getProgressQualifying();
			for (TownshipAnnualDone done : sortedList) {
				done.setTaskPoint(maxQualifying-done.getProgressQualifying()+1);
			}
		}else if(pointBy == 2){
			Integer maxQualifying = lastDone.getGrowthQualifying();
			for (TownshipAnnualDone done : sortedList) {
				done.setGrowthPoint(maxQualifying-done.getGrowthQualifying()+1);
			}
		}else{
			Integer maxQualifying = lastDone.getAddQualifying();
			for (TownshipAnnualDone done : sortedList) {
				done.setAddPoint(maxQualifying-done.getAddQualifying()+1);
			}
		}
	}

	/**
	 * 按指定字段计算排位
	 * @param sortedList
	 * @param qualifyingBy 0:完成总量 1:完成进度 2:综合增速 3: 入库得分
	 */
	private static void calcQualifying(List<TownshipAnnualDone> sortedList,int qualifyingBy) {
		int index = 1;
		TownshipAnnualDone curr = sortedList.get(0);
		for (int i = 1; i < sortedList.size(); i++) {
			TownshipAnnualDone next = sortedList.get(i);
			if (qualifyingBy == 0) {
				if(i==1){
					curr.setGrossQualifying(1);
				}
				if(next.getGrossDone().compareTo(curr.getGrossDone())==0){
					next.setGrossQualifying(index);
				}else{
					next.setGrossQualifying(++index);
				}
			} else if(qualifyingBy == 1) {
				if(i==1){
					curr.setProgressQualifying(1);
				}
				if(next.getDoneRatio().compareTo(curr.getDoneRatio())==0){
					next.setProgressQualifying(index);
				}else{
					next.setProgressQualifying(++index);
				}
			}else if(qualifyingBy == 2){
				if(i==1){
					curr.setGrowthQualifying(1);
				}
				if(next.getOverallGrowth().compareTo(curr.getOverallGrowth())==0){
					next.setGrowthQualifying(index);
				}else{
					next.setGrowthQualifying(++index);
				}
			}else{
				if(i==1){
					curr.setAddQualifying(1);
				}
				if(next.getRealAdd().compareTo(curr.getRealAdd())==0){
					next.setAddQualifying(index);
				}else{
					next.setAddQualifying(++index);
				}
			}
			curr = sortedList.get(i);
		}
	}

	/**
	 * 按指定字段降序排序
	 * @param list
	 * @param sortBy 0:完成总量 1:完成进度 2:综合增速 3: 入库得分
	 */
	private static void sortList(List<TownshipAnnualDone> list,final int sortBy) {
		Collections.sort(list, new Comparator<TownshipAnnualDone>() {
			@Override
			public int compare(TownshipAnnualDone o1, TownshipAnnualDone o2) {
				if(sortBy == 0){
					return o2.getGrossDone().compareTo(o1.getGrossDone());
				}else if(sortBy == 1){
					return o2.getDoneRatio().compareTo(o1.getDoneRatio());
				}else if(sortBy == 2){
					return o2.getOverallGrowth().compareTo(o1.getOverallGrowth());
				}else{
					return o2.getRealAdd().compareTo(o1.getRealAdd());
				}
			}			
		});
	}
	
}
