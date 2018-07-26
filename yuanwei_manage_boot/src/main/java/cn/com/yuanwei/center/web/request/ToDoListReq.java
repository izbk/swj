package cn.com.yuanwei.center.web.request;

import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 待办事项
 * 
 * @author zbk
 * @email 
 * @date 2017-05-16 11:11:22
 */
@ApiModel
public class ToDoListReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//处理人
	@ApiModelProperty(value = "处理人",dataType="Integer")
	private Integer userId;
	//审核配置ID
	@ApiModelProperty(value = "审核配置ID",dataType="Integer")
	private Integer auditConfigId;
	//业务名称
	@ApiModelProperty(value = "业务名称",dataType="String")
	private String busiName;
	//业务ID
	@ApiModelProperty(value = "业务ID",dataType="Integer")
	private Integer busiId;
	//业务类型
	@ApiModelProperty(value = "业务类型",dataType="Integer")
	private Integer busiType;
	//子业务类型
	@ApiModelProperty(value = "子业务类型",dataType="Integer")
	private Integer subBusiType;
	//创建时间
	@ApiModelProperty(value = "创建时间",dataType="Date")
	private Date createTime;
	//是否处理
	@ApiModelProperty(value = "是否处理",dataType="Integer")
	private Integer isDeal;
	//处理时间
	@ApiModelProperty(value = "处理时间",dataType="Date")
	private Date dealTime;
	//业务审核状态
	private Integer status;
	
	private String content;

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
	 * 设置：处理人
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：处理人
	 */
	public Integer getUserId() {
		return userId;
	}
	public Integer getAuditConfigId() {
		return auditConfigId;
	}
	public void setAuditConfigId(Integer auditConfigId) {
		this.auditConfigId = auditConfigId;
	}
	/**
	 * 设置：业务名称
	 */
	public void setBusiName(String busiName) {
		this.busiName = busiName;
	}
	/**
	 * 获取：业务名称
	 */
	public String getBusiName() {
		return busiName;
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
	 * 设置：业务类型
	 */
	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}
	/**
	 * 获取：业务类型
	 */
	public Integer getBusiType() {
		return busiType;
	}
	/**
	 * 设置：子业务类型
	 */
	public void setSubBusiType(Integer subBusiType) {
		this.subBusiType = subBusiType;
	}
	/**
	 * 获取：子业务类型
	 */
	public Integer getSubBusiType() {
		return subBusiType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 设置：是否处理
	 */
	public void setIsDeal(Integer isDeal) {
		this.isDeal = isDeal;
	}
	/**
	 * 获取：是否处理
	 */
	public Integer getIsDeal() {
		return isDeal;
	}
	/**
	 * 设置：处理时间
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	/**
	 * 获取：处理时间
	 */
	public Date getDealTime() {
		return dealTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
