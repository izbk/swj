package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 服务业企业数据预测
 * 
 * @author zbk
 * @email 
 * @date 2017-06-09 10:02:26
 */
@ApiModel
public class ServiceForecastReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//服务业定义ID
	@ApiModelProperty(value = "服务业定义ID",dataType="Integer")
	private Integer defineId;
	//年度
	@ApiModelProperty(value = "年度",dataType="Integer")
	private Integer year;
	//月份
	@ApiModelProperty(value = "月份",dataType="Integer")
	private Integer month;
	//本月金额
	@ApiModelProperty(value = "本月金额",dataType="BigDecimal")
	private BigDecimal currMonth;
	//1至本月累计金额
	@ApiModelProperty(value = "1至本月累计金额",dataType="BigDecimal")
	private BigDecimal currAmount;
	//1至本月增速
	@ApiModelProperty(value = "1至本月增速",dataType="BigDecimal")
	private BigDecimal currAmountRise;
	//上年同期金额
	@ApiModelProperty(value = "上年同期金额",dataType="BigDecimal")
	private BigDecimal lastMonth;
	//上年同期1至本月金额
	@ApiModelProperty(value = "上年同期1至本月金额",dataType="BigDecimal")
	private BigDecimal lastAmount;
	//上年同期1至本月增速
	@ApiModelProperty(value = "上年同期1至本月增速",dataType="BigDecimal")
	private BigDecimal lastAmountRise;
	//当前主要问题
	@ApiModelProperty(value = "当前主要问题",dataType="String")
	private String problem;
	//拟采取措施
	@ApiModelProperty(value = "拟采取措施",dataType="String")
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
}
