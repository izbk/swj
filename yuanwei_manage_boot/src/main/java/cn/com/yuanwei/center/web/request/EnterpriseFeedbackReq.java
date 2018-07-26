package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 样本企业反馈信息
 * 
 * @author zbk
 * @email 
 * @date 2017-08-21 15:51:16
 */
@ApiModel
public class EnterpriseFeedbackReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//样本企业ID
	@ApiModelProperty(value = "样本企业ID",dataType="Integer")
	private Integer userId;
	//样板企业名称
	@ApiModelProperty(value = "样板企业名称",dataType="String")
	private String userName;
	//样本企业类型
	@ApiModelProperty(value = "样本企业类型",dataType="Integer")
	private Integer modelType;
	//上报内容
	@ApiModelProperty(value = "上报内容",dataType="String")
	private String content;
	//创建人
	@ApiModelProperty(value = "创建人",dataType="Integer")
	private Integer createBy;
	//创建时间
	@ApiModelProperty(value = "创建时间",dataType="Date")
	private Date createTime;
	
	private Date startDate;
	private Date endDate;

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
	 * 设置：样本企业ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：样本企业ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：样板企业名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：样板企业名称
	 */
	public String getUserName() {
		return userName;
	}
	public Integer getModelType() {
		return modelType;
	}
	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}
	/**
	 * 设置：上报内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：上报内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public Integer getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
