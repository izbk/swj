package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 企业信息表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-07 14:35:42
 */
@ApiModel
public class CompanyReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//企业名称
	@ApiModelProperty(value = "企业名称",dataType="String")
	private String companyName;
	//企业类型
	@ApiModelProperty(value = "企业类型",dataType="Integer")
	private Integer enterpriseType;
	//行业类型
	@ApiModelProperty(value = "行业类型",dataType="Integer")
	private Integer industryType;
	//企业负责人
	@ApiModelProperty(value = "企业负责人",dataType="String")
	private String chargeName;
	//负责人电话
	@ApiModelProperty(value = "负责人电话",dataType="String")
	private String chargeMobile;
	//主营业务
	@ApiModelProperty(value = "主营业务",dataType="String")
	private String mianBusiness;
	//近三年营业额均值（千元）
	@ApiModelProperty(value = "近三年营业额均值（千元）",dataType="Integer")
	private Integer avgTurnover;
	//员工人数
	@ApiModelProperty(value = "员工人数",dataType="Integer")
	private Integer employees;
	//是否培育企业
	@ApiModelProperty(value = "是否培育企业",dataType="Integer")
	private Integer isSeed;
	//审核状态
	@ApiModelProperty(value = "审核状态",dataType="Integer")
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
}
