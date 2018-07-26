package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.component.WebSocketComponent;
import cn.com.yuanwei.center.entity.Advice;
import cn.com.yuanwei.center.entity.AdviceExample;
import cn.com.yuanwei.center.entity.AdviceExample.Criteria;
import cn.com.yuanwei.center.entity.AuditConfig;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.ToDoList;
import cn.com.yuanwei.center.entity.ToDoListExample;
import cn.com.yuanwei.center.enums.AuditStatusEnum;
import cn.com.yuanwei.center.enums.BusiTypeEnum;
import cn.com.yuanwei.center.enums.IsDealEnum;
import cn.com.yuanwei.center.mapper.AdviceMapper;
import cn.com.yuanwei.center.mapper.AuditConfigMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.ToDoListMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.AdviceService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.AdviceReq;
import cn.com.yuanwei.center.web.response.AdviceLtResp;

@Service
@Transactional
public class AdviceServiceImpl implements AdviceService {
	@Autowired
	private AdviceMapper adviceMapper;
	@Autowired
	private AuditConfigMapper auditConfigMapper;
	@Autowired
	private ToDoListMapper toDoListMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(Advice advice) throws Exception {
		advice.setStatus(AuditStatusEnum.weishenhe.getCode());
		advice.setCreateTime(new Date());
		advice.setIsDeal(IsDealEnum.fou.getCode());
		adviceMapper.insert(advice);
		//新增待办事项
		AuditConfig record = new AuditConfig();
		record.setBusiType(BusiTypeEnum.tousujianyi.getCode());
		record.setSubBusiType(advice.getAdviceType());
		List<AuditConfig> list = auditConfigMapper.selectByAuditConfig(record);
		if(list != null && list.size() > 0){
			AuditConfig config = list.get(0);
			if(!ValidateUtil.isEmpty(config.getUserId1())){
				ToDoList toDoList = new ToDoList();
				toDoList.setAuditConfigId(config.getId());
				toDoList.setBusiId(advice.getId());
				toDoList.setBusiName(advice.getAdviceTitle());
				toDoList.setBusiType(BusiTypeEnum.tousujianyi.getCode());
				toDoList.setSubBusiType(advice.getAdviceType());
				toDoList.setCreateTime(new Date());
				toDoList.setUserId(config.getUserId1());
				toDoList.setIsDeal(IsDealEnum.fou.getCode());
				toDoListMapper.insertSelective(toDoList);
				WebSocketComponent.sendMessage("您有新的待办事项", config.getUserId1().toString());
			}
		}
		return advice.getId();
	}

