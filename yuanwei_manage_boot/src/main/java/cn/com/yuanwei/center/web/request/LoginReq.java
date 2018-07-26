package cn.com.yuanwei.center.web.request;

import java.io.Serializable;

public class LoginReq implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String username;

	private String password;
	
	private Integer source;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

}
