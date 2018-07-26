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
import cn.com.yuanwei.center.entity.StatisticianRangeRules;
import cn.com.yuanwei.center.entity.StatisticianRangeRulesExample;
import cn.com.yuanwei.center.entity.StatisticianReward;
import cn.com.yuanwei.center.entity.StatisticianRewardExample;
import cn.com.yuanwei.center.entity.StatisticianRewardExample.Criteria;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.StatisticianAssessmentMapper;
import cn.com.yuanwei.center.mapper.StatisticianRangeRulesMapper;
import cn.com.yuanwei.center.mapper.StatisticianRewardMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.StatisticianRewardService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.StatisticianRewardReq;
import cn.com.yuanwei.center.web.response.StatisticianRewardLtResp;

@Service
@Transactional
public class StatisticianRewardServiceImpl implements StatisticianRewardService {
	@Autowired
	private StatisticianRewardMapper statisticianRewardMapper;
	@Autowired
	private StatisticianRangeRulesMapper statisticianRangeRulesMapper;
	@Autowired
	private StatisticianAssessmentMapper statisticianAssessmentMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;	 
	
	@Override
	public Integer save(StatisticianReward statisticianReward) throws Exception {
		/**
		 * 计算参数：
		 */
		Calendar ca = Calendar.getInstance();
		Date startDate = statisticianReward.getStartDate();
		Date endDate = statisticianReward.getEndDate();
		BigDecimal amount = statisticianReward.getAmount();
		UserInfo userInfo = LoginUserThread.getUser();
		Integer createBy = userInfo.getId();
		Date createTime = ca.getTime();
		
		Map<String,Object> param = new HashMap<String,Object>();
		
		ca.setTime(startDate);
		Integer year = ca.get(Calendar.YEAR);
		Integer startMonth = ca.get(Calendar.MONTH)+1;
		ca.setTime(endDate);
		Integer endMonth = ca.get(Calendar.MONTH)+1;
		param.put("startMonth", startMonth);
		param.put("endMonth", endMonth);
		param.put("year", year);
	
		StatisticianRewardExample rewardExample = new StatisticianRewardExample();
		rewardExample.createCriteria().andYearEqualTo(year).andStartDateEqualTo(startDate).andEndDateEqualTo(endDate);
		List<StatisticianReward> rewards = statisticianRewardMapper.selectByExample(rewardExample);
		if(!ValidateUtil.isEmpty(rewards)){
			throw new Exception("相同时间段的考核数据已存在");
		}
		
		CheckMonthVo vo = statisticianAssessmentMapper.selectCountRealReportByMonth(param);
		if(!ValidateUtil.isEmpty(vo)){
			Integer months = vo.getMonths();
			Integer maxMonth = vo.getMaxMonth();
			Integer requiredMonth = endMonth-startMonth+1;
			if(months.compareTo(0)==0){
				throw new Exception("未获取到导入统计局社消零数据");
			}
			if(startMonth == 1){
				if(months.compareTo(requiredMonth-1)!=0){
					throw new Exception("考核时间段社消零数据不完整");
				}
			}else if(months.compareTo(requiredMonth)!=0){
				throw new Exception("考核时间段社消零数据不完整");
			}
			param.put("endMonth", maxMonth);
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
		BigDecimal zero = new BigDecimal("0");
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
					BigDecimal saleCompareRatio = zero;
					BigDecimal retailCompareRatio = zero;
					if(preSalesDone.compareTo(zero)>0){
						saleCompareRatio = salesDone.divide(preSalesDone,4,BigDecimal.ROUND_HALF_UP).subtract(one);
					}
					if(preRetailSalesDone.compareTo(zero)>0){
						retailCompareRatio = retailSalesDone.divide(preRetailSalesDone,4,BigDecimal.ROUND_HALF_UP).subtract(one);
					}
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
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),rewardId, "新增统计员考核"));
		return list.size();
	}

	@Override
	public Integer update(StatisticianReward statisticianReward) throws Exception {
		BigDecimal amount = statisticianReward.getAmount();
		if(ValidateUtil.isEmpty(amount)){
			throw new Exception("数据错误");
		}
		StatisticianReward sr = statisticianRewardMapper.selectByPrimaryKey(statisticianReward.getId());
		if(amount.compareTo(sr.getAmount()) != 0){
			//计算单位分值金额
			BigDecimal totalPoint = new BigDecimal(sr.getTotalPoint());
			BigDecimal perPointValue = amount.divide(totalPoint, 4, BigDecimal.ROUND_HALF_UP);
			statisticianReward.setPerPointValue(perPointValue);
			
			StatisticianAssessmentExample example = new StatisticianAssessmentExample();
			example.createCriteria().andRewardIdEqualTo(statisticianReward.getId());
			List<StatisticianAssessment> list = statisticianAssessmentMapper.selectByExample(example);
			//更新考核数据
			for (StatisticianAssessment sa : list) {
				sa.setPerPointValue(perPointValue);
				sa.setAllowance(perPointValue.multiply(new BigDecimal(sa.getTotalPoint().toString())));
				statisticianAssessmentMapper.updateByPrimaryKeySelective(sa);
			}
		}
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(), statisticianReward.getId(), "修改统计员考核"));
		return statisticianRewardMapper.updateByPrimaryKey(statisticianReward);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		StatisticianAssessmentExample saExample = new StatisticianAssessmentExample();
		saExample.createCriteria().andRewardIdIn(ids);
		statisticianAssessmentMapper.deleteByExample(saExample);
		
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除统计员考核"));
		}
		
		StatisticianRewardExample example = new StatisticianRewardExample();
		example.createCriteria().andIdIn(ids);
		return statisticianRewardMapper.deleteByExample(example);
	}
	
	@Override
	public StatisticianReward queryById(Integer id){
		return statisticianRewardMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public StatisticianRewardLtResp queryList(StatisticianRewardReq req) throws Exception {
		Integer id = req.getId();
		Integer year = req.getYear();
		Date startDate = req.getStartDate();
		Date endDate = req.getEndDate();
		BigDecimal amount = req.getAmount();
		Integer totalPoint = req.getTotalPoint();
		BigDecimal perPointValue = req.getPerPointValue();
		Date createTime = req.getCreateTime();
		Integer createBy = req.getCreateBy();
		StatisticianRewardExample example = new StatisticianRewardExample();
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
		if(!ValidateUtil.isEmpty(amount)){
			c.andAmountEqualTo(amount);
		}
		if(!ValidateUtil.isEmpty(totalPoint)){
			c.andTotalPointEqualTo(totalPoint);
		}
		if(!ValidateUtil.isEmpty(perPointValue)){
			c.andPerPointValueEqualTo(perPointValue);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<StatisticianReward> page = (Page<StatisticianReward>) statisticianRewardMapper.selectByExample(example);
		StatisticianRewardLtResp resp = new StatisticianRewardLtResp();
		resp.setCount(page.getTotal());
		resp.setStatisticianRewardLt(page.getResult());
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
