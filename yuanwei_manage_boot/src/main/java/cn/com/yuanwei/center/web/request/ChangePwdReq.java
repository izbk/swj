package cn.com.yuanwei.center.web.request;

import java.io.Serializable;

public class ChangePwdReq implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String loginName;

	private String oldPwd;

	private String newPwd;

	private String confirmPwd;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	

}
