package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

public class UserVo implements Serializable {

	@Excel(name = "登录名称")
    private String loginName;
	
	@Excel(name = "昵称")
    private String nickName;
	
	@Excel(name = "角色名称")
    private String roleName;
	
	@Excel(name = "部门名称")
    private String departName;
	
	@Excel(name = "手机号码")
    private String mobilePhone;
	
	@Excel(name = "Email")
    private String email;
	
	@Excel(name = "用户状态")
    private String status;
	
	@Excel(name = "所属乡镇")
    private String townshipName;
	
	@Excel(name = "注册时间",format="yyyy-MM-dd")
    private Date regTime;
	
    private static final long serialVersionUID = 1L;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getTownshipName() {
		return townshipName;
	}

	public void setTownshipName(String townshipName) {
		this.townshipName = townshipName;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

}