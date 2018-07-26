package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;

/**
 * 孵化园企业信息
 * 
 * @author zbk
 * @date 2017-07-04 17:26:50
 */
public class IncubationParkCompany implements Serializable {
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
	//办公室数量
	@Excel(name = "办公室数量（间）",isImportField="true")
	private Integer rooms;
	//仓储面积
	@Excel(name = "仓储面积(㎡)",isImportField="true")
	private String areas;
	//经营范围
	@Excel(name = "经营范围",isImportField="true")
	private String businessScope;
	//入驻团队人数
	@Excel(name = "入驻团队人数",isImportField="true")
	private Integer teamNumber;
	//项目简介
	@Excel(name = "项目简介",isImportField="true")
	private String projectIntroduction;
	//企业简介
	@Excel(name = "企业简介",isImportField="true")
	private String companyDesc;
	//企业评价
	@Excel(name = "企业评价",isImportField="true")
	private String evaluate;
	//发展规划
	@Excel(name = "发展规划",isImportField="true")
	private String development;
	//电商协会审查意见
	@Excel(name = "电商协会审查意见",isImportField="true")
	private String ecExamination;
	//状态
	@Excel(name = "状态",replace={"已入园_0","已出园_1"},isImportField="true")
	private Integer companyStatus;
	//入园时间
	@Excel(name = "入园时间",format="yyyy-MM-dd",isImportField="true")
	private Date inDate;
	//出园时间
	@Excel(name = "出园时间",format="yyyy-MM-dd",isImportField="true")
	private Date outDate;
	//出园原因
	@Excel(name = "出园原因",isImportField="true")
	private String outReason;
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

	public IncubationParkCompany() {
		super();
	}

	public IncubationParkCompany(
		Integer id,
		String name,
		String mobile,
		String businessSubject,
		String legalPerson,
		Integer companyType,
		Integer rooms,
		String areas,
		String businessScope,
		Integer teamNumber,
		String projectIntroduction,
		String companyDesc,
		String evaluate,
		String development,
		String ecExamination,
		Integer companyStatus,
		Date inDate,
		Date outDate,
		String outReason,
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
		this.rooms = rooms;
		this.areas = areas;
		this.businessScope = businessScope;
		this.teamNumber = teamNumber;
		this.projectIntroduction = projectIntroduction;
		this.companyDesc = companyDesc;
		this.evaluate = evaluate;
		this.development = development;
		this.ecExamination = ecExamination;
		this.companyStatus = companyStatus;
		this.inDate = inDate;
		this.outDate = outDate;
		this.outReason = outReason;
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
		sb.append("\"rooms\":").append("\"").append(rooms).append("\"").append(",");
		sb.append("\"areas\":").append("\"").append(areas).append("\"").append(",");
		sb.append("\"businessScope\":").append("\"").append(businessScope).append("\"").append(",");
		sb.append("\"teamNumber\":").append("\"").append(teamNumber).append("\"").append(",");
		sb.append("\"projectIntroduction\":").append("\"").append(projectIntroduction).append("\"").append(",");
		sb.append("\"companyDesc\":").append("\"").append(companyDesc).append("\"").append(",");
		sb.append("\"evaluate\":").append("\"").append(evaluate).append("\"").append(",");
		sb.append("\"development\":").append("\"").append(development).append("\"").append(",");
		sb.append("\"ecExamination\":").append("\"").append(ecExamination).append("\"").append(",");
		sb.append("\"companyStatus\":").append("\"").append(companyStatus).append("\"").append(",");
		sb.append("\"inDate\":").append("\"").append(inDate).append("\"").append(",");
		sb.append("\"outDate\":").append("\"").append(outDate).append("\"").append(",");
		sb.append("\"outReason\":").append("\"").append(outReason).append("\"").append(",");
		sb.append("\"remark\":").append("\"").append(remark).append("\"").append(",");
		sb.append("\"createBy\":").append("\"").append(createBy).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
