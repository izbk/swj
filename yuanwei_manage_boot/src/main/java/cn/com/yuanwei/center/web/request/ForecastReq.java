package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 总量预测结果表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-07 11:55:52
 */
@ApiModel
public class ForecastReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//年度
	@ApiModelProperty(value = "年度",dataType="Integer")
	private Integer year;
	//月份
	@ApiModelProperty(value = "月份",dataType="Integer")
	private Integer month;
	//新增限上同期数
	@ApiModelProperty(value = "新增限上同期数",dataType="BigDecimal")
	private BigDecimal lastAdd;
	//同期总量
	@ApiModelProperty(value = "同期总量",dataType="BigDecimal")
	private BigDecimal lastAmount;
	//本期限上增幅
	@ApiModelProperty(value = "本期限上增幅",dataType="BigDecimal")
	private BigDecimal currRise;
	//本期限下增幅
	@ApiModelProperty(value = "本期限下增幅",dataType="BigDecimal")
	private BigDecimal currUnderRise;
	//本月累计限上预测数
	@ApiModelProperty(value = "本月累计限上预测数",dataType="BigDecimal")
	private BigDecimal currMonthAmount;
	//本月限上预测数
	@ApiModelProperty(value = "本月限上预测数",dataType="BigDecimal")
	private BigDecimal currMonth;
	//本期总量增幅
	@ApiModelProperty(value = "本期总量增幅",dataType="BigDecimal")
	private BigDecimal currAmountRise;
	//本期累计总量
	@ApiModelProperty(value = "本期累计总量",dataType="BigDecimal")
	private BigDecimal currAmount;
	//同期限上占比
	@ApiModelProperty(value = "同期限上占比",dataType="BigDecimal")
	private BigDecimal lastRatio;
	//同期限下占比
	@ApiModelProperty(value = "同期限下占比",dataType="BigDecimal")
	private BigDecimal lastUnderRatio;
	//同期限上未调整
	@ApiModelProperty(value = "同期限上未调整",dataType="BigDecimal")
	private BigDecimal lastNoAdjust;
	//同期限上已调整
	@ApiModelProperty(value = "同期限上已调整",dataType="BigDecimal")
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
}
