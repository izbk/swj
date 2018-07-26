package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 统计员任务考核
 * 
 * @author zbk
 * @email 
 * @date 2017-06-16 09:56:12
 */
@ApiModel
public class StatisticianAssessmentReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//奖励记录ID
	@ApiModelProperty(value = "奖励记录ID",dataType="Integer")
	private Integer rewardId;
	//年度
	@ApiModelProperty(value = "年度",dataType="Integer")
	private Integer year;
	//开始日期
	@ApiModelProperty(value = "开始日期",dataType="Date")
	private Date startDate;
	//结束日期
	@ApiModelProperty(value = "结束日期",dataType="Date")
	private Date endDate;
	//企业编号
	@ApiModelProperty(value = "企业编号",dataType="String")
	private String enterpriseCode;
	//企业名称
	@ApiModelProperty(value = "企业名称",dataType="String")
	private String enterpriseName;
	//统计员ID
	@ApiModelProperty(value = "统计员ID",dataType="Integer")
	private Integer userId;
	//统计员姓名
	@ApiModelProperty(value = "统计员姓名",dataType="String")
	private String statisticianName;
	//零售额总量
	@ApiModelProperty(value = "零售额总量",dataType="BigDecimal")
	private BigDecimal retailSalesDone;
	//销售额总量
	@ApiModelProperty(value = "销售额总量",dataType="BigDecimal")
	private BigDecimal salesDone;
	//零售额排位得分
	@ApiModelProperty(value = "零售额排位得分",dataType="Integer")
	private Integer retailSalesPoint;
	//销售额排位得分
	@ApiModelProperty(value = "销售额排位得分",dataType="Integer")
	private Integer salesPoint;
	//排位总分
	@ApiModelProperty(value = "排位总分",dataType="Integer")
	private Integer qualifyingPoint;
	//零售额同比
	@ApiModelProperty(value = "零售额同比",dataType="BigDecimal")
	private BigDecimal retailCompareRatio;
	//销售额同比
	@ApiModelProperty(value = "销售额同比",dataType="BigDecimal")
	private BigDecimal saleCompareRatio;
	//零售增幅排位得分
	@ApiModelProperty(value = "零售增幅排位得分",dataType="Integer")
	private Integer retailGrowthPoint;
	//销售增幅排位得分
	@ApiModelProperty(value = "销售增幅排位得分",dataType="Integer")
	private Integer salesGrowthPoint;
	//增幅排位综合得分
	@ApiModelProperty(value = "增幅排位综合得分",dataType="Integer")
	private Integer growthPoint;
	//上报情况考核得分
	@ApiModelProperty(value = "上报情况考核得分",dataType="Integer")
	private Integer reportPoint;
	//考核总得分
	@ApiModelProperty(value = "考核总得分",dataType="Integer")
	private Integer totalPoint;
	//单位分值金额
	@ApiModelProperty(value = "单位分值金额",dataType="BigDecimal")
	private BigDecimal perPointValue;
	//以奖代补金额
	@ApiModelProperty(value = "以奖代补金额",dataType="BigDecimal")
	private BigDecimal allowance;
	//考核时间
	@ApiModelProperty(value = "考核时间",dataType="Date")
	private Date createTime;
	//考核人
	@ApiModelProperty(value = "考核人",dataType="Integer")
	private Integer createBy;
	
	//奖励总金额
	@ApiModelProperty(value = "奖励总金额",dataType="BigDecimal")
	private BigDecimal amount;

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
	 * 设置：奖励记录ID
	 */
	public void setRewardId(Integer rewardId) {
		this.rewardId = rewardId;
	}
	/**
	 * 获取：奖励记录ID
	 */
	public Integer getRewardId() {
		return rewardId;
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
	 * 设置：开始日期
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：开始日期
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 设置：结束日期
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：结束日期
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 设置：企业编号
	 */
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	/**
	 * 获取：企业编号
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
	 * 设置：统计员ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：统计员ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：统计员姓名
	 */
	public void setStatisticianName(String statisticianName) {
		this.statisticianName = statisticianName;
	}
	/**
	 * 获取：统计员姓名
	 */
	public String getStatisticianName() {
		return statisticianName;
	}
	/**
	 * 设置：零售额总量
	 */
	public void setRetailSalesDone(BigDecimal retailSalesDone) {
		this.retailSalesDone = retailSalesDone;
	}
	/**
	 * 获取：零售额总量
	 */
	public BigDecimal getRetailSalesDone() {
		return retailSalesDone;
	}
	/**
	 * 设置：销售额总量
	 */
	public void setSalesDone(BigDecimal salesDone) {
		this.salesDone = salesDone;
	}
	/**
	 * 获取：销售额总量
	 */
	public BigDecimal getSalesDone() {
		return salesDone;
	}
	/**
	 * 设置：零售额排位得分
	 */
	public void setRetailSalesPoint(Integer retailSalesPoint) {
		this.retailSalesPoint = retailSalesPoint;
	}
	/**
	 * 获取：零售额排位得分
	 */
	public Integer getRetailSalesPoint() {
		return retailSalesPoint;
	}
	/**
	 * 设置：销售额排位得分
	 */
	public void setSalesPoint(Integer salesPoint) {
		this.salesPoint = salesPoint;
	}
	/**
	 * 获取：销售额排位得分
	 */
	public Integer getSalesPoint() {
		return salesPoint;
	}
	/**
	 * 设置：排位总分
	 */
	public void setQualifyingPoint(Integer qualifyingPoint) {
		this.qualifyingPoint = qualifyingPoint;
	}
	/**
	 * 获取：排位总分
	 */
	public Integer getQualifyingPoint() {
		return qualifyingPoint;
	}
	/**
	 * 设置：零售额同比
	 */
	public void setRetailCompareRatio(BigDecimal retailCompareRatio) {
		this.retailCompareRatio = retailCompareRatio;
	}
	/**
	 * 获取：零售额同比
	 */
	public BigDecimal getRetailCompareRatio() {
		return retailCompareRatio;
	}
	/**
	 * 设置：销售额同比
	 */
	public void setSaleCompareRatio(BigDecimal saleCompareRatio) {
		this.saleCompareRatio = saleCompareRatio;
	}
	/**
	 * 获取：销售额同比
	 */
	public BigDecimal getSaleCompareRatio() {
		return saleCompareRatio;
	}
	/**
	 * 设置：零售增幅排位得分
	 */
	public void setRetailGrowthPoint(Integer retailGrowthPoint) {
		this.retailGrowthPoint = retailGrowthPoint;
	}
	/**
	 * 获取：零售增幅排位得分
	 */
	public Integer getRetailGrowthPoint() {
		return retailGrowthPoint;
	}
	/**
	 * 设置：销售增幅排位得分
	 */
	public void setSalesGrowthPoint(Integer salesGrowthPoint) {
		this.salesGrowthPoint = salesGrowthPoint;
	}
	/**
	 * 获取：销售增幅排位得分
	 */
	public Integer getSalesGrowthPoint() {
		return salesGrowthPoint;
	}
	/**
	 * 设置：增幅排位综合得分
	 */
	public void setGrowthPoint(Integer growthPoint) {
		this.growthPoint = growthPoint;
	}
	/**
	 * 获取：增幅排位综合得分
	 */
	public Integer getGrowthPoint() {
		return growthPoint;
	}
	/**
	 * 设置：上报情况考核得分
	 */
	public void setReportPoint(Integer reportPoint) {
		this.reportPoint = reportPoint;
	}
	/**
	 * 获取：上报情况考核得分
	 */
	public Integer getReportPoint() {
		return reportPoint;
	}
	/**
	 * 设置：考核总得分
	 */
	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}
	/**
	 * 获取：考核总得分
	 */
	public Integer getTotalPoint() {
		return totalPoint;
	}
	/**
	 * 设置：单位分值金额
	 */
	public void setPerPointValue(BigDecimal perPointValue) {
		this.perPointValue = perPointValue;
	}
	/**
	 * 获取：单位分值金额
	 */
	public BigDecimal getPerPointValue() {
		return perPointValue;
	}
	/**
	 * 设置：以奖代补金额
	 */
	public void setAllowance(BigDecimal allowance) {
		this.allowance = allowance;
	}
	/**
	 * 获取：以奖代补金额
	 */
	public BigDecimal getAllowance() {
		return allowance;
	}
	/**
	 * 设置：考核时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：考核时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：考核人
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：考核人
	 */
	public Integer getCreateBy() {
		return createBy;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
