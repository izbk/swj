package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.CheckMonthVo;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.StatisticianAssessment;
import cn.com.yuanwei.center.entity.StatisticianAssessmentExample;
import cn.com.yuanwei.center.entity.StatisticianAssessmentExample.Criteria;
import cn.com.yuanwei.center.entity.StatisticianRangeRules;
import cn.com.yuanwei.center.entity.StatisticianRangeRulesExample;
import cn.com.yuanwei.center.entity.StatisticianReward;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.StatisticianAssessmentMapper;
import cn.com.yuanwei.center.mapper.StatisticianRangeRulesMapper;
import cn.com.yuanwei.center.mapper.StatisticianRewardMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.StatisticianAssessmentService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.StatisticianAssessmentReq;
import cn.com.yuanwei.center.web.response.StatisticianAssessmentLtResp;

@Service
@Transactional
public class StatisticianAssessmentServiceImpl implements StatisticianAssessmentService {
	@Autowired
	private StatisticianAssessmentMapper statisticianAssessmentMapper;
	@Autowired
	private StatisticianRangeRulesMapper statisticianRangeRulesMapper;
	@Autowired
	private StatisticianRewardMapper statisticianRewardMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(StatisticianAssessmentReq req) throws Exception {
		/**
		 * 计算参数：
		 */
		Calendar ca = Calendar.getInstance();
		Date startDate = req.getStartDate();
		Date endDate = req.getEndDate();
		BigDecimal amount = req.getAmount();
		UserInfo userInfo = LoginUserThread.getUser();
		Integer createBy = userInfo.getId();
		Date createTime = ca.getTime();
		
		Map<String,Object> param = new HashMap<String,Object>();
		
		ca.setTime(startDate);
		Integer year = ca.get(Calendar.YEAR);
	    Integer startMonth = ca.get(Calendar.MONTH)+1;
		param.put("startMonth", startMonth);
		ca.setTime(endDate);
		Integer endMonth = ca.get(Calendar.MONTH)+1;
		param.put("endMonth", endMonth);
		param.put("year", year);
	
		CheckMonthVo vo = statisticianAssessmentMapper.selectCountRealReportByMonth(param);
		if(!ValidateUtil.isEmpty(vo)){
			Integer months = vo.getMonths();
			Integer maxMath = endMonth-startMonth+1;
			if(months.compareTo(0)==0){
				throw new Exception("未获取到导入统计局社消零数据");
			}
			if(startMonth == 1){
				if(months.compareTo(maxMath-1)!=0){
					throw new Exception("导入统计局社消零数据不完整");
				}
			}else{
				if(months.compareTo(maxMath)!=0){
					throw new Exception("导入统计局社消零数据不完整");
				}
			}

			param.put("endMonth", maxMath);
		}
		
		//获取数据直报得分
		List<StatisticianAssessment> reportPoints = statisticianAssessmentMapper.selectReportPointDoneList(param);
		if(ValidateUtil.isEmpty(reportPoints)){
			throw new Exception("未获取到月报打分数据");
		}
		//获取当前年度企业数据
		List<StatisticianAssessment> list = statisticianAssessmentMapper.selectStatisticianDoneList(param);
		if(ValidateUtil.isEmpty(list)){
			throw new Exception("未获取到导入统计局社消零数据");
		}
		//获取去年同期企业数据
		param.put("year", year-1);
		List<StatisticianAssessment> preList = statisticianAssessmentMapper.selectStatisticianDoneList(param);
		if(ValidateUtil.isEmpty(preList)){
			throw new Exception("未获取到同期导入统计局社消零数据");
		}
		
		//按企业计算增速
		BigDecimal one = new BigDecimal("1");
		for (StatisticianAssessment sa : list) {
			//设置创建人、创建时间、开始时期、结束日期
			sa.setStartDate(startDate);
			sa.setEndDate(endDate);
			sa.setCreateBy(createBy);
			sa.setCreateTime(createTime);
			
			Integer userId = sa.getUserId();
			String enterpriseCode = sa.getEnterpriseCode();
			BigDecimal salesDone = sa.getSalesDone();
			BigDecimal retailSalesDone = sa.getRetailSalesDone();
			for (StatisticianAssessment pre : preList) {
				if(userId.compareTo(pre.getUserId())==0&&enterpriseCode.equals(pre.getEnterpriseCode())){
					BigDecimal preSalesDone = pre.getSalesDone();
					BigDecimal preRetailSalesDone = pre.getRetailSalesDone();
					BigDecimal saleCompareRatio = salesDone.divide(preSalesDone).subtract(one).setScale(4,BigDecimal.ROUND_HALF_UP);
					BigDecimal retailCompareRatio = retailSalesDone.divide(preRetailSalesDone).subtract(one).setScale(4,BigDecimal.ROUND_HALF_UP);
					//设置数据增速
					sa.setSaleCompareRatio(saleCompareRatio);
					sa.setRetailCompareRatio(retailCompareRatio);
				}
			}
			//设置直报数据得分
			for (StatisticianAssessment point : reportPoints) {
				sa.setReportPoint(0);//设置初始值
				if(userId.compareTo(point.getUserId())==0&&enterpriseCode.equals(point.getEnterpriseCode())){
					sa.setReportPoint(point.getReportPoint());
				}
			}
		}
		
		StatisticianRangeRulesExample example = new StatisticianRangeRulesExample();
		example.createCriteria().andRangeTypeEqualTo(0);
		List<StatisticianRangeRules> amountRanges = statisticianRangeRulesMapper.selectByExample(example);
		example.clear();
		example.createCriteria().andRangeTypeEqualTo(1);
		List<StatisticianRangeRules> growthRanges = statisticianRangeRulesMapper.selectByExample(example);
		//按企业计算销售、零售总额及增幅得分
		for (int i = 0; i < 4; i++) {
			if(i < 2){
				calcPoint(list, amountRanges, i);
			}else{
				calcPoint(list, growthRanges, i);
			}
		}
		//按企业计算排位得分、总得分
		BigDecimal pointSix = new BigDecimal("0.6");
		BigDecimal pointfour = new BigDecimal("0.4");
		BigDecimal retailSalesPoint,salesPoint,retailGrowthPoint,salesGrowthPoint,qualifyingPoint,reportPoint,totalPoint;
		BigDecimal allTotalPoint = new BigDecimal("0");
		for (StatisticianAssessment sa : list) {
			retailSalesPoint = new BigDecimal(sa.getRetailSalesPoint().toString());
			salesPoint = new BigDecimal(sa.getSalesPoint().toString());
			retailGrowthPoint = new BigDecimal(sa.getRetailGrowthPoint().toString());
			salesGrowthPoint = new BigDecimal(sa.getSalesGrowthPoint().toString());
			reportPoint = new BigDecimal(sa.getReportPoint().toString());
			qualifyingPoint = retailSalesPoint.multiply(pointSix).add(salesPoint.multiply(pointfour));
			totalPoint = retailSalesPoint.add(retailGrowthPoint).add(salesGrowthPoint).add(qualifyingPoint).add(reportPoint);
			sa.setQualifyingPoint(qualifyingPoint.intValue());
			sa.setTotalPoint(totalPoint.intValue());
			//计算本次考核总得分
			allTotalPoint = allTotalPoint.add(totalPoint);
		}
		//计算单位分值金额
		BigDecimal perPointValue = null;
		if(!ValidateUtil.isEmpty(amount)&&amount.compareTo(new BigDecimal("0"))>0){
			perPointValue = amount.divide(allTotalPoint, 2, BigDecimal.ROUND_HALF_UP);
		}else{
			amount = new BigDecimal("0");
		}
		//生成统计员补助金额信息
		StatisticianReward reward = new StatisticianReward();
		reward.setTotalPoint(allTotalPoint.intValue());
		reward.setAmount(amount);
		reward.setPerPointValue(perPointValue);
		reward.setYear(year);
		reward.setStartDate(startDate);
		reward.setEndDate(endDate);
		reward.setCreateBy(createBy);
		reward.setCreateTime(createTime);
		statisticianRewardMapper.insertSelective(reward);
		Integer rewardId = reward.getId();
		
		//保存考核数据
		for (StatisticianAssessment sa : list) {
			if(!ValidateUtil.isEmpty(perPointValue)){
				sa.setPerPointValue(perPointValue);
				sa.setAllowance(perPointValue.multiply(new BigDecimal(sa.getTotalPoint().toString())));
			}
			sa.setRewardId(rewardId);
			statisticianAssessmentMapper.insertSelective(sa);
		}
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),rewardId, "新增统计员任务考核"));
		return list.size();
	}

	@Override
	public Integer update(StatisticianAssessment statisticianAssessment) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),statisticianAssessment.getId(), "更新统计员任务考核"));
		return statisticianAssessmentMapper.updateByPrimaryKey(statisticianAssessment);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除统计员任务考核"));
		}
		StatisticianAssessmentExample example = new StatisticianAssessmentExample();
		example.createCriteria().andIdIn(ids);
		return statisticianAssessmentMapper.deleteByExample(example);
	}
	
	@Override
	public StatisticianAssessment queryById(Integer id){
		return statisticianAssessmentMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public StatisticianAssessmentLtResp queryList(StatisticianAssessmentReq req) throws Exception {
		Integer id = req.getId();
		Integer year = req.getYear();
		Date startDate = req.getStartDate();
		Date endDate = req.getEndDate();
		String enterpriseCode = req.getEnterpriseCode();
		String enterpriseName = req.getEnterpriseName();
		Integer userId = req.getUserId();
		String statisticianName = req.getStatisticianName();
		BigDecimal retailSalesDone = req.getRetailSalesDone();
		BigDecimal salesDone = req.getSalesDone();
		Integer retailSalesPoint = req.getRetailSalesPoint();
		Integer salesPoint = req.getSalesPoint();
		Integer qualifyingPoint = req.getQualifyingPoint();
		BigDecimal retailCompareRatio = req.getRetailCompareRatio();
		BigDecimal saleCompareRatio = req.getSaleCompareRatio();
		Integer retailGrowthPoint = req.getRetailGrowthPoint();
		Integer salesGrowthPoint = req.getSalesGrowthPoint();
		Integer growthPoint = req.getGrowthPoint();
		Integer reportPoint = req.getReportPoint();
		Integer totalPoint = req.getTotalPoint();
		BigDecimal perPointValue = req.getPerPointValue();
		BigDecimal allowance = req.getAllowance();
		Date createTime = req.getCreateTime();
		Integer createBy = req.getCreateBy();
		StatisticianAssessmentExample example = new StatisticianAssessmentExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(startDate)){
			c.andStartDateEqualTo(startDate);
		}
		if(!ValidateUtil.isEmpty(endDate)){
			c.andEndDateEqualTo(endDate);
		}
		if(!ValidateUtil.isEmpty(enterpriseCode)){
			c.andEnterpriseCodeEqualTo(enterpriseCode);
		}
		if(!ValidateUtil.isEmpty(enterpriseName)){
			c.andEnterpriseNameLike("%"+enterpriseName+"%");
		}
		if(!ValidateUtil.isEmpty(userId)){
			c.andUserIdEqualTo(userId);
		}
		if(!ValidateUtil.isEmpty(statisticianName)){
			c.andStatisticianNameLike("%"+statisticianName+"%");
		}
		if(!ValidateUtil.isEmpty(retailSalesDone)){
			c.andRetailSalesDoneEqualTo(retailSalesDone);
		}
		if(!ValidateUtil.isEmpty(salesDone)){
			c.andSalesDoneEqualTo(salesDone);
		}
		if(!ValidateUtil.isEmpty(retailSalesPoint)){
			c.andRetailSalesPointEqualTo(retailSalesPoint);
		}
		if(!ValidateUtil.isEmpty(salesPoint)){
			c.andSalesPointEqualTo(salesPoint);
		}
		if(!ValidateUtil.isEmpty(qualifyingPoint)){
			c.andQualifyingPointEqualTo(qualifyingPoint);
		}
		if(!ValidateUtil.isEmpty(retailCompareRatio)){
			c.andRetailCompareRatioEqualTo(retailCompareRatio);
		}
		if(!ValidateUtil.isEmpty(saleCompareRatio)){
			c.andSaleCompareRatioEqualTo(saleCompareRatio);
		}
		if(!ValidateUtil.isEmpty(retailGrowthPoint)){
			c.andRetailGrowthPointEqualTo(retailGrowthPoint);
		}
		if(!ValidateUtil.isEmpty(salesGrowthPoint)){
			c.andSalesGrowthPointEqualTo(salesGrowthPoint);
		}
		if(!ValidateUtil.isEmpty(growthPoint)){
			c.andGrowthPointEqualTo(growthPoint);
		}
		if(!ValidateUtil.isEmpty(reportPoint)){
			c.andReportPointEqualTo(reportPoint);
		}
		if(!ValidateUtil.isEmpty(totalPoint)){
			c.andTotalPointEqualTo(totalPoint);
		}
		if(!ValidateUtil.isEmpty(perPointValue)){
			c.andPerPointValueEqualTo(perPointValue);
		}
		if(!ValidateUtil.isEmpty(allowance)){
			c.andAllowanceEqualTo(allowance);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<StatisticianAssessment> page = (Page<StatisticianAssessment>) statisticianAssessmentMapper.selectByExample(example);
		StatisticianAssessmentLtResp resp = new StatisticianAssessmentLtResp();
		resp.setCount(page.getTotal());
		resp.setStatisticianAssessmentLt(page.getResult());
		return resp;
	}
	
	/**
	 * 按指定字段计算排位得分
	 * @param list
	 * @param pointBy 0:零售额 1:销售额 2:零售增幅 3: 销售增幅
	 */
	private static void calcPoint(List<StatisticianAssessment> list,List<StatisticianRangeRules> ranges,int pointBy) {
		if(pointBy == 0){
			for (StatisticianAssessment done : list) {
				BigDecimal retailSalesDone = done.getRetailSalesDone();
				done.setRetailSalesPoint(0);
				for (StatisticianRangeRules range : ranges) {
					if(retailSalesDone.compareTo(range.getMinValue())>=0 && retailSalesDone.compareTo(range.getMaxValue())<=0){
						done.setRetailSalesPoint(range.getPoint());
						break;
					}
				}
			}
		}else if(pointBy == 1){
			for (StatisticianAssessment done : list) {
				BigDecimal salesDone = done.getSalesDone();
				done.setSalesPoint(0);
				for (StatisticianRangeRules range : ranges) {
					if(salesDone.compareTo(range.getMinValue())>=0 && salesDone.compareTo(range.getMaxValue())<=0){
						done.setSalesPoint(range.getPoint());
						break;
					}
				}
			}
		}else if(pointBy == 2){
			for (StatisticianAssessment done : list) {
				BigDecimal retailCompareRatio = done.getRetailCompareRatio();
				done.setRetailGrowthPoint(0);
				for (StatisticianRangeRules range : ranges) {
					if(retailCompareRatio.compareTo(range.getMinValue())>=0 && retailCompareRatio.compareTo(range.getMaxValue())<=0){
						done.setRetailGrowthPoint(range.getPoint());
						break;
					}
				}
			}
		}else{
			for (StatisticianAssessment done : list) {
				BigDecimal saleCompareRatio = done.getSaleCompareRatio();
				done.setSalesGrowthPoint(0);
				for (StatisticianRangeRules range : ranges) {
					if(saleCompareRatio.compareTo(range.getMinValue())>=0 && saleCompareRatio.compareTo(range.getMaxValue())<=0){
						done.setSalesGrowthPoint(range.getPoint());
						break;
					}
				}
			}
		}
	}
	
}
