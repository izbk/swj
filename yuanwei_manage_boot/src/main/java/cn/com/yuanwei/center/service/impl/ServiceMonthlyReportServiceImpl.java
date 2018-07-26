package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.ServiceForecast;
import cn.com.yuanwei.center.entity.ServiceForecastExample;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.ServiceMonthlyReport;
import cn.com.yuanwei.center.entity.ServiceMonthlyReportExample;
import cn.com.yuanwei.center.entity.ServiceMonthlyReportExample.Criteria;
import cn.com.yuanwei.center.enums.RoleTypeEnum;
import cn.com.yuanwei.center.mapper.ServiceForecastMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.ServiceMonthlyReportMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.ServiceMonthlyReportService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ServiceMonthlyReportReq;
import cn.com.yuanwei.center.web.response.ServiceMonthlyReportLtResp;

@Service
@Transactional
public class ServiceMonthlyReportServiceImpl implements ServiceMonthlyReportService {
	@Autowired
	private 
	 ServiceMonthlyReportMapper serviceMonthlyReportMapper;
	@Autowired
	private 
	 ServiceForecastMapper serviceForecastMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(ServiceMonthlyReport serviceMonthlyReport) throws Exception {
		//初始化属性
		UserInfo userInfo = LoginUserThread.getUser();
		serviceMonthlyReport.setUserId(userInfo.getId());
		serviceMonthlyReport.setEnterpriseName(userInfo.getNickName());
		serviceMonthlyReport.setCreateTime(new Date());
		
		Integer year = serviceMonthlyReport.getYear();
		Integer month = serviceMonthlyReport.getMonth();
		Integer defineId = 2;
		ServiceMonthlyReportExample de=new ServiceMonthlyReportExample();
		de.createCriteria().andUserIdEqualTo(userInfo.getId()).andYearEqualTo(year).andMonthEqualTo(month);
		List<ServiceMonthlyReport> list = serviceMonthlyReportMapper.selectByExample(de);
		if(list != null && list.size()>0){
			throw new Exception("该月已存在数据");
		}
		
		serviceMonthlyReportMapper.insert(serviceMonthlyReport);
		//更新或新增服务业汇总数据
		ServiceForecastExample example = new ServiceForecastExample();
		example.createCriteria().andDefineIdEqualTo(defineId).andYearEqualTo(year).andMonthEqualTo(month);
		List<ServiceForecast> sfs = serviceForecastMapper.selectByExample(example);
		if(!ValidateUtil.isEmpty(sfs)){
			ServiceForecast sf = sfs.get(0);
			sf.setCurrMonth(sf.getCurrAmount().add(serviceMonthlyReport.getCurrMonth()));
			sf.setCurrAmount(sf.getCurrAmount().add(serviceMonthlyReport.getCurrMonthAmount()));
			sf.setLastMonth(sf.getLastMonth().add(serviceMonthlyReport.getLastMonth()));
			sf.setLastAmount(sf.getLastAmount().add(serviceMonthlyReport.getLastMonthAmount()));
			serviceForecastMapper.updateByPrimaryKeySelective(sf);
		}else{
			ServiceForecast sf = new ServiceForecast(2, year, month, serviceMonthlyReport.getCurrMonth(), serviceMonthlyReport.getCurrMonthAmount(), serviceMonthlyReport.getLastMonth(), serviceMonthlyReport.getLastMonthAmount());
			serviceForecastMapper.insertSelective(sf);
		}
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),serviceMonthlyReport.getId(), "更新服务业企业数据月报信息"));
		return serviceMonthlyReport.getId();
	}

	@Override
	public Integer update(ServiceMonthlyReport serviceMonthlyReport) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),serviceMonthlyReport.getId(), "更新服务业企业数据月报信息"));
		return serviceMonthlyReportMapper.updateByPrimaryKey(serviceMonthlyReport);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除服务业企业数据月报信息"));
		}
		//按年月汇总数据
		ServiceMonthlyReportExample de=new ServiceMonthlyReportExample();
		de.createCriteria().andIdIn(ids);
		List<ServiceMonthlyReport> list = serviceMonthlyReportMapper.selectServiceMonthlyReportByMonth(de);
		for (ServiceMonthlyReport serviceMonthlyReport : list) {
			//更新服务业汇总数据
			Integer year = serviceMonthlyReport.getYear();
			Integer month = serviceMonthlyReport.getMonth();
			ServiceForecastExample example = new ServiceForecastExample();
			example.createCriteria().andDefineIdEqualTo(2).andYearEqualTo(year).andMonthEqualTo(month);
			List<ServiceForecast> sfs = serviceForecastMapper.selectByExample(example);
			if(!ValidateUtil.isEmpty(sfs)){
				ServiceForecast sf = sfs.get(0);
				sf.setCurrMonth(sf.getCurrAmount().subtract(serviceMonthlyReport.getCurrMonth()));
				sf.setCurrAmount(sf.getCurrAmount().subtract(serviceMonthlyReport.getCurrMonthAmount()));
				sf.setLastMonth(sf.getLastMonth().subtract(serviceMonthlyReport.getLastMonth()));
				sf.setLastAmount(sf.getLastAmount().subtract(serviceMonthlyReport.getLastMonthAmount()));
				serviceForecastMapper.updateByPrimaryKeySelective(sf);
			}
		}
		
		return serviceMonthlyReportMapper.deleteByExample(de);
	}
	
	@Override
	public ServiceMonthlyReport queryById(Integer id){
		return serviceMonthlyReportMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ServiceMonthlyReportLtResp queryList(ServiceMonthlyReportReq req) throws Exception {
		Integer id = req.getId();
		String enterpriseName = req.getEnterpriseName();
		BigDecimal currMonth = req.getCurrMonth();
		BigDecimal lastMonth = req.getLastMonth();
		BigDecimal currMonthAmount = req.getCurrMonthAmount();
		BigDecimal lastMonthAmount = req.getLastMonthAmount();
		Integer year = req.getYear();
		Integer month = req.getMonth();
		Date createTime = req.getCreateTime();
		ServiceMonthlyReportExample de=new ServiceMonthlyReportExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(enterpriseName)){
			c.andEnterpriseNameLike("%"+enterpriseName+"%");
		}
		if(!ValidateUtil.isEmpty(currMonth)){
			c.andCurrMonthEqualTo(currMonth);
		}
		if(!ValidateUtil.isEmpty(lastMonth)){
			c.andLastMonthEqualTo(lastMonth);
		}
		if(!ValidateUtil.isEmpty(currMonthAmount)){
			c.andCurrMonthAmountEqualTo(currMonthAmount);
		}
		if(!ValidateUtil.isEmpty(lastMonthAmount)){
			c.andLastMonthAmountEqualTo(lastMonthAmount);
		}
		if(!ValidateUtil.isEmpty(year)){
			c.andYearEqualTo(year);
		}
		if(!ValidateUtil.isEmpty(month)){
			c.andMonthEqualTo(month);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		//根据角色查询
		UserInfo userInfo = LoginUserThread.getUser();
		//服务业角色
		if(RoleTypeEnum.subservice.getCode().compareTo(userInfo.getRoleId())==0){
			c.andUserIdEqualTo(userInfo.getId());
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<ServiceMonthlyReport> page = (Page<ServiceMonthlyReport>) serviceMonthlyReportMapper.selectByExample(de);
		ServiceMonthlyReportLtResp resp = new ServiceMonthlyReportLtResp();
		resp.setCount(page.getTotal());
		resp.setServiceMonthlyReportLt(page.getResult());
		return resp;
	}
	
}
