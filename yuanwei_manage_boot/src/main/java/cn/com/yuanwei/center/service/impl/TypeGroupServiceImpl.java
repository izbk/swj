package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.TypeGroup;
import cn.com.yuanwei.center.entity.TypeGroupExample;
import cn.com.yuanwei.center.entity.TypeGroupExample.Criteria;
import cn.com.yuanwei.center.mapper.TypeGroupMapper;
import cn.com.yuanwei.center.service.TypeGroupService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.TypeGroupReq;
import cn.com.yuanwei.center.web.response.TypeGroupLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class TypeGroupServiceImpl implements TypeGroupService {
	@Autowired
	private TypeGroupMapper typeGroupMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(TypeGroup typeGroup) throws Exception {
		Date currDate = new Date();
		typeGroupMapper.insert(typeGroup);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,typeGroup.getId(), "新增数据类型定义"));		
		return typeGroup.getId();
	}

	@Override
	public Integer update(TypeGroup typeGroup) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),typeGroup.getId(), "更新数据类型定义"));
		return typeGroupMapper.updateByPrimaryKey(typeGroup);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除数据类型定义"));
		}	
		TypeGroupExample example = new TypeGroupExample();
		example.createCriteria().andIdIn(ids);
		return typeGroupMapper.deleteByExample(example);
	}
	
	@Override
	public TypeGroup queryById(Integer id){
		return typeGroupMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public TypeGroupLtResp queryList(TypeGroupReq req) throws Exception {
		Integer id = req.getId();
		String groupName = req.getGroupName();
		String groupCode = req.getGroupCode();
		TypeGroupExample example = new TypeGroupExample();
		Criteria c = example.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(groupName)){
			c.andGroupNameLike("%"+groupName+"%");
		}
		if(!ValidateUtil.isEmpty(groupCode)){
			c.andGroupCodeEqualTo(groupCode);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<TypeGroup> page = (Page<TypeGroup>) typeGroupMapper.selectByExample(example);
		TypeGroupLtResp resp = new TypeGroupLtResp();
		resp.setCount(page.getTotal());
		resp.setTypeGroupLt(page.getResult());
		return resp;
	}
	
}
