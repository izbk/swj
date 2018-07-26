package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;

/**
 * 统计员直报考核记录表
 * 
 * @author zbk
 * @date 2017-07-07 15:09:21
 */
public class StatisticianReportPoint implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//年度
	@Excel(name = "年度",isImportField="true")
	private Integer year;
	//月份
	@Excel(name = "月份",isImportField="true")
	private Integer month;
	//企业编号
	@Excel(name = "企业编号",isImportField="true")
	private String enterpriseCode;
	//企业名称
	@Excel(name = "企业名称",isImportField="true")
	private String enterpriseName;
	//统计员ID
	@Excel(name = "统计员ID",isImportField="true")
	private Integer userId;
	//统计员名称
	@Excel(name = "统计员名称",isImportField="true")
	private String statisticianName;
	//扣分项ID
	@Excel(name = "扣分项ID",replace={"未按时上报月报表的扣10分_1","未按时上报其他报表的扣4分_2","未按要求参会及培训扣5分_3","错报误报的扣5分_4","未按要求完成配合工作的扣10分_5","每月短信未回复及咨询扣5分_6","其中两项未完成扣10分_7","其中三项未完成扣15分_8"},isImportField="true")
	private Integer deductRuleId;
	//加分项ID
	@Excel(name = "加分项ID",replace={"配合部门工作较好加10分_9","工作交接时主动报告加5分_10","技术过硬差错率低的加5分_11","在群里主动传帮带的加5分_12","评为优秀统计员加100分_13","有统计资格证加10分_14","积极完成交办的其他事项加5分_15","积极完成相关信息上报的加10分_16"},isImportField="true")
	private Integer increaseRuleId;
	//扣分小计
	@Excel(name = "扣分小计",isImportField="true")
	private Integer deductPoint;
	//加分小计
	@Excel(name = "加分小计",isImportField="true")
	private Integer increasePoint;
	//总计得分
	@Excel(name = "总计得分",isImportField="true")
	private Integer reportPoint;
	//考核时间
	private Date createTime;
	//考核人
	private Integer createBy;

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

	public StatisticianReportPoint() {
		super();
	}

	public StatisticianReportPoint(
		Integer id,
		Integer year,
		Integer month,
		String enterpriseCode,
		String enterpriseName,
		Integer userId,
		String statisticianName,
		Integer deductRuleId,
		Integer increaseRuleId,
		Integer deductPoint,
		Integer increasePoint,
		Integer reportPoint,
		Date createTime,
		Integer createBy) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.enterpriseCode = enterpriseCode;
		this.enterpriseName = enterpriseName;
		this.userId = userId;
		this.statisticianName = statisticianName;
		this.deductRuleId = deductRuleId;
		this.increaseRuleId = increaseRuleId;
		this.deductPoint = deductPoint;
		this.increasePoint = increasePoint;
		this.reportPoint = reportPoint;
		this.createTime = createTime;
		this.createBy = createBy;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"year\":").append("\"").append(year).append("\"").append(",");
		sb.append("\"month\":").append("\"").append(month).append("\"").append(",");
		sb.append("\"enterpriseCode\":").append("\"").append(enterpriseCode).append("\"").append(",");
		sb.append("\"enterpriseName\":").append("\"").append(enterpriseName).append("\"").append(",");
		sb.append("\"userId\":").append("\"").append(userId).append("\"").append(",");
		sb.append("\"statisticianName\":").append("\"").append(statisticianName).append("\"").append(",");
		sb.append("\"deductRuleId\":").append("\"").append(deductRuleId).append("\"").append(",");
		sb.append("\"increaseRuleId\":").append("\"").append(increaseRuleId).append("\"").append(",");
		sb.append("\"deductPoint\":").append("\"").append(deductPoint).append("\"").append(",");
		sb.append("\"increasePoint\":").append("\"").append(increasePoint).append("\"").append(",");
		sb.append("\"reportPoint\":").append("\"").append(reportPoint).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append(",");
		sb.append("\"createBy\":").append("\"").append(createBy).append("\"").append("}");
        return sb.toString();
    }
}
