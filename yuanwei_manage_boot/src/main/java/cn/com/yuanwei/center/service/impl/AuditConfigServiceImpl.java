package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.AuditConfig;
import cn.com.yuanwei.center.entity.AuditConfigExample;
import cn.com.yuanwei.center.entity.AuditConfigExample.Criteria;
import cn.com.yuanwei.center.mapper.AuditConfigMapper;
import cn.com.yuanwei.center.service.AuditConfigService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.AuditConfigReq;
import cn.com.yuanwei.center.web.response.AuditConfigLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class AuditConfigServiceImpl implements AuditConfigService {
	@Autowired
	private AuditConfigMapper auditConfigMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(AuditConfig auditConfig) throws Exception {
		Date currDate = new Date();
		auditConfigMapper.insert(auditConfig);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,auditConfig.getId(), "新增审核配置"));		
		return auditConfig.getId();
	}

	@Override
	public Integer update(AuditConfig auditConfig) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),auditConfig.getId(), "更新审核配置"));
		return auditConfigMapper.updateByPrimaryKey(auditConfig);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除审核配置"));
		}	
		AuditConfigExample example = new AuditConfigExample();
		example.createCriteria().andIdIn(ids);
		return auditConfigMapper.deleteByExample(example);
	}
	
	@Override
	public AuditConfig queryById(Integer id){
		return auditConfigMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public AuditConfigLtResp queryList(AuditConfigReq req) throws Exception {
		Integer id = req.getId();
		Integer departId = req.getDepartId();
		Integer userId1 = req.getUserId1();
		Integer userId2 = req.getUserId2();
		Integer userId3 = req.getUserId3();
		Integer busiType = req.getBusiType();
		Integer subBusiType = req.getSubBusiType();
		AuditConfigExample example = new AuditConfigExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(departId)){
			c.andDepartIdEqualTo(departId);
		}
		if(!ValidateUtil.isEmpty(userId1)){
			c.andUserId1EqualTo(userId1);
		}
		if(!ValidateUtil.isEmpty(userId2)){
			c.andUserId2EqualTo(userId2);
		}
		if(!ValidateUtil.isEmpty(userId3)){
			c.andUserId3EqualTo(userId3);
		}
		if(!ValidateUtil.isEmpty(busiType)){
			c.andBusiTypeEqualTo(busiType);
		}
		if(!ValidateUtil.isEmpty(subBusiType)){
			c.andSubBusiTypeEqualTo(subBusiType);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<AuditConfig> page = (Page<AuditConfig>) auditConfigMapper.selectByExample(example);
		AuditConfigLtResp resp = new AuditConfigLtResp();
		resp.setCount(page.getTotal());
		resp.setAuditConfigLt(page.getResult());
		return resp;
	}
	
}
