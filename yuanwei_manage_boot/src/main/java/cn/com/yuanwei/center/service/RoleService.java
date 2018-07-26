package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Role;
import cn.com.yuanwei.center.web.request.UserLtReq;
import cn.com.yuanwei.center.web.response.RoleLtResp;



public interface RoleService {
	public RoleLtResp getRoleLt(UserLtReq req) throws Exception;
	public void updateRole(Role role) throws Exception;
	public void createRole(Role role) throws Exception;
	public void delRole(List<Integer> req) throws Exception;
}
