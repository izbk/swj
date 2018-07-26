package cn.com.yuanwei.center.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.IncubationParkAssessment;
import cn.com.yuanwei.center.entity.IncubationParkAssessmentExample;
import cn.com.yuanwei.center.entity.IncubationParkAssessmentExample.Criteria;
import cn.com.yuanwei.center.entity.IncubationParkCompany;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.IncubationParkAssessmentMapper;
import cn.com.yuanwei.center.mapper.IncubationParkCompanyMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.IncubationParkAssessmentService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.IncubationParkAssessmentReq;
import cn.com.yuanwei.center.web.response.IncubationParkAssessmentLtResp;

@Service
@Transactional
public class IncubationParkAssessmentServiceImpl implements IncubationParkAssessmentService {
	@Autowired
	private IncubationParkAssessmentMapper incubationParkAssessmentMapper;
	@Autowired
	private IncubationParkCompanyMapper incubationParkCompanyMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(IncubationParkAssessment incubationParkAssessment) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		incubationParkAssessment.setCreateBy(userInfo.getId());
		incubationParkAssessment.setCreateTime(currDate);
		Integer ipCompanyId = incubationParkAssessment.getIpcompanyId();
		IncubationParkCompany company =  incubationParkCompanyMapper.selectByPrimaryKey(ipCompanyId);
		if(ValidateUtil.isEmpty(company)){
			throw new Exception("未获取到孵化园企业信息");
		}
		IncubationParkAssessmentExample example = new IncubationParkAssessmentExample();
		example.createCriteria().andIpcompanyIdEqualTo(ipCompanyId).andAssessDateEqualTo(incubationParkAssessment.getAssessDate());
		List<IncubationParkAssessment> list = incubationParkAssessmentMapper.selectByExample(example);
		if(!ValidateUtil.isEmpty(list)){
			throw new Exception("本月已存在此企业的考核信息");
		}
		Integer attendPoint = incubationParkAssessment.getAttendPoint();
		if(ValidateUtil.isEmpty(attendPoint)){
			attendPoint = 0;
		}
		Integer teamPoint = incubationParkAssessment.getTeamPoint();
		if(ValidateUtil.isEmpty(teamPoint)){
			teamPoint = 0;
		}
		Integer performPoint = incubationParkAssessment.getPerformPoint();
		if(ValidateUtil.isEmpty(performPoint)){
			performPoint = 0;
		}
		Integer deductPoint = incubationParkAssessment.getDeductPoint();
		if(ValidateUtil.isEmpty(deductPoint)){
			deductPoint = 0;
		}
		Integer plusPoint = incubationParkAssessment.getPlusPoint();
		if(ValidateUtil.isEmpty(plusPoint)){
			plusPoint = 0;
		}
		Integer totalPoint = attendPoint+teamPoint+performPoint+deductPoint+plusPoint;
		incubationParkAssessment.setTotalPoint(totalPoint);
		incubationParkAssessment.setBusinessSubject(company.getBusinessSubject());
		incubationParkAssessmentMapper.insert(incubationParkAssessment);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,incubationParkAssessment.getId(), "新增孵化园企业考核"));		
		return incubationParkAssessment.getId();
	}

	@Override
	public Integer update(IncubationParkAssessment incubationParkAssessment) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),incubationParkAssessment.getId(), "更新孵化园企业考核"));
		return incubationParkAssessmentMapper.updateByPrimaryKey(incubationParkAssessment);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除孵化园企业考核"));
		}	
		IncubationParkAssessmentExample example = new IncubationParkAssessmentExample();
		example.createCriteria().andIdIn(ids);
		return incubationParkAssessmentMapper.deleteByExample(example);
	}
	
	@Override
	public IncubationParkAssessment queryById(Integer id){
		return incubationParkAssessmentMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public IncubationParkAssessmentLtResp queryList(IncubationParkAssessmentReq req) throws Exception {
		Integer id = req.getId();
		Integer ipcompanyId = req.getIpcompanyId();
		String businessSubject = req.getBusinessSubject();
		Date assessDate = req.getAssessDate();
		BigDecimal ycqts = req.getYcqts();
		String attendance = req.getAttendance();
		Integer attendPoint = req.getAttendPoint();
		BigDecimal avgTeamNum = req.getAvgTeamNum();
		Integer teamPoint = req.getTeamPoint();
		String evaluate = req.getEvaluate();
		Integer performPoint = req.getPerformPoint();
		String deductReason = req.getDeductReason();
		Integer deductPoint = req.getDeductPoint();
		String plusReason = req.getPlusReason();
		Integer plusPoint = req.getPlusPoint();
		Integer totalPoint = req.getTotalPoint();
		String reamrk = req.getReamrk();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		IncubationParkAssessmentExample example = new IncubationParkAssessmentExample();
		example.setOrderByClause("id desc");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(ipcompanyId)){
			c.andIpcompanyIdEqualTo(ipcompanyId);
		}
		if(!ValidateUtil.isEmpty(businessSubject)){
			c.andBusinessSubjectLike("%"+businessSubject+"%");
		}
		if(!ValidateUtil.isEmpty(assessDate)){
			c.andAssessDateEqualTo(assessDate);
		}
		if(!ValidateUtil.isEmpty(ycqts)){
			c.andYcqtsEqualTo(ycqts);
		}
		if(!ValidateUtil.isEmpty(attendance)){
			c.andAttendanceEqualTo(attendance);
		}
		if(!ValidateUtil.isEmpty(attendPoint)){
			c.andAttendPointEqualTo(attendPoint);
		}
		if(!ValidateUtil.isEmpty(avgTeamNum)){
			c.andAvgTeamNumEqualTo(avgTeamNum);
		}
		if(!ValidateUtil.isEmpty(teamPoint)){
			c.andTeamPointEqualTo(teamPoint);
		}
		if(!ValidateUtil.isEmpty(evaluate)){
			c.andEvaluateEqualTo(evaluate);
		}
		if(!ValidateUtil.isEmpty(performPoint)){
			c.andPerformPointEqualTo(performPoint);
		}
		if(!ValidateUtil.isEmpty(deductReason)){
			c.andDeductReasonEqualTo(deductReason);
		}
		if(!ValidateUtil.isEmpty(deductPoint)){
			c.andDeductPointEqualTo(deductPoint);
		}
		if(!ValidateUtil.isEmpty(plusReason)){
			c.andPlusReasonEqualTo(plusReason);
		}
		if(!ValidateUtil.isEmpty(plusPoint)){
			c.andPlusPointEqualTo(plusPoint);
		}
		if(!ValidateUtil.isEmpty(totalPoint)){
			c.andTotalPointEqualTo(totalPoint);
		}
		if(!ValidateUtil.isEmpty(reamrk)){
			c.andReamrkEqualTo(reamrk);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<IncubationParkAssessment> page = (Page<IncubationParkAssessment>) incubationParkAssessmentMapper.selectByExample(example);
		IncubationParkAssessmentLtResp resp = new IncubationParkAssessmentLtResp();
		resp.setCount(page.getTotal());
		resp.setIncubationParkAssessmentLt(page.getResult());
		return resp;
	}
	
}
