package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 项目资金信息
 * 
 * @author zbk
 * @date 2017-07-04 11:03:17
 */
public class FundResp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//资金名称
	private String fundName;
	//部门ID
	private Integer departId;
	//部门名称
	private String departName;
	//拨付时间
	private Date approDate;
	//应拨款金额
	private BigDecimal amount;
	//实际拨款金额
	private BigDecimal realAmount;
	//未拨余额
	private BigDecimal noAmount;
	//实际余额
	private BigDecimal surplusAmount;
	//凭证号
	private String voucherNo;
	//父级ID
	private Integer pid;
	//索引位
	private String indexId;
	//上级文件
	private String superiorFile;
	//本级文件
	private String localFile;
	//备注
	private String remark;
	private Integer isValid;
	//创建人
	private Integer createBy;
	//创建时间
	private Date createTime;
	//子类列表
	private List<FundResp> children;

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
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
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
	public List<FundResp> getChildren() {
		return children;
	}
	public void setChildren(List<FundResp> children) {
		this.children = children;
	}

}
