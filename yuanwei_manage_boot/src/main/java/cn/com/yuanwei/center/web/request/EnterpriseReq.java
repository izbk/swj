package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 限上企业信息表
 * 
 * @author zbk
 * @email 
 * @date 2017-07-17 17:56:52
 */
@ApiModel
public class EnterpriseReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//企业代码
	@ApiModelProperty(value = "企业代码",dataType="String")
	private String enterpriseCode;
	//企业名称
	@ApiModelProperty(value = "企业名称",dataType="String")
	private String enterpriseName;
	//乡镇ID
	@ApiModelProperty(value = "乡镇ID",dataType="Integer")
	private Integer townshipId;
	//企业类型（0:法人 1:个体）
	@ApiModelProperty(value = "企业类型（0:法人 1:个体）",dataType="Integer")
	private Integer enterpriseType;
	//业态（0:批发 1:零售 2:餐饮 3:住宿 ）
	@ApiModelProperty(value = "业态（0:批发 1:零售 2:餐饮 3:住宿 ）",dataType="Integer")
	private Integer industry;
	//企业负责人
	@ApiModelProperty(value = "企业负责人",dataType="String")
	private String chargeName;
	//负责人电话
	@ApiModelProperty(value = "负责人电话",dataType="String")
	private String chargeMobile;
	//统计员ID
	@ApiModelProperty(value = "统计员ID",dataType="Integer")
	private Integer userId;
	//统计员姓名
	@ApiModelProperty(value = "统计员姓名",dataType="String")
	private String userName;
	//入库时间
	@ApiModelProperty(value = "入库时间",dataType="Date")
	private Date inDate;
	//出库时间
	@ApiModelProperty(value = "出库时间",dataType="Date")
	private Date outDate;
	//入库类型（0:已入库 1:新增入库 2:未入库 3:已出库 4:破产吊销出库）
	@ApiModelProperty(value = "入库类型（0:已入库 1:新增入库 2:未入库 3:已出库 4:破产吊销出库）",dataType="Integer")
	private Integer inType;
	//是否代报
	@ApiModelProperty(value = "是否代报",dataType="Integer")
	private Integer agent;
	@ApiModelProperty(value = "新增企业同期门槛数",dataType="BigDecimal")
	private BigDecimal threshold;
	//创建人
	@ApiModelProperty(value = "创建人",dataType="Integer")
	private Integer createBy;
	//创建时间
	@ApiModelProperty(value = "创建时间",dataType="Date")
	private Date createTime;

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
	 * 设置：企业代码
	 */
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	/**
	 * 获取：企业代码
	 */
	public String getEnterpriseCode() {
		return enterpriseCode;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：乡镇ID
	 */
	public void setTownshipId(Integer townshipId) {
		this.townshipId = townshipId;
	}
	/**
	 * 获取：乡镇ID
	 */
	public Integer getTownshipId() {
		return townshipId;
	}
	/**
	 * 设置：企业类型（0:法人 1:个体）
	 */
	public void setEnterpriseType(Integer enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	/**
	 * 获取：企业类型（0:法人 1:个体）
	 */
	public Integer getEnterpriseType() {
		return enterpriseType;
	}
	/**
	 * 设置：业态（0:批发 1:零售 2:餐饮 3:住宿 ）
	 */
	public void setIndustry(Integer industry) {
		this.industry = industry;
	}
	/**
	 * 获取：业态（0:批发 1:零售 2:餐饮 3:住宿 ）
	 */
	public Integer getIndustry() {
		return industry;
	}
	/**
	 * 设置：企业负责人
	 */
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	/**
	 * 获取：企业负责人
	 */
	public String getChargeName() {
		return chargeName;
	}
	/**
	 * 设置：负责人电话
	 */
	public void setChargeMobile(String chargeMobile) {
		this.chargeMobile = chargeMobile;
	}
	/**
	 * 获取：负责人电话
	 */
	public String getChargeMobile() {
		return chargeMobile;
	}
	/**
	 * 设置：统计员ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：统计员ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：统计员姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：统计员姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：入库时间
	 */
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	/**
	 * 获取：入库时间
	 */
	public Date getInDate() {
		return inDate;
	}
	/**
	 * 设置：出库时间
	 */
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	/**
	 * 获取：出库时间
	 */
	public Date getOutDate() {
		return outDate;
	}
	/**
	 * 设置：入库类型（0:已入库 1:新增入库 2:未入库 3:已出库 4:破产吊销出库）
	 */
	public void setInType(Integer inType) {
		this.inType = inType;
	}
	/**
	 * 获取：入库类型（0:已入库 1:新增入库 2:未入库 3:已出库 4:破产吊销出库）
	 */
	public Integer getInType() {
		return inType;
	}
	/**
	 * 设置：是否代报
	 */
	public void setAgent(Integer agent) {
		this.agent = agent;
	}
	/**
	 * 获取：是否代报
	 */
	public Integer getAgent() {
		return agent;
	}
	public BigDecimal getThreshold() {
		return threshold;
	}
	public void setThreshold(BigDecimal threshold) {
		this.threshold = threshold;
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
}
