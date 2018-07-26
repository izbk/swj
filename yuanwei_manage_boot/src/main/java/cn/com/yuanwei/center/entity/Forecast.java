package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.math.BigDecimal;

/**
 * 总量预测结果表
 * 
 * @author zbk
 * @date 2017-06-29 14:57:07
 */
public class Forecast implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//年度
	@Excel(name = "年度",isImportField="true")
	private Integer year;
	//月份
	@Excel(name = "月份",isImportField="true")
	private Integer month;
	//新增限上同期数
	@Excel(name = "新增限上同期数(千元)",isImportField="true")
	private BigDecimal lastAdd;
	//同期总量
	@Excel(name = "同期总量(千元)",isImportField="true")
	private BigDecimal lastAmount;
	//本期限上增幅
	@Excel(name = "本期限上增幅(%)",isImportField="true")
	private BigDecimal currRise;
	//本期限下增幅
	@Excel(name = "本期限下增幅(%)",isImportField="true")
	private BigDecimal currUnderRise;
	//本月累计限上预测数
	@Excel(name = "本月累计限上预测数(千元)",isImportField="true")
	private BigDecimal currMonthAmount;
	//本月限上预测数
	@Excel(name = "本月限上预测数(千元)",isImportField="true")
	private BigDecimal currMonth;
	//本期总量增幅
	@Excel(name = "本期总量增幅(%)",isImportField="true")
	private BigDecimal currAmountRise;
	//本期累计总量
	@Excel(name = "本期累计总量(千元)",isImportField="true")
	private BigDecimal currAmount;
	//同期限上占比
	@Excel(name = "同期限上占比(%)",isImportField="true")
	private BigDecimal lastRatio;
	//同期限下占比
	@Excel(name = "同期限下占比(%)",isImportField="true")
	private BigDecimal lastUnderRatio;
	//同期限上未调整
	@Excel(name = "同期限上未调整(千元)",isImportField="true")
	private BigDecimal lastNoAdjust;
	//同期限上已调整
	@Excel(name = "同期限上已调整(千元)",isImportField="true")
	private BigDecimal lastAdjusted;

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
	 * 设置：新增限上同期数
	 */
	public void setLastAdd(BigDecimal lastAdd) {
		this.lastAdd = lastAdd;
	}
	/**
	 * 获取：新增限上同期数
	 */
	public BigDecimal getLastAdd() {
		return lastAdd;
	}
	/**
	 * 设置：同期总量
	 */
	public void setLastAmount(BigDecimal lastAmount) {
		this.lastAmount = lastAmount;
	}
	/**
	 * 获取：同期总量
	 */
	public BigDecimal getLastAmount() {
		return lastAmount;
	}
	/**
	 * 设置：本期限上增幅
	 */
	public void setCurrRise(BigDecimal currRise) {
		this.currRise = currRise;
	}
	/**
	 * 获取：本期限上增幅
	 */
	public BigDecimal getCurrRise() {
		return currRise;
	}
	/**
	 * 设置：本期限下增幅
	 */
	public void setCurrUnderRise(BigDecimal currUnderRise) {
		this.currUnderRise = currUnderRise;
	}
	/**
	 * 获取：本期限下增幅
	 */
	public BigDecimal getCurrUnderRise() {
		return currUnderRise;
	}
	/**
	 * 设置：本月累计限上预测数
	 */
	public void setCurrMonthAmount(BigDecimal currMonthAmount) {
		this.currMonthAmount = currMonthAmount;
	}
	/**
	 * 获取：本月累计限上预测数
	 */
	public BigDecimal getCurrMonthAmount() {
		return currMonthAmount;
	}
	/**
	 * 设置：本月限上预测数
	 */
	public void setCurrMonth(BigDecimal currMonth) {
		this.currMonth = currMonth;
	}
	/**
	 * 获取：本月限上预测数
	 */
	public BigDecimal getCurrMonth() {
		return currMonth;
	}
	/**
	 * 设置：本期总量增幅
	 */
	public void setCurrAmountRise(BigDecimal currAmountRise) {
		this.currAmountRise = currAmountRise;
	}
	/**
	 * 获取：本期总量增幅
	 */
	public BigDecimal getCurrAmountRise() {
		return currAmountRise;
	}
	/**
	 * 设置：本期累计总量
	 */
	public void setCurrAmount(BigDecimal currAmount) {
		this.currAmount = currAmount;
	}
	/**
	 * 获取：本期累计总量
	 */
	public BigDecimal getCurrAmount() {
		return currAmount;
	}
	/**
	 * 设置：同期限上占比
	 */
	public void setLastRatio(BigDecimal lastRatio) {
		this.lastRatio = lastRatio;
	}
	/**
	 * 获取：同期限上占比
	 */
	public BigDecimal getLastRatio() {
		return lastRatio;
	}
	/**
	 * 设置：同期限下占比
	 */
	public void setLastUnderRatio(BigDecimal lastUnderRatio) {
		this.lastUnderRatio = lastUnderRatio;
	}
	/**
	 * 获取：同期限下占比
	 */
	public BigDecimal getLastUnderRatio() {
		return lastUnderRatio;
	}
	/**
	 * 设置：同期限上未调整
	 */
	public void setLastNoAdjust(BigDecimal lastNoAdjust) {
		this.lastNoAdjust = lastNoAdjust;
	}
	/**
	 * 获取：同期限上未调整
	 */
	public BigDecimal getLastNoAdjust() {
		return lastNoAdjust;
	}
	/**
	 * 设置：同期限上已调整
	 */
	public void setLastAdjusted(BigDecimal lastAdjusted) {
		this.lastAdjusted = lastAdjusted;
	}
	/**
	 * 获取：同期限上已调整
	 */
	public BigDecimal getLastAdjusted() {
		return lastAdjusted;
	}

	public Forecast() {
		super();
	}
	public Forecast(Integer year, Integer month, BigDecimal lastAdd, BigDecimal lastAmount, BigDecimal currRise,
			BigDecimal currUnderRise, BigDecimal currMonthAmount, BigDecimal currMonth, BigDecimal currAmountRise,
			BigDecimal currAmount, BigDecimal lastRatio, BigDecimal lastUnderRatio, BigDecimal lastNoAdjust,
			BigDecimal lastAdjusted) {
		super();
		this.year = year;
		this.month = month;
		this.lastAdd = lastAdd;
		this.lastAmount = lastAmount;
		this.currRise = currRise;
		this.currUnderRise = currUnderRise;
		this.currMonthAmount = currMonthAmount;
		this.currMonth = currMonth;
		this.currAmountRise = currAmountRise;
		this.currAmount = currAmount;
		this.lastRatio = lastRatio;
		this.lastUnderRatio = lastUnderRatio;
		this.lastNoAdjust = lastNoAdjust;
		this.lastAdjusted = lastAdjusted;
	}
	public Forecast(
		Integer id,
		Integer year,
		Integer month,
		BigDecimal lastAdd,
		BigDecimal lastAmount,
		BigDecimal currRise,
		BigDecimal currUnderRise,
		BigDecimal currMonthAmount,
		BigDecimal currMonth,
		BigDecimal currAmountRise,
		BigDecimal currAmount,
		BigDecimal lastRatio,
		BigDecimal lastUnderRatio,
		BigDecimal lastNoAdjust,
		BigDecimal lastAdjusted) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.lastAdd = lastAdd;
		this.lastAmount = lastAmount;
		this.currRise = currRise;
		this.currUnderRise = currUnderRise;
		this.currMonthAmount = currMonthAmount;
		this.currMonth = currMonth;
		this.currAmountRise = currAmountRise;
		this.currAmount = currAmount;
		this.lastRatio = lastRatio;
		this.lastUnderRatio = lastUnderRatio;
		this.lastNoAdjust = lastNoAdjust;
		this.lastAdjusted = lastAdjusted;
	}

	@Override
    public String toString() {
StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"year\":").append("\"").append(year).append("\"").append(",");
		sb.append("\"month\":").append("\"").append(month).append("\"").append(",");
		sb.append("\"lastAdd\":").append("\"").append(lastAdd).append("\"").append(",");
		sb.append("\"lastAmount\":").append("\"").append(lastAmount).append("\"").append(",");
		sb.append("\"currRise\":").append("\"").append(currRise).append("\"").append(",");
		sb.append("\"currUnderRise\":").append("\"").append(currUnderRise).append("\"").append(",");
		sb.append("\"currMonthAmount\":").append("\"").append(currMonthAmount).append("\"").append(",");
		sb.append("\"currMonth\":").append("\"").append(currMonth).append("\"").append(",");
		sb.append("\"currAmountRise\":").append("\"").append(currAmountRise).append("\"").append(",");
		sb.append("\"currAmount\":").append("\"").append(currAmount).append("\"").append(",");
		sb.append("\"lastRatio\":").append("\"").append(lastRatio).append("\"").append(",");
		sb.append("\"lastUnderRatio\":").append("\"").append(lastUnderRatio).append("\"").append(",");
		sb.append("\"lastNoAdjust\":").append("\"").append(lastNoAdjust).append("\"").append(",");
		sb.append("\"lastAdjusted\":").append("\"").append(lastAdjusted).append("\"").append("}");
        return sb.toString();
    }
}
