package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 项目资金拨付信息
 * 
 * @author zbk
 * @date 2017-07-04 11:03:17
 */
public class FundDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//所属年度
	@Excel(name = "所属年度",format="yyyy",isImportField="true")
	private Date year;
	//资金ID
	@Excel(name = "资金ID",isImportField="true")
	private Integer fundId;
	//资金名称
	@Excel(name = "资金名称",isImportField="true")
	private String fundName;
	//项目名称
	@Excel(name = "项目名称",isImportField="true")
	private String projectName;
	//拨款去向
	@Excel(name = "拨款去向",isImportField="true")
	private String enterpiseName;
	//拨付时间
	@Excel(name = "拨付时间",format="yyyy-MM-dd",isImportField="true")
	private Date approDate;
	//应拨款金额
	@Excel(name = "应拨款金额(千元)",isImportField="true")
	private BigDecimal approAmount;
	//实际拨款金额
	@Excel(name = "实际拨款金额(千元)",isImportField="true")
	private BigDecimal realApproAmount;
	//未拨余额
	@Excel(name = "未拨余额(千元)",isImportField="true")
	private BigDecimal surplusApproAmount;
	//项目验收时间
	@Excel(name = "项目验收时间",format="yyyy-MM-dd",isImportField="true")
	private Date acceptanceDate;
	//凭证号
	@Excel(name = "凭证号",isImportField="true")
	private String voucherNo;
	//备注
	@Excel(name = "备注",isImportField="true")
	private String remark;
	//创建人
	private Integer createBy;
	//创建人姓名
	@Excel(name = "创建人姓名",isImportField="true")
	private String createName;
	//创建时间
	private Date createTime;
	private Integer[] fundIds;
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
	public void setYear(Date year) {
		this.year = year;
	}
	/**
	 * 获取：所属年度
	 */
	public Date getYear() {
		return year;
	}
	/**
	 * 设置：资金ID
	 */
	public void setFundId(Integer fundId) {
		this.fundId = fundId;
	}
	/**
	 * 获取：资金ID
	 */
	public Integer getFundId() {
		return fundId;
	}
	/**
	 * 设置：资金名称
	 */
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	/**
	 * 获取：资金名称
	 */
	public String getFundName() {
		return fundName;
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
	 * 设置：拨款去向
	 */
	public void setEnterpiseName(String enterpiseName) {
		this.enterpiseName = enterpiseName;
	}
	/**
	 * 获取：拨款去向
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
	 * 设置：创建人姓名
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	/**
	 * 获取：创建人姓名
	 */
	public String getCreateName() {
		return createName;
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

	public Integer[] getFundIds() {
		return fundIds;
	}
	public void setFundIds(Integer[] fundIds) {
		this.fundIds = fundIds;
	}
	public FundDetail() {
		super();
	}

	public FundDetail(
		Integer id,
		Date year,
		Integer fundId,
		String fundName,
		String projectName,
		String enterpiseName,
		Date approDate,
		BigDecimal approAmount,
		BigDecimal realApproAmount,
		BigDecimal surplusApproAmount,
		Date acceptanceDate,
		String voucherNo,
		String remark,
		Integer createBy,
		String createName,
		Date createTime) {
		super();
		this.id = id;
		this.year = year;
		this.fundId = fundId;
		this.fundName = fundName;
		this.projectName = projectName;
		this.enterpiseName = enterpiseName;
		this.approDate = approDate;
		this.approAmount = approAmount;
		this.realApproAmount = realApproAmount;
		this.surplusApproAmount = surplusApproAmount;
		this.acceptanceDate = acceptanceDate;
		this.voucherNo = voucherNo;
		this.remark = remark;
		this.createBy = createBy;
		this.createName = createName;
		this.createTime = createTime;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"year\":").append("\"").append(year).append("\"").append(",");
		sb.append("\"fundId\":").append("\"").append(fundId).append("\"").append(",");
		sb.append("\"fundName\":").append("\"").append(fundName).append("\"").append(",");
		sb.append("\"projectName\":").append("\"").append(projectName).append("\"").append(",");
		sb.append("\"enterpiseName\":").append("\"").append(enterpiseName).append("\"").append(",");
		sb.append("\"approDate\":").append("\"").append(approDate).append("\"").append(",");
		sb.append("\"approAmount\":").append("\"").append(approAmount).append("\"").append(",");
		sb.append("\"realApproAmount\":").append("\"").append(realApproAmount).append("\"").append(",");
		sb.append("\"surplusApproAmount\":").append("\"").append(surplusApproAmount).append("\"").append(",");
		sb.append("\"acceptanceDate\":").append("\"").append(acceptanceDate).append("\"").append(",");
		sb.append("\"voucherNo\":").append("\"").append(voucherNo).append("\"").append(",");
		sb.append("\"remark\":").append("\"").append(remark).append("\"").append(",");
		sb.append("\"createBy\":").append("\"").append(createBy).append("\"").append(",");
		sb.append("\"createName\":").append("\"").append(createName).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
