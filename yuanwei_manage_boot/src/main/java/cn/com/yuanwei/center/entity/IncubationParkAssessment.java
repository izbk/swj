package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 孵化园企业考核
 * 
 * @author zbk
 * @date 2017-07-04 17:42:05
 */
public class IncubationParkAssessment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//孵化园企业ID
	@Excel(name = "孵化园企业ID",isImportField="true")
	private Integer ipcompanyId;
	//单位名称
	@Excel(name = "单位名称",isImportField="true")
	private String businessSubject;
	//考核日期
	@Excel(name = "考核日期",format="yyyy-MM-dd",isImportField="true")
	private Date assessDate;
	//出勤天数
	@Excel(name = "出勤天数",isImportField="true")
	private BigDecimal ycqts;
	//出勤率
	@Excel(name = "出勤率",isImportField="true")
	private String attendance;
	//出勤得分
	@Excel(name = "出勤得分",isImportField="true")
	private Integer attendPoint;
	//日均在位人数
	@Excel(name = "日均在位人数",isImportField="true")
	private BigDecimal avgTeamNum;
	//团队建设得分
	@Excel(name = "团队建设得分",isImportField="true")
	private Integer teamPoint;
	//评估
	@Excel(name = "评估",isImportField="true")
	private String evaluate;
	//业绩得分
	@Excel(name = "业绩得分",isImportField="true")
	private Integer performPoint;
	//扣分项
	@Excel(name = "扣分项",isImportField="true")
	private String deductReason;
	//扣分项得分
	@Excel(name = "扣分项得分",isImportField="true")
	private Integer deductPoint;
	//加分项
	@Excel(name = "加分项",isImportField="true")
	private String plusReason;
	//加分项得分
	@Excel(name = "加分项得分",isImportField="true")
	private Integer plusPoint;
	//总得分
	@Excel(name = "总得分",isImportField="true")
	private Integer totalPoint;
	//备注
	@Excel(name = "备注",isImportField="true")
	private String reamrk;
	//创建人
	private Integer createBy;
	//创建时间
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
	 * 设置：孵化园企业ID
	 */
	public void setIpcompanyId(Integer ipcompanyId) {
		this.ipcompanyId = ipcompanyId;
	}
	/**
	 * 获取：孵化园企业ID
	 */
	public Integer getIpcompanyId() {
		return ipcompanyId;
	}
	/**
	 * 设置：单位名称
	 */
	public void setBusinessSubject(String businessSubject) {
		this.businessSubject = businessSubject;
	}
	/**
	 * 获取：单位名称
	 */
	public String getBusinessSubject() {
		return businessSubject;
	}
	/**
	 * 设置：考核日期
	 */
	public void setAssessDate(Date assessDate) {
		this.assessDate = assessDate;
	}
	/**
	 * 获取：考核日期
	 */
	public Date getAssessDate() {
		return assessDate;
	}
	/**
	 * 设置：出勤天数
	 */
	public void setYcqts(BigDecimal ycqts) {
		this.ycqts = ycqts;
	}
	/**
	 * 获取：出勤天数
	 */
	public BigDecimal getYcqts() {
		return ycqts;
	}
	/**
	 * 设置：出勤率
	 */
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	/**
	 * 获取：出勤率
	 */
	public String getAttendance() {
		return attendance;
	}
	/**
	 * 设置：出勤得分
	 */
	public void setAttendPoint(Integer attendPoint) {
		this.attendPoint = attendPoint;
	}
	/**
	 * 获取：出勤得分
	 */
	public Integer getAttendPoint() {
		return attendPoint;
	}
	/**
	 * 设置：日均在位人数
	 */
	public void setAvgTeamNum(BigDecimal avgTeamNum) {
		this.avgTeamNum = avgTeamNum;
	}
	/**
	 * 获取：日均在位人数
	 */
	public BigDecimal getAvgTeamNum() {
		return avgTeamNum;
	}
	/**
	 * 设置：团队建设得分
	 */
	public void setTeamPoint(Integer teamPoint) {
		this.teamPoint = teamPoint;
	}
	/**
	 * 获取：团队建设得分
	 */
	public Integer getTeamPoint() {
		return teamPoint;
	}
	/**
	 * 设置：评估
	 */
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	/**
	 * 获取：评估
	 */
	public String getEvaluate() {
		return evaluate;
	}
	/**
	 * 设置：业绩得分
	 */
	public void setPerformPoint(Integer performPoint) {
		this.performPoint = performPoint;
	}
	/**
	 * 获取：业绩得分
	 */
	public Integer getPerformPoint() {
		return performPoint;
	}
	/**
	 * 设置：扣分项
	 */
	public void setDeductReason(String deductReason) {
		this.deductReason = deductReason;
	}
	/**
	 * 获取：扣分项
	 */
	public String getDeductReason() {
		return deductReason;
	}
	/**
	 * 设置：扣分项得分
	 */
	public void setDeductPoint(Integer deductPoint) {
		this.deductPoint = deductPoint;
	}
	/**
	 * 获取：扣分项得分
	 */
	public Integer getDeductPoint() {
		return deductPoint;
	}
	/**
	 * 设置：加分项
	 */
	public void setPlusReason(String plusReason) {
		this.plusReason = plusReason;
	}
	/**
	 * 获取：加分项
	 */
	public String getPlusReason() {
		return plusReason;
	}
	/**
	 * 设置：加分项得分
	 */
	public void setPlusPoint(Integer plusPoint) {
		this.plusPoint = plusPoint;
	}
	/**
	 * 获取：加分项得分
	 */
	public Integer getPlusPoint() {
		return plusPoint;
	}
	/**
	 * 设置：总得分
	 */
	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}
	/**
	 * 获取：总得分
	 */
	public Integer getTotalPoint() {
		return totalPoint;
	}
	/**
	 * 设置：备注
	 */
	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}
	/**
	 * 获取：备注
	 */
	public String getReamrk() {
		return reamrk;
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

	public IncubationParkAssessment() {
		super();
	}

	public IncubationParkAssessment(
		Integer id,
		Integer ipcompanyId,
		String businessSubject,
		Date assessDate,
		BigDecimal ycqts,
		String attendance,
		Integer attendPoint,
		BigDecimal avgTeamNum,
		Integer teamPoint,
		String evaluate,
		Integer performPoint,
		String deductReason,
		Integer deductPoint,
		String plusReason,
		Integer plusPoint,
		Integer totalPoint,
		String reamrk,
		Integer createBy,
		Date createTime) {
		super();
		this.id = id;
		this.ipcompanyId = ipcompanyId;
		this.businessSubject = businessSubject;
		this.assessDate = assessDate;
		this.ycqts = ycqts;
		this.attendance = attendance;
		this.attendPoint = attendPoint;
		this.avgTeamNum = avgTeamNum;
		this.teamPoint = teamPoint;
		this.evaluate = evaluate;
		this.performPoint = performPoint;
		this.deductReason = deductReason;
		this.deductPoint = deductPoint;
		this.plusReason = plusReason;
		this.plusPoint = plusPoint;
		this.totalPoint = totalPoint;
		this.reamrk = reamrk;
		this.createBy = createBy;
		this.createTime = createTime;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"ipcompanyId\":").append("\"").append(ipcompanyId).append("\"").append(",");
		sb.append("\"businessSubject\":").append("\"").append(businessSubject).append("\"").append(",");
		sb.append("\"assessDate\":").append("\"").append(assessDate).append("\"").append(",");
		sb.append("\"ycqts\":").append("\"").append(ycqts).append("\"").append(",");
		sb.append("\"attendance\":").append("\"").append(attendance).append("\"").append(",");
		sb.append("\"attendPoint\":").append("\"").append(attendPoint).append("\"").append(",");
		sb.append("\"avgTeamNum\":").append("\"").append(avgTeamNum).append("\"").append(",");
		sb.append("\"teamPoint\":").append("\"").append(teamPoint).append("\"").append(",");
		sb.append("\"evaluate\":").append("\"").append(evaluate).append("\"").append(",");
		sb.append("\"performPoint\":").append("\"").append(performPoint).append("\"").append(",");
		sb.append("\"deductReason\":").append("\"").append(deductReason).append("\"").append(",");
		sb.append("\"deductPoint\":").append("\"").append(deductPoint).append("\"").append(",");
		sb.append("\"plusReason\":").append("\"").append(plusReason).append("\"").append(",");
		sb.append("\"plusPoint\":").append("\"").append(plusPoint).append("\"").append(",");
		sb.append("\"totalPoint\":").append("\"").append(totalPoint).append("\"").append(",");
		sb.append("\"reamrk\":").append("\"").append(reamrk).append("\"").append(",");
		sb.append("\"createBy\":").append("\"").append(createBy).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
