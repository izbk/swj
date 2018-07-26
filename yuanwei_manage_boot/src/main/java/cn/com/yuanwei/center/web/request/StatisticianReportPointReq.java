package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 统计员直报考核记录表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-20 16:57:34
 */
@ApiModel
public class StatisticianReportPointReq extends PageReq {
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
	//企业编号
	@ApiModelProperty(value = "企业编号",dataType="String")
	private String enterpriseCode;
	//企业名称
	@ApiModelProperty(value = "企业名称",dataType="String")
	private String enterpriseName;
	//统计员ID
	@ApiModelProperty(value = "统计员ID",dataType="Integer")
	private Integer userId;
	//统计员名称
	@ApiModelProperty(value = "统计员名称",dataType="String")
	private String statisticianName;
	//扣分项ID
	@ApiModelProperty(value = "扣分项ID",dataType="Integer")
	private Integer deductRuleId;
	//加分项ID
	@ApiModelProperty(value = "加分项ID",dataType="Integer")
	private Integer increaseRuleId;
	//扣分小计
	@ApiModelProperty(value = "扣分小计",dataType="Integer")
	private Integer deductPoint;
	//加分小计
	@ApiModelProperty(value = "加分小计",dataType="Integer")
	private Integer increasePoint;
	//总计得分
	@ApiModelProperty(value = "总计得分",dataType="Integer")
	private Integer reportPoint;
	//考核时间
	@ApiModelProperty(value = "考核时间",dataType="Date")
	private Date createTime;
	//考核人
	@ApiModelProperty(value = "考核人",dataType="Integer")
	private Integer createBy;
	
	private Date queryDate;

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
	 * 设置：统计员名称
	 */
	public void setStatisticianName(String statisticianName) {
		this.statisticianName = statisticianName;
	}
	/**
	 * 获取：统计员名称
	 */
	public String getStatisticianName() {
		return statisticianName;
	}
	/**
	 * 设置：扣分项ID
	 */
	public void setDeductRuleId(Integer deductRuleId) {
		this.deductRuleId = deductRuleId;
	}
	/**
	 * 获取：扣分项ID
	 */
	public Integer getDeductRuleId() {
		return deductRuleId;
	}
	/**
	 * 设置：加分项ID
	 */
	public void setIncreaseRuleId(Integer increaseRuleId) {
		this.increaseRuleId = increaseRuleId;
	}
	/**
	 * 获取：加分项ID
	 */
	public Integer getIncreaseRuleId() {
		return increaseRuleId;
	}
	/**
	 * 设置：扣分小计
	 */
	public void setDeductPoint(Integer deductPoint) {
		this.deductPoint = deductPoint;
	}
	/**
	 * 获取：扣分小计
	 */
	public Integer getDeductPoint() {
		return deductPoint;
	}
	/**
	 * 设置：加分小计
	 */
	public void setIncreasePoint(Integer increasePoint) {
		this.increasePoint = increasePoint;
	}
	/**
	 * 获取：加分小计
	 */
	public Integer getIncreasePoint() {
		return increasePoint;
	}
	/**
	 * 设置：总计得分
	 */
	public void setReportPoint(Integer reportPoint) {
		this.reportPoint = reportPoint;
	}
	/**
	 * 获取：总计得分
	 */
	public Integer getReportPoint() {
		return reportPoint;
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
	public Date getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}
	
}
