package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.EnterpriseFeedback;
import cn.com.yuanwei.center.entity.EnterpriseFeedbackExample;
import cn.com.yuanwei.center.entity.EnterpriseFeedbackExample.Criteria;
import cn.com.yuanwei.center.mapper.EnterpriseFeedbackMapper;
import cn.com.yuanwei.center.service.EnterpriseFeedbackService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.EnterpriseFeedbackReq;
import cn.com.yuanwei.center.web.response.EnterpriseFeedbackLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.enums.ModelTypeEnum;
import cn.com.yuanwei.center.enums.RoleTypeEnum;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class EnterpriseFeedbackServiceImpl implements EnterpriseFeedbackService {
	@Autowired
	private EnterpriseFeedbackMapper enterpriseFeedbackMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(EnterpriseFeedback enterpriseFeedback) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		enterpriseFeedback.setUserId(userInfo.getId());
		enterpriseFeedback.setUserName(userInfo.getNickName());
		enterpriseFeedback.setCreateBy(userInfo.getId());
		enterpriseFeedback.setCreateTime(currDate);
		if(userInfo.getRoleId().compareTo(RoleTypeEnum.shbxpjc.getCode())==0){
			enterpriseFeedback.setModelType(ModelTypeEnum.shenghuobixupinjiance.getCode());
		}else if(userInfo.getRoleId().compareTo(RoleTypeEnum.zysczljc.getCode())==0){
			enterpriseFeedback.setModelType(ModelTypeEnum.shengchanziliaojiance.getCode());
		}
		enterpriseFeedbackMapper.insert(enterpriseFeedback);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,enterpriseFeedback.getId(), "新增样本企业反馈信息"));		
		return enterpriseFeedback.getId();
	}

	@Override
	public Integer update(EnterpriseFeedback enterpriseFeedback) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),enterpriseFeedback.getId(), "更新样本企业反馈信息"));
		return enterpriseFeedbackMapper.updateByPrimaryKey(enterpriseFeedback);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除样本企业反馈信息"));
		}	
		EnterpriseFeedbackExample example = new EnterpriseFeedbackExample();
		example.createCriteria().andIdIn(ids);
		return enterpriseFeedbackMapper.deleteByExample(example);
	}
	
	@Override
	public EnterpriseFeedback queryById(Integer id){
		return enterpriseFeedbackMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public EnterpriseFeedbackLtResp queryList(EnterpriseFeedbackReq req) throws Exception {
		Integer id = req.getId();
		Integer userId = req.getUserId();
		String userName = req.getUserName();
		Integer modelType = req.getModelType();
		String content = req.getContent();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		Date startDate = req.getStartDate();
		Date endDate = req.getEndDate();
		EnterpriseFeedbackExample example = new EnterpriseFeedbackExample();
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
		if(!ValidateUtil.isEmpty(modelType)){
			c.andModelTypeEqualTo(modelType);
		}
		if(!ValidateUtil.isEmpty(content)){
			c.andContentEqualTo(content);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		if(!ValidateUtil.isEmpty(startDate)){
			c.andCreateTimeGreaterThanOrEqualTo(startDate);
		}
		if(!ValidateUtil.isEmpty(endDate)){
			Calendar ca = Calendar.getInstance();
			ca.setTime(endDate);
			ca.set(Calendar.SECOND,60*60*24-1);
			c.andCreateTimeLessThanOrEqualTo(ca.getTime());
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<EnterpriseFeedback> page = (Page<EnterpriseFeedback>) enterpriseFeedbackMapper.selectByExample(example);
		EnterpriseFeedbackLtResp resp = new EnterpriseFeedbackLtResp();
		resp.setCount(page.getTotal());
		resp.setEnterpriseFeedbackLt(page.getResult());
		return resp;
	}
	
}
