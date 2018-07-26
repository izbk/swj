package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.StatisticianScoringRules;
import cn.com.yuanwei.center.entity.StatisticianScoringRulesExample;
import cn.com.yuanwei.center.entity.StatisticianScoringRulesExample.Criteria;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.StatisticianScoringRulesMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.StatisticianScoringRulesService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.StatisticianScoringRulesReq;
import cn.com.yuanwei.center.web.response.StatisticianScoringRulesLtResp;

@Service
@Transactional
public class StatisticianScoringRulesServiceImpl implements StatisticianScoringRulesService {
	@Autowired
	private StatisticianScoringRulesMapper statisticianScoringRulesMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(StatisticianScoringRules statisticianScoringRules) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		statisticianScoringRules.setCreateBy(userInfo.getId());
		statisticianScoringRules.setCreateTime(new Date());
		statisticianScoringRulesMapper.insert(statisticianScoringRules);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),statisticianScoringRules.getId(), "新增统计员计分细则"));
		return statisticianScoringRules.getId();
	}

	@Override
	public Integer update(StatisticianScoringRules statisticianScoringRules) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),statisticianScoringRules.getId(), "更新统计员计分细则"));
		return statisticianScoringRulesMapper.updateByPrimaryKey(statisticianScoringRules);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除统计员计分细则"));
		}
		StatisticianScoringRulesExample example = new StatisticianScoringRulesExample();
		example.createCriteria().andIdIn(ids);
		return statisticianScoringRulesMapper.deleteByExample(example);
	}
	
	@Override
	public StatisticianScoringRules queryById(Integer id){
		return statisticianScoringRulesMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public StatisticianScoringRulesLtResp queryList(StatisticianScoringRulesReq req) throws Exception {
		Integer id = req.getId();
		String rule = req.getRule();
		Integer point = req.getPoint();
		Integer pointType = req.getPointType();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		StatisticianScoringRulesExample example = new StatisticianScoringRulesExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
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
		Page<StatisticianScoringRules> page = (Page<StatisticianScoringRules>) statisticianScoringRulesMapper.selectByExample(example);
		StatisticianScoringRulesLtResp resp = new StatisticianScoringRulesLtResp();
		resp.setCount(page.getTotal());
		resp.setStatisticianScoringRulesLt(page.getResult());
		return resp;
	}
	
}
