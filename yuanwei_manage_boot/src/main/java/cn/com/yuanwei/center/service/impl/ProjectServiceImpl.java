package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.Project;
import cn.com.yuanwei.center.entity.ProjectExample;
import cn.com.yuanwei.center.entity.ProjectExample.Criteria;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.ToDoListExample;
import cn.com.yuanwei.center.enums.AuditStatusEnum;
import cn.com.yuanwei.center.mapper.AuditConfigMapper;
import cn.com.yuanwei.center.mapper.ProjectMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.ToDoListMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.ProjectService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ProjectReq;
import cn.com.yuanwei.center.web.response.ProjectLtResp;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private AuditConfigMapper auditConfigMapper;
	@Autowired
	private ToDoListMapper toDoListMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(Project project) throws Exception {
		project.setCreateTime(new Date());
		project.setStatus(AuditStatusEnum.weishenhe.getCode());
		projectMapper.insert(project);
		//新增待办事项
		/*AuditConfig record = new AuditConfig();
		record.setBusiType(BusiTypeEnum.xiangmu.getCode());
		record.setSubBusiType(project.getProjectType());
		List<AuditConfig> list = auditConfigMapper.selectByAuditConfig(record);
		if(list != null && list.size() > 0){
			AuditConfig config = list.get(0);
			if(!ValidateUtil.isEmpty(config.getUserId1())){
				ToDoList toDoList = new ToDoList();
				toDoList.setAuditConfigId(config.getId());
				toDoList.setBusiId(project.getId());
				toDoList.setBusiName(project.getProjectName());
				toDoList.setBusiType(BusiTypeEnum.xiangmu.getCode());
				toDoList.setSubBusiType(project.getProjectType());
				toDoList.setCreateTime(new Date());
				toDoList.setUserId(config.getUserId1());
				toDoList.setIsDeal(IsDealEnum.fou.getCode());
				toDoListMapper.insertSelective(toDoList);
				WebSocketComponent.sendMessage("您有新的待办事项", config.getUserId1().toString());
			}
		}*/
		return project.getId();
	}

	@Override
	public Integer update(Project project) throws Exception {
		/*Integer status = project.getStatus();
		if(status != null){
			ToDoListExample de = new ToDoListExample();
			de.createCriteria().andBusiIdEqualTo(project.getId());
			toDoListMapper.deleteByExample(de);
			if(status.compareTo(AuditStatusEnum.weishenhe.getCode())==0){
				//新增待办事项
				AuditConfig record = new AuditConfig();
				record.setBusiType(BusiTypeEnum.xiangmu.getCode());
				record.setSubBusiType(project.getProjectType());
				List<AuditConfig> list = auditConfigMapper.selectByAuditConfig(record);
				if(list != null && list.size() > 0){
					AuditConfig config = list.get(0);
					if(!ValidateUtil.isEmpty(config.getUserId1())){
						ToDoList toDoList = new ToDoList();
						toDoList.setAuditConfigId(config.getId());
						toDoList.setBusiId(project.getId());
						toDoList.setBusiName(project.getProjectName());
						toDoList.setBusiType(BusiTypeEnum.xiangmu.getCode());
						toDoList.setSubBusiType(project.getProjectType());
						toDoList.setCreateTime(new Date());
						toDoList.setUserId(config.getUserId1());
						toDoList.setIsDeal(IsDealEnum.fou.getCode());
						toDoListMapper.insertSelective(toDoList);
					}
				}
			}
		}*/
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,project.getId(), "更新项目储备信息"));		
		return projectMapper.updateByPrimaryKey(project);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除项目储备信息"));
		}
		
		//删除待办事项
		ToDoListExample de2 = new ToDoListExample();
		de2.createCriteria().andBusiIdIn(ids);
		toDoListMapper.deleteByExample(de2);
		
		ProjectExample de=new ProjectExample();
		de.createCriteria().andIdIn(ids);
		return projectMapper.deleteByExample(de);
	}
	
	@Override
	public Project queryById(Integer id){
		return projectMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ProjectLtResp queryList(ProjectReq req) throws Exception {
		Integer id = req.getId();
		String projectName = req.getProjectName();
		String address = req.getAddress();
		Date plannedStartDate = req.getPlannedStartDate();
		Date plannedCompletionTime = req.getPlannedCompletionTime();
		BigDecimal landArea = req.getLandArea();
		BigDecimal buildingArea = req.getBuildingArea();
		BigDecimal businessArea = req.getBusinessArea();
		Integer isUse = req.getIsUse();
		Integer isStage = req.getIsStage();
		Integer isBeyondYear = req.getIsBeyondYear();
		Integer projectType = req.getProjectType();
		String owner = req.getOwner();
		String legalPerson = req.getLegalPerson();
		String contact = req.getContact();
		String recordNum = req.getRecordNum();
		BigDecimal approveInvestment = req.getApproveInvestment();
		BigDecimal programInvestment = req.getProgramInvestment();
		BigDecimal planInvestment = req.getPlanInvestment();
		BigDecimal realInvestment = req.getRealInvestment();
		BigDecimal raise = req.getRaise();
		BigDecimal loan = req.getLoan();
		BigDecimal other = req.getOther();
		Integer buildStatus = req.getBuildStatus();
		String constructionContent = req.getConstructionContent();
		String proposal = req.getProposal();
		String assessment = req.getAssessment();
		Integer payStatus = req.getPayStatus();
		Integer status = req.getStatus();
		Integer audit1By = req.getAudit1By();
		Date audit1Time = req.getAudit1Time();
		Integer audit2By = req.getAudit2By();
		Date audit2Time = req.getAudit2Time();
		Integer audit3By = req.getAudit3By();
		Date audit3Time = req.getAudit3Time();
		ProjectExample de=new ProjectExample();
		de.setOrderByClause(" status,id desc");
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(projectName)){
			c.andProjectNameLike("%"+projectName+"%");
		}
		if(!ValidateUtil.isEmpty(address)){
			c.andAddressEqualTo(address);
		}
		if(!ValidateUtil.isEmpty(plannedStartDate)){
			c.andPlannedStartDateEqualTo(plannedStartDate);
		}
		if(!ValidateUtil.isEmpty(plannedCompletionTime)){
			c.andPlannedCompletionTimeEqualTo(plannedCompletionTime);
		}
		if(!ValidateUtil.isEmpty(landArea)){
			c.andLandAreaEqualTo(landArea);
		}
		if(!ValidateUtil.isEmpty(buildingArea)){
			c.andBuildingAreaEqualTo(buildingArea);
		}
		if(!ValidateUtil.isEmpty(businessArea)){
			c.andBusinessAreaEqualTo(businessArea);
		}
		if(!ValidateUtil.isEmpty(isUse)){
			c.andIsUseEqualTo(isUse);
		}
		if(!ValidateUtil.isEmpty(isStage)){
			c.andIsStageEqualTo(isStage);
		}
		if(!ValidateUtil.isEmpty(isBeyondYear)){
			c.andIsBeyondYearEqualTo(isBeyondYear);
		}
		if(!ValidateUtil.isEmpty(projectType)){
			c.andProjectTypeEqualTo(projectType);
		}
		if(!ValidateUtil.isEmpty(owner)){
			c.andOwnerEqualTo(owner);
		}
		if(!ValidateUtil.isEmpty(legalPerson)){
			c.andLegalPersonEqualTo(legalPerson);
		}
		if(!ValidateUtil.isEmpty(contact)){
			c.andContactEqualTo(contact);
		}
		if(!ValidateUtil.isEmpty(recordNum)){
			c.andRecordNumEqualTo(recordNum);
		}
		if(!ValidateUtil.isEmpty(approveInvestment)){
			c.andApproveInvestmentEqualTo(approveInvestment);
		}
		if(!ValidateUtil.isEmpty(programInvestment)){
			c.andProgramInvestmentGreaterThan(programInvestment);
		}
		if(!ValidateUtil.isEmpty(planInvestment)){
			c.andPlanInvestmentEqualTo(planInvestment);
		}
		if(!ValidateUtil.isEmpty(realInvestment)){
			c.andRealInvestmentEqualTo(realInvestment);
		}
		if(!ValidateUtil.isEmpty(raise)){
			c.andRaiseEqualTo(raise);
		}
		if(!ValidateUtil.isEmpty(loan)){
			c.andLoanEqualTo(loan);
		}
		if(!ValidateUtil.isEmpty(other)){
			c.andOtherEqualTo(other);
		}
		if(!ValidateUtil.isEmpty(buildStatus)){
			c.andBuildStatusEqualTo(buildStatus);
		}
		if(!ValidateUtil.isEmpty(constructionContent)){
			c.andConstructionContentEqualTo(constructionContent);
		}
		if(!ValidateUtil.isEmpty(proposal)){
			c.andProposalEqualTo(proposal);
		}
		if(!ValidateUtil.isEmpty(assessment)){
			c.andAssessmentEqualTo(assessment);
		}
		if(!ValidateUtil.isEmpty(payStatus)){
			c.andPayStatusEqualTo(payStatus);
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
		Page<Project> page = (Page<Project>) projectMapper.selectByExampleWithBLOBs(de);
		ProjectLtResp resp = new ProjectLtResp();
		resp.setCount(page.getTotal());
		resp.setProjectLt(page.getResult());
		return resp;
	}
	
}
