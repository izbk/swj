package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 服务业企业数据月报
 * 
 * @author zbk
 * @email 
 * @date 2017-06-07 11:55:52
 */
@ApiModel
public class ServiceMonthlyReportReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//用户ID
	@ApiModelProperty(value = "用户ID",dataType="Integer")
	private Integer userId;
	//企业名称
	@ApiModelProperty(value = "企业名称",dataType="String")
	private String enterpriseName;
	//本年本月（万元）
	@ApiModelProperty(value = "本年本月（万元）",dataType="BigDecimal")
	private BigDecimal currMonth;
	//上年同期（万元）
	@ApiModelProperty(value = "上年同期（万元）",dataType="BigDecimal")
	private BigDecimal lastMonth;
	//本年1-本月（万元）
	@ApiModelProperty(value = "本年1-本月（万元）",dataType="BigDecimal")
	private BigDecimal currMonthAmount;
	//上年1-本月（万元）
	@ApiModelProperty(value = "上年1-本月（万元）",dataType="BigDecimal")
	private BigDecimal lastMonthAmount;
	//年度
	@ApiModelProperty(value = "年度",dataType="Integer")
	private Integer year;
	//月份
	@ApiModelProperty(value = "月份",dataType="Integer")
	private Integer month;
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
	 * 设置：本年本月（万元）
	 */
	public void setCurrMonth(BigDecimal currMonth) {
		this.currMonth = currMonth;
	}
	/**
	 * 获取：本年本月（万元）
	 */
	public BigDecimal getCurrMonth() {
		return currMonth;
	}
	/**
	 * 设置：上年同期（万元）
	 */
	public void setLastMonth(BigDecimal lastMonth) {
		this.lastMonth = lastMonth;
	}
	/**
	 * 获取：上年同期（万元）
	 */
	public BigDecimal getLastMonth() {
		return lastMonth;
	}
	/**
	 * 设置：本年1-本月（万元）
	 */
	public void setCurrMonthAmount(BigDecimal currMonthAmount) {
		this.currMonthAmount = currMonthAmount;
	}
	/**
	 * 获取：本年1-本月（万元）
	 */
	public BigDecimal getCurrMonthAmount() {
		return currMonthAmount;
	}
	/**
	 * 设置：上年1-本月（万元）
	 */
	public void setLastMonthAmount(BigDecimal lastMonthAmount) {
		this.lastMonthAmount = lastMonthAmount;
	}
	/**
	 * 获取：上年1-本月（万元）
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
