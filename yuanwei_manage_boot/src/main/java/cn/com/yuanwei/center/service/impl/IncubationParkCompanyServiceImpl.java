package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.IncubationParkCompany;
import cn.com.yuanwei.center.entity.IncubationParkCompanyExample;
import cn.com.yuanwei.center.entity.IncubationParkCompanyExample.Criteria;
import cn.com.yuanwei.center.mapper.IncubationParkCompanyMapper;
import cn.com.yuanwei.center.service.IncubationParkCompanyService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.IncubationParkCompanyReq;
import cn.com.yuanwei.center.web.response.IncubationParkCompanyLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class IncubationParkCompanyServiceImpl implements IncubationParkCompanyService {
	@Autowired
	private IncubationParkCompanyMapper incubationParkCompanyMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(IncubationParkCompany incubationParkCompany) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		incubationParkCompany.setCreateBy(userInfo.getId());
		incubationParkCompany.setCreateTime(currDate);
		incubationParkCompanyMapper.insert(incubationParkCompany);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,incubationParkCompany.getId(), "新增孵化园企业信息"));		
		return incubationParkCompany.getId();
	}

	@Override
	public Integer update(IncubationParkCompany incubationParkCompany) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),incubationParkCompany.getId(), "更新孵化园企业信息"));
		return incubationParkCompanyMapper.updateByPrimaryKey(incubationParkCompany);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除孵化园企业信息"));
		}	
		IncubationParkCompanyExample example = new IncubationParkCompanyExample();
		example.createCriteria().andIdIn(ids);
		return incubationParkCompanyMapper.deleteByExample(example);
	}
	
	@Override
	public IncubationParkCompany queryById(Integer id){
		return incubationParkCompanyMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public IncubationParkCompanyLtResp queryList(IncubationParkCompanyReq req) throws Exception {
		Integer id = req.getId();
		String name = req.getName();
		String mobile = req.getMobile();
		String businessSubject = req.getBusinessSubject();
		String legalPerson = req.getLegalPerson();
		Integer companyType = req.getCompanyType();
		Integer rooms = req.getRooms();
		String areas = req.getAreas();
		String businessScope = req.getBusinessScope();
		Integer teamNumber = req.getTeamNumber();
		String projectIntroduction = req.getProjectIntroduction();
		String companyDesc = req.getCompanyDesc();
		String evaluate = req.getEvaluate();
		String development = req.getDevelopment();
		String ecExamination = req.getEcExamination();
		Integer companyStatus = req.getCompanyStatus();
		Date inDate = req.getInDate();
		Date outDate = req.getOutDate();
		String outReason = req.getOutReason();
		String remark = req.getRemark();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		IncubationParkCompanyExample example = new IncubationParkCompanyExample();
		example.setOrderByClause("id desc");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(name)){
			c.andNameLike("%"+name+"%");
		}
		if(!ValidateUtil.isEmpty(mobile)){
			c.andMobileEqualTo(mobile);
		}
		if(!ValidateUtil.isEmpty(businessSubject)){
			c.andBusinessSubjectEqualTo(businessSubject);
		}
		if(!ValidateUtil.isEmpty(legalPerson)){
			c.andLegalPersonEqualTo(legalPerson);
		}
		if(!ValidateUtil.isEmpty(companyType)){
			c.andCompanyTypeEqualTo(companyType);
		}
		if(!ValidateUtil.isEmpty(rooms)){
			c.andRoomsEqualTo(rooms);
		}
		if(!ValidateUtil.isEmpty(areas)){
			c.andAreasEqualTo(areas);
		}
		if(!ValidateUtil.isEmpty(businessScope)){
			c.andBusinessScopeEqualTo(businessScope);
		}
		if(!ValidateUtil.isEmpty(teamNumber)){
			c.andTeamNumberEqualTo(teamNumber);
		}
		if(!ValidateUtil.isEmpty(projectIntroduction)){
			c.andProjectIntroductionEqualTo(projectIntroduction);
		}
		if(!ValidateUtil.isEmpty(companyDesc)){
			c.andCompanyDescEqualTo(companyDesc);
		}
		if(!ValidateUtil.isEmpty(evaluate)){
			c.andEvaluateEqualTo(evaluate);
		}
		if(!ValidateUtil.isEmpty(development)){
			c.andDevelopmentEqualTo(development);
		}
		if(!ValidateUtil.isEmpty(ecExamination)){
			c.andEcExaminationEqualTo(ecExamination);
		}
		if(!ValidateUtil.isEmpty(companyStatus)){
			c.andCompanyStatusEqualTo(companyStatus);
		}
		if(!ValidateUtil.isEmpty(inDate)){
			c.andInDateEqualTo(inDate);
		}
		if(!ValidateUtil.isEmpty(outDate)){
			c.andOutDateEqualTo(outDate);
		}
		if(!ValidateUtil.isEmpty(outReason)){
			c.andOutReasonEqualTo(outReason);
		}
		if(!ValidateUtil.isEmpty(remark)){
			c.andRemarkEqualTo(remark);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<IncubationParkCompany> page = (Page<IncubationParkCompany>) incubationParkCompanyMapper.selectByExample(example);
		IncubationParkCompanyLtResp resp = new IncubationParkCompanyLtResp();
		resp.setCount(page.getTotal());
		resp.setIncubationParkCompanyLt(page.getResult());
		return resp;
	}
	
}
