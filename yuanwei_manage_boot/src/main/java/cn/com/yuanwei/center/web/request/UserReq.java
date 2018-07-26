package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 用户
 * 
 * @author zbk
 * @email 
 * @date 2017-06-09 15:34:28
 */
@ApiModel
public class UserReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//用户id
	@ApiModelProperty(value = "用户id",dataType="Integer")
	private Integer id;
	//用户角色id
	@ApiModelProperty(value = "用户角色id",dataType="Integer")
	private Integer roleId;
	//父级用户id
	@ApiModelProperty(value = "父级用户id",dataType="Integer")
	private Integer pid;
	//手机号
	@ApiModelProperty(value = "手机号",dataType="String")
	private String mobilePhone;
	//登录名
	@ApiModelProperty(value = "登录名",dataType="String")
	private String loginName;
	//昵称
	@ApiModelProperty(value = "昵称",dataType="String")
	private String nickName;
	//邮箱
	@ApiModelProperty(value = "邮箱",dataType="String")
	private String email;
	//登陆密码
	@ApiModelProperty(value = "登陆密码",dataType="String")
	private String pwd;
	//头像
	@ApiModelProperty(value = "头像",dataType="String")
	private String pic;
	//索引位，对于下级单位的索引    当前级id_下级id_下级id
	@ApiModelProperty(value = "索引位，对于下级单位的索引    当前级id_下级id_下级id",dataType="String")
	private String indexId;
	//积分
	@ApiModelProperty(value = "积分",dataType="Integer")
	private Integer point;
	//用户来源 0-网站 2-app 3-微信公众号 4-微信小程序
	@ApiModelProperty(value = "用户来源 0-网站 2-app 3-微信公众号 4-微信小程序",dataType="Integer")
	private Integer source;
	//用户等级名
	@ApiModelProperty(value = "用户等级名",dataType="String")
	private String levelName;
	//会员等级
	@ApiModelProperty(value = "会员等级",dataType="Integer")
	private Integer level;
	//状态 0：未激活
	@ApiModelProperty(value = "状态",dataType="Integer")
	private Integer status;
	//已删除
	@ApiModelProperty(value = "是否删除",dataType="Integer")
	private Integer isDel;
	//注册时间
	@ApiModelProperty(value = "注册时间",dataType="Date")
	private Date regTime;
	//所属乡镇
	@ApiModelProperty(value = "所属乡镇",dataType="Integer")
	private Integer townshipId;
	//所属部门
	@ApiModelProperty(value = "所属部门",dataType="Integer")
	private Integer departId;
	//微信openid
	@ApiModelProperty(value = "微信openid",dataType="String")
	private String openId;
	
	private String isSend;

	/**
	 * 设置：用户id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户角色id
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：用户角色id
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * 设置：父级用户id
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父级用户id
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * 设置：登录名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 获取：登录名
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：登陆密码
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * 获取：登陆密码
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * 设置：头像
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * 获取：头像
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * 设置：索引位，对于下级单位的索引    当前级id_下级id_下级id
	 */
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	/**
	 * 获取：索引位，对于下级单位的索引    当前级id_下级id_下级id
	 */
	public String getIndexId() {
		return indexId;
	}
	/**
	 * 设置：积分
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}
	/**
	 * 获取：积分
	 */
	public Integer getPoint() {
		return point;
	}
	/**
	 * 设置：用户来源 0-网站 2-app 3-微信公众号 4-微信小程序
	 */
	public void setSource(Integer source) {
		this.source = source;
	}
	/**
	 * 获取：用户来源 0-网站 2-app 3-微信公众号 4-微信小程序
	 */
	public Integer getSource() {
		return source;
	}
	/**
	 * 设置：用户等级名
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	/**
	 * 获取：用户等级名
	 */
	public String getLevelName() {
		return levelName;
	}
	/**
	 * 设置：会员等级 0-普通会员 1-青铜会员 2-白银会员 3-黄金会员
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：会员等级 0-普通会员 1-青铜会员 2-白银会员 3-黄金会员
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：状态 0：未激活
1：正常
2：冻结
 3：注销
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0：未激活
1：正常
2：冻结
 3：注销
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：已删除
  1:已删除0：正常
	 */
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	/**
	 * 获取：已删除
  1:已删除0：正常
	 */
	public Integer getIsDel() {
		return isDel;
	}
	/**
	 * 设置：注册时间
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getRegTime() {
		return regTime;
	}
	/**
	 * 设置：所属乡镇
	 */
	public void setTownshipId(Integer townshipId) {
		this.townshipId = townshipId;
	}
	/**
	 * 获取：所属乡镇
	 */
	public Integer getTownshipId() {
		return townshipId;
	}
	/**
	 * 设置：所属部门
	 */
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	/**
	 * 获取：所属部门
	 */
	public Integer getDepartId() {
		return departId;
	}
	/**
	 * 设置：微信openid
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：微信openid
	 */
	public String getOpenId() {
		return openId;
	}
	public String getIsSend() {
		return isSend;
	}
	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}
	
}
