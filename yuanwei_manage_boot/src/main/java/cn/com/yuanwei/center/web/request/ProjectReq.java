package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 项目储备表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-01 15:57:22
 */
@ApiModel
public class ProjectReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//项目名称
	@ApiModelProperty(value = "项目名称",dataType="String")
	private String projectName;
	//建设地点
	@ApiModelProperty(value = "建设地点",dataType="String")
	private String address;
	//计划开工日期
	@ApiModelProperty(value = "计划开工日期",dataType="Date")
	private Date plannedStartDate;
	//计划完工日期
	@ApiModelProperty(value = "计划完工日期",dataType="Date")
	private Date plannedCompletionTime;
	//用地面积
	@ApiModelProperty(value = "用地面积",dataType="BigDecimal")
	private BigDecimal landArea;
	//建筑面积
	@ApiModelProperty(value = "建筑面积",dataType="BigDecimal")
	private BigDecimal buildingArea;
	//营业面积
	@ApiModelProperty(value = "营业面积",dataType="BigDecimal")
	private BigDecimal businessArea;
	//是否投入使用(0:否 1:是)
	@ApiModelProperty(value = "是否投入使用(0:否 1:是)",dataType="Integer")
	private Integer isUse;
	//是否分期(0:否 1:是)
	@ApiModelProperty(value = "是否分期(0:否 1:是)",dataType="Integer")
	private Integer isStage;
	//是否跨年度(0:否 1:是)
	@ApiModelProperty(value = "是否跨年度(0:否 1:是)",dataType="Integer")
	private Integer isBeyondYear;
	//项目类型(0:电子商务、1:物流、2:市场、3:综合体、4:商业设施升级改造、5:扩大消费活动、6:品牌创建及推广、7:家政服务、8:健康养老、9:文化旅游等)
	@ApiModelProperty(value = "项目类型(0:电子商务、1:物流、2:市场、3:综合体、4:商业设施升级改造、5:扩大消费活动、6:品牌创建及推广、7:家政服务、8:健康养老、9:文化旅游等)",dataType="Integer")
	private Integer projectType;
	//项目业主名称
	@ApiModelProperty(value = "项目业主名称",dataType="String")
	private String owner;
	//法人姓名
	@ApiModelProperty(value = "法人姓名",dataType="String")
	private String legalPerson;
	//通信联系
	@ApiModelProperty(value = "通信联系",dataType="String")
	private String contact;
	//项目批复为文号
	@ApiModelProperty(value = "项目批复为文号",dataType="String")
	private String recordNum;
	//批复总投资
	@ApiModelProperty(value = "批复总投资",dataType="BigDecimal")
	private BigDecimal approveInvestment;
	//规划投资（万元）
	@ApiModelProperty(value = "规划投资（万元）",dataType="BigDecimal")
	private BigDecimal programInvestment;
	//计划投资（万元）
	@ApiModelProperty(value = "计划投资（万元）",dataType="BigDecimal")
	private BigDecimal planInvestment;
	//实际投入（万元）
	@ApiModelProperty(value = "实际投入（万元）",dataType="BigDecimal")
	private BigDecimal realInvestment;
	//自筹
	@ApiModelProperty(value = "自筹",dataType="BigDecimal")
	private BigDecimal raise;
	//贷款
	@ApiModelProperty(value = "贷款",dataType="BigDecimal")
	private BigDecimal loan;
	//其它
	@ApiModelProperty(value = "其它",dataType="BigDecimal")
	private BigDecimal other;
	//建设状态
	@ApiModelProperty(value = "建设状态",dataType="Integer")
	private Integer buildStatus;
	//建设内容
	@ApiModelProperty(value = "建设内容",dataType="String")
	private String constructionContent;
	//存在困难及建议
	@ApiModelProperty(value = "存在困难及建议",dataType="String")
	private String proposal;
	//项目建设状态评估
	@ApiModelProperty(value = "项目建设状态评估",dataType="String")
	private String assessment;
	//拨付状态（0：未拨付 1：已拨付）
	@ApiModelProperty(value = "拨付状态（0：未拨付 1：已拨付）",dataType="Integer")
	private Integer payStatus;
	//状态 (0:未审核 1:已审核 2:审核不通过 )
	@ApiModelProperty(value = "状态 (0:未审核 1:已审核 2:审核不通过 )",dataType="Integer")
	private Integer status;
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
	 * 设置：项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：建设地点
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：建设地点
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：计划开工日期
	 */
	public void setPlannedStartDate(Date plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}
	/**
	 * 获取：计划开工日期
	 */
	public Date getPlannedStartDate() {
		return plannedStartDate;
	}
	/**
	 * 设置：计划完工日期
	 */
	public void setPlannedCompletionTime(Date plannedCompletionTime) {
		this.plannedCompletionTime = plannedCompletionTime;
	}
	/**
	 * 获取：计划完工日期
	 */
	public Date getPlannedCompletionTime() {
		return plannedCompletionTime;
	}
	/**
	 * 设置：用地面积
	 */
	public void setLandArea(BigDecimal landArea) {
		this.landArea = landArea;
	}
	/**
	 * 获取：用地面积
	 */
	public BigDecimal getLandArea() {
		return landArea;
	}
	/**
	 * 设置：建筑面积
	 */
	public void setBuildingArea(BigDecimal buildingArea) {
		this.buildingArea = buildingArea;
	}
	/**
	 * 获取：建筑面积
	 */
	public BigDecimal getBuildingArea() {
		return buildingArea;
	}
	/**
	 * 设置：营业面积
	 */
	public void setBusinessArea(BigDecimal businessArea) {
		this.businessArea = businessArea;
	}
	/**
	 * 获取：营业面积
	 */
	public BigDecimal getBusinessArea() {
		return businessArea;
	}
	/**
	 * 设置：是否投入使用(0:否 1:是)
	 */
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	/**
	 * 获取：是否投入使用(0:否 1:是)
	 */
	public Integer getIsUse() {
		return isUse;
	}
	/**
	 * 设置：是否分期(0:否 1:是)
	 */
	public void setIsStage(Integer isStage) {
		this.isStage = isStage;
	}
	/**
	 * 获取：是否分期(0:否 1:是)
	 */
	public Integer getIsStage() {
		return isStage;
	}
	/**
	 * 设置：是否跨年度(0:否 1:是)
	 */
	public void setIsBeyondYear(Integer isBeyondYear) {
		this.isBeyondYear = isBeyondYear;
	}
	/**
	 * 获取：是否跨年度(0:否 1:是)
	 */
	public Integer getIsBeyondYear() {
		return isBeyondYear;
	}
	/**
	 * 设置：项目类型(0:电子商务、1:物流、2:市场、3:综合体、4:商业设施升级改造、5:扩大消费活动、6:品牌创建及推广、7:家政服务、8:健康养老、9:文化旅游等)
	 */
	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}
	/**
	 * 获取：项目类型(0:电子商务、1:物流、2:市场、3:综合体、4:商业设施升级改造、5:扩大消费活动、6:品牌创建及推广、7:家政服务、8:健康养老、9:文化旅游等)
	 */
	public Integer getProjectType() {
		return projectType;
	}
	/**
	 * 设置：项目业主名称
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * 获取：项目业主名称
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * 设置：法人姓名
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	/**
	 * 获取：法人姓名
	 */
	public String getLegalPerson() {
		return legalPerson;
	}
	/**
	 * 设置：通信联系
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：通信联系
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：项目批复为文号
	 */
	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}
	/**
	 * 获取：项目批复为文号
	 */
	public String getRecordNum() {
		return recordNum;
	}
	/**
	 * 设置：批复总投资
	 */
	public void setApproveInvestment(BigDecimal approveInvestment) {
		this.approveInvestment = approveInvestment;
	}
	/**
	 * 获取：批复总投资
	 */
	public BigDecimal getApproveInvestment() {
		return approveInvestment;
	}
	/**
	 * 设置：规划投资（万元）
	 */
	public void setProgramInvestment(BigDecimal programInvestment) {
		this.programInvestment = programInvestment;
	}
	/**
	 * 获取：规划投资（万元）
	 */
	public BigDecimal getProgramInvestment() {
		return programInvestment;
	}
	/**
	 * 设置：计划投资（万元）
	 */
	public void setPlanInvestment(BigDecimal planInvestment) {
		this.planInvestment = planInvestment;
	}
	/**
	 * 获取：计划投资（万元）
	 */
	public BigDecimal getPlanInvestment() {
		return planInvestment;
	}
	/**
	 * 设置：实际投入（万元）
	 */
	public void setRealInvestment(BigDecimal realInvestment) {
		this.realInvestment = realInvestment;
	}
	/**
	 * 获取：实际投入（万元）
	 */
	public BigDecimal getRealInvestment() {
		return realInvestment;
	}
	/**
	 * 设置：自筹
	 */
	public void setRaise(BigDecimal raise) {
		this.raise = raise;
	}
	/**
	 * 获取：自筹
	 */
	public BigDecimal getRaise() {
		return raise;
	}
	/**
	 * 设置：贷款
	 */
	public void setLoan(BigDecimal loan) {
		this.loan = loan;
	}
	/**
	 * 获取：贷款
	 */
	public BigDecimal getLoan() {
		return loan;
	}
	/**
	 * 设置：其它
	 */
	public void setOther(BigDecimal other) {
		this.other = other;
	}
	/**
	 * 获取：其它
	 */
	public BigDecimal getOther() {
		return other;
	}
	/**
	 * 设置：建设状态
	 */
	public void setBuildStatus(Integer buildStatus) {
		this.buildStatus = buildStatus;
	}
	/**
	 * 获取：建设状态
	 */
	public Integer getBuildStatus() {
		return buildStatus;
	}
	/**
	 * 设置：建设内容
	 */
	public void setConstructionContent(String constructionContent) {
		this.constructionContent = constructionContent;
	}
	/**
	 * 获取：建设内容
	 */
	public String getConstructionContent() {
		return constructionContent;
	}
	/**
	 * 设置：存在困难及建议
	 */
	public void setProposal(String proposal) {
		this.proposal = proposal;
	}
	/**
	 * 获取：存在困难及建议
	 */
	public String getProposal() {
		return proposal;
	}
	/**
	 * 设置：项目建设状态评估
	 */
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	/**
	 * 获取：项目建设状态评估
	 */
	public String getAssessment() {
		return assessment;
	}
	/**
	 * 设置：拨付状态（0：未拨付 1：已拨付）
	 */
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	/**
	 * 获取：拨付状态（0：未拨付 1：已拨付）
	 */
	public Integer getPayStatus() {
		return payStatus;
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
