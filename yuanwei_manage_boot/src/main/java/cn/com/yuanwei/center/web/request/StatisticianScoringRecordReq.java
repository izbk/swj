package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 统计员得分记录
 * 
 * @author zbk
 * @email 
 * @date 2017-06-19 11:52:16
 */
@ApiModel
public class StatisticianScoringRecordReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//月打分记录ID
	@ApiModelProperty(value = "月打分记录ID",dataType="Integer")
	private Integer reportId;
	//年度
	@ApiModelProperty(value = "年度",dataType="Integer")
	private Integer year;
	//月份
	@ApiModelProperty(value = "月份",dataType="Integer")
	private Integer month;
	//企业名称
	@ApiModelProperty(value = "企业名称",dataType="String")
	private String enterpriseName;
	//企业编号
	@ApiModelProperty(value = "企业编号",dataType="String")
	private String enterpriseCode;
	//统计员ID
	@ApiModelProperty(value = "统计员ID",dataType="Integer")
	private Integer userId;
	//统计员姓名
	@ApiModelProperty(value = "统计员姓名",dataType="String")
	private String userName;
	//统计员手机号码
	@ApiModelProperty(value = "统计员手机号码",dataType="String")
	private String mobilePhone;
	//得分规则ID
	@ApiModelProperty(value = "得分规则ID",dataType="Integer")
	private Integer ruleId;
	//规则
	@ApiModelProperty(value = "规则",dataType="String")
	private String rule;
	//得分
	@ApiModelProperty(value = "得分",dataType="Integer")
	private Integer point;
	//得分类型
	@ApiModelProperty(value = "得分类型",dataType="Integer")
	private Integer pointType;
	//创建人
	@ApiModelProperty(value = "创建人",dataType="Integer")
	private Integer createBy;
	//创建时间
	@ApiModelProperty(value = "创建时间",dataType="Date")
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
	 * 设置：月打分记录ID
	 */
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	/**
	 * 获取：月打分记录ID
	 */
	public Integer getReportId() {
		return reportId;
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
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：统计员姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：统计员手机号码
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	/**
	 * 获取：统计员手机号码
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * 设置：得分规则ID
	 */
	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}
	/**
	 * 获取：得分规则ID
	 */
	public Integer getRuleId() {
		return ruleId;
	}
	/**
	 * 设置：规则
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}
	/**
	 * 获取：规则
	 */
	public String getRule() {
		return rule;
	}
	/**
	 * 设置：得分
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}
	/**
	 * 获取：得分
	 */
	public Integer getPoint() {
		return point;
	}
	/**
	 * 设置：得分类型
	 */
	public void setPointType(Integer pointType) {
		this.pointType = pointType;
	}
	/**
	 * 获取：得分类型
	 */
	public Integer getPointType() {
		return pointType;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public Integer getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
