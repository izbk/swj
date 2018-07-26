package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.ServiceLogsExample;
import cn.com.yuanwei.center.entity.ServiceLogsExample.Criteria;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.service.ServiceLogsService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ServiceLogsReq;
import cn.com.yuanwei.center.web.response.ServiceLogsLtResp;

@Service
@Transactional
public class ServiceLogsServiceImpl implements ServiceLogsService {
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	 
	@Override
	public Integer save(ServiceLogs serviceLogs) throws Exception {
		serviceLogsMapper.insert(serviceLogs);
		return serviceLogs.getId();
	}

	@Override
	public Integer update(ServiceLogs serviceLogs) throws Exception {
		return serviceLogsMapper.updateByPrimaryKey(serviceLogs);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		ServiceLogsExample example = new ServiceLogsExample();
		example.createCriteria().andIdIn(ids);
		return serviceLogsMapper.deleteByExample(example);
	}
	
	@Override
	public ServiceLogs queryById(Integer id){
		return serviceLogsMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ServiceLogsLtResp queryList(ServiceLogsReq req) throws Exception {
		Integer id = req.getId();
		Integer userId = req.getUserId();
		String userName = req.getUserName();
		Date operateTime = req.getOperateTime();
		Integer busiId = req.getBusiId();
		String logContent = req.getLogContent();
		String ip = req.getIp();
		ServiceLogsExample example = new ServiceLogsExample();
		example.setOrderByClause("id desc");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(userId)){
			c.andUserIdEqualTo(userId);
		}
		if(!ValidateUtil.isEmpty(userName)){
			c.andUserNameLike("%"+userName+"%");
		}
		if(!ValidateUtil.isEmpty(operateTime)){
			c.andOperateTimeEqualTo(operateTime);
		}
		if(!ValidateUtil.isEmpty(busiId)){
			c.andBusiIdEqualTo(busiId);
		}
		if(!ValidateUtil.isEmpty(logContent)){
			c.andLogContentLike("%"+logContent+"%");
		}
		if(!ValidateUtil.isEmpty(ip)){
			c.andIpEqualTo(ip);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<ServiceLogs> page = (Page<ServiceLogs>) serviceLogsMapper.selectByExample(example);
		ServiceLogsLtResp resp = new ServiceLogsLtResp();
		resp.setCount(page.getTotal());
		resp.setServiceLogsLt(page.getResult());
		return resp;
	}
	
}
