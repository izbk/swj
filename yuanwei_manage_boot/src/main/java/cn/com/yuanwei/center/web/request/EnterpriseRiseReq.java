package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 企业预测增幅设置
 * 
 * @author zbk
 * @email 
 * @date 2017-05-12 17:10:44
 */
@ApiModel
public class EnterpriseRiseReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//法人同比增幅限额
	@ApiModelProperty(value = "法人同比增幅限额",dataType="BigDecimal")
	private BigDecimal enterCompareRise;
	//法人增幅浮动范围
	@ApiModelProperty(value = "法人增幅浮动范围",dataType="BigDecimal")
	private BigDecimal enterRandomRise;
	//个体同比增幅限额
	@ApiModelProperty(value = "个体同比增幅限额",dataType="BigDecimal")
	private BigDecimal personCompareRise;
	//个人增幅浮动范围
	@ApiModelProperty(value = "个人增幅浮动范围",dataType="BigDecimal")
	private BigDecimal personRandomRise;
	//数据上报误差
	@ApiModelProperty(value = "数据上报误差",dataType="BigDecimal")
	private BigDecimal reportDifference;
	@ApiModelProperty(value = "预测明细合计误差",dataType="BigDecimal")
	private BigDecimal forecastDifference;
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
	 * 设置：法人同比增幅限额
	 */
	public void setEnterCompareRise(BigDecimal enterCompareRise) {
		this.enterCompareRise = enterCompareRise;
	}
	/**
	 * 获取：法人同比增幅限额
	 */
	public BigDecimal getEnterCompareRise() {
		return enterCompareRise;
	}
	/**
	 * 设置：法人增幅浮动范围
	 */
	public void setEnterRandomRise(BigDecimal enterRandomRise) {
		this.enterRandomRise = enterRandomRise;
	}
	/**
	 * 获取：法人增幅浮动范围
	 */
	public BigDecimal getEnterRandomRise() {
		return enterRandomRise;
	}
	/**
	 * 设置：个体同比增幅限额
	 */
	public void setPersonCompareRise(BigDecimal personCompareRise) {
		this.personCompareRise = personCompareRise;
	}
	/**
	 * 获取：个体同比增幅限额
	 */
	public BigDecimal getPersonCompareRise() {
		return personCompareRise;
	}
	/**
	 * 设置：个人增幅浮动范围
	 */
	public void setPersonRandomRise(BigDecimal personRandomRise) {
		this.personRandomRise = personRandomRise;
	}
	/**
	 * 获取：个人增幅浮动范围
	 */
	public BigDecimal getPersonRandomRise() {
		return personRandomRise;
	}
	/**
	 * 设置：数据上报误差
	 */
	public void setReportDifference(BigDecimal reportDifference) {
		this.reportDifference = reportDifference;
	}
	/**
	 * 获取：数据上报误差
	 */
	public BigDecimal getReportDifference() {
		return reportDifference;
	}
	public BigDecimal getForecastDifference() {
		return forecastDifference;
	}
	public void setForecastDifference(BigDecimal forecastDifference) {
		this.forecastDifference = forecastDifference;
	}
}
