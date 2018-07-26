package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 企业数据上报
 * 
 * @author zbk
 * @date 2017-05-12 17:10:43
 */
public class EnterpriseReportVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//企业代码
	private String enterpriseCode;
	//企业名称
	private String enterpriseName;
	 //企业名称
	 private Integer enterpriseType;
	//销售额
	private BigDecimal sales;
	//零售额
	private BigDecimal retailSales;
	//年度
	private Integer year;
	//月份
	private Integer month;
	//数据日期
	private Date createTime;
     
    //预测零售额
    private BigDecimal forecastRetailSales;
    
    //上年同期零售额
    private BigDecimal sntqRetailSales;
    
    private BigDecimal difference;
    
    //预报结果标志位
    private Integer flag;
    
	//个体零售额
	private BigDecimal gtRetailSales;
	
    //上年同期个体零售额
    private BigDecimal gtSntqRetailSales;

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
	
	public Integer getEnterpriseType() {
		return enterpriseType;
	}
	public void setEnterpriseType(Integer enterpriseType) {
		this.enterpriseType = enterpriseType;
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
	public BigDecimal getForecastRetailSales() {
		return forecastRetailSales;
	}
	public void setForecastRetailSales(BigDecimal forecastRetailSales) {
		this.forecastRetailSales = forecastRetailSales;
	}
	
	public BigDecimal getSntqRetailSales() {
		return sntqRetailSales;
	}
	public void setSntqRetailSales(BigDecimal sntqRetailSales) {
		this.sntqRetailSales = sntqRetailSales;
	}
	public BigDecimal getDifference() {
		return difference;
	}
	public void setDifference(BigDecimal difference) {
		this.difference = difference;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public BigDecimal getGtRetailSales() {
		return gtRetailSales;
	}
	public void setGtRetailSales(BigDecimal gtRetailSales) {
		this.gtRetailSales = gtRetailSales;
	}
	public BigDecimal getGtSntqRetailSales() {
		return gtSntqRetailSales;
	}
	public void setGtSntqRetailSales(BigDecimal gtSntqRetailSales) {
		this.gtSntqRetailSales = gtSntqRetailSales;
	}
	
	public EnterpriseReportVo() {
		super();
	}
	public EnterpriseReportVo(Integer id, String enterpriseCode, String enterpriseName, BigDecimal sales,
			BigDecimal retailSales, Integer year, Integer month, Date createTime, BigDecimal forecastRetailSales,
			Integer flag) {
		super();
		this.id = id;
		this.enterpriseCode = enterpriseCode;
		this.enterpriseName = enterpriseName;
		this.sales = sales;
		this.retailSales = retailSales;
		this.year = year;
		this.month = month;
		this.createTime = createTime;
		this.forecastRetailSales = forecastRetailSales;
		this.flag = flag;
	}
	public EnterpriseReportVo(EnterpriseReport report,BigDecimal forecastRetailSales,Integer flag) {
		super();
		this.id = report.getId();
		this.enterpriseCode = report.getEnterpriseCode();
		this.enterpriseName = report.getEnterpriseName();
		this.sales = report.getSales();
		this.retailSales = report.getRetailSales();
		this.year = report.getYear();
		this.month = report.getMonth();
		this.createTime = report.getCreateTime();
		this.forecastRetailSales = forecastRetailSales;
		this.flag = flag;
	}
	
}
