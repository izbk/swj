package cn.com.yuanwei.center.web.request;

import java.math.BigDecimal;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 统计局导出表
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:22
 */
@ApiModel
public class RealReportReq extends PageReq {
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
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	@ApiModelProperty(value = "数据日期",dataType="Date")
	private Date createTime;
	@ApiModelProperty(value = "乡镇ID",dataType="Integer")
	private Integer townshipId;
	@ApiModelProperty(value = "企业类型",dataType="Integer")
	private Integer enterpriseType;
	@ApiModelProperty(value = "行业类型",dataType="Integer")
	private Integer industry;
	@ApiModelProperty(value = "入库类型",dataType="Integer")
	private Integer inType;
	
	private Integer startMonth;
	private Integer endMonth;
	

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
	public Integer getTownshipId() {
		return townshipId;
	}
	public void setTownshipId(Integer townshipId) {
		this.townshipId = townshipId;
	}
	public Integer getEnterpriseType() {
		return enterpriseType;
	}
	public void setEnterpriseType(Integer enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	public Integer getIndustry() {
		return industry;
	}
	public void setIndustry(Integer industry) {
		this.industry = industry;
	}
	public Integer getInType() {
		return inType;
	}
	public void setInType(Integer inType) {
		this.inType = inType;
	}
	public Integer getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(Integer startMonth) {
		this.startMonth = startMonth;
	}
	public Integer getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(Integer endMonth) {
		this.endMonth = endMonth;
	}
	
}
