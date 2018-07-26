package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.Role;
import cn.com.yuanwei.center.entity.RoleExample;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.RoleExample.Criteria;
import cn.com.yuanwei.center.enums.IsEnum;
import cn.com.yuanwei.center.mapper.RoleMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.RoleService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.UserLtReq;
import cn.com.yuanwei.center.web.response.RoleLtResp;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	 /**
	  * Desc:获取角色列表
	  * @author sky
	  * @date 2017年4月13日  下午8:18:38
	  */
	@Override
	public RoleLtResp getRoleLt(UserLtReq req) throws Exception {
		Integer id = req.getId();
		String name = req.getName();
		RoleExample re = new RoleExample();
		Criteria c = re.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(name)){
			c.andNameLike("%"+name+"%");
		}
		//只查询非内置角色
		c.andIsSysEqualTo(IsEnum.no.getCode());
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Role> page = (Page<Role>) roleMapper.selectByExample(re);
		RoleLtResp resp = new RoleLtResp();
		resp.setCount(page.getTotal());
		resp.setRoleLt(page.getResult());
		return resp;
	}
	/**
	 * Desc:更新角色
	 * @author sky
	 * @date 2017年4月13日  下午8:19:04
	 */
	@Override
	public void updateRole(Role role) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,role.getId(), "更新角色信息"));		
		roleMapper.updateByPrimaryKey(role);
		
	}
	/**
	 * Desc:创建角色
	 * @author sky
	 * @date 2017年4月13日  下午8:19:21
	 */
	@Override
	public void createRole(Role role) throws Exception {
		role.setIsSys(IsEnum.no.getCode());
		roleMapper.insert(role);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,role.getId(), "新建角色信息"));		
	}
	/**
	 * Desc:删除角色
	 * @author sky
	 * @date 2017年4月13日  下午8:19:30
	 */
	@Override
	public void delRole(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除角色信息"));
		}
		RoleExample re = new  RoleExample();
		re.createCriteria().andIdIn(ids);
		roleMapper.deleteByExample(re);
	}
	
}
