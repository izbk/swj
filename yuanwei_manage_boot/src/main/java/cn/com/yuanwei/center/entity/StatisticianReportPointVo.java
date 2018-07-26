package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;


/**
 * 统计员直报考核记录表
 * 
 * @author zbk
 * @date 2017-06-15 15:17:36
 */
public class StatisticianReportPointVo implements Serializable {
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
	private Integer enterpriseType;	
	//是否打分
	@Excel(name = "是否打分",replace={"是_1","否_0"},isImportField="true")
	private Integer isMark;
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public String getEnterpriseCode() {
		return enterpriseCode;
	}
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getStatisticianName() {
		return statisticianName;
	}
	public void setStatisticianName(String statisticianName) {
		this.statisticianName = statisticianName;
	}
	public Integer getIsMark() {
		return isMark;
	}
	public void setIsMark(Integer isMark) {
		this.isMark = isMark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDeductRuleId() {
		return deductRuleId;
	}
	public void setDeductRuleId(Integer deductRuleId) {
		this.deductRuleId = deductRuleId;
	}
	public Integer getIncreaseRuleId() {
		return increaseRuleId;
	}
	public void setIncreaseRuleId(Integer increaseRuleId) {
		this.increaseRuleId = increaseRuleId;
	}
	public Integer getDeductPoint() {
		return deductPoint;
	}
	public void setDeductPoint(Integer deductPoint) {
		this.deductPoint = deductPoint;
	}
	public Integer getIncreasePoint() {
		return increasePoint;
	}
	public void setIncreasePoint(Integer increasePoint) {
		this.increasePoint = increasePoint;
	}
	public Integer getReportPoint() {
		return reportPoint;
	}
	public void setReportPoint(Integer reportPoint) {
		this.reportPoint = reportPoint;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getEnterpriseType() {
		return enterpriseType;
	}
	public void setEnterpriseType(Integer enterpriseType) {
		this.enterpriseType = enterpriseType;
	}


}
