package cn.com.yuanwei.center.web.response;

import java.io.Serializable;

public class LoginResp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
