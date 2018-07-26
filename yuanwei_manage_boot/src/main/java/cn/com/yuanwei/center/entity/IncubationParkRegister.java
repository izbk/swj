package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;

/**
 * 孵化园申请登记信息
 * 
 * @author zbk
 * @date 2017-07-03 17:59:11
 */
public class IncubationParkRegister implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//姓名
	@Excel(name = "姓名",isImportField="true")
	private String name;
	//联系电话
	@Excel(name = "联系电话",isImportField="true")
	private String mobile;
	//经营主体全称
	@Excel(name = "经营主体全称",isImportField="true")
	private String businessSubject;
	//法人（负责人）
	@Excel(name = "法人（负责人）",isImportField="true")
	private String legalPerson;
	//企业类型
	@Excel(name = "企业类型",replace={"实体商品交易电商_0","电商服务_1","自营平台_2","代理平台_3","微商_4","新媒体_5","软件开发_6","虚拟产品交易电商_7"},isImportField="true")
	private Integer companyType;
	//申请办公室数量
	@Excel(name = "申请办公室数量（间）",isImportField="true")
	private Integer applicationRoom;
	//申请仓储面积
	@Excel(name = "申请仓储面积（平方米）",isImportField="true")
	private String applicationArea;
	//申请经营范围
	@Excel(name = "申请经营范围",isImportField="true")
	private String businessScope;
	//入驻团队人数
	@Excel(name = "入驻团队人数",isImportField="true")
	private Integer teamNumber;
	//项目简介
	@Excel(name = "项目简介",isImportField="true")
	private String projectIntroduction;
	//审核状态
	@Excel(name = "审核状态",replace={"未审核_0","已审核_1","审核不通过_2"},isImportField="true")
	private Integer status;
	//备注
	@Excel(name = "备注",isImportField="true")
	private String remark;
	//创建人
	private Integer createBy;
	//创建时间
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

	public IncubationParkRegister() {
		super();
	}

	public IncubationParkRegister(
		Integer id,
		String name,
		String mobile,
		String businessSubject,
		String legalPerson,
		Integer companyType,
		Integer applicationRoom,
		String applicationArea,
		String businessScope,
		Integer teamNumber,
		String projectIntroduction,
		Integer status,
		String remark,
		Integer createBy,
		Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.businessSubject = businessSubject;
		this.legalPerson = legalPerson;
		this.companyType = companyType;
		this.applicationRoom = applicationRoom;
		this.applicationArea = applicationArea;
		this.businessScope = businessScope;
		this.teamNumber = teamNumber;
		this.projectIntroduction = projectIntroduction;
		this.status = status;
		this.remark = remark;
		this.createBy = createBy;
		this.createTime = createTime;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"name\":").append("\"").append(name).append("\"").append(",");
		sb.append("\"mobile\":").append("\"").append(mobile).append("\"").append(",");
		sb.append("\"businessSubject\":").append("\"").append(businessSubject).append("\"").append(",");
		sb.append("\"legalPerson\":").append("\"").append(legalPerson).append("\"").append(",");
		sb.append("\"companyType\":").append("\"").append(companyType).append("\"").append(",");
		sb.append("\"applicationRoom\":").append("\"").append(applicationRoom).append("\"").append(",");
		sb.append("\"applicationArea\":").append("\"").append(applicationArea).append("\"").append(",");
		sb.append("\"businessScope\":").append("\"").append(businessScope).append("\"").append(",");
		sb.append("\"teamNumber\":").append("\"").append(teamNumber).append("\"").append(",");
		sb.append("\"projectIntroduction\":").append("\"").append(projectIntroduction).append("\"").append(",");
		sb.append("\"status\":").append("\"").append(status).append("\"").append(",");
		sb.append("\"remark\":").append("\"").append(remark).append("\"").append(",");
		sb.append("\"createBy\":").append("\"").append(createBy).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
