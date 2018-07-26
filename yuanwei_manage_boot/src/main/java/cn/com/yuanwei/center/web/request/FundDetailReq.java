package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 项目资金拨付信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 11:03:17
 */
@ApiModel
public class FundDetailReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//所属年度
	@ApiModelProperty(value = "所属年度",dataType="Date")
	private Date year;
	//资金ID
	@ApiModelProperty(value = "资金ID",dataType="Integer")
	private Integer fundId;
	//资金名称
	@ApiModelProperty(value = "资金名称",dataType="String")
	private String fundName;
	//项目名称
	@ApiModelProperty(value = "项目名称",dataType="String")
	private String projectName;
	//拨款去向
	@ApiModelProperty(value = "拨款去向",dataType="String")
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
	//备注
	@ApiModelProperty(value = "备注",dataType="String")
	private String remark;
	//创建人
	@ApiModelProperty(value = "创建人",dataType="Integer")
	private Integer createBy;
	//创建人姓名
	@ApiModelProperty(value = "创建人姓名",dataType="String")
	private String createName;
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
	
}
