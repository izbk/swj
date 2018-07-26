package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.component.WebSocketComponent;
import cn.com.yuanwei.center.entity.AuditConfig;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.Specialty;
import cn.com.yuanwei.center.entity.SpecialtyExample;
import cn.com.yuanwei.center.entity.SpecialtyExample.Criteria;
import cn.com.yuanwei.center.entity.ToDoList;
import cn.com.yuanwei.center.entity.ToDoListExample;
import cn.com.yuanwei.center.enums.AuditStatusEnum;
import cn.com.yuanwei.center.enums.BusiTypeEnum;
import cn.com.yuanwei.center.enums.IsDealEnum;
import cn.com.yuanwei.center.mapper.AuditConfigMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.SpecialtyMapper;
import cn.com.yuanwei.center.mapper.ToDoListMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.SpecialtyService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.SpecialtyReq;
import cn.com.yuanwei.center.web.response.SpecialtyLtResp;

@Service
@Transactional
public class SpecialtyServiceImpl implements SpecialtyService {
	@Autowired
	private SpecialtyMapper specialtyMapper;
	@Autowired
	private AuditConfigMapper auditConfigMapper;
	@Autowired
	private ToDoListMapper toDoListMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(Specialty specialty) throws Exception {
		specialty.setCreateTime(new Date());
		specialty.setStatus(AuditStatusEnum.weishenhe.getCode());
		specialtyMapper.insert(specialty);
		
		//新增待办事项
		AuditConfig record = new AuditConfig();
		record.setBusiType(BusiTypeEnum.mianzhuzao.getCode());
		record.setSubBusiType(specialty.getCategory());
		List<AuditConfig> list = auditConfigMapper.selectByAuditConfig(record);
		if(list != null && list.size() > 0){
			AuditConfig config = list.get(0);
			if(!ValidateUtil.isEmpty(config.getUserId1())){
				ToDoList toDoList = new ToDoList();
				toDoList.setAuditConfigId(config.getId());
				toDoList.setBusiId(specialty.getId());
				toDoList.setBusiName(specialty.getProductName());
				toDoList.setBusiType(BusiTypeEnum.mianzhuzao.getCode());
				toDoList.setSubBusiType(specialty.getCategory());
				toDoList.setCreateTime(new Date());
				toDoList.setUserId(config.getUserId1());
				toDoList.setIsDeal(IsDealEnum.fou.getCode());
				toDoListMapper.insertSelective(toDoList);
				WebSocketComponent.sendMessage("您有新的待办事项", config.getUserId1().toString());
			}
		}
		return specialty.getId();
	}

	@Override
	public Integer update(Specialty specialty) throws Exception {
		Integer status = specialty.getStatus();
		if(status != null){
			ToDoListExample de = new ToDoListExample();
			de.createCriteria().andBusiIdEqualTo(specialty.getId());
			toDoListMapper.deleteByExample(de);
			if(status.compareTo(AuditStatusEnum.weishenhe.getCode())==0){
				//新增待办事项
				AuditConfig record = new AuditConfig();
				record.setBusiType(BusiTypeEnum.mianzhuzao.getCode());
				record.setSubBusiType(specialty.getCategory());
				List<AuditConfig> list = auditConfigMapper.selectByAuditConfig(record);
				if(list != null && list.size() > 0){
					AuditConfig config = list.get(0);
					if(!ValidateUtil.isEmpty(config.getUserId1())){
						ToDoList toDoList = new ToDoList();
						toDoList.setAuditConfigId(config.getId());
						toDoList.setBusiId(specialty.getId());
						toDoList.setBusiName(specialty.getProductName());
						toDoList.setBusiType(BusiTypeEnum.mianzhuzao.getCode());
						toDoList.setSubBusiType(specialty.getCategory());
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
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),specialty.getId(), "更新绵竹造信息"));
		return specialtyMapper.updateByPrimaryKey(specialty);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除绵竹造信息"));
		}
		
		//删除待办事项
		ToDoListExample de2 = new ToDoListExample();
		de2.createCriteria().andBusiIdIn(ids);
		toDoListMapper.deleteByExample(de2);
		
		SpecialtyExample de=new SpecialtyExample();
		de.createCriteria().andIdIn(ids);
		return specialtyMapper.deleteByExample(de);
	}
	
