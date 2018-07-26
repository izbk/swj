package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 系统日志
 * 
 * @author zbk
 * @email 
 * @date 2017-06-22 10:57:25
 */
@ApiModel
public class ServiceLogsReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//操作人ID
	@ApiModelProperty(value = "操作人ID",dataType="Integer")
	private Integer userId;
	//操作人姓名
	@ApiModelProperty(value = "操作人姓名",dataType="String")
	private String userName;
	//操作时间
	@ApiModelProperty(value = "操作时间",dataType="Date")
	private Date operateTime;
	//业务ID
	@ApiModelProperty(value = "业务ID",dataType="Integer")
	private Integer busiId;
	//日志内容
	@ApiModelProperty(value = "日志内容",dataType="String")
	private String logContent;
	//IP地址
	@ApiModelProperty(value = "IP地址",dataType="String")
	private String ip;

	/**
	 * 设置：主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：操作人ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：操作人ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：操作人姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：操作人姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：操作时间
	 */
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getOperateTime() {
		return operateTime;
	}
	/**
	 * 设置：业务ID
	 */
	public void setBusiId(Integer busiId) {
		this.busiId = busiId;
	}
	/**
	 * 获取：业务ID
	 */
	public Integer getBusiId() {
		return busiId;
	}
	/**
	 * 设置：日志内容
	 */
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	/**
	 * 获取：日志内容
	 */
	public String getLogContent() {
		return logContent;
	}
	/**
	 * 设置：IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：IP地址
	 */
	public String getIp() {
		return ip;
	}
}
