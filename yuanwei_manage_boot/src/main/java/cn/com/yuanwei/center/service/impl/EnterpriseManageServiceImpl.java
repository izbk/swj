package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.EnterpriseManage;
import cn.com.yuanwei.center.entity.EnterpriseManageExample;
import cn.com.yuanwei.center.entity.EnterpriseManageExample.Criteria;
import cn.com.yuanwei.center.mapper.EnterpriseManageMapper;
import cn.com.yuanwei.center.service.EnterpriseManageService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.EnterpriseManageReq;
import cn.com.yuanwei.center.web.response.EnterpriseManageLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class EnterpriseManageServiceImpl implements EnterpriseManageService {
	@Autowired
	private EnterpriseManageMapper enterpriseManageMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(EnterpriseManage enterpriseManage) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		enterpriseManage.setCreateBy(userInfo.getId());
		enterpriseManage.setCreateTime(currDate);
		enterpriseManageMapper.insert(enterpriseManage);
		//记录日志
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,enterpriseManage.getId(), "新增企业进退库管理表"));		
		return enterpriseManage.getId();
	}

	@Override
	public Integer update(EnterpriseManage enterpriseManage) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),enterpriseManage.getId(), "更新企业进退库管理表"));
		return enterpriseManageMapper.updateByPrimaryKey(enterpriseManage);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除企业进退库管理表"));
		}	
		EnterpriseManageExample example = new EnterpriseManageExample();
		example.createCriteria().andIdIn(ids);
		return enterpriseManageMapper.deleteByExample(example);
	}
	
	@Override
	public EnterpriseManage queryById(Integer id){
		return enterpriseManageMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public EnterpriseManageLtResp queryList(EnterpriseManageReq req) throws Exception {
		Integer id = req.getId();
		String enterpriseCode = req.getEnterpriseCode();
		String enterpriseName = req.getEnterpriseName();
		Date startInDate = req.getStartInDate();
		Date startOutDate = req.getStartOutDate();
		Date endInDate = req.getEndInDate();
		Date endOutDate = req.getEndOutDate();
		Integer inWay = req.getInWay();
		Integer outWay = req.getOutWay();
		String remark = req.getRemark();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		EnterpriseManageExample example = new EnterpriseManageExample();
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
		if(!ValidateUtil.isEmpty(startInDate)){
			c.andInDateGreaterThanOrEqualTo(startInDate);
		}
		if(!ValidateUtil.isEmpty(endInDate)){
			c.andInDateLessThanOrEqualTo(endInDate);
		}
		if(!ValidateUtil.isEmpty(startOutDate)){
			c.andOutDateGreaterThanOrEqualTo(startOutDate);
		}
		if(!ValidateUtil.isEmpty(endOutDate)){
			c.andOutDateLessThanOrEqualTo(endOutDate);
		}
		if(!ValidateUtil.isEmpty(inWay)){
			c.andInWayEqualTo(inWay);
		}
		if(!ValidateUtil.isEmpty(outWay)){
			c.andOutWayEqualTo(outWay);
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
		Page<EnterpriseManage> page = (Page<EnterpriseManage>) enterpriseManageMapper.selectByExample(example);
		EnterpriseManageLtResp resp = new EnterpriseManageLtResp();
		resp.setCount(page.getTotal());
		resp.setEnterpriseManageLt(page.getResult());
		return resp;
	}
	
}
