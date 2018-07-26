package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.ServiceDefine;
import cn.com.yuanwei.center.entity.ServiceDefineExample;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.ServiceDefineExample.Criteria;
import cn.com.yuanwei.center.mapper.ServiceDefineMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.ServiceDefineService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ServiceDefineReq;
import cn.com.yuanwei.center.web.response.ServiceDefineLtResp;

@Service
@Transactional
public class ServiceDefineServiceImpl implements ServiceDefineService {

	@Autowired
	private ServiceDefineMapper serviceDefineMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	 
	@Override
	public void save(ServiceDefine serviceDefine) throws Exception {
		serviceDefineMapper.insert(serviceDefine);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,serviceDefine.getId(), "新增服务业企业数据定义信息"));		
	}

	@Override
	public void update(ServiceDefine serviceDefine) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,serviceDefine.getId(), "更新服务业企业数据定义信息"));			
		serviceDefineMapper.updateByPrimaryKey(serviceDefine);
	}

	@Override
	public void delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除服务业企业数据定义信息"));
		}
		
		ServiceDefineExample de=new ServiceDefineExample();
		de.createCriteria().andIdIn(ids);
		serviceDefineMapper.deleteByExample(de);
	}
	
	@Override
	public ServiceDefine queryById(Integer id){
		return serviceDefineMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ServiceDefineLtResp queryList(ServiceDefineReq req) throws Exception {
		Integer id = req.getId();
		Integer dataSource = req.getDataSource();
		Integer calculationIndustry = req.getCalculationIndustry();
		Integer departId = req.getDepartId();
		String departName = req.getDepartName();
		String indexName = req.getIndexName();
		ServiceDefineExample example = new ServiceDefineExample();
		example.setOrderByClause("id desc");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(dataSource)){
			c.andDataSourceEqualTo(dataSource);
		}
		if(!ValidateUtil.isEmpty(calculationIndustry)){
			c.andCalculationIndustryEqualTo(calculationIndustry);
		}
		if(!ValidateUtil.isEmpty(departId)){
			c.andDepartIdEqualTo(departId);
		}
		if(!ValidateUtil.isEmpty(departName)){
			c.andDepartNameLike("%"+departName+"%");
		}
		if(!ValidateUtil.isEmpty(indexName)){
			c.andIndexNameLike("%"+indexName+"%");
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<ServiceDefine> page = (Page<ServiceDefine>) serviceDefineMapper.selectByExample(example);
		ServiceDefineLtResp resp = new ServiceDefineLtResp();
		resp.setCount(page.getTotal());
		resp.setServiceDefineLt(page.getResult());
		return resp;
	}
	
}
