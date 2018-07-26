package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelEntity;

import java.math.BigDecimal;


/**
 * 服务业企业数据预测
 * 
 * @author zbk
 * @date 2017-06-09 10:02:26
 */
public class ServiceForecast implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//服务业定义ID
//	 @Excel(name = "服务业定义ID",isImportField="true")
	private Integer defineId;
	//导出增加
	 @ExcelEntity
	 private ServiceDefine serviceDefine;
	//年度
	 @Excel(name = "年度",isImportField="true")
	private Integer year;
	//月份
	 @Excel(name = "月份",isImportField="true")
	private Integer month;
	//本月金额
	 @Excel(name = "本月金额(千元)",isImportField="true")
	private BigDecimal currMonth;
	//1至本月累计金额
	 @Excel(name = "1至本月累计金额(千元)",isImportField="true")
	private BigDecimal currAmount;
	//1至本月增速
	 @Excel(name = "1至本月增速(%)",isImportField="true")
	private BigDecimal currAmountRise;
	//上年同期金额
	 @Excel(name = "上年同期金额(千元)",isImportField="true")
	private BigDecimal lastMonth;
	//上年同期1至本月金额
	 @Excel(name = "上年同期1至本月金额(千元)",isImportField="true")
	private BigDecimal lastAmount;
	//上年同期1至本月增速
	 @Excel(name = "上年同期1至本月增速(%)",isImportField="true")
	private BigDecimal lastAmountRise;
	//当前主要问题
	 @Excel(name = "当前主要问题",isImportField="true")
	private String problem;
	//拟采取措施
	 @Excel(name = "拟采取措施",isImportField="true")
	private String solution;

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
	 * 设置：服务业定义ID
	 */
	public void setDefineId(Integer defineId) {
		this.defineId = defineId;
	}
	/**
	 * 获取：服务业定义ID
	 */
	public Integer getDefineId() {
		return defineId;
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
	 * 设置：本月金额
	 */
	public void setCurrMonth(BigDecimal currMonth) {
		this.currMonth = currMonth;
	}
	/**
	 * 获取：本月金额
	 */
	public BigDecimal getCurrMonth() {
		return currMonth;
	}
	/**
	 * 设置：1至本月累计金额
	 */
	public void setCurrAmount(BigDecimal currAmount) {
		this.currAmount = currAmount;
	}
	/**
	 * 获取：1至本月累计金额
	 */
	public BigDecimal getCurrAmount() {
		return currAmount;
	}
	/**
	 * 设置：1至本月增速
	 */
	public void setCurrAmountRise(BigDecimal currAmountRise) {
		this.currAmountRise = currAmountRise;
	}
	/**
	 * 获取：1至本月增速
	 */
	public BigDecimal getCurrAmountRise() {
		return currAmountRise;
	}
	/**
	 * 设置：上年同期金额
	 */
	public void setLastMonth(BigDecimal lastMonth) {
		this.lastMonth = lastMonth;
	}
	/**
	 * 获取：上年同期金额
	 */
	public BigDecimal getLastMonth() {
		return lastMonth;
	}
	/**
	 * 设置：上年同期1至本月金额
	 */
	public void setLastAmount(BigDecimal lastAmount) {
		this.lastAmount = lastAmount;
	}
	/**
	 * 获取：上年同期1至本月金额
	 */
	public BigDecimal getLastAmount() {
		return lastAmount;
	}
	/**
	 * 设置：上年同期1至本月增速
	 */
	public void setLastAmountRise(BigDecimal lastAmountRise) {
		this.lastAmountRise = lastAmountRise;
	}
	/**
	 * 获取：上年同期1至本月增速
	 */
	public BigDecimal getLastAmountRise() {
		return lastAmountRise;
	}
	/**
	 * 设置：当前主要问题
	 */
	public void setProblem(String problem) {
		this.problem = problem;
	}
	/**
	 * 获取：当前主要问题
	 */
	public String getProblem() {
		return problem;
	}
	/**
	 * 设置：拟采取措施
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}
	/**
	 * 获取：拟采取措施
	 */
	public String getSolution() {
		return solution;
	}

	public ServiceDefine getServiceDefine() {
		return serviceDefine;
	}
	public void setServiceDefine(ServiceDefine serviceDefine) {
		this.serviceDefine = serviceDefine;
	}
	public ServiceForecast() {
		super();
	}
	public ServiceForecast(Integer defineId, Integer year, Integer month, BigDecimal currMonth, BigDecimal currAmount,
			BigDecimal lastMonth, BigDecimal lastAmount) {
		super();
		this.defineId = defineId;
		this.year = year;
		this.month = month;
		this.currMonth = currMonth;
		this.currAmount = currAmount;
		this.lastMonth = lastMonth;
		this.lastAmount = lastAmount;
	}
	
}
