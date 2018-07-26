package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 企业预测结果表
 * 
 * @author zbk
 * @date 2017-06-29 14:57:07
 */
public class ForecastDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//企业编码
	@Excel(name = "企业编码",isImportField="true")
	private String enterpriseCode;
	//企业名称
	@Excel(name = "企业名称",isImportField="true")
	private String enterpriseName;
	//上年同期零售额
	@Excel(name = "上年同期零售额(千元)",isImportField="true")
	private BigDecimal sntqRetailSales;
	//同步增幅
	@Excel(name = "同步增幅(%)",isImportField="true")
	private BigDecimal compareRise;
	//本月零售额预测
	@Excel(name = "本月零售额预测(千元)",isImportField="true")
	private BigDecimal currRetailSales;
	//企业类型（0;法人 1:个体）
	@Excel(name = "企业类型（0;法人 1:个体）",replace={"法人_0","个体_1","工商未注册_2"},isImportField="true")
	private Integer enterpriseType;
	//入库类型(0:已入库 1: 新增入库)
	@Excel(name = "入库类型(0:已入库 1: 新增入库)",replace={"年审入库_0"},isImportField="true")
	private Integer inType;
	//年度
	@Excel(name = "年度",isImportField="true")
	private Integer year;
	//月份
	@Excel(name = "月份",isImportField="true")
	private Integer month;
	//创建日期
	@Excel(name = "创建日期",format="yyyy-MM-dd",isImportField="true")
	private Date createDate;
	
	private BigDecimal compareMonthRise;

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
	 * 设置：企业编码
	 */
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	/**
	 * 获取：企业编码
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
	 * 设置：上年同期零售额
	 */
	public void setSntqRetailSales(BigDecimal sntqRetailSales) {
		this.sntqRetailSales = sntqRetailSales;
	}
	/**
	 * 获取：上年同期零售额
	 */
	public BigDecimal getSntqRetailSales() {
		return sntqRetailSales;
	}
	/**
	 * 设置：同步增幅
	 */
	public void setCompareRise(BigDecimal compareRise) {
		this.compareRise = compareRise;
	}
	/**
	 * 获取：同步增幅
	 */
	public BigDecimal getCompareRise() {
		return compareRise;
	}
	/**
	 * 设置：本月零售额预测
	 */
	public void setCurrRetailSales(BigDecimal currRetailSales) {
		this.currRetailSales = currRetailSales;
	}
	/**
	 * 获取：本月零售额预测
	 */
	public BigDecimal getCurrRetailSales() {
		return currRetailSales;
	}
	/**
	 * 设置：企业类型（0;法人 1:个体）
	 */
	public void setEnterpriseType(Integer enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	/**
	 * 获取：企业类型（0;法人 1:个体）
	 */
	public Integer getEnterpriseType() {
		return enterpriseType;
	}
	/**
	 * 设置：入库类型(0:已入库 1: 新增入库)
	 */
	public void setInType(Integer inType) {
		this.inType = inType;
	}
	/**
	 * 获取：入库类型(0:已入库 1: 新增入库)
	 */
	public Integer getInType() {
		return inType;
	}
	/**
	 * 设置：年度
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：年度
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 设置：月份
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}
	/**
	 * 获取：月份
	 */
	public Integer getMonth() {
		return month;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}

	public BigDecimal getCompareMonthRise() {
		return compareMonthRise;
	}
	public void setCompareMonthRise(BigDecimal compareMonthRise) {
		this.compareMonthRise = compareMonthRise;
	}
	public ForecastDetail() {
		super();
	}
	public ForecastDetail(String enterpriseCode, String enterpriseName, BigDecimal sntqRetailSales,
			BigDecimal compareRise, BigDecimal currRetailSales, Integer enterpriseType, Integer inType, Integer year,
			Integer month, Date createDate) {
		super();
		this.enterpriseCode = enterpriseCode;
		this.enterpriseName = enterpriseName;
		this.sntqRetailSales = sntqRetailSales;
		this.compareRise = compareRise;
		this.currRetailSales = currRetailSales;
		this.enterpriseType = enterpriseType;
		this.inType = inType;
		this.year = year;
		this.month = month;
		this.createDate = createDate;
	}
	public ForecastDetail(
		Integer id,
		String enterpriseCode,
		String enterpriseName,
		BigDecimal sntqRetailSales,
		BigDecimal compareRise,
		BigDecimal currRetailSales,
		Integer enterpriseType,
		Integer inType,
		Integer year,
		Integer month,
		Date createDate) {
		super();
		this.id = id;
		this.enterpriseCode = enterpriseCode;
		this.enterpriseName = enterpriseName;
		this.sntqRetailSales = sntqRetailSales;
		this.compareRise = compareRise;
		this.currRetailSales = currRetailSales;
		this.enterpriseType = enterpriseType;
		this.inType = inType;
		this.year = year;
		this.month = month;
		this.createDate = createDate;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"enterpriseCode\":").append("\"").append(enterpriseCode).append("\"").append(",");
		sb.append("\"enterpriseName\":").append("\"").append(enterpriseName).append("\"").append(",");
		sb.append("\"sntqRetailSales\":").append("\"").append(sntqRetailSales).append("\"").append(",");
		sb.append("\"compareRise\":").append("\"").append(compareRise).append("\"").append(",");
		sb.append("\"currRetailSales\":").append("\"").append(currRetailSales).append("\"").append(",");
		sb.append("\"enterpriseType\":").append("\"").append(enterpriseType).append("\"").append(",");
		sb.append("\"inType\":").append("\"").append(inType).append("\"").append(",");
		sb.append("\"year\":").append("\"").append(year).append("\"").append(",");
		sb.append("\"month\":").append("\"").append(month).append("\"").append(",");
		sb.append("\"createDate\":").append("\"").append(createDate).append("\"").append("}");
        return sb.toString();
    }
}
