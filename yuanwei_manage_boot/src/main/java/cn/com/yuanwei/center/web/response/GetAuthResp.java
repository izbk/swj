package cn.com.yuanwei.center.web.response;

import java.io.Serializable;

public class GetAuthResp implements Serializable{
	private static final long serialVersionUID = 1L;
	//登陆凭证
	private String voucher;
	//用户对象信息
	private	Object	userInfo;
	
	public String getVoucher() {
		return voucher;
	}
	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	public Object getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(Object userInfo) {
		this.userInfo = userInfo;
	}
}
