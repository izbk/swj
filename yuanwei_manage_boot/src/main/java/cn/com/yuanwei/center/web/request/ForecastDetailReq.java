package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 企业预测结果表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-07 12:13:22
 */
@ApiModel
public class ForecastDetailReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//企业编码
	@ApiModelProperty(value = "企业编码",dataType="String")
	private String enterpriseCode;
	//企业名称
	@ApiModelProperty(value = "企业名称",dataType="String")
	private String enterpriseName;
	//上年同期零售额
	@ApiModelProperty(value = "上年同期零售额",dataType="BigDecimal")
	private BigDecimal sntqRetailSales;
	//同步增幅
	@ApiModelProperty(value = "同步增幅",dataType="BigDecimal")
	private BigDecimal compareRise;
	//本月零售额预测
	@ApiModelProperty(value = "本月零售额预测",dataType="BigDecimal")
	private BigDecimal currRetailSales;
	//企业类型（0;法人 1:个体）
	@ApiModelProperty(value = "企业类型（0;法人 1:个体）",dataType="Integer")
	private Integer enterpriseType;
	//入库类型(0:已入库 1: 新增入库)
	@ApiModelProperty(value = "入库类型(0:已入库 1: 新增入库)",dataType="Integer")
	private Integer inType;
	//年度
	@ApiModelProperty(value = "年度",dataType="Integer")
	private Integer year;
	//月份
	@ApiModelProperty(value = "月份",dataType="Integer")
	private Integer month;
	//创建日期
	@ApiModelProperty(value = "创建日期",dataType="Date")
	private Date createDate;

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
	 * 设置：企业编码
	 */
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	/**
	 * 获取：企业编码
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
	/**
	 * 设置：上年同期零售额
	 */
	public void setSntqRetailSales(BigDecimal sntqRetailSales) {
		this.sntqRetailSales = sntqRetailSales;
	}
	/**
	 * 获取：上年同期零售额
	 */
	public BigDecimal getSntqRetailSales() {
		return sntqRetailSales;
	}
	/**
	 * 设置：同步增幅
	 */
	public void setCompareRise(BigDecimal compareRise) {
		this.compareRise = compareRise;
	}
	/**
	 * 获取：同步增幅
	 */
	public BigDecimal getCompareRise() {
		return compareRise;
	}
	/**
	 * 设置：本月零售额预测
	 */
	public void setCurrRetailSales(BigDecimal currRetailSales) {
		this.currRetailSales = currRetailSales;
	}
	/**
	 * 获取：本月零售额预测
	 */
	public BigDecimal getCurrRetailSales() {
		return currRetailSales;
	}
	/**
	 * 设置：企业类型（0;法人 1:个体）
	 */
	public void setEnterpriseType(Integer enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	/**
	 * 获取：企业类型（0;法人 1:个体）
	 */
	public Integer getEnterpriseType() {
		return enterpriseType;
	}
	/**
	 * 设置：入库类型(0:已入库 1: 新增入库)
	 */
	public void setInType(Integer inType) {
		this.inType = inType;
	}
	/**
	 * 获取：入库类型(0:已入库 1: 新增入库)
	 */
	public Integer getInType() {
		return inType;
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
	 * 设置：创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
