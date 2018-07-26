package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.StatisticianRangeRules;
import cn.com.yuanwei.center.entity.StatisticianRangeRulesExample;
import cn.com.yuanwei.center.entity.StatisticianRangeRulesExample.Criteria;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.StatisticianRangeRulesMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.StatisticianRangeRulesService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.StatisticianRangeRulesReq;
import cn.com.yuanwei.center.web.response.StatisticianRangeRulesLtResp;

@Service
@Transactional
public class StatisticianRangeRulesServiceImpl implements StatisticianRangeRulesService {
	@Autowired
	private StatisticianRangeRulesMapper statisticianRangeRulesMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(StatisticianRangeRules statisticianRangeRules) throws Exception {
		BigDecimal minValue = statisticianRangeRules.getMinValue();
		BigDecimal maxValue = statisticianRangeRules.getMaxValue();
		Integer rangeType = statisticianRangeRules.getRangeType();
		if(minValue.compareTo(maxValue)>0){
			throw new Exception("数据有误");
		}
		StatisticianRangeRulesExample example = new StatisticianRangeRulesExample();
		example.createCriteria().andRangeTypeEqualTo(rangeType);
		List<StatisticianRangeRules> list = statisticianRangeRulesMapper.selectByExample(example);
		for (StatisticianRangeRules range : list) {
			if ((minValue.compareTo(range.getMinValue()) >= 0 && minValue.compareTo(range.getMaxValue()) <= 0)
					|| (maxValue.compareTo(range.getMinValue()) >= 0 && maxValue.compareTo(range.getMaxValue()) <= 0)) {
				throw new Exception("数据有误");
			}
		}
		UserInfo userInfo = LoginUserThread.getUser();
		statisticianRangeRules.setCreateBy(userInfo.getId());
		statisticianRangeRules.setCreateTime(new Date());
		statisticianRangeRulesMapper.insert(statisticianRangeRules);
		//记录日志
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,statisticianRangeRules.getId(), "新增统计员排位得分规则"));	
		return statisticianRangeRules.getId();
	}

	@Override
	public Integer update(StatisticianRangeRules statisticianRangeRules) throws Exception {
		BigDecimal minValue = statisticianRangeRules.getMinValue();
		BigDecimal maxValue = statisticianRangeRules.getMaxValue();
		Integer id = statisticianRangeRules.getId();
		Integer rangeType = statisticianRangeRules.getRangeType();
		if(minValue.compareTo(maxValue)>0){
			throw new Exception("数据有误");
		}
		StatisticianRangeRulesExample example = new StatisticianRangeRulesExample();
		example.createCriteria().andRangeTypeEqualTo(rangeType);
		List<StatisticianRangeRules> list = statisticianRangeRulesMapper.selectByExample(example);
			for (StatisticianRangeRules range : list) {
				if(id.compareTo(range.getId()) != 0){
					if ((minValue.compareTo(range.getMinValue()) >= 0 && minValue.compareTo(range.getMaxValue()) <= 0)
							|| (maxValue.compareTo(range.getMinValue()) >= 0 && maxValue.compareTo(range.getMaxValue()) <= 0)) {
						throw new Exception("数据有误");
					}
				}
			}
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,statisticianRangeRules.getId(), "更新统计员排位得分规则"));	
		return statisticianRangeRulesMapper.updateByPrimaryKey(statisticianRangeRules);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除统计员排位得分规则"));
		}		
		StatisticianRangeRulesExample example = new StatisticianRangeRulesExample();
		example.createCriteria().andIdIn(ids);
		return statisticianRangeRulesMapper.deleteByExample(example);
	}
	
	@Override
	public StatisticianRangeRules queryById(Integer id){
		return statisticianRangeRulesMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public StatisticianRangeRulesLtResp queryList(StatisticianRangeRulesReq req) throws Exception {
		Integer id = req.getId();
		BigDecimal minValue = req.getMinValue();
		BigDecimal maxValue = req.getMaxValue();
		Integer point = req.getPoint();
		Integer rangeType = req.getRangeType();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		StatisticianRangeRulesExample example = new StatisticianRangeRulesExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(minValue)){
			c.andMinValueEqualTo(minValue);
		}
		if(!ValidateUtil.isEmpty(maxValue)){
			c.andMaxValueEqualTo(maxValue);
		}
		if(!ValidateUtil.isEmpty(point)){
			c.andPointEqualTo(point);
		}
		if(!ValidateUtil.isEmpty(rangeType)){
			c.andRangeTypeEqualTo(rangeType);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<StatisticianRangeRules> page = (Page<StatisticianRangeRules>) statisticianRangeRulesMapper.selectByExample(example);
		StatisticianRangeRulesLtResp resp = new StatisticianRangeRulesLtResp();
		resp.setCount(page.getTotal());
		resp.setStatisticianRangeRulesLt(page.getResult());
		return resp;
	}
	
}
