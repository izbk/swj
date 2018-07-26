package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;


/**
 * 系统日志
 * 
 * @author zbk
 * @date 2017-06-22 10:57:25
 */
public class ServiceLogs implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//操作人ID
	 @Excel(name = "操作人ID",isImportField="true")
	private Integer userId;
	//操作人姓名
	 @Excel(name = "操作人姓名",isImportField="true")
	private String userName;
	//操作时间
     @Excel(name = "操作时间",format="yyyy-MM-dd",isImportField="true")
	private Date operateTime;
	//业务ID
	 @Excel(name = "业务ID",isImportField="true")
	private Integer busiId;
	//日志内容
	 @Excel(name = "日志内容",isImportField="true")
	private String logContent;
	//IP地址
	 @Excel(name = "IP地址",isImportField="true")
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
	
	public ServiceLogs() {
		super();
	}

	public ServiceLogs(Integer userId, String userName, Date operateTime, String logContent) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.operateTime = operateTime;
		this.logContent = logContent;
	}

	public ServiceLogs(Integer userId, String userName, Date operateTime, Integer busiId, String logContent) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.operateTime = operateTime;
		this.busiId = busiId;
		this.logContent = logContent;
	}

	public ServiceLogs(Integer userId, String userName, Date operateTime, Integer busiId, String logContent,
			String ip) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.operateTime = operateTime;
		this.busiId = busiId;
		this.logContent = logContent;
		this.ip = ip;
	}
}
