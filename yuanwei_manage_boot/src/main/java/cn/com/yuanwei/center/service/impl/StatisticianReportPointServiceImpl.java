package cn.com.yuanwei.center.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.StatisticianReportPoint;
import cn.com.yuanwei.center.entity.StatisticianReportPointExample;
import cn.com.yuanwei.center.entity.StatisticianReportPointVo;
import cn.com.yuanwei.center.entity.StatisticianScoringRules;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.StatisticianReportPointMapper;
import cn.com.yuanwei.center.mapper.StatisticianScoringRulesMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.StatisticianReportPointService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.StatisticianReportPointReq;
import cn.com.yuanwei.center.web.response.StatisticianReportPointLtResp;

@Service
@Transactional
public class StatisticianReportPointServiceImpl implements StatisticianReportPointService {
	@Autowired
	private StatisticianReportPointMapper statisticianReportPointMapper;
	@Autowired
	private StatisticianScoringRulesMapper statisticianScoringRulesMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(StatisticianReportPoint statisticianReportPoint) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		statisticianReportPoint.setCreateBy(userInfo.getId());
		statisticianReportPoint.setCreateTime(new Date());
		//计算得分
		Integer deductRuleId = statisticianReportPoint.getDeductRuleId();
		Integer increaseRuleId = statisticianReportPoint.getIncreaseRuleId();
		Integer deductPoint = 0;
		Integer increasePoint = 0;
		if(!ValidateUtil.isEmpty(deductRuleId)){
			StatisticianScoringRules rules = statisticianScoringRulesMapper.selectByPrimaryKey(deductRuleId);
			if(!ValidateUtil.isEmpty(rules)){
				deductPoint = rules.getPoint();
			}
		}
		if(!ValidateUtil.isEmpty(increaseRuleId)){
			StatisticianScoringRules rules = statisticianScoringRulesMapper.selectByPrimaryKey(increaseRuleId);
			if(!ValidateUtil.isEmpty(rules)){
				increasePoint = rules.getPoint();
			}
		}
		statisticianReportPoint.setDeductPoint(deductPoint);
		statisticianReportPoint.setIncreasePoint(increasePoint);
		statisticianReportPoint.setReportPoint(20+increasePoint-deductPoint);
		statisticianReportPointMapper.insert(statisticianReportPoint);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),statisticianReportPoint.getId(), "新增统计员直报考核信息"));
		return statisticianReportPoint.getId();
	}

	@Override
	public Integer update(StatisticianReportPoint statisticianReportPoint) throws Exception {
		//计算得分
		Integer deductRuleId = statisticianReportPoint.getDeductRuleId();
		Integer increaseRuleId = statisticianReportPoint.getIncreaseRuleId();
		Integer deductPoint = 0;
		Integer increasePoint = 0;
		if(!ValidateUtil.isEmpty(deductRuleId)){
			StatisticianScoringRules rules = statisticianScoringRulesMapper.selectByPrimaryKey(deductRuleId);
			if(!ValidateUtil.isEmpty(rules)){
				deductPoint = rules.getPoint();
			}
		}
		if(!ValidateUtil.isEmpty(increaseRuleId)){
			StatisticianScoringRules rules = statisticianScoringRulesMapper.selectByPrimaryKey(increaseRuleId);
			if(!ValidateUtil.isEmpty(rules)){
				increasePoint = rules.getPoint();
			}
		}
		statisticianReportPoint.setDeductPoint(deductPoint);
		statisticianReportPoint.setIncreasePoint(increasePoint);
		statisticianReportPoint.setReportPoint(20+increasePoint-deductPoint);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),statisticianReportPoint.getId(), "更新统计员直报考核信息"));
		return statisticianReportPointMapper.updateByPrimaryKey(statisticianReportPoint);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除统计员直报考核信息"));
		}
		StatisticianReportPointExample example = new StatisticianReportPointExample();
		example.createCriteria().andIdIn(ids);
		return statisticianReportPointMapper.deleteByExample(example);
	}
	
	@Override
	public StatisticianReportPoint queryById(Integer id){
		return statisticianReportPointMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public StatisticianReportPointLtResp queryList(StatisticianReportPointReq req) throws Exception {
		Date queryDate = req.getQueryDate();
		Calendar ca = Calendar.getInstance();
		ca.setTime(queryDate);
		Integer year = ca.get(Calendar.YEAR);
		Integer month = ca.get(Calendar.MONTH)+1;
		Integer id = req.getId();
		String enterpriseCode = req.getEnterpriseCode();
		String enterpriseName = req.getEnterpriseName();
		StatisticianReportPoint record = new StatisticianReportPoint();
		if(!ValidateUtil.isEmpty(id)){
			record.setId(id);
		}
		if(!ValidateUtil.isEmpty(year)){
			record.setYear(year);
		}
		if(!ValidateUtil.isEmpty(month)){
			record.setMonth(month);
		}
		if(!ValidateUtil.isEmpty(enterpriseCode)){
			record.setEnterpriseCode(enterpriseCode);
		}
		if(!ValidateUtil.isEmpty(enterpriseName)){
			record.setEnterpriseName(enterpriseName);
		}
		
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<?> page = (Page<?>) statisticianReportPointMapper.selectEnterprisesForPoint(record);
		List<?> list = page.getResult();
		List<StatisticianReportPointVo> statisticianReportPointLt = new ArrayList<StatisticianReportPointVo>();
		for (int i = 0; i < list.size(); i++) {
			statisticianReportPointLt.add((StatisticianReportPointVo)list.get(i));
		}
		StatisticianReportPointLtResp resp = new StatisticianReportPointLtResp();
		resp.setCount(page.getTotal());
		resp.setStatisticianReportPointLt(statisticianReportPointLt);
		return resp;
	}
	
}
