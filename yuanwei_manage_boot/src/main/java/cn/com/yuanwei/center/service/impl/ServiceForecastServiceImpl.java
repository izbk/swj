package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.ServiceDefine;
import cn.com.yuanwei.center.entity.ServiceDefineExample;
import cn.com.yuanwei.center.entity.ServiceForecast;
import cn.com.yuanwei.center.entity.ServiceForecastExample;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.ServiceForecastExample.Criteria;
import cn.com.yuanwei.center.enums.RoleTypeEnum;
import cn.com.yuanwei.center.mapper.ServiceDefineMapper;
import cn.com.yuanwei.center.mapper.ServiceForecastMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.ServiceForecastService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ServiceForecastReq;
import cn.com.yuanwei.center.web.response.ServiceForecastLtResp;

@Service
@Transactional
public class ServiceForecastServiceImpl implements ServiceForecastService {
	@Autowired
	private ServiceForecastMapper serviceForecastMapper;
	@Autowired
	private ServiceDefineMapper serviceDefineMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(ServiceForecast serviceForecast) throws Exception {
		//判断用户部门
		UserInfo userInfo = LoginUserThread.getUser();
		if(ValidateUtil.isEmpty(userInfo.getDepartId())){
			if(RoleTypeEnum.service.getCode().compareTo(userInfo.getRoleId())==0){
				throw new Exception("该用户未分配部门，请联系管理员");
			}
		}
		Integer year = serviceForecast.getYear();
		Integer month = serviceForecast.getMonth();
		Integer defineId = serviceForecast.getDefineId();
		ServiceForecastExample de=new ServiceForecastExample();
		de.createCriteria().andDefineIdEqualTo(defineId).andYearEqualTo(year).andMonthEqualTo(month);
		List<ServiceForecast> list = serviceForecastMapper.selectByExample(de);
		if(list != null && list.size()>0){
			throw new Exception("该月已存在数据");
		}
		serviceForecastMapper.insert(serviceForecast);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),serviceForecast.getId(), "新增服务业企业数据预测信息"));
		return serviceForecast.getId();
	}

	@Override
	public Integer update(ServiceForecast serviceForecast) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),serviceForecast.getId(), "更新服务业企业数据预测信息"));
		return serviceForecastMapper.updateByPrimaryKey(serviceForecast);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除服务业企业数据预测信息"));
		}
		ServiceForecastExample de=new ServiceForecastExample();
		de.createCriteria().andIdIn(ids);
		return serviceForecastMapper.deleteByExample(de);
	}
	
	@Override
	public ServiceForecast queryById(Integer id){
		return serviceForecastMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ServiceForecastLtResp queryList(ServiceForecastReq req) throws Exception {
		//判断用户部门
		UserInfo userInfo = LoginUserThread.getUser();
		if(ValidateUtil.isEmpty(userInfo.getDepartId())){
			if(RoleTypeEnum.service.getCode().compareTo(userInfo.getRoleId())==0){
				throw new Exception("该用户未分配部门，请联系管理员");
			}
		}
		Integer id = req.getId();
		Integer defineId = req.getDefineId();
		Integer year = req.getYear();
		Integer month = req.getMonth();
		BigDecimal currMonth = req.getCurrMonth();
		BigDecimal currAmount = req.getCurrAmount();
		BigDecimal currAmountRise = req.getCurrAmountRise();
		BigDecimal lastMonth = req.getLastMonth();
		BigDecimal lastAmount = req.getLastAmount();
		BigDecimal lastAmountRise = req.getLastAmountRise();
		String problem = req.getProblem();
		String solution = req.getSolution();
		ServiceForecastExample de=new ServiceForecastExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(defineId)){
			c.andDefineIdEqualTo(defineId);
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(month)){
			c.andMonthEqualTo(month);
		}
		if(!ValidateUtil.isEmpty(currMonth)){
			c.andCurrMonthEqualTo(currMonth);
		}
		if(!ValidateUtil.isEmpty(currAmount)){
			c.andCurrAmountEqualTo(currAmount);
		}
		if(!ValidateUtil.isEmpty(currAmountRise)){
			c.andCurrAmountRiseEqualTo(currAmountRise);
		}
		if(!ValidateUtil.isEmpty(lastMonth)){
			c.andLastMonthEqualTo(lastMonth);
		}
		if(!ValidateUtil.isEmpty(lastAmount)){
			c.andLastAmountEqualTo(lastAmount);
		}
		if(!ValidateUtil.isEmpty(lastAmountRise)){
			c.andLastAmountRiseEqualTo(lastAmountRise);
		}
		if(!ValidateUtil.isEmpty(problem)){
			c.andProblemEqualTo(problem);
		}
		if(!ValidateUtil.isEmpty(solution)){
			c.andSolutionEqualTo(solution);
		}
		//服务业角色
		if(RoleTypeEnum.service.getCode().compareTo(userInfo.getRoleId())==0){
			ServiceDefineExample example = new ServiceDefineExample();
			example.createCriteria().andDepartIdEqualTo(userInfo.getDepartId());
			List<ServiceDefine> defines = serviceDefineMapper.selectByExample(example);
			List<Integer> defineIds = new ArrayList<Integer>();
			for (ServiceDefine serviceDefine : defines) {
				defineIds.add(serviceDefine.getId());
			}
			c.andDefineIdIn(defineIds);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<ServiceForecast> page = (Page<ServiceForecast>) serviceForecastMapper.selectByExample(de);
		ServiceForecastLtResp resp = new ServiceForecastLtResp();
		resp.setCount(page.getTotal());
		resp.setServiceForecastLt(page.getResult());
		return resp;
	}
	
	@Override
	public ServiceForecastLtResp queryExport(ServiceForecastReq req) throws Exception {
		Integer id = req.getId();
		Integer defineId = req.getDefineId();
		Integer year = req.getYear();
		Integer month = req.getMonth();
		BigDecimal currMonth = req.getCurrMonth();
		BigDecimal currAmount = req.getCurrAmount();
		BigDecimal currAmountRise = req.getCurrAmountRise();
		BigDecimal lastMonth = req.getLastMonth();
		BigDecimal lastAmount = req.getLastAmount();
		BigDecimal lastAmountRise = req.getLastAmountRise();
		String problem = req.getProblem();
		String solution = req.getSolution();
		ServiceForecastExample de=new ServiceForecastExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(defineId)){
			c.andDefineIdEqualTo(defineId);
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(month)){
			c.andMonthEqualTo(month);
		}
		if(!ValidateUtil.isEmpty(currMonth)){
			c.andCurrMonthEqualTo(currMonth);
		}
		if(!ValidateUtil.isEmpty(currAmount)){
			c.andCurrAmountEqualTo(currAmount);
		}
		if(!ValidateUtil.isEmpty(currAmountRise)){
			c.andCurrAmountRiseEqualTo(currAmountRise);
		}
		if(!ValidateUtil.isEmpty(lastMonth)){
			c.andLastMonthEqualTo(lastMonth);
		}
		if(!ValidateUtil.isEmpty(lastAmount)){
			c.andLastAmountEqualTo(lastAmount);
		}
		if(!ValidateUtil.isEmpty(lastAmountRise)){
			c.andLastAmountRiseEqualTo(lastAmountRise);
		}
		if(!ValidateUtil.isEmpty(problem)){
			c.andProblemEqualTo(problem);
		}
		if(!ValidateUtil.isEmpty(solution)){
			c.andSolutionEqualTo(solution);
		}
		List<ServiceForecast> list = serviceForecastMapper.selectByExample(de);
		for (ServiceForecast serviceForecast : list) {
			serviceForecast.setServiceDefine(serviceDefineMapper.selectByPrimaryKey(serviceForecast.getDefineId()));
		}
		ServiceForecastLtResp resp = new ServiceForecastLtResp();
		resp.setCount((long)list.size());
		resp.setServiceForecastLt(list);
		return resp;
	}
	
}
