package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.Company;
import cn.com.yuanwei.center.entity.CompanyExample;
import cn.com.yuanwei.center.entity.CompanyExample.Criteria;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.ToDoListExample;
import cn.com.yuanwei.center.enums.AuditStatusEnum;
import cn.com.yuanwei.center.mapper.AuditConfigMapper;
import cn.com.yuanwei.center.mapper.CompanyMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.ToDoListMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.CompanyService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.CompanyReq;
import cn.com.yuanwei.center.web.response.CompanyLtResp;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private AuditConfigMapper auditConfigMapper;
	@Autowired
	private ToDoListMapper toDoListMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(Company company) throws Exception {
		company.setStatus(AuditStatusEnum.weishenhe.getCode());
		company.setCreateTime(new Date());
		companyMapper.insert(company);
		//新增待办事项
		/*AuditConfig record = new AuditConfig();
		record.setBusiType(BusiTypeEnum.qiyebeian.getCode());
		record.setSubBusiType(company.getEnterpriseType());
		List<AuditConfig> list = auditConfigMapper.selectByAuditConfig(record);
		if(list != null && list.size() > 0){
			AuditConfig config = list.get(0);
			if(!ValidateUtil.isEmpty(config.getUserId1())){
				ToDoList toDoList = new ToDoList();
				toDoList.setAuditConfigId(config.getId());
				toDoList.setBusiId(company.getId());
				toDoList.setBusiName(company.getCompanyName());
				toDoList.setBusiType(BusiTypeEnum.qiyebeian.getCode());
				toDoList.setSubBusiType(company.getEnterpriseType());
				toDoList.setCreateTime(new Date());
				toDoList.setUserId(config.getUserId1());
				toDoList.setIsDeal(IsDealEnum.fou.getCode());
				toDoListMapper.insertSelective(toDoList);
				WebSocketComponent.sendMessage("您有新的待办事项", config.getUserId1().toString());
			}
		}*/
		return company.getId();
	}

	@Override
	public Integer update(Company company) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),company.getId(), "更新企业备案信息"));
		/*Integer status = company.getStatus();
		if(status != null){
			ToDoListExample de = new ToDoListExample();
			de.createCriteria().andBusiIdEqualTo(company.getId());
			toDoListMapper.deleteByExample(de);
			if(status.compareTo(AuditStatusEnum.weishenhe.getCode())==0){
				//新增待办事项
				AuditConfig record = new AuditConfig();
				record.setBusiType(BusiTypeEnum.qiyebeian.getCode());
				record.setSubBusiType(company.getEnterpriseType());
				List<AuditConfig> list = auditConfigMapper.selectByAuditConfig(record);
				if(list != null && list.size() > 0){
					AuditConfig config = list.get(0);
					if(!ValidateUtil.isEmpty(config.getUserId1())){
						ToDoList toDoList = new ToDoList();
						toDoList.setAuditConfigId(config.getId());
						toDoList.setBusiId(company.getId());
						toDoList.setBusiName(company.getCompanyName());
						toDoList.setBusiType(BusiTypeEnum.qiyebeian.getCode());
						toDoList.setSubBusiType(company.getEnterpriseType());
						toDoList.setCreateTime(new Date());
						toDoList.setUserId(config.getUserId1());
						toDoList.setIsDeal(IsDealEnum.fou.getCode());
						toDoListMapper.insertSelective(toDoList);
					}
				}
			}
		}*/
		return companyMapper.updateByPrimaryKey(company);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除企业备案信息"));
		}
		//删除待办事项
		ToDoListExample de2 = new ToDoListExample();
		de2.createCriteria().andBusiIdIn(ids);
		toDoListMapper.deleteByExample(de2);
		
		CompanyExample de=new CompanyExample();
		de.createCriteria().andIdIn(ids);
		return companyMapper.deleteByExample(de);
	}
	
	@Override
	public Company queryById(Integer id){
		return companyMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public CompanyLtResp queryList(CompanyReq req) throws Exception {
		Integer id = req.getId();
		String companyName = req.getCompanyName();
		Integer enterpriseType = req.getEnterpriseType();
		Integer industryType = req.getIndustryType();
		String chargeName = req.getChargeName();
		String chargeMobile = req.getChargeMobile();
		String mianBusiness = req.getMianBusiness();
		Integer avgTurnover = req.getAvgTurnover();
		Integer employees = req.getEmployees();
		Integer isSeed = req.getIsSeed();
		Date createTime = req.getCreateTime();
		CompanyExample de=new CompanyExample();
		de.setOrderByClause(" status,id desc");
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(companyName)){
			c.andCompanyNameLike("%"+companyName+"%");
		}
		if(!ValidateUtil.isEmpty(enterpriseType)){
			c.andEnterpriseTypeEqualTo(enterpriseType);
		}
		if(!ValidateUtil.isEmpty(industryType)){
			c.andIndustryTypeEqualTo(industryType);
		}
		if(!ValidateUtil.isEmpty(chargeName)){
			c.andChargeNameLike("%"+chargeName+"%");
		}
		if(!ValidateUtil.isEmpty(chargeMobile)){
			c.andChargeMobileEqualTo(chargeMobile);
		}
		if(!ValidateUtil.isEmpty(mianBusiness)){
			c.andMianBusinessEqualTo(mianBusiness);
		}
		if(!ValidateUtil.isEmpty(avgTurnover)){
			c.andAvgTurnoverEqualTo(avgTurnover);
		}
		if(!ValidateUtil.isEmpty(employees)){
			c.andEmployeesEqualTo(employees);
		}
		if(!ValidateUtil.isEmpty(isSeed)){
			c.andIsSeedEqualTo(isSeed);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Company> page = (Page<Company>) companyMapper.selectByExampleWithBLOBs(de);
		CompanyLtResp resp = new CompanyLtResp();
		resp.setCount(page.getTotal());
		resp.setCompanyLt(page.getResult());
		return resp;
	}
	
}
