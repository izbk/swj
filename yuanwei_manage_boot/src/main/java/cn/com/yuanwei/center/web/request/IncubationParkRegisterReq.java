package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 孵化园申请登记信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-03 17:59:11
 */
@ApiModel
public class IncubationParkRegisterReq extends PageReq {
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
	//申请办公室数量
	@ApiModelProperty(value = "申请办公室数量",dataType="Integer")
	private Integer applicationRoom;
	//申请仓储面积
	@ApiModelProperty(value = "申请仓储面积",dataType="String")
	private String applicationArea;
	//申请经营范围
	@ApiModelProperty(value = "申请经营范围",dataType="String")
	private String businessScope;
	//入驻团队人数
	@ApiModelProperty(value = "入驻团队人数",dataType="Integer")
	private Integer teamNumber;
	//项目简介
	@ApiModelProperty(value = "项目简介",dataType="String")
	private String projectIntroduction;
	//审核状态
	@ApiModelProperty(value = "审核状态",dataType="Integer")
	private Integer status;
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
	 * 设置：申请办公室数量
	 */
	public void setApplicationRoom(Integer applicationRoom) {
		this.applicationRoom = applicationRoom;
	}
	/**
	 * 获取：申请办公室数量
	 */
	public Integer getApplicationRoom() {
		return applicationRoom;
	}
	/**
	 * 设置：申请仓储面积
	 */
	public void setApplicationArea(String applicationArea) {
		this.applicationArea = applicationArea;
	}
	/**
	 * 获取：申请仓储面积
	 */
	public String getApplicationArea() {
		return applicationArea;
	}
	/**
	 * 设置：申请经营范围
	 */
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	/**
	 * 获取：申请经营范围
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
	 * 设置：审核状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：审核状态
	 */
	public Integer getStatus() {
		return status;
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
