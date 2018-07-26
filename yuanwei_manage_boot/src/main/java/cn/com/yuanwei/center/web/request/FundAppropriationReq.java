package cn.com.yuanwei.center.web.request;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 项目资金拨付记录表
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:28:05
 */
@ApiModel
public class FundAppropriationReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//所属年度
	@ApiModelProperty(value = "所属年度",dataType="Integer")
	private Integer year;
	//项目ID
	@ApiModelProperty(value = "项目ID",dataType="Integer")
	private Integer projectId;
	//拨付项目类别
	@ApiModelProperty(value = "拨付项目类别",dataType="Integer")
	private Integer approType;
	//项目名称
	@ApiModelProperty(value = "项目名称",dataType="String")
	private String projectName;
	//企业编号
	@ApiModelProperty(value = "企业编号",dataType="String")
	private String enterpiseCode;
	//企业名称
	@ApiModelProperty(value = "企业名称",dataType="String")
	private String enterpiseName;
	//拨付时间
	@ApiModelProperty(value = "拨付时间",dataType="Date")
	private Date approDate;
	//应拨款金额
	@ApiModelProperty(value = "应拨款金额",dataType="BigDecimal")
	private BigDecimal approAmount;
	//实际拨款金额
	@ApiModelProperty(value = "实际拨款金额",dataType="BigDecimal")
	private BigDecimal realApproAmount;
	//未拨余额
	@ApiModelProperty(value = "未拨余额",dataType="BigDecimal")
	private BigDecimal surplusApproAmount;
	//项目验收时间
	@ApiModelProperty(value = "项目验收时间",dataType="Date")
	private Date acceptanceDate;
	//凭证号
	@ApiModelProperty(value = "凭证号",dataType="String")
	private String voucherNo;
	//上级文件
	@ApiModelProperty(value = "上级文件",dataType="String")
	private String superiorFile;
	//本级文件
	@ApiModelProperty(value = "本级文件",dataType="String")
	private String localFile;
	//备注
	@ApiModelProperty(value = "备注",dataType="String")
	private String remark;

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
	 * 设置：所属年度
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：所属年度
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 设置：项目ID
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：项目ID
	 */
	public Integer getProjectId() {
		return projectId;
	}
	/**
	 * 设置：拨付项目类别
	 */
	public void setApproType(Integer approType) {
		this.approType = approType;
	}
	/**
	 * 获取：拨付项目类别
	 */
	public Integer getApproType() {
		return approType;
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
	 * 设置：企业编号
	 */
	public void setEnterpiseCode(String enterpiseCode) {
		this.enterpiseCode = enterpiseCode;
	}
	/**
	 * 获取：企业编号
	 */
	public String getEnterpiseCode() {
		return enterpiseCode;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEnterpiseName(String enterpiseName) {
		this.enterpiseName = enterpiseName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEnterpiseName() {
		return enterpiseName;
	}
	/**
	 * 设置：拨付时间
	 */
	public void setApproDate(Date approDate) {
		this.approDate = approDate;
	}
	/**
	 * 获取：拨付时间
	 */
	public Date getApproDate() {
		return approDate;
	}
	/**
	 * 设置：应拨款金额
	 */
	public void setApproAmount(BigDecimal approAmount) {
		this.approAmount = approAmount;
	}
	/**
	 * 获取：应拨款金额
	 */
	public BigDecimal getApproAmount() {
		return approAmount;
	}
	/**
	 * 设置：实际拨款金额
	 */
	public void setRealApproAmount(BigDecimal realApproAmount) {
		this.realApproAmount = realApproAmount;
	}
	/**
	 * 获取：实际拨款金额
	 */
	public BigDecimal getRealApproAmount() {
		return realApproAmount;
	}
	/**
	 * 设置：未拨余额
	 */
	public void setSurplusApproAmount(BigDecimal surplusApproAmount) {
		this.surplusApproAmount = surplusApproAmount;
	}
	/**
	 * 获取：未拨余额
	 */
	public BigDecimal getSurplusApproAmount() {
		return surplusApproAmount;
	}
	/**
	 * 设置：项目验收时间
	 */
	public void setAcceptanceDate(Date acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}
	/**
	 * 获取：项目验收时间
	 */
	public Date getAcceptanceDate() {
		return acceptanceDate;
	}
	/**
	 * 设置：凭证号
	 */
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	/**
	 * 获取：凭证号
	 */
	public String getVoucherNo() {
		return voucherNo;
	}
	/**
	 * 设置：上级文件
	 */
	public void setSuperiorFile(String superiorFile) {
		this.superiorFile = superiorFile;
	}
	/**
	 * 获取：上级文件
	 */
	public String getSuperiorFile() {
		return superiorFile;
	}
	/**
	 * 设置：本级文件
	 */
	public void setLocalFile(String localFile) {
		this.localFile = localFile;
	}
	/**
	 * 获取：本级文件
	 */
	public String getLocalFile() {
		return localFile;
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
}
