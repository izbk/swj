package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 孵化园企业信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 17:26:50
 */
@ApiModel
public class IncubationParkCompanyReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//姓名
	@ApiModelProperty(value = "姓名",dataType="String")
	private String name;
	//联系电话
	@ApiModelProperty(value = "联系电话",dataType="String")
	private String mobile;
	//经营主体全称
	@ApiModelProperty(value = "经营主体全称",dataType="String")
	private String businessSubject;
	//法人（负责人）
	@ApiModelProperty(value = "法人（负责人）",dataType="String")
	private String legalPerson;
	//企业类型
	@ApiModelProperty(value = "企业类型",dataType="Integer")
	private Integer companyType;
	//办公室数量
	@ApiModelProperty(value = "办公室数量",dataType="Integer")
	private Integer rooms;
	//仓储面积
	@ApiModelProperty(value = "仓储面积",dataType="String")
	private String areas;
	//经营范围
	@ApiModelProperty(value = "经营范围",dataType="String")
	private String businessScope;
	//入驻团队人数
	@ApiModelProperty(value = "入驻团队人数",dataType="Integer")
	private Integer teamNumber;
	//项目简介
	@ApiModelProperty(value = "项目简介",dataType="String")
	private String projectIntroduction;
	//企业简介
	@ApiModelProperty(value = "企业简介",dataType="String")
	private String companyDesc;
	//企业评价
	@ApiModelProperty(value = "企业评价",dataType="String")
	private String evaluate;
	//发展规划
	@ApiModelProperty(value = "发展规划",dataType="String")
	private String development;
	//电商协会审查意见
	@ApiModelProperty(value = "电商协会审查意见",dataType="String")
	private String ecExamination;
	//状态
	@ApiModelProperty(value = "状态",dataType="Integer")
	private Integer companyStatus;
	//
	@ApiModelProperty(value = "",dataType="Date")
	private Date inDate;
	//
	@ApiModelProperty(value = "",dataType="Date")
	private Date outDate;
	//
	@ApiModelProperty(value = "",dataType="String")
	private String outReason;
	//备注
	@ApiModelProperty(value = "备注",dataType="String")
	private String remark;
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
	 * 设置：联系电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：联系电话
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：经营主体全称
	 */
	public void setBusinessSubject(String businessSubject) {
		this.businessSubject = businessSubject;
	}
	/**
	 * 获取：经营主体全称
	 */
	public String getBusinessSubject() {
		return businessSubject;
	}
	/**
	 * 设置：法人（负责人）
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	/**
	 * 获取：法人（负责人）
	 */
	public String getLegalPerson() {
		return legalPerson;
	}
	/**
	 * 设置：企业类型
	 */
	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}
	/**
	 * 获取：企业类型
	 */
	public Integer getCompanyType() {
		return companyType;
	}
	/**
	 * 设置：办公室数量
	 */
	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}
	/**
	 * 获取：办公室数量
	 */
	public Integer getRooms() {
		return rooms;
	}
	/**
	 * 设置：仓储面积
	 */
	public void setAreas(String areas) {
		this.areas = areas;
	}
	/**
	 * 获取：仓储面积
	 */
	public String getAreas() {
		return areas;
	}
	/**
	 * 设置：经营范围
	 */
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	/**
	 * 获取：经营范围
	 */
	public String getBusinessScope() {
		return businessScope;
	}
	/**
	 * 设置：入驻团队人数
	 */
	public void setTeamNumber(Integer teamNumber) {
		this.teamNumber = teamNumber;
	}
	/**
	 * 获取：入驻团队人数
	 */
	public Integer getTeamNumber() {
		return teamNumber;
	}
	/**
	 * 设置：项目简介
	 */
	public void setProjectIntroduction(String projectIntroduction) {
		this.projectIntroduction = projectIntroduction;
	}
	/**
	 * 获取：项目简介
	 */
	public String getProjectIntroduction() {
		return projectIntroduction;
	}
	/**
	 * 设置：企业简介
	 */
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}
	/**
	 * 获取：企业简介
	 */
	public String getCompanyDesc() {
		return companyDesc;
	}
	/**
	 * 设置：企业评价
	 */
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	/**
	 * 获取：企业评价
	 */
	public String getEvaluate() {
		return evaluate;
	}
	/**
	 * 设置：发展规划
	 */
	public void setDevelopment(String development) {
		this.development = development;
	}
	/**
	 * 获取：发展规划
	 */
	public String getDevelopment() {
		return development;
	}
	/**
	 * 设置：电商协会审查意见
	 */
	public void setEcExamination(String ecExamination) {
		this.ecExamination = ecExamination;
	}
	/**
	 * 获取：电商协会审查意见
	 */
	public String getEcExamination() {
		return ecExamination;
	}
	/**
	 * 设置：状态
	 */
	public void setCompanyStatus(Integer companyStatus) {
		this.companyStatus = companyStatus;
	}
	/**
	 * 获取：状态
	 */
	public Integer getCompanyStatus() {
		return companyStatus;
	}
	/**
	 * 设置：
	 */
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	/**
	 * 获取：
	 */
	public Date getInDate() {
		return inDate;
	}
	/**
	 * 设置：
	 */
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	/**
	 * 获取：
	 */
	public Date getOutDate() {
		return outDate;
	}
	/**
	 * 设置：
	 */
	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}
	/**
	 * 获取：
	 */
	public String getOutReason() {
		return outReason;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
