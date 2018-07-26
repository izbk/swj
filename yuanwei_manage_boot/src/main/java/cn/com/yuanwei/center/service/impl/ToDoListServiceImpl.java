package cn.com.yuanwei.center.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.Advice;
import cn.com.yuanwei.center.entity.Article;
import cn.com.yuanwei.center.entity.AuditConfig;
import cn.com.yuanwei.center.entity.Company;
import cn.com.yuanwei.center.entity.Project;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.Specialty;
import cn.com.yuanwei.center.entity.ToDoList;
import cn.com.yuanwei.center.entity.ToDoListExample;
import cn.com.yuanwei.center.entity.ToDoListExample.Criteria;
import cn.com.yuanwei.center.enums.ArticleStatusEnum;
import cn.com.yuanwei.center.enums.AuditStatusEnum;
import cn.com.yuanwei.center.enums.BusiTypeEnum;
import cn.com.yuanwei.center.enums.IsDealEnum;
import cn.com.yuanwei.center.enums.IsEnum;
import cn.com.yuanwei.center.mapper.AdviceMapper;
import cn.com.yuanwei.center.mapper.ArticleMapper;
import cn.com.yuanwei.center.mapper.AuditConfigMapper;
import cn.com.yuanwei.center.mapper.CompanyMapper;
import cn.com.yuanwei.center.mapper.ProjectMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.SpecialtyMapper;
import cn.com.yuanwei.center.mapper.ToDoListMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.ToDoListService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ToDoListReq;
import cn.com.yuanwei.center.web.response.ToDoListLtResp;

@Service
@Transactional
public class ToDoListServiceImpl implements ToDoListService {
	@Autowired
	private ToDoListMapper toDoListMapper;
	@Autowired
	 private AuditConfigMapper auditConfigMapper;
	@Autowired
	 private ArticleMapper articleMapper;
	@Autowired
	 private ProjectMapper projectMapper;
	@Autowired
	 private  SpecialtyMapper specialtyMapper;
	@Autowired
	 private AdviceMapper adviceMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	private UserInfo userInfo = LoginUserThread.getUser();
	
