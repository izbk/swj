package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.Enterprise;
import cn.com.yuanwei.center.entity.EnterpriseExample;
import cn.com.yuanwei.center.entity.EnterpriseExample.Criteria;
import cn.com.yuanwei.center.entity.EnterpriseManage;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.enums.InTypeEnum;
import cn.com.yuanwei.center.enums.InWayEnum;
import cn.com.yuanwei.center.enums.OutWayEnum;
import cn.com.yuanwei.center.mapper.EnterpriseManageMapper;
import cn.com.yuanwei.center.mapper.EnterpriseMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.UserMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.EnterpriseService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.EnterpriseReq;
import cn.com.yuanwei.center.web.response.EnterpriseLtResp;

@Service
@Transactional
public class EnterpriseServiceImpl implements EnterpriseService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private EnterpriseMapper enterpriseMapper;
	@Autowired
	private EnterpriseManageMapper enterpriseManageMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(Enterprise enterprise) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Integer inType = enterprise.getInType();
		Date currDate = new Date();
		Integer userId = enterprise.getUserId();
		if(!ValidateUtil.isEmpty(userId)){
			enterprise.setUserName(userMapper.selectByPrimaryKey(userId).getNickName());
		}
		enterprise.setCreateBy(userInfo.getId());
		enterprise.setCreateTime(currDate);
		enterpriseMapper.insert(enterprise);
		//入库记录
		if(!ValidateUtil.isEmpty(inType)){
			if(InTypeEnum.yiruku.getCode().compareTo(inType)==0||InTypeEnum.xinzengruku.getCode().compareTo(inType)==0){
				EnterpriseManage em = new EnterpriseManage();
				BeanUtils.copyProperties(enterprise, em);
				em.setId(null);
				em.setInWay(InWayEnum.nianshenruku.getCode());
				enterpriseManageMapper.insertSelective(em);
			}
		}
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),enterprise.getId(), "新增限上企业信息"));		
		return enterprise.getId();
	}

	@Override
	public Integer update(Enterprise enterprise) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),enterprise.getId(), "更新限上企业信息"));		
		Integer inType = enterprise.getInType();
		EnterpriseManage em = new EnterpriseManage();
		BeanUtils.copyProperties(enterprise, em);
		em.setId(null);
		Enterprise old = enterpriseMapper.selectByPrimaryKey(enterprise.getId());
		//变更类型记录日志
		if(ValidateUtil.isEmpty(old.getInType()) || old.getInType().compareTo(enterprise.getInType())!=0){
			//入库
			if(InTypeEnum.yiruku.getCode().compareTo(inType)==0||InTypeEnum.xinzengruku.getCode().compareTo(inType)==0){
				em.setInWay(InWayEnum.nianshenruku.getCode());
			}else if(InTypeEnum.yichuku.getCode().compareTo(inType)==0){//正常出库
				em.setOutWay(OutWayEnum.zhengchangchuku.getCode());
			}else{//破产吊销
				em.setOutWay(OutWayEnum.pochandiaoxiao.getCode());
			}
			enterpriseManageMapper.insertSelective(em);
		}
		Integer userId = enterprise.getUserId();
		if(!ValidateUtil.isEmpty(userId)){
			enterprise.setUserName(userMapper.selectByPrimaryKey(userId).getNickName());
		}
		return enterpriseMapper.updateByPrimaryKey(enterprise);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除限上企业信息"));
		}
		EnterpriseExample example = new EnterpriseExample();
		example.createCriteria().andIdIn(ids);
		return enterpriseMapper.deleteByExample(example);
	}
	
	@Override
	public Enterprise queryById(Integer id){
		return enterpriseMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public EnterpriseLtResp queryList(EnterpriseReq req) throws Exception {
		Integer id = req.getId();
		String enterpriseCode = req.getEnterpriseCode();
		String enterpriseName = req.getEnterpriseName();
		Integer townshipId = req.getTownshipId();
		Integer enterpriseType = req.getEnterpriseType();
		Integer industry = req.getIndustry();
		String chargeName = req.getChargeName();
		String chargeMobile = req.getChargeMobile();
		Integer userId = req.getUserId();
		String userName = req.getUserName();
		Date inDate = req.getInDate();
		Date outDate = req.getOutDate();
		Integer inType = req.getInType();
		Integer agent = req.getAgent();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		EnterpriseExample example = new EnterpriseExample();
		example.setOrderByClause("id desc");
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(enterpriseCode)){
			c.andEnterpriseCodeEqualTo(enterpriseCode);
		}
		if(!ValidateUtil.isEmpty(enterpriseName)){
			c.andEnterpriseNameLike("%"+enterpriseName+"%");
		}
		if(!ValidateUtil.isEmpty(townshipId)){
			c.andTownshipIdEqualTo(townshipId);
		}
		if(!ValidateUtil.isEmpty(enterpriseType)){
			c.andEnterpriseTypeEqualTo(enterpriseType);
		}
		if(!ValidateUtil.isEmpty(industry)){
			c.andIndustryEqualTo(industry);
		}
		if(!ValidateUtil.isEmpty(chargeName)){
			c.andChargeNameLike("%"+chargeName+"%");
		}
		if(!ValidateUtil.isEmpty(chargeMobile)){
			c.andChargeMobileEqualTo(chargeMobile);
		}
		if(!ValidateUtil.isEmpty(userId)){
			c.andUserIdEqualTo(userId);
		}
		if(!ValidateUtil.isEmpty(userName)){
			c.andUserNameLike("%"+userName+"%");
		}
		if(!ValidateUtil.isEmpty(inDate)){
			c.andInDateEqualTo(inDate);
		}
		if(!ValidateUtil.isEmpty(outDate)){
			c.andOutDateEqualTo(outDate);
		}
		if(!ValidateUtil.isEmpty(inType)){
			c.andInTypeEqualTo(inType);
		}
		if(!ValidateUtil.isEmpty(agent)){
			c.andAgentEqualTo(agent);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Enterprise> page = (Page<Enterprise>) enterpriseMapper.selectByExample(example);
		EnterpriseLtResp resp = new EnterpriseLtResp();
		resp.setCount(page.getTotal());
		resp.setEnterpriseLt(page.getResult());
		return resp;
	}
	
}
