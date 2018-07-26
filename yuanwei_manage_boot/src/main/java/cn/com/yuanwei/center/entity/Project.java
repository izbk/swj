package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 项目储备表
 * 
 * @author zbk
 * @date 2017-06-29 16:51:37
 */
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//项目名称
	@Excel(name = "项目名称",isImportField="true")
	private String projectName;
	//建设地点
	@Excel(name = "建设地点")
	private String address;
	//计划开工日期
	@Excel(name = "计划开工日期",format="yyyy-MM-dd")
	private Date plannedStartDate;
	//计划完工日期
	@Excel(name = "计划完工日期",format="yyyy-MM-dd")
	private Date plannedCompletionTime;
	//用地面积
	@Excel(name = "用地面积(㎡)")
	private BigDecimal landArea;
	//建筑面积
	@Excel(name = "建筑面积(㎡)")
	private BigDecimal buildingArea;
	//营业面积
	@Excel(name = "营业面积(㎡)")
	private BigDecimal businessArea;
	//是否投入使用(0:否 1:是)
	@Excel(name = "是否投入使用(0:否 1:是)",replace={"否_0","是_1"})
	private Integer isUse;
	//是否分期(0:否 1:是)
	@Excel(name = "是否分期(0:否 1:是)",replace={"否_0","是_1"})
	private Integer isStage;
	//是否跨年度(0:否 1:是)
	@Excel(name = "是否跨年度(0:否 1:是)",replace={"否_0","是_1"})
	private Integer isBeyondYear;
	//项目类型(0:电子商务、1:物流、2:市场、3:综合体、4:商业设施升级改造、5:扩大消费活动、6:品牌创建及推广、7:家政服务、8:健康养老、9:文化旅游等)
	@Excel(name = "项目类型(0:电子商务、1:物流、2:市场、3:综合体、4:商业设施升级改造、5:扩大消费活动、6:品牌创建及推广、7:家政服务、8:健康养老、9:文化旅游等)",replace={"电子商务_0","物流_1","市场_2","综合体_3","商业设施升级改造_4","扩大消费活动_5","品牌创建及推广_6","家政服务_7","健康养老_8","文化旅游_9"})
	private Integer projectType;
	//项目业主名称
	@Excel(name = "项目业主名称")
	private String owner;
	//法人姓名
	@Excel(name = "法人姓名")
	private String legalPerson;
	//通信联系
	@Excel(name = "通信联系")
	private String contact;
	//项目批复为文号
	@Excel(name = "项目批复为文号")
	private String recordNum;
	//批复总投资
	@Excel(name = "批复总投资（万元）")
	private BigDecimal approveInvestment;
	//规划投资（万元）
	@Excel(name = "规划投资（万元）")
	private BigDecimal programInvestment;
	//计划投资（万元）
	@Excel(name = "计划投资（万元）")
	private BigDecimal planInvestment;
	//实际投入（万元）
	@Excel(name = "实际投入（万元）")
	private BigDecimal realInvestment;
	//自筹
	@Excel(name = "自筹（万元）")
	private BigDecimal raise;
	//贷款
	@Excel(name = "贷款（万元）")
	private BigDecimal loan;
	//其它
	@Excel(name = "其它（万元）")
	private BigDecimal other;
	//建设状态
	@Excel(name = "建设状态",replace={"拟建_0","在建_1","完工_2"})
	private Integer buildStatus;
	//建设内容
	@Excel(name = "建设内容")
	private String constructionContent;
	//存在困难及建议
	@Excel(name = "存在困难及建议")
	private String proposal;
	//项目建设状态评估
	@Excel(name = "项目建设状态评估")
	private String assessment;
	//拨付状态（0：未拨付 1：已拨付）
	@Excel(name = "拨付状态（0：未拨付 1：已拨付）",replace={"未拨付_0","已拨付_1"})
	private Integer payStatus;
	//状态 (0:未审核 1:已审核 2:审核不通过 )
	@Excel(name = "状态 (0:未审核 1:已审核 2:审核不通过 )",replace={"未审核_0","已审核_1","审核不通过_2"})
	private Integer status;
	//创建时间
	private Date createTime;
	//一级审核人
	private Integer audit1By;
	//一级审核时间
	private Date audit1Time;
	//二级审核人
	private Integer audit2By;
	//二级审核时间
	private Date audit2Time;
	//三级审核人
	private Integer audit3By;
	//三级审核时间
	private Date audit3Time;
	private String audit1Opinion;
	private String audit2Opinion;
	private String audit3Opinion;
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

	public String getAudit1Opinion() {
		return audit1Opinion;
	}
	public void setAudit1Opinion(String audit1Opinion) {
		this.audit1Opinion = audit1Opinion;
	}
	public String getAudit2Opinion() {
		return audit2Opinion;
	}
	public void setAudit2Opinion(String audit2Opinion) {
		this.audit2Opinion = audit2Opinion;
	}
	public String getAudit3Opinion() {
		return audit3Opinion;
	}
	public void setAudit3Opinion(String audit3Opinion) {
		this.audit3Opinion = audit3Opinion;
	}
	public Project() {
		super();
	}

	public Project(
		Integer id,
		String projectName,
		String address,
		Date plannedStartDate,
		Date plannedCompletionTime,
		BigDecimal landArea,
		BigDecimal buildingArea,
		BigDecimal businessArea,
		Integer isUse,
		Integer isStage,
		Integer isBeyondYear,
		Integer projectType,
		String owner,
		String legalPerson,
		String contact,
		String recordNum,
		BigDecimal approveInvestment,
		BigDecimal programInvestment,
		BigDecimal planInvestment,
		BigDecimal realInvestment,
		BigDecimal raise,
		BigDecimal loan,
		BigDecimal other,
		Integer buildStatus,
		String constructionContent,
		String proposal,
		String assessment,
		Integer payStatus,
		Integer status,
		Date createTime,
		Integer audit1By,
		Date audit1Time,
		Integer audit2By,
		Date audit2Time,
		Integer audit3By,
		Date audit3Time) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.address = address;
		this.plannedStartDate = plannedStartDate;
		this.plannedCompletionTime = plannedCompletionTime;
		this.landArea = landArea;
		this.buildingArea = buildingArea;
		this.businessArea = businessArea;
		this.isUse = isUse;
		this.isStage = isStage;
		this.isBeyondYear = isBeyondYear;
		this.projectType = projectType;
		this.owner = owner;
		this.legalPerson = legalPerson;
		this.contact = contact;
		this.recordNum = recordNum;
		this.approveInvestment = approveInvestment;
		this.programInvestment = programInvestment;
		this.planInvestment = planInvestment;
		this.realInvestment = realInvestment;
		this.raise = raise;
		this.loan = loan;
		this.other = other;
		this.buildStatus = buildStatus;
		this.constructionContent = constructionContent;
		this.proposal = proposal;
		this.assessment = assessment;
		this.payStatus = payStatus;
		this.status = status;
		this.createTime = createTime;
		this.audit1By = audit1By;
		this.audit1Time = audit1Time;
		this.audit2By = audit2By;
		this.audit2Time = audit2Time;
		this.audit3By = audit3By;
		this.audit3Time = audit3Time;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"projectName\":").append("\"").append(projectName).append("\"").append(",");
		sb.append("\"address\":").append("\"").append(address).append("\"").append(",");
		sb.append("\"plannedStartDate\":").append("\"").append(plannedStartDate).append("\"").append(",");
		sb.append("\"plannedCompletionTime\":").append("\"").append(plannedCompletionTime).append("\"").append(",");
		sb.append("\"landArea\":").append("\"").append(landArea).append("\"").append(",");
		sb.append("\"buildingArea\":").append("\"").append(buildingArea).append("\"").append(",");
		sb.append("\"businessArea\":").append("\"").append(businessArea).append("\"").append(",");
		sb.append("\"isUse\":").append("\"").append(isUse).append("\"").append(",");
		sb.append("\"isStage\":").append("\"").append(isStage).append("\"").append(",");
		sb.append("\"isBeyondYear\":").append("\"").append(isBeyondYear).append("\"").append(",");
		sb.append("\"projectType\":").append("\"").append(projectType).append("\"").append(",");
		sb.append("\"owner\":").append("\"").append(owner).append("\"").append(",");
		sb.append("\"legalPerson\":").append("\"").append(legalPerson).append("\"").append(",");
		sb.append("\"contact\":").append("\"").append(contact).append("\"").append(",");
		sb.append("\"recordNum\":").append("\"").append(recordNum).append("\"").append(",");
		sb.append("\"approveInvestment\":").append("\"").append(approveInvestment).append("\"").append(",");
		sb.append("\"programInvestment\":").append("\"").append(programInvestment).append("\"").append(",");
		sb.append("\"planInvestment\":").append("\"").append(planInvestment).append("\"").append(",");
		sb.append("\"realInvestment\":").append("\"").append(realInvestment).append("\"").append(",");
		sb.append("\"raise\":").append("\"").append(raise).append("\"").append(",");
		sb.append("\"loan\":").append("\"").append(loan).append("\"").append(",");
		sb.append("\"other\":").append("\"").append(other).append("\"").append(",");
		sb.append("\"buildStatus\":").append("\"").append(buildStatus).append("\"").append(",");
		sb.append("\"constructionContent\":").append("\"").append(constructionContent).append("\"").append(",");
		sb.append("\"proposal\":").append("\"").append(proposal).append("\"").append(",");
		sb.append("\"assessment\":").append("\"").append(assessment).append("\"").append(",");
		sb.append("\"payStatus\":").append("\"").append(payStatus).append("\"").append(",");
		sb.append("\"status\":").append("\"").append(status).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append(",");
		sb.append("\"audit1By\":").append("\"").append(audit1By).append("\"").append(",");
		sb.append("\"audit1Time\":").append("\"").append(audit1Time).append("\"").append(",");
		sb.append("\"audit2By\":").append("\"").append(audit2By).append("\"").append(",");
		sb.append("\"audit2Time\":").append("\"").append(audit2Time).append("\"").append(",");
		sb.append("\"audit3By\":").append("\"").append(audit3By).append("\"").append(",");
		sb.append("\"audit3Time\":").append("\"").append(audit3Time).append("\"").append("}");
        return sb.toString();
    }
}
