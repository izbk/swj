package cn.com.yuanwei.center.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.StatisticianReportPoint;
import cn.com.yuanwei.center.entity.StatisticianReportPointVo;
import cn.com.yuanwei.center.entity.StatisticianScoringRecord;
import cn.com.yuanwei.center.entity.StatisticianScoringRecordExample;
import cn.com.yuanwei.center.entity.StatisticianScoringRecordExample.Criteria;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.StatisticianReportPointMapper;
import cn.com.yuanwei.center.mapper.StatisticianScoringRecordMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.StatisticianScoringRecordService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.StatisticianReportPointReq;
import cn.com.yuanwei.center.web.request.StatisticianScoringRecordReq;
import cn.com.yuanwei.center.web.response.StatisticianReportPointLtResp;
import cn.com.yuanwei.center.web.response.StatisticianScoringRecordLtResp;

@Service
@Transactional
public class StatisticianScoringRecordServiceImpl implements StatisticianScoringRecordService {
	@Autowired
	private StatisticianScoringRecordMapper statisticianScoringRecordMapper;
	@Autowired
	private StatisticianReportPointMapper statisticianReportPointMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(StatisticianScoringRecord statisticianScoringRecord) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		statisticianScoringRecord.setCreateBy(userInfo.getId());
		statisticianScoringRecord.setCreateTime(new Date());
		statisticianScoringRecordMapper.insert(statisticianScoringRecord);
		StatisticianReportPoint param = new StatisticianReportPoint();
		BeanUtils.copyProperties(statisticianScoringRecord, param);
		List<StatisticianReportPoint> list = statisticianReportPointMapper.selectScoringRecordForPoint(param);
		if(!ValidateUtil.isEmpty(list)){
			statisticianReportPointMapper.insert(list.get(0));
		}
		//记录日志
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,statisticianScoringRecord.getId(), "新增统计员得分记录"));	
		return statisticianScoringRecord.getId();
	}

	@Override
	public Integer update(StatisticianScoringRecord statisticianScoringRecord) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,statisticianScoringRecord.getId(), "更新统计员得分记录"));
		return statisticianScoringRecordMapper.updateByPrimaryKey(statisticianScoringRecord);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除统计员得分记录"));
		}
		StatisticianScoringRecordExample example = new StatisticianScoringRecordExample();
		example.createCriteria().andIdIn(ids);
		return statisticianScoringRecordMapper.deleteByExample(example);
	}
	
	@Override
	public StatisticianScoringRecord queryById(Integer id){
		return statisticianScoringRecordMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public StatisticianReportPointLtResp queryList(StatisticianReportPointReq req) throws Exception {
		Integer year = req.getYear();
		Integer month = req.getMonth();
		String enterpriseCode = req.getEnterpriseCode();
		String enterpriseName = req.getEnterpriseName();
		StatisticianReportPoint record = new StatisticianReportPoint();
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
		for (Object object : list) {
			statisticianReportPointLt.add((StatisticianReportPointVo)object);
		}
		StatisticianReportPointLtResp resp = new StatisticianReportPointLtResp();
		resp.setCount(page.getTotal());
		resp.setStatisticianReportPointLt(statisticianReportPointLt);
		return resp;
	}
	
	@Override
	public StatisticianScoringRecordLtResp queryList(StatisticianScoringRecordReq req) throws Exception {
		Integer id = req.getId();
		Integer reportId = req.getReportId();
		Integer year = req.getYear();
		Integer month = req.getMonth();
		String enterpriseName = req.getEnterpriseName();
		String enterpriseCode = req.getEnterpriseCode();
		Integer userId = req.getUserId();
		String userName = req.getUserName();
		String mobilePhone = req.getMobilePhone();
		Integer ruleId = req.getRuleId();
		String rule = req.getRule();
		Integer point = req.getPoint();
		Integer pointType = req.getPointType();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		StatisticianScoringRecordExample example = new StatisticianScoringRecordExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(reportId)){
			c.andReportIdEqualTo(reportId);
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(month)){
			c.andMonthEqualTo(month);
		}
		if(!ValidateUtil.isEmpty(enterpriseName)){
			c.andEnterpriseNameLike("%"+enterpriseName+"%");
		}
		if(!ValidateUtil.isEmpty(enterpriseCode)){
			c.andEnterpriseCodeEqualTo(enterpriseCode);
		}
		if(!ValidateUtil.isEmpty(userId)){
			c.andUserIdEqualTo(userId);
		}
		if(!ValidateUtil.isEmpty(userName)){
			c.andUserNameLike("%"+userName+"%");
		}
		if(!ValidateUtil.isEmpty(mobilePhone)){
			c.andMobilePhoneEqualTo(mobilePhone);
		}
		if(!ValidateUtil.isEmpty(ruleId)){
			c.andRuleIdEqualTo(ruleId);
		}
		if(!ValidateUtil.isEmpty(rule)){
			c.andRuleEqualTo(rule);
		}
		if(!ValidateUtil.isEmpty(point)){
			c.andPointEqualTo(point);
		}
		if(!ValidateUtil.isEmpty(pointType)){
			c.andPointTypeEqualTo(pointType);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<StatisticianScoringRecord> page = (Page<StatisticianScoringRecord>) statisticianScoringRecordMapper.selectByExample(example);
		StatisticianScoringRecordLtResp resp = new StatisticianScoringRecordLtResp();
		resp.setCount(page.getTotal());
		resp.setStatisticianScoringRecordLt(page.getResult());
		return resp;
	}
	
}
