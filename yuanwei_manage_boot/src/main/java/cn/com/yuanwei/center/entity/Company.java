package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;

/**
 * 企业信息表
 * 
 * @author zbk
 * @date 2017-06-29 16:51:38
 */
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//企业名称
	@Excel(name = "企业名称",isImportField="true")
	private String companyName;
	//企业类型
	@Excel(name = "企业类型",replace={"法人_0","个体_1","工商未注册_2"},isImportField="true")
	private Integer enterpriseType;
	//行业类型
	@Excel(name = "行业类型",replace={"批发_0","零售_1","农业服务_10","中介服务_11","金融服务_12","电子商务_13","运输物流_14","住宿_2","餐饮_3","文化_4","旅游_5","教育_6","医疗_7","健康养老_8","家政服务_9"},isImportField="true")
	private Integer industryType;
	//企业负责人
	@Excel(name = "企业负责人",isImportField="true")
	private String chargeName;
	//负责人电话
	@Excel(name = "负责人电话",isImportField="true")
	private String chargeMobile;
	//主营业务
	@Excel(name = "主营业务",isImportField="true")
	private String mianBusiness;
	//近三年营业额均值（千元）
	@Excel(name = "近三年营业额均值（千元）",isImportField="true")
	private Integer avgTurnover;
	//员工人数
	@Excel(name = "员工人数",isImportField="true")
	private Integer employees;
	//是否培育企业
	@Excel(name = "是否培育企业",replace={"否_0","是_1"},isImportField="true")
	private Integer isSeed;
	//审核状态
	@Excel(name = "审核状态",replace={"未审核_0","已审核_1","审核不通过_2"},isImportField="true")
	private Integer status;
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
	//创建时间
	private Date createTime;
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
	 * 设置：企业名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：企业类型
	 */
	public void setEnterpriseType(Integer enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	/**
	 * 获取：企业类型
	 */
	public Integer getEnterpriseType() {
		return enterpriseType;
	}
	/**
	 * 设置：行业类型
	 */
	public void setIndustryType(Integer industryType) {
		this.industryType = industryType;
	}
	/**
	 * 获取：行业类型
	 */
	public Integer getIndustryType() {
		return industryType;
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
	 * 设置：主营业务
	 */
	public void setMianBusiness(String mianBusiness) {
		this.mianBusiness = mianBusiness;
	}
	/**
	 * 获取：主营业务
	 */
	public String getMianBusiness() {
		return mianBusiness;
	}
	/**
	 * 设置：近三年营业额均值（千元）
	 */
	public void setAvgTurnover(Integer avgTurnover) {
		this.avgTurnover = avgTurnover;
	}
	/**
	 * 获取：近三年营业额均值（千元）
	 */
	public Integer getAvgTurnover() {
		return avgTurnover;
	}
	/**
	 * 设置：员工人数
	 */
	public void setEmployees(Integer employees) {
		this.employees = employees;
	}
	/**
	 * 获取：员工人数
	 */
	public Integer getEmployees() {
		return employees;
	}
	/**
	 * 设置：是否培育企业
	 */
	public void setIsSeed(Integer isSeed) {
		this.isSeed = isSeed;
	}
	/**
	 * 获取：是否培育企业
	 */
	public Integer getIsSeed() {
		return isSeed;
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
	public Company() {
		super();
	}

	public Company(
		Integer id,
		String companyName,
		Integer enterpriseType,
		Integer industryType,
		String chargeName,
		String chargeMobile,
		String mianBusiness,
		Integer avgTurnover,
		Integer employees,
		Integer isSeed,
		Integer status,
		Integer audit1By,
		Date audit1Time,
		Integer audit2By,
		Date audit2Time,
		Integer audit3By,
		Date audit3Time,
		Date createTime) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.enterpriseType = enterpriseType;
		this.industryType = industryType;
		this.chargeName = chargeName;
		this.chargeMobile = chargeMobile;
		this.mianBusiness = mianBusiness;
		this.avgTurnover = avgTurnover;
		this.employees = employees;
		this.isSeed = isSeed;
		this.status = status;
		this.audit1By = audit1By;
		this.audit1Time = audit1Time;
		this.audit2By = audit2By;
		this.audit2Time = audit2Time;
		this.audit3By = audit3By;
		this.audit3Time = audit3Time;
		this.createTime = createTime;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"companyName\":").append("\"").append(companyName).append("\"").append(",");
		sb.append("\"enterpriseType\":").append("\"").append(enterpriseType).append("\"").append(",");
		sb.append("\"industryType\":").append("\"").append(industryType).append("\"").append(",");
		sb.append("\"chargeName\":").append("\"").append(chargeName).append("\"").append(",");
		sb.append("\"chargeMobile\":").append("\"").append(chargeMobile).append("\"").append(",");
		sb.append("\"mianBusiness\":").append("\"").append(mianBusiness).append("\"").append(",");
		sb.append("\"avgTurnover\":").append("\"").append(avgTurnover).append("\"").append(",");
		sb.append("\"employees\":").append("\"").append(employees).append("\"").append(",");
		sb.append("\"isSeed\":").append("\"").append(isSeed).append("\"").append(",");
		sb.append("\"status\":").append("\"").append(status).append("\"").append(",");
		sb.append("\"audit1By\":").append("\"").append(audit1By).append("\"").append(",");
		sb.append("\"audit1Time\":").append("\"").append(audit1Time).append("\"").append(",");
		sb.append("\"audit2By\":").append("\"").append(audit2By).append("\"").append(",");
		sb.append("\"audit2Time\":").append("\"").append(audit2Time).append("\"").append(",");
		sb.append("\"audit3By\":").append("\"").append(audit3By).append("\"").append(",");
		sb.append("\"audit3Time\":").append("\"").append(audit3Time).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
