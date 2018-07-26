package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.User;

public class UserLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<User> userLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<User> getUserLt() {
		return userLt;
	}
	public void setUserLt(List<User> userLt) {
		this.userLt = userLt;
	}
	

	
}
