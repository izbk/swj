package cn.com.yuanwei.center.web.request;

import java.math.BigDecimal;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 项目资金信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 11:03:17
 */
@ApiModel
public class FundReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//部门ID
	@ApiModelProperty(value = "部门ID",dataType="Integer")
	private Integer departId;
	//部门名称
	@ApiModelProperty(value = "部门名称",dataType="String")
	private String departName;
	//资金名称
	@ApiModelProperty(value = "资金名称",dataType="String")
	private String fundName;
	//拨付时间
	@ApiModelProperty(value = "拨付时间",dataType="Date")
	private Date approDate;
	//应拨款金额
	@ApiModelProperty(value = "应拨款金额",dataType="BigDecimal")
	private BigDecimal amount;
	//实际拨款金额
	@ApiModelProperty(value = "实际拨款金额",dataType="BigDecimal")
	private BigDecimal realAmount;
	//未拨余额
	@ApiModelProperty(value = "未拨余额",dataType="BigDecimal")
	private BigDecimal noAmount;
	//实际余额
	@ApiModelProperty(value = "实际余额",dataType="BigDecimal")
	private BigDecimal surplusAmount;
	//凭证号
	@ApiModelProperty(value = "凭证号",dataType="String")
	private String voucherNo;
	//父级ID
	@ApiModelProperty(value = "父级ID",dataType="Integer")
	private Integer pid;
	//索引位
	@ApiModelProperty(value = "索引位",dataType="String")
	private String indexId;
	//上级文件
	@ApiModelProperty(value = "上级文件",dataType="String")
	private String superiorFile;
	//本级文件
	@ApiModelProperty(value = "本级文件",dataType="String")
	private String localFile;
	//备注
	@ApiModelProperty(value = "备注",dataType="String")
	private String remark;
	//是否有效
	@ApiModelProperty(value = "是否有效",dataType="Integer")
	private Integer isValid;
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
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
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
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：应拨款金额
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：实际拨款金额
	 */
	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}
	/**
	 * 获取：实际拨款金额
	 */
	public BigDecimal getRealAmount() {
		return realAmount;
	}
	/**
	 * 设置：未拨余额
	 */
	public void setNoAmount(BigDecimal noAmount) {
		this.noAmount = noAmount;
	}
	/**
	 * 获取：未拨余额
	 */
	public BigDecimal getNoAmount() {
		return noAmount;
	}
	/**
	 * 设置：实际余额
	 */
	public void setSurplusAmount(BigDecimal surplusAmount) {
		this.surplusAmount = surplusAmount;
	}
	/**
	 * 获取：实际余额
	 */
	public BigDecimal getSurplusAmount() {
		return surplusAmount;
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
	 * 设置：父级ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父级ID
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：索引位
	 */
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	/**
	 * 获取：索引位
	 */
	public String getIndexId() {
		return indexId;
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
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
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
