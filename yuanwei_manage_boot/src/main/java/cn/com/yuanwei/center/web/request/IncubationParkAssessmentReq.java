package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 孵化园企业考核
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 17:42:05
 */
@ApiModel
public class IncubationParkAssessmentReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//孵化园企业ID
	@ApiModelProperty(value = "孵化园企业ID",dataType="Integer")
	private Integer ipcompanyId;
	//单位名称
	@ApiModelProperty(value = "单位名称",dataType="String")
	private String businessSubject;
	//考核日期
	@ApiModelProperty(value = "考核日期",dataType="Date")
	private Date assessDate;
	//出勤天数
	@ApiModelProperty(value = "出勤天数",dataType="BigDecimal")
	private BigDecimal ycqts;
	//出勤率
	@ApiModelProperty(value = "出勤率",dataType="String")
	private String attendance;
	//出勤得分
	@ApiModelProperty(value = "出勤得分",dataType="Integer")
	private Integer attendPoint;
	//日均在位人数
	@ApiModelProperty(value = "日均在位人数",dataType="BigDecimal")
	private BigDecimal avgTeamNum;
	//团队建设得分
	@ApiModelProperty(value = "团队建设得分",dataType="Integer")
	private Integer teamPoint;
	//评估
	@ApiModelProperty(value = "评估",dataType="String")
	private String evaluate;
	//业绩得分
	@ApiModelProperty(value = "业绩得分",dataType="Integer")
	private Integer performPoint;
	//扣分项
	@ApiModelProperty(value = "扣分项",dataType="String")
	private String deductReason;
	//扣分项得分
	@ApiModelProperty(value = "扣分项得分",dataType="Integer")
	private Integer deductPoint;
	//加分项
	@ApiModelProperty(value = "加分项",dataType="String")
	private String plusReason;
	//加分项得分
	@ApiModelProperty(value = "加分项得分",dataType="Integer")
	private Integer plusPoint;
	//总得分
	@ApiModelProperty(value = "总得分",dataType="Integer")
	private Integer totalPoint;
	//备注
	@ApiModelProperty(value = "备注",dataType="String")
	private String reamrk;
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
}
