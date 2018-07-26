package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 服务业企业数据月报
 * 
 * @author zbk
 * @date 2017-06-07 11:55:52
 */
public class ServiceMonthlyReport implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//用户ID
	 @Excel(name = "用户ID",isImportField="true")
	private Integer userId;
	//企业名称
	 @Excel(name = "企业名称",isImportField="true")
	private String enterpriseName;
	//本年本月（千元）
	 @Excel(name = "本年本月（千元）",isImportField="true")
	private BigDecimal currMonth;
	//上年同期（千元）
	 @Excel(name = "上年同期（千元）",isImportField="true")
	private BigDecimal lastMonth;
	//本年1-本月（千元）
	 @Excel(name = "本年1-本月（千元）",isImportField="true")
	private BigDecimal currMonthAmount;
	//上年1-本月（千元）
	 @Excel(name = "上年1-本月（千元）",isImportField="true")
	private BigDecimal lastMonthAmount;
	//年度
	 @Excel(name = "年度",isImportField="true")
	private Integer year;
	//月份
	 @Excel(name = "月份",isImportField="true")
	private Integer month;
	//创建时间
     @Excel(name = "创建时间",format="yyyy-MM-dd",isImportField="true")
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
	 * 设置：用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUserId() {
		return userId;
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
	 * 设置：本年本月（千元）
	 */
	public void setCurrMonth(BigDecimal currMonth) {
		this.currMonth = currMonth;
	}
	/**
	 * 获取：本年本月（千元）
	 */
	public BigDecimal getCurrMonth() {
		return currMonth;
	}
	/**
	 * 设置：上年同期（千元）
	 */
	public void setLastMonth(BigDecimal lastMonth) {
		this.lastMonth = lastMonth;
	}
	/**
	 * 获取：上年同期（千元）
	 */
	public BigDecimal getLastMonth() {
		return lastMonth;
	}
	/**
	 * 设置：本年1-本月（千元）
	 */
	public void setCurrMonthAmount(BigDecimal currMonthAmount) {
		this.currMonthAmount = currMonthAmount;
	}
	/**
	 * 获取：本年1-本月（千元）
	 */
	public BigDecimal getCurrMonthAmount() {
		return currMonthAmount;
	}
	/**
	 * 设置：上年1-本月（千元）
	 */
	public void setLastMonthAmount(BigDecimal lastMonthAmount) {
		this.lastMonthAmount = lastMonthAmount;
	}
	/**
	 * 获取：上年1-本月（千元）
	 */
	public BigDecimal getLastMonthAmount() {
		return lastMonthAmount;
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
