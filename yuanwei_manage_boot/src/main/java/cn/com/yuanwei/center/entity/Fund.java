package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 项目资金信息
 * 
 * @author zbk
 * @date 2017-07-04 11:03:17
 */
public class Fund implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//部门ID
	private Integer departId;
	//部门名称
	@Excel(name = "部门名称",isImportField="true")
	private String departName;
	//资金名称
	@Excel(name = "资金名称",isImportField="true")
	private String fundName;
	//拨付时间
	@Excel(name = "拨付时间",format="yyyy-MM-dd",isImportField="true")
	private Date approDate;
	//应拨款金额
	@Excel(name = "应拨款金额(千元)",isImportField="true")
	private BigDecimal amount;
	//实际拨款金额
	@Excel(name = "实际拨款金额(千元)",isImportField="true")
	private BigDecimal realAmount;
	//未拨余额
	@Excel(name = "未拨余额(千元)",isImportField="true")
	private BigDecimal noAmount;
	//实际余额
	@Excel(name = "实际余额(千元)",isImportField="true")
	private BigDecimal surplusAmount;
	//凭证号
	@Excel(name = "凭证号",isImportField="true")
	private String voucherNo;
	//父级ID
	@Excel(name = "父级ID",isImportField="true")
	private Integer pid;
	//索引位
	@Excel(name = "索引位",isImportField="true")
	private String indexId;
	//上级文件
	@Excel(name = "上级文件",isImportField="true")
	private String superiorFile;
	//本级文件
	@Excel(name = "本级文件",isImportField="true")
	private String localFile;
	//备注
	@Excel(name = "备注",isImportField="true")
	private String remark;
	//是否有效
	@Excel(name = "是否有效",isImportField="true")
	private Integer isValid;
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

	public Fund() {
		super();
	}

	public Fund(
		Integer id,
		String fundName,
		Date approDate,
		BigDecimal amount,
		BigDecimal realAmount,
		BigDecimal noAmount,
		BigDecimal surplusAmount,
		String voucherNo,
		Integer pid,
		String indexId,
		String superiorFile,
		String localFile,
		String remark,
		Integer createBy,
		Date createTime) {
		super();
		this.id = id;
		this.fundName = fundName;
		this.approDate = approDate;
		this.amount = amount;
		this.realAmount = realAmount;
		this.noAmount = noAmount;
		this.surplusAmount = surplusAmount;
		this.voucherNo = voucherNo;
		this.pid = pid;
		this.indexId = indexId;
		this.superiorFile = superiorFile;
		this.localFile = localFile;
		this.remark = remark;
		this.createBy = createBy;
		this.createTime = createTime;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"fundName\":").append("\"").append(fundName).append("\"").append(",");
		sb.append("\"approDate\":").append("\"").append(approDate).append("\"").append(",");
		sb.append("\"amount\":").append("\"").append(amount).append("\"").append(",");
		sb.append("\"realAmount\":").append("\"").append(realAmount).append("\"").append(",");
		sb.append("\"noAmount\":").append("\"").append(noAmount).append("\"").append(",");
		sb.append("\"surplusAmount\":").append("\"").append(surplusAmount).append("\"").append(",");
		sb.append("\"voucherNo\":").append("\"").append(voucherNo).append("\"").append(",");
		sb.append("\"pid\":").append("\"").append(pid).append("\"").append(",");
		sb.append("\"indexId\":").append("\"").append(indexId).append("\"").append(",");
		sb.append("\"superiorFile\":").append("\"").append(superiorFile).append("\"").append(",");
		sb.append("\"localFile\":").append("\"").append(localFile).append("\"").append(",");
		sb.append("\"remark\":").append("\"").append(remark).append("\"").append(",");
		sb.append("\"createBy\":").append("\"").append(createBy).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
