package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;

/**
 * 企业进退库管理表
 * 
 * @author zbk
 * @date 2017-06-29 16:51:37
 */
public class EnterpriseManage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//企业编号
	@Excel(name = "企业编号",isImportField="true")
	private String enterpriseCode;
	//企业名称
	@Excel(name = "企业名称",isImportField="true")
	private String enterpriseName;
	//入库时间
	@Excel(name = "入库时间",format="yyyy-MM-dd",isImportField="true")
	private Date inDate;
	//出库事件
	@Excel(name = "出库时间",format="yyyy-MM-dd",isImportField="true")
	private Date outDate;
	//入库方式(0:年审入库)
	@Excel(name = "入库方式(0:年审入库)",replace={"年审入库_0"},isImportField="true")
	private Integer inWay;
	//出库方式（0: 正常出库 1:破产吊销）
	@Excel(name = "出库方式（0: 正常出库 1:破产吊销）",replace={"正常出库_0","破产吊销_1"},isImportField="true")
	private Integer outWay;
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
	 * 设置：企业编号
	 */
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	/**
	 * 获取：企业编号
	 */
	public String getEnterpriseCode() {
		return enterpriseCode;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：入库时间
	 */
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	/**
	 * 获取：入库时间
	 */
	public Date getInDate() {
		return inDate;
	}
	/**
	 * 设置：出库事件
	 */
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	/**
	 * 获取：出库事件
	 */
	public Date getOutDate() {
		return outDate;
	}
	/**
	 * 设置：入库方式(0:年审入库)
	 */
	public void setInWay(Integer inWay) {
		this.inWay = inWay;
	}
	/**
	 * 获取：入库方式(0:年审入库)
	 */
	public Integer getInWay() {
		return inWay;
	}
	/**
	 * 设置：出库方式（0: 正常出库 1:破产吊销）
	 */
	public void setOutWay(Integer outWay) {
		this.outWay = outWay;
	}
	/**
	 * 获取：出库方式（0: 正常出库 1:破产吊销）
	 */
	public Integer getOutWay() {
		return outWay;
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

	public EnterpriseManage() {
		super();
	}

	public EnterpriseManage(
		Integer id,
		String enterpriseCode,
		String enterpriseName,
		Date inDate,
		Date outDate,
		Integer inWay,
		Integer outWay,
		String remark,
		Integer createBy,
		Date createTime) {
		super();
		this.id = id;
		this.enterpriseCode = enterpriseCode;
		this.enterpriseName = enterpriseName;
		this.inDate = inDate;
		this.outDate = outDate;
		this.inWay = inWay;
		this.outWay = outWay;
		this.remark = remark;
		this.createBy = createBy;
		this.createTime = createTime;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"enterpriseCode\":").append("\"").append(enterpriseCode).append("\"").append(",");
		sb.append("\"enterpriseName\":").append("\"").append(enterpriseName).append("\"").append(",");
		sb.append("\"inDate\":").append("\"").append(inDate).append("\"").append(",");
		sb.append("\"outDate\":").append("\"").append(outDate).append("\"").append(",");
		sb.append("\"inWay\":").append("\"").append(inWay).append("\"").append(",");
		sb.append("\"outWay\":").append("\"").append(outWay).append("\"").append(",");
		sb.append("\"remark\":").append("\"").append(remark).append("\"").append(",");
		sb.append("\"createBy\":").append("\"").append(createBy).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