	@Override
	public Specialty queryById(Integer id){
		return specialtyMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public SpecialtyLtResp queryList(SpecialtyReq req) throws Exception {
		Integer id = req.getId();
		String subject = req.getSubject();
		Integer subjectType = req.getSubjectType();
		String productName = req.getProductName();
		String intro = req.getIntro();
		String scale = req.getScale();
		Integer category = req.getCategory();
		String origin = req.getOrigin();
		String seasonal = req.getSeasonal();
		String saleChannel = req.getSaleChannel();
		String salesStatus = req.getSalesStatus();
		String priceRange = req.getPriceRange();
		String accreditation = req.getAccreditation();
		String trademark = req.getTrademark();
		String onlineSale = req.getOnlineSale();
		String contact = req.getContact();
		String proposal = req.getProposal();
		String productPic = req.getProductPic();
		Integer status = req.getStatus();
		Integer audit1By = req.getAudit1By();
		Date audit1Time = req.getAudit1Time();
		Integer audit2By = req.getAudit2By();
		Date audit2Time = req.getAudit2Time();
		Integer audit3By = req.getAudit3By();
		Date audit3Time = req.getAudit3Time();
		SpecialtyExample de=new SpecialtyExample();
		de.setOrderByClause(" status,id desc");
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(subject)){
			c.andSubjectEqualTo(subject);
		}
		if(!ValidateUtil.isEmpty(subjectType)){
			c.andSubjectTypeEqualTo(subjectType);
		}
		if(!ValidateUtil.isEmpty(productName)){
			c.andProductNameLike("%"+productName+"%");
		}
		if(!ValidateUtil.isEmpty(intro)){
			c.andIntroEqualTo(intro);
		}
		if(!ValidateUtil.isEmpty(scale)){
			c.andScaleEqualTo(scale);
		}
		if(!ValidateUtil.isEmpty(category)){
			c.andCategoryEqualTo(category);
		}
		if(!ValidateUtil.isEmpty(origin)){
			c.andOriginEqualTo(origin);
		}
		if(!ValidateUtil.isEmpty(seasonal)){
			c.andSeasonalEqualTo(seasonal);
		}
		if(!ValidateUtil.isEmpty(saleChannel)){
			c.andSaleChannelEqualTo(saleChannel);
		}
		if(!ValidateUtil.isEmpty(salesStatus)){
			c.andSalesStatusEqualTo(salesStatus);
		}
		if(!ValidateUtil.isEmpty(priceRange)){
			c.andPriceRangeEqualTo(priceRange);
		}
		if(!ValidateUtil.isEmpty(accreditation)){
			c.andAccreditationEqualTo(accreditation);
		}
		if(!ValidateUtil.isEmpty(trademark)){
			c.andTrademarkEqualTo(trademark);
		}
		if(!ValidateUtil.isEmpty(onlineSale)){
			c.andOnlineSaleEqualTo(onlineSale);
		}
		if(!ValidateUtil.isEmpty(contact)){
			c.andContactEqualTo(contact);
		}
		if(!ValidateUtil.isEmpty(proposal)){
			c.andProposalEqualTo(proposal);
		}
		if(!ValidateUtil.isEmpty(productPic)){
			c.andProductPicEqualTo(productPic);
		}
		if(!ValidateUtil.isEmpty(status)){
			c.andStatusEqualTo(status);
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
		Page<Specialty> page = (Page<Specialty>) specialtyMapper.selectByExampleWithBLOBs(de);
		SpecialtyLtResp resp = new SpecialtyLtResp();
		resp.setCount(page.getTotal());
		resp.setSpecialtyLt(page.getResult());
		return resp;
	}
	
}