	@Override
	public Integer save(ToDoList toDoList) throws Exception {
		Date currDate = new Date();
		toDoList.setCreateTime(currDate);
		toDoListMapper.insert(toDoList);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,toDoList.getId(), "新增待办事项"));
		return toDoList.getId();
	}

	@Override
	public Integer update(ToDoList toDoList) throws Exception {
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),toDoList.getId(), "更新待办事项"));
		return toDoListMapper.updateByPrimaryKey(toDoList);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除待办事项"));
		}	
		ToDoListExample example = new ToDoListExample();
		example.createCriteria().andIdIn(ids);
		return toDoListMapper.deleteByExample(example);
	}
	
	@Override
	public ToDoList queryById(Integer id){
		return toDoListMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ToDoListLtResp queryList(ToDoListReq req) throws Exception {
		Integer id = req.getId();
		Integer userId = req.getUserId();
		Integer auditConfigId = req.getAuditConfigId();
		String busiName = req.getBusiName();
		Integer busiId = req.getBusiId();
		Integer busiType = req.getBusiType();
		Integer subBusiType = req.getSubBusiType();
		Date createTime = req.getCreateTime();
		Integer isDeal = req.getIsDeal();
		Date dealTime = req.getDealTime();
		ToDoListExample example = new ToDoListExample();
		example.setOrderByClause("is_deal,id");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(userId)){
			c.andUserIdEqualTo(userId);
		}
		if(!ValidateUtil.isEmpty(auditConfigId)){
			c.andAuditConfigIdEqualTo(auditConfigId);
		}
		if(!ValidateUtil.isEmpty(busiName)){
			c.andBusiNameLike("%"+busiName+"%");
		}
		if(!ValidateUtil.isEmpty(busiId)){
			c.andBusiIdEqualTo(busiId);
		}
		if(!ValidateUtil.isEmpty(busiType)){
			c.andBusiTypeEqualTo(busiType);
		}
		if(!ValidateUtil.isEmpty(subBusiType)){
			c.andSubBusiTypeEqualTo(subBusiType);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		if(!ValidateUtil.isEmpty(isDeal)){
			c.andIsDealEqualTo(isDeal);
		}
		if(!ValidateUtil.isEmpty(dealTime)){
			c.andDealTimeEqualTo(dealTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<ToDoList> page = (Page<ToDoList>) toDoListMapper.selectByExample(example);
		ToDoListLtResp resp = new ToDoListLtResp();
		resp.setCount(page.getTotal());
		resp.setToDoListLt(page.getResult());
		return resp;
	}
	

	@Override
	public ToDoListLtResp queryTotal(ToDoListReq req) throws Exception {
		Integer userId = req.getUserId();
		ToDoListExample de=new ToDoListExample();
		de.createCriteria().andUserIdEqualTo(userId).andIsDealEqualTo(req.getIsDeal());
		int total = toDoListMapper.countByExample(de);
		ToDoListLtResp resp = new ToDoListLtResp();
		resp.setCount((long)total);
		return resp;
	}

	@Override
	public void deal(ToDoListReq req) throws Exception {
		Integer id = req.getId();
		Integer status = req.getStatus();
		String content = req.getContent();
		ToDoList toDoList = toDoListMapper.selectByPrimaryKey(id);
		if(toDoList == null){
			throw new Exception("未获取到待办事项信息");
		}
		//更新待办事项状态
		Date currDate = Calendar.getInstance().getTime();
		toDoList.setIsDeal(1);
		toDoList.setDealTime(currDate);
		toDoListMapper.updateByPrimaryKeySelective(toDoList);
		
		//审核具体业务
		Integer userId = toDoList.getUserId();
		Integer busiId = toDoList.getBusiId();
		Integer busiType = toDoList.getBusiType();
		Integer auditConfigId = toDoList.getAuditConfigId();
		if(BusiTypeEnum.wenzhang.getCode().compareTo(busiType)==0){//文章审核
			dealArticle(status, toDoList, currDate, userId, busiId, auditConfigId,content);
		}else if(BusiTypeEnum.xiangmu.getCode().compareTo(busiType)==0){//项目审核
			dealProject(status, toDoList, currDate, userId, busiId, auditConfigId,content);
		}else if(BusiTypeEnum.mianzhuzao.getCode().compareTo(busiType)==0){//绵竹造审核
			dealSpecialty(status, toDoList, currDate, userId, busiId, auditConfigId,content);
		}else if(BusiTypeEnum.tousujianyi.getCode().compareTo(busiType)==0){//投诉建议审核
			dealAdvice(IsEnum.yes.getCode(), toDoList, currDate, userId, busiId,auditConfigId,content);
		}else{//企业备案审核
			dealCompany(status, toDoList, currDate, userId, busiId, auditConfigId,content);
		}
		//记录日志
		ServiceLogs log = new ServiceLogs(userId, LoginUserThread.getUser().getNickName(), new Date(),req.getBusiId(), "处理待办事项， 业务名称:"+BusiTypeEnum.getDesc(busiType));
		serviceLogsMapper.insertSelective(log);
	}

	private void dealAdvice(Integer status, ToDoList toDoList, Date currDate, Integer userId, Integer busiId,
			Integer auditConfigId,String content) {
		Advice advice = new Advice();
		advice.setId(busiId);
		
		AuditConfig config = auditConfigMapper.selectByPrimaryKey(auditConfigId);
		Integer audit1 = config.getUserId1();
		Integer audit2 = config.getUserId2();
		Integer audit3 = config.getUserId3();
		if(audit1 !=null && userId.compareTo(audit1) == 0){
			advice.setAudit1By(userId);
			advice.setAudit1Time(currDate);
			//一级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				advice.setStatus(AuditStatusEnum.shenhebutongguo.getCode());//审核不通过
				advice.setAudit1Opinion(content);
			}else{
				if(audit2 != null){
					//新增上级待办事项
					toDoList.setUserId(audit2);
					toDoList.setIsDeal(IsDealEnum.fou.getCode());
					toDoList.setCreateTime(new Date());
					toDoList.setDealTime(null);
					toDoList.setId(null);
					toDoListMapper.insertSelective(toDoList);
				}else{
					advice.setStatus(AuditStatusEnum.yishenhe.getCode());//审核通过
				}
			}
		}
		
		if(audit2 !=null && userId.compareTo(audit2) == 0){
			advice.setAudit2By(userId);
			advice.setAudit2Time(currDate);
			//二级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				advice.setStatus(AuditStatusEnum.shenhebutongguo.getCode());//审核不通过
				advice.setAudit2Opinion(content);
			}else{
				if(audit3 != null){
					//新增上级待办事项
					toDoList.setUserId(audit3);
					toDoList.setIsDeal(IsDealEnum.fou.getCode());
					toDoList.setCreateTime(new Date());
					toDoList.setDealTime(null);
					toDoList.setId(null);
					toDoListMapper.insertSelective(toDoList);
				}else{
					advice.setStatus(ArticleStatusEnum.yishenhe.getCode());//审核通过
				}
			}
		}
		if(audit3 !=null && userId.compareTo(audit3) == 0){
			advice.setAudit3By(userId);
			advice.setAudit3Time(currDate);
			//三级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				advice.setStatus(AuditStatusEnum.shenhebutongguo.getCode());//审核不通过
				advice.setAudit3Opinion(content);
			}else{
				advice.setStatus(AuditStatusEnum.yishenhe.getCode());//审核通过
			}
		}
		advice.setDealBy(audit1);
		advice.setDealTime(currDate);
		advice.setIsDeal(IsDealEnum.shi.getCode());
		advice.setResContent(content);
		adviceMapper.updateByPrimaryKeySelective(advice);
	}

	private void dealSpecialty(Integer status, ToDoList toDoList, Date currDate, Integer userId, Integer busiId,
			Integer auditConfigId,String content) {
		//绵竹造审核
		Specialty specialty = new Specialty();
		specialty.setId(busiId);
		
		AuditConfig config = auditConfigMapper.selectByPrimaryKey(auditConfigId);
		Integer audit1 = config.getUserId1();
		Integer audit2 = config.getUserId2();
		Integer audit3 = config.getUserId3();
		if(audit1 !=null && userId.compareTo(audit1) == 0){
			specialty.setAudit1By(userId);
			specialty.setAudit1Time(currDate);
			//一级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				specialty.setStatus(AuditStatusEnum.shenhebutongguo.getCode());//审核不通过
				specialty.setAudit1Opinion(content);
			}else{
				if(audit2 != null){
					//新增上级待办事项
					toDoList.setUserId(audit2);
					toDoList.setIsDeal(IsDealEnum.fou.getCode());
					toDoList.setCreateTime(new Date());
					toDoList.setDealTime(null);
					toDoList.setId(null);
					toDoListMapper.insertSelective(toDoList);
				}else{
					specialty.setStatus(AuditStatusEnum.yishenhe.getCode());//审核通过
				}
			}
		}
		
		if(audit2 !=null && userId.compareTo(audit2) == 0){
			specialty.setAudit2By(userId);
			specialty.setAudit2Time(currDate);
			//二级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				specialty.setStatus(AuditStatusEnum.shenhebutongguo.getCode());//审核不通过
				specialty.setAudit2Opinion(content);
			}else{
				if(audit3 != null){
					//新增上级待办事项
					toDoList.setUserId(audit3);
					toDoList.setIsDeal(IsDealEnum.fou.getCode());
					toDoList.setCreateTime(new Date());
					toDoList.setDealTime(null);
					toDoList.setId(null);
					toDoListMapper.insertSelective(toDoList);
				}else{
					specialty.setStatus(ArticleStatusEnum.yishenhe.getCode());//审核通过
				}
			}
		}
		if(audit3 !=null && userId.compareTo(audit3) == 0){
			specialty.setAudit3By(userId);
			specialty.setAudit3Time(currDate);
			//三级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				specialty.setStatus(AuditStatusEnum.shenhebutongguo.getCode());//审核不通过
				specialty.setAudit3Opinion(content);
			}else{
				specialty.setStatus(AuditStatusEnum.yishenhe.getCode());//审核通过
			}
		}
		specialtyMapper.updateByPrimaryKeySelective(specialty);
	}

	private void dealProject(Integer status, ToDoList toDoList, Date currDate, Integer userId, Integer busiId,
			Integer auditConfigId,String content) {
		//项目审核
		Project project = new Project();
		project.setId(busiId);
		
		AuditConfig config = auditConfigMapper.selectByPrimaryKey(auditConfigId);
		Integer audit1 = config.getUserId1();
		Integer audit2 = config.getUserId2();
		Integer audit3 = config.getUserId3();
		if(audit1 !=null && userId.compareTo(audit1) == 0){
			project.setAudit1By(userId);
			project.setAudit1Time(currDate);
			//一级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				project.setStatus(AuditStatusEnum.shenhebutongguo.getCode());//审核不通过
				project.setAudit1Opinion(content);
			}else{
				if(audit2 != null){
					//新增上级待办事项
					toDoList.setUserId(audit2);
					toDoList.setIsDeal(IsDealEnum.fou.getCode());
					toDoList.setCreateTime(new Date());
					toDoList.setDealTime(null);
					toDoList.setId(null);
					toDoListMapper.insertSelective(toDoList);
				}else{
					project.setStatus(AuditStatusEnum.yishenhe.getCode());//审核通过
				}
			}
		}
		
		if(audit2 !=null && userId.compareTo(audit2) == 0){
			project.setAudit2By(userId);
			project.setAudit2Time(currDate);
			//二级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				project.setStatus(AuditStatusEnum.shenhebutongguo.getCode());//审核不通过
				project.setAudit2Opinion(content);
			}else{
				if(audit3 != null){
					//新增上级待办事项
					toDoList.setUserId(audit3);
					toDoList.setIsDeal(IsDealEnum.fou.getCode());
					toDoList.setCreateTime(new Date());
					toDoList.setDealTime(null);
					toDoList.setId(null);
					toDoListMapper.insertSelective(toDoList);
				}else{
					project.setStatus(ArticleStatusEnum.yishenhe.getCode());//审核通过
				}
			}
		}
		if(audit3 !=null && userId.compareTo(audit3) == 0){
			project.setAudit3By(userId);
			project.setAudit3Time(currDate);
			//三级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				project.setStatus(AuditStatusEnum.shenhebutongguo.getCode());//审核不通过
				project.setAudit3Opinion(content);
			}else{
				project.setStatus(AuditStatusEnum.yishenhe.getCode());//审核通过
			}
		}
		projectMapper.updateByPrimaryKeySelective(project);
	}

	private void dealArticle(Integer status, ToDoList toDoList, Date currDate, Integer userId, Integer busiId,
			Integer auditConfigId,String content) {
		Article article = new Article();
		article.setId(busiId);
		
		AuditConfig config = auditConfigMapper.selectByPrimaryKey(auditConfigId);
		Integer audit1 = config.getUserId1();
		Integer audit2 = config.getUserId2();
		Integer audit3 = config.getUserId3();
		if(audit1 !=null && userId.compareTo(audit1) == 0){
			article.setAudit1By(userId);
			article.setAudit1Time(currDate);
			//一级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				article.setStatus(ArticleStatusEnum.shenhebutongguo.getCode());//审核不通过
				article.setAudit1Opinion(content);
			}else{
				if(audit2 != null){
					//新增上级待办事项
					toDoList.setUserId(audit2);
					toDoList.setIsDeal(IsDealEnum.fou.getCode());
					toDoList.setCreateTime(new Date());
					toDoList.setDealTime(null);
					toDoList.setId(null);
					toDoListMapper.insertSelective(toDoList);
				}else{
					article.setPublishTime(currDate);
					article.setStatus(ArticleStatusEnum.yishenhe.getCode());//审核通过
				}
			}
		}
		if(audit2 !=null && userId.compareTo(audit2) == 0){
			article.setAudit2By(userId);
			article.setAudit2Time(currDate);
			//二级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				article.setStatus(ArticleStatusEnum.shenhebutongguo.getCode());//审核不通过
				article.setAudit2Opinion(content);
			}else{
				if(audit3 != null){
					//新增上级待办事项
					toDoList.setUserId(audit3);
					toDoList.setIsDeal(IsDealEnum.fou.getCode());
					toDoList.setCreateTime(new Date());
					toDoList.setDealTime(null);
					toDoList.setId(null);
					toDoListMapper.insertSelective(toDoList);
				}else{
					article.setPublishTime(currDate);
					article.setStatus(ArticleStatusEnum.yishenhe.getCode());//审核通过
				}
			}
		}
		if(audit3 !=null && userId.compareTo(audit3) == 0){
			article.setAudit3By(userId);
			article.setAudit3Time(currDate);
			//三级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				article.setStatus(ArticleStatusEnum.shenhebutongguo.getCode());//审核不通过
				article.setAudit3Opinion(content);
			}else{
				article.setPublishTime(currDate);
				article.setStatus(ArticleStatusEnum.yishenhe.getCode());//审核通过
			}
		}
		articleMapper.updateByPrimaryKeySelective(article);
	}
	private void dealCompany(Integer status, ToDoList toDoList, Date currDate, Integer userId, Integer busiId,
			Integer auditConfigId,String content) {
		Company company = new Company();
		company.setId(busiId);
		
		AuditConfig config = auditConfigMapper.selectByPrimaryKey(auditConfigId);
		Integer audit1 = config.getUserId1();
		Integer audit2 = config.getUserId2();
		Integer audit3 = config.getUserId3();
		if(audit1 !=null && userId.compareTo(audit1) == 0){
			company.setAudit1By(userId);
			company.setAudit1Time(currDate);
			//一级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				company.setStatus(ArticleStatusEnum.shenhebutongguo.getCode());//审核不通过
				company.setAudit1Opinion(content);
			}else{
				if(audit2 != null){
					//新增上级待办事项
					toDoList.setUserId(audit2);
					toDoList.setIsDeal(IsDealEnum.fou.getCode());
					toDoList.setCreateTime(new Date());
					toDoList.setDealTime(null);
					toDoList.setId(null);
					toDoListMapper.insertSelective(toDoList);
				}else{
					company.setStatus(ArticleStatusEnum.yishenhe.getCode());//审核通过
				}
			}
		}
		if(audit2 !=null && userId.compareTo(audit2) == 0){
			company.setAudit2By(userId);
			company.setAudit2Time(currDate);
			//二级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				company.setStatus(ArticleStatusEnum.shenhebutongguo.getCode());//审核不通过
				company.setAudit2Opinion(content);
			}else{
				if(audit3 != null){
					//新增上级待办事项
					toDoList.setUserId(audit3);
					toDoList.setIsDeal(IsDealEnum.fou.getCode());
					toDoList.setCreateTime(new Date());
					toDoList.setDealTime(null);
					toDoList.setId(null);
					toDoListMapper.insertSelective(toDoList);
				}else{
					company.setStatus(ArticleStatusEnum.yishenhe.getCode());//审核通过
				}
			}
		}
		if(audit3 !=null && userId.compareTo(audit3) == 0){
			company.setAudit3By(userId);
			company.setAudit3Time(currDate);
			//三级审核不通过
			if(status.compareTo(IsEnum.no.getCode())==0){
				company.setStatus(ArticleStatusEnum.shenhebutongguo.getCode());//审核不通过
				company.setAudit3Opinion(content);
			}else{
				company.setStatus(ArticleStatusEnum.yishenhe.getCode());//审核通过
			}
		}
		companyMapper.updateByPrimaryKeySelective(company);
	}

}
