package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 总量数据表
 * 
 * @author zbk
 * @date 2017-06-01 15:17:00
 */
public class TotalReport implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//销售总额
	 @Excel(name = "销售总额(千元)",isImportField="true")
	private BigDecimal totalSales;
	//年度
	 @Excel(name = "年度",isImportField="true")
	private Integer year;
	//月份
	 @Excel(name = "月份",isImportField="true")
	private Integer month;
	//数据日期
     @Excel(name = "数据日期",format="yyyy-MM-dd",isImportField="true")
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
	 * 设置：销售总额
	 */
	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}
	/**
	 * 获取：销售总额
	 */
	public BigDecimal getTotalSales() {
		return totalSales;
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
}
