package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.IncubationParkRegister;
import cn.com.yuanwei.center.entity.IncubationParkRegisterExample;
import cn.com.yuanwei.center.entity.IncubationParkRegisterExample.Criteria;
import cn.com.yuanwei.center.mapper.IncubationParkRegisterMapper;
import cn.com.yuanwei.center.service.IncubationParkRegisterService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.IncubationParkRegisterReq;
import cn.com.yuanwei.center.web.response.IncubationParkRegisterLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class IncubationParkRegisterServiceImpl implements IncubationParkRegisterService {
	@Autowired
	private IncubationParkRegisterMapper incubationParkRegisterMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(IncubationParkRegister incubationParkRegister) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		incubationParkRegister.setCreateBy(userInfo.getId());
		incubationParkRegister.setCreateTime(currDate);
		incubationParkRegisterMapper.insert(incubationParkRegister);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,incubationParkRegister.getId(), "新增孵化园申请登记信息"));		
		return incubationParkRegister.getId();
	}

	@Override
	public Integer update(IncubationParkRegister incubationParkRegister) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),incubationParkRegister.getId(), "更新孵化园申请登记信息"));
		return incubationParkRegisterMapper.updateByPrimaryKey(incubationParkRegister);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除孵化园申请登记信息"));
		}	
		IncubationParkRegisterExample example = new IncubationParkRegisterExample();
		example.createCriteria().andIdIn(ids);
		return incubationParkRegisterMapper.deleteByExample(example);
	}
	
	@Override
	public IncubationParkRegister queryById(Integer id){
		return incubationParkRegisterMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public IncubationParkRegisterLtResp queryList(IncubationParkRegisterReq req) throws Exception {
		Integer id = req.getId();
		String name = req.getName();
		String mobile = req.getMobile();
		String businessSubject = req.getBusinessSubject();
		String legalPerson = req.getLegalPerson();
		Integer companyType = req.getCompanyType();
		Integer applicationRoom = req.getApplicationRoom();
		String applicationArea = req.getApplicationArea();
		String businessScope = req.getBusinessScope();
		Integer teamNumber = req.getTeamNumber();
		String projectIntroduction = req.getProjectIntroduction();
		Integer status = req.getStatus();
		String remark = req.getRemark();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		IncubationParkRegisterExample example = new IncubationParkRegisterExample();
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
		if(!ValidateUtil.isEmpty(applicationRoom)){
			c.andApplicationRoomEqualTo(applicationRoom);
		}
		if(!ValidateUtil.isEmpty(applicationArea)){
			c.andApplicationAreaEqualTo(applicationArea);
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
		if(!ValidateUtil.isEmpty(status)){
			c.andStatusEqualTo(status);
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
		Page<IncubationParkRegister> page = (Page<IncubationParkRegister>) incubationParkRegisterMapper.selectByExample(example);
		IncubationParkRegisterLtResp resp = new IncubationParkRegisterLtResp();
		resp.setCount(page.getTotal());
		resp.setIncubationParkRegisterLt(page.getResult());
		return resp;
	}
	
}
