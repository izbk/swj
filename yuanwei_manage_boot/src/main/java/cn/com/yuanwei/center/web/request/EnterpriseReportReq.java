package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 企业数据上报
 * 
 * @author zbk
 * @email 
 * @date 2017-05-12 21:01:40
 */
@ApiModel
public class EnterpriseReportReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//企业代码
	@ApiModelProperty(value = "企业代码",dataType="String")
	private String enterpriseCode;
	//企业名称
	@ApiModelProperty(value = "企业名称",dataType="String")
	private String enterpriseName;
	//企业类型
	@ApiModelProperty(value = "企业类型",dataType="Integer")
	private Integer enterpriseType;
	//销售额
	@ApiModelProperty(value = "销售额",dataType="BigDecimal")
	private BigDecimal sales;
	//零售额
	@ApiModelProperty(value = "零售额",dataType="BigDecimal")
	private BigDecimal retailSales;
	//年度
	@ApiModelProperty(value = "年度",dataType="Integer")
	private Integer year;
	//月份
	@ApiModelProperty(value = "月份",dataType="Integer")
	private Integer month;
	//数据日期
	@ApiModelProperty(value = "数据日期",dataType="Date")
	private Date createTime;
	//统计员ID
	@ApiModelProperty(value = "统计员ID",dataType="Integer")
	private Integer userId;
	//预测零售额
	@ApiModelProperty(value = "预测零售额",dataType="BigDecimal")
	private BigDecimal forcastRetailSales;
	//上报结果标示
	@ApiModelProperty(value = "上报结果标示",dataType="Integer")
	private Integer flag;

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
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 设置：预测零售额
	 */
	public void setForcastRetailSales(BigDecimal forcastRetailSales) {
		this.forcastRetailSales = forcastRetailSales;
	}
	/**
	 * 获取：预测零售额
	 */
	public BigDecimal getForcastRetailSales() {
		return forcastRetailSales;
	}
	/**
	 * 设置：上报结果标示
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：上报结果标示
	 */
	public Integer getFlag() {
		return flag;
	}
}