	@Override
	public Integer update(Advice advice) throws Exception {
		Integer status = advice.getStatus();
		if(status != null){
			ToDoListExample de = new ToDoListExample();
			de.createCriteria().andBusiIdEqualTo(advice.getId());
			toDoListMapper.deleteByExample(de);
			if(status.compareTo(AuditStatusEnum.weishenhe.getCode())==0){
				//新增待办事项
				AuditConfig record = new AuditConfig();
				record.setBusiType(BusiTypeEnum.tousujianyi.getCode());
				record.setSubBusiType(advice.getAdviceType());
				List<AuditConfig> list = auditConfigMapper.selectByAuditConfig(record);
				if(list != null && list.size() > 0){
					AuditConfig config = list.get(0);
					if(!ValidateUtil.isEmpty(config.getUserId1())){
						ToDoList toDoList = new ToDoList();
						toDoList.setAuditConfigId(config.getId());
						toDoList.setBusiId(advice.getId());
						toDoList.setBusiName(advice.getAdviceTitle());
						toDoList.setBusiType(BusiTypeEnum.tousujianyi.getCode());
						toDoList.setSubBusiType(advice.getAdviceType());
						toDoList.setCreateTime(new Date());
						toDoList.setUserId(config.getUserId1());
						toDoList.setIsDeal(IsDealEnum.fou.getCode());
						toDoListMapper.insertSelective(toDoList);
					}
				}
			}
		}
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),advice.getId(), "更新投诉建议"));
		return adviceMapper.updateByPrimaryKey(advice);
	}
	
	@Override
	public Integer delete(List<Integer> req) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : req) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除投诉建议"));
		}
		
		//删除待办事项
		ToDoListExample de2 = new ToDoListExample();
		de2.createCriteria().andBusiIdIn(req);
		toDoListMapper.deleteByExample(de2);
		
		AdviceExample de=new AdviceExample();
		de.createCriteria().andIdIn(req);
		return adviceMapper.deleteByExample(de);
	}
	
	@Override
	public Advice queryById(Integer id){
		return adviceMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public AdviceLtResp queryList(AdviceReq req) throws Exception {
		Integer id = req.getId();
		String name = req.getName();
		String mobile = req.getMobile();
		String email = req.getEmail();
		String adviceTitle = req.getAdviceTitle();
		String adviceContent = req.getAdviceContent();
		Integer adviceType = req.getAdviceType();
		Integer status = req.getStatus();
		Date createTime = req.getCreateTime();
		Integer isDeal = req.getIsDeal();
		String resContent = req.getResContent();
		Integer dealBy = req.getDealBy();
		Date dealTime = req.getDealTime();
		Integer audit1By = req.getAudit1By();
		Date audit1Time = req.getAudit1Time();
		Integer audit2By = req.getAudit2By();
		Date audit2Time = req.getAudit2Time();
		Integer audit3By = req.getAudit3By();
		Date audit3Time = req.getAudit3Time();
		AdviceExample de=new AdviceExample();
		de.setOrderByClause(" status,id desc");
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(name)){
			c.andNameLike("%"+name+"%");
		}
		if(!ValidateUtil.isEmpty(mobile)){
			c.andMobileEqualTo(mobile);
		}
		if(!ValidateUtil.isEmpty(email)){
			c.andEmailEqualTo(email);
		}
		if(!ValidateUtil.isEmpty(adviceTitle)){
			c.andAdviceTitleLike("%"+adviceTitle+"%");
		}
		if(!ValidateUtil.isEmpty(adviceContent)){
			c.andAdviceContentEqualTo(adviceContent);
		}
		if(!ValidateUtil.isEmpty(adviceType)){
			c.andAdviceTypeEqualTo(adviceType);
		}
		if(!ValidateUtil.isEmpty(status)){
			c.andStatusEqualTo(status);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		if(!ValidateUtil.isEmpty(isDeal)){
			c.andIsDealEqualTo(isDeal);
		}
		if(!ValidateUtil.isEmpty(resContent)){
			c.andResContentEqualTo(resContent);
		}
		if(!ValidateUtil.isEmpty(dealBy)){
			c.andDealByEqualTo(dealBy);
		}
		if(!ValidateUtil.isEmpty(dealTime)){
			c.andDealTimeEqualTo(dealTime);
		}
		if(!ValidateUtil.isEmpty(audit1By)){
			c.andAudit1ByEqualTo(audit1By);
		}
		if(!ValidateUtil.isEmpty(audit1Time)){
			c.andAudit1TimeEqualTo(audit1Time);
		}
		if(!ValidateUtil.isEmpty(audit2By)){
			c.andAudit2ByEqualTo(audit2By);
		}
		if(!ValidateUtil.isEmpty(audit2Time)){
			c.andAudit2TimeEqualTo(audit2Time);
		}
		if(!ValidateUtil.isEmpty(audit3By)){
			c.andAudit3ByEqualTo(audit3By);
		}
		if(!ValidateUtil.isEmpty(audit3Time)){
			c.andAudit3TimeEqualTo(audit3Time);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Advice> page = (Page<Advice>) adviceMapper.selectByExampleWithBLOBs(de);
		AdviceLtResp resp = new AdviceLtResp();
		resp.setCount(page.getTotal());
		resp.setAdviceLt(page.getResult());
		return resp;
	}
	
}
