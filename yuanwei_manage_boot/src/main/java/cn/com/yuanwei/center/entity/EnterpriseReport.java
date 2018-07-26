package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 企业数据上报
 * 
 * @author zbk
 * @date 2017-06-29 16:51:38
 */
public class EnterpriseReport implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//企业代码
	@Excel(name = "企业代码",isImportField="true")
	private String enterpriseCode;
	//企业名称
	@Excel(name = "企业名称",isImportField="true")
	private String enterpriseName;
	//企业类型
	@Excel(name = "企业类型",replace={"法人_0","个体_1","工商未注册_2"},isImportField="true")
	private Integer enterpriseType;
	//销售额
	@Excel(name = "销售额(千元)",isImportField="true")
	private BigDecimal sales;
	//零售额
	@Excel(name = "零售额(千元)",isImportField="true")
	private BigDecimal retailSales;
	//年度
	@Excel(name = "年度",isImportField="true")
	private Integer year;
	//月份
	@Excel(name = "月份",isImportField="true")
	private Integer month;
	//数据日期
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
	 * 设置：企业代码
	 */
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	/**
	 * 获取：企业代码
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
	 * 设置：销售额
	 */
	public void setSales(BigDecimal sales) {
		this.sales = sales;
	}
	/**
	 * 获取：销售额
	 */
	public BigDecimal getSales() {
		return sales;
	}
	/**
	 * 设置：零售额
	 */
	public void setRetailSales(BigDecimal retailSales) {
		this.retailSales = retailSales;
	}
	/**
	 * 获取：零售额
	 */
	public BigDecimal getRetailSales() {
		return retailSales;
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
	 * 设置：数据日期
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：数据日期
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public EnterpriseReport() {
		super();
	}

	public EnterpriseReport(
		Integer id,
		String enterpriseCode,
		String enterpriseName,
		Integer enterpriseType,
		BigDecimal sales,
		BigDecimal retailSales,
		Integer year,
		Integer month,
		Date createTime) {
		super();
		this.id = id;
		this.enterpriseCode = enterpriseCode;
		this.enterpriseName = enterpriseName;
		this.enterpriseType = enterpriseType;
		this.sales = sales;
		this.retailSales = retailSales;
		this.year = year;
		this.month = month;
		this.createTime = createTime;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"enterpriseCode\":").append("\"").append(enterpriseCode).append("\"").append(",");
		sb.append("\"enterpriseName\":").append("\"").append(enterpriseName).append("\"").append(",");
		sb.append("\"enterpriseType\":").append("\"").append(enterpriseType).append("\"").append(",");
		sb.append("\"sales\":").append("\"").append(sales).append("\"").append(",");
		sb.append("\"retailSales\":").append("\"").append(retailSales).append("\"").append(",");
		sb.append("\"year\":").append("\"").append(year).append("\"").append(",");
		sb.append("\"month\":").append("\"").append(month).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
