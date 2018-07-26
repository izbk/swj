package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Role;

public class RoleLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Role> roleLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Role> getRoleLt() {
		return roleLt;
	}
	public void setRoleLt(List<Role> roleLt) {
		this.roleLt = roleLt;
	}

	

	
}
