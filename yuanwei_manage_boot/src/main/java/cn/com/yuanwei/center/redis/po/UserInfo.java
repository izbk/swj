package cn.com.yuanwei.center.redis.po;


import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer pid;

    private String mobilePhone;

    private String loginName;

    private String nickName;

    private String email;

    private String pwd;

    private String pic;

    private String indexId;

    private Integer point;

    private Integer source;

    private String levelName;

    private Integer level;

    private Integer status;

    private Integer isDel;

    private Date regTime;
    
    private Integer townshipId;

    private Integer departId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId == null ? null : indexId.trim();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }
    
    public Integer getTownshipId() {
		return townshipId;
	}

	public void setTownshipId(Integer townshipId) {
		this.townshipId = townshipId;
	}

	public Integer getDepartId() {
		return departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", pid=").append(pid);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", loginName=").append(loginName);
        sb.append(", nickName=").append(nickName);
        sb.append(", email=").append(email);
        sb.append(", pwd=").append(pwd);
        sb.append(", pic=").append(pic);
        sb.append(", indexId=").append(indexId);
        sb.append(", point=").append(point);
        sb.append(", source=").append(source);
        sb.append(", levelName=").append(levelName);
        sb.append(", level=").append(level);
        sb.append(", status=").append(status);
        sb.append(", isDel=").append(isDel);
        sb.append(", regTime=").append(regTime);
        sb.append(", townshipId=").append(townshipId);
        sb.append(", departId=").append(departId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}
