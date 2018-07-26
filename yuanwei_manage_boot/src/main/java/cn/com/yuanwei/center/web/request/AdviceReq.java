package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 投诉建议
 * 
 * @author zbk
 * @email 
 * @date 2017-06-06 17:56:58
 */
@ApiModel
public class AdviceReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//姓名
	@ApiModelProperty(value = "姓名",dataType="String")
	private String name;
	//电话
	@ApiModelProperty(value = "电话",dataType="String")
	private String mobile;
	//邮箱
	@ApiModelProperty(value = "邮箱",dataType="String")
	private String email;
	//投诉建议标题
	@ApiModelProperty(value = "投诉建议标题",dataType="String")
	private String adviceTitle;
	//投诉建议详情
	@ApiModelProperty(value = "投诉建议详情",dataType="String")
	private String adviceContent;
	//意见类型
	@ApiModelProperty(value = "意见类型",dataType="Integer")
	private Integer adviceType;
	//状态 (0:未审核 1:已审核 2:审核不通过 )
	@ApiModelProperty(value = "状态 (0:未审核 1:已审核 2:审核不通过 )",dataType="Integer")
	private Integer status;
	//处理时间
	@ApiModelProperty(value = "处理时间",dataType="Date")
	private Date createTime;
	//处理状态
	@ApiModelProperty(value = "处理状态",dataType="Integer")
	private Integer isDeal;
	//回复内容
	@ApiModelProperty(value = "回复内容",dataType="String")
	private String resContent;
	//处理人
	@ApiModelProperty(value = "处理人",dataType="Integer")
	private Integer dealBy;
	//处理时间
	@ApiModelProperty(value = "处理时间",dataType="Date")
	private Date dealTime;
	//一级审核人
	@ApiModelProperty(value = "一级审核人",dataType="Integer")
	private Integer audit1By;
	//一级审核时间
	@ApiModelProperty(value = "一级审核时间",dataType="Date")
	private Date audit1Time;
	//二级审核人
	@ApiModelProperty(value = "二级审核人",dataType="Integer")
	private Integer audit2By;
	//二级审核时间
	@ApiModelProperty(value = "二级审核时间",dataType="Date")
	private Date audit2Time;
	//三级审核人
	@ApiModelProperty(value = "三级审核人",dataType="Integer")
	private Integer audit3By;
	//三级审核时间
	@ApiModelProperty(value = "三级审核时间",dataType="Date")
	private Date audit3Time;

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
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：电话
	 */
	public String getMobile() {
		return mobile;
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
	 * 设置：投诉建议标题
	 */
	public void setAdviceTitle(String adviceTitle) {
		this.adviceTitle = adviceTitle;
	}
	/**
	 * 获取：投诉建议标题
	 */
	public String getAdviceTitle() {
		return adviceTitle;
	}
	/**
	 * 设置：投诉建议详情
	 */
	public void setAdviceContent(String adviceContent) {
		this.adviceContent = adviceContent;
	}
	/**
	 * 获取：投诉建议详情
	 */
	public String getAdviceContent() {
		return adviceContent;
	}
	/**
	 * 设置：意见类型
	 */
	public void setAdviceType(Integer adviceType) {
		this.adviceType = adviceType;
	}
	/**
	 * 获取：意见类型
	 */
	public Integer getAdviceType() {
		return adviceType;
	}
	/**
	 * 设置：状态 (0:未审核 1:已审核 2:审核不通过 )
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 (0:未审核 1:已审核 2:审核不通过 )
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：处理时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：处理时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：处理状态
	 */
	public void setIsDeal(Integer isDeal) {
		this.isDeal = isDeal;
	}
	/**
	 * 获取：处理状态
	 */
	public Integer getIsDeal() {
		return isDeal;
	}
	/**
	 * 设置：回复内容
	 */
	public void setResContent(String resContent) {
		this.resContent = resContent;
	}
	/**
	 * 获取：回复内容
	 */
	public String getResContent() {
		return resContent;
	}
	/**
	 * 设置：处理人
	 */
	public void setDealBy(Integer dealBy) {
		this.dealBy = dealBy;
	}
	/**
	 * 获取：处理人
	 */
	public Integer getDealBy() {
		return dealBy;
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
	/**
	 * 设置：一级审核人
	 */
	public void setAudit1By(Integer audit1By) {
		this.audit1By = audit1By;
	}
	/**
	 * 获取：一级审核人
	 */
	public Integer getAudit1By() {
		return audit1By;
	}
	/**
	 * 设置：一级审核时间
	 */
	public void setAudit1Time(Date audit1Time) {
		this.audit1Time = audit1Time;
	}
	/**
	 * 获取：一级审核时间
	 */
	public Date getAudit1Time() {
		return audit1Time;
	}
	/**
	 * 设置：二级审核人
	 */
	public void setAudit2By(Integer audit2By) {
		this.audit2By = audit2By;
	}
	/**
	 * 获取：二级审核人
	 */
	public Integer getAudit2By() {
		return audit2By;
	}
	/**
	 * 设置：二级审核时间
	 */
	public void setAudit2Time(Date audit2Time) {
		this.audit2Time = audit2Time;
	}
	/**
	 * 获取：二级审核时间
	 */
	public Date getAudit2Time() {
		return audit2Time;
	}
	/**
	 * 设置：三级审核人
	 */
	public void setAudit3By(Integer audit3By) {
		this.audit3By = audit3By;
	}
	/**
	 * 获取：三级审核人
	 */
	public Integer getAudit3By() {
		return audit3By;
	}
	/**
	 * 设置：三级审核时间
	 */
	public void setAudit3Time(Date audit3Time) {
		this.audit3Time = audit3Time;
	}
	/**
	 * 获取：三级审核时间
	 */
	public Date getAudit3Time() {
		return audit3Time;
	}
}
