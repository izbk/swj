package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;

/**
 * 投诉建议
 * 
 * @author zbk
 * @date 2017-06-29 16:51:38
 */
public class Advice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//姓名
	@Excel(name = "姓名",isImportField="true")
	private String name;
	//电话
	@Excel(name = "电话",isImportField="true")
	private String mobile;
	//邮箱
	@Excel(name = "邮箱",isImportField="true")
	private String email;
	//投诉建议标题
	@Excel(name = "投诉建议标题",isImportField="true")
	private String adviceTitle;
	//投诉建议详情
	@Excel(name = "投诉建议详情",isImportField="true")
	private String adviceContent;
	//意见类型
	@Excel(name = "意见类型",replace={"咨询_0","求助_1","意见建议_2","投诉举报_3","表扬_4"},isImportField="true")
	private Integer adviceType;
	//状态 (0:未审核 1:已审核 2:审核不通过 )
	@Excel(name = "状态 (0:未审核 1:已审核 2:审核不通过 )",replace={"未审核_0","已审核_1","审核不通过_2"},isImportField="true")
	private Integer status;
	//处理时间
	private Date createTime;
	//处理状态
	@Excel(name = "处理状态",replace={"否_0","是_1"},isImportField="true")
	private Integer isDeal;
	//回复内容
	@Excel(name = "回复内容",isImportField="true")
	private String resContent;
	//处理人
	@Excel(name = "处理人",isImportField="true")
	private Integer dealBy;
	//处理时间
	@Excel(name = "处理时间",format="yyyy-MM-dd",isImportField="true")
	private Date dealTime;
	//一级审核人
	private Integer audit1By;
	//一级审核时间
	private Date audit1Time;
	//二级审核人
	private Integer audit2By;
	//二级审核时间
	private Date audit2Time;
	//三级审核人
	private Integer audit3By;
	//三级审核时间
	private Date audit3Time;
	private String audit1Opinion;
	private String audit2Opinion;
	private String audit3Opinion;

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
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：电话
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：投诉建议标题
	 */
	public void setAdviceTitle(String adviceTitle) {
		this.adviceTitle = adviceTitle;
	}
	/**
	 * 获取：投诉建议标题
	 */
	public String getAdviceTitle() {
		return adviceTitle;
	}
	/**
	 * 设置：投诉建议详情
	 */
	public void setAdviceContent(String adviceContent) {
		this.adviceContent = adviceContent;
	}
	/**
	 * 获取：投诉建议详情
	 */
	public String getAdviceContent() {
		return adviceContent;
	}
	/**
	 * 设置：意见类型
	 */
	public void setAdviceType(Integer adviceType) {
		this.adviceType = adviceType;
	}
	/**
	 * 获取：意见类型
	 */
	public Integer getAdviceType() {
		return adviceType;
	}
	/**
	 * 设置：状态 (0:未审核 1:已审核 2:审核不通过 )
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 (0:未审核 1:已审核 2:审核不通过 )
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：处理时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：处理时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：处理状态
	 */
	public void setIsDeal(Integer isDeal) {
		this.isDeal = isDeal;
	}
	/**
	 * 获取：处理状态
	 */
	public Integer getIsDeal() {
		return isDeal;
	}
	/**
	 * 设置：回复内容
	 */
	public void setResContent(String resContent) {
		this.resContent = resContent;
	}
	/**
	 * 获取：回复内容
	 */
	public String getResContent() {
		return resContent;
	}
	/**
	 * 设置：处理人
	 */
	public void setDealBy(Integer dealBy) {
		this.dealBy = dealBy;
	}
	/**
	 * 获取：处理人
	 */
	public Integer getDealBy() {
		return dealBy;
	}
	/**
	 * 设置：处理时间
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	/**
	 * 获取：处理时间
	 */
	public Date getDealTime() {
		return dealTime;
	}
	/**
	 * 设置：一级审核人
	 */
	public void setAudit1By(Integer audit1By) {
		this.audit1By = audit1By;
	}
	/**
	 * 获取：一级审核人
	 */
	public Integer getAudit1By() {
		return audit1By;
	}
	/**
	 * 设置：一级审核时间
	 */
	public void setAudit1Time(Date audit1Time) {
		this.audit1Time = audit1Time;
	}
	/**
	 * 获取：一级审核时间
	 */
	public Date getAudit1Time() {
		return audit1Time;
	}
	/**
	 * 设置：二级审核人
	 */
	public void setAudit2By(Integer audit2By) {
		this.audit2By = audit2By;
	}
	/**
	 * 获取：二级审核人
	 */
	public Integer getAudit2By() {
		return audit2By;
	}
	/**
	 * 设置：二级审核时间
	 */
	public void setAudit2Time(Date audit2Time) {
		this.audit2Time = audit2Time;
	}
	/**
	 * 获取：二级审核时间
	 */
	public Date getAudit2Time() {
		return audit2Time;
	}
	/**
	 * 设置：三级审核人
	 */
	public void setAudit3By(Integer audit3By) {
		this.audit3By = audit3By;
	}
	/**
	 * 获取：三级审核人
	 */
	public Integer getAudit3By() {
		return audit3By;
	}
	/**
	 * 设置：三级审核时间
	 */
	public void setAudit3Time(Date audit3Time) {
		this.audit3Time = audit3Time;
	}
	/**
	 * 获取：三级审核时间
	 */
	public Date getAudit3Time() {
		return audit3Time;
	}

	public String getAudit1Opinion() {
		return audit1Opinion;
	}
	public void setAudit1Opinion(String audit1Opinion) {
		this.audit1Opinion = audit1Opinion;
	}
	public String getAudit2Opinion() {
		return audit2Opinion;
	}
	public void setAudit2Opinion(String audit2Opinion) {
		this.audit2Opinion = audit2Opinion;
	}
	public String getAudit3Opinion() {
		return audit3Opinion;
	}
	public void setAudit3Opinion(String audit3Opinion) {
		this.audit3Opinion = audit3Opinion;
	}
	public Advice() {
		super();
	}

	public Advice(
		Integer id,
		String name,
		String mobile,
		String email,
		String adviceTitle,
		String adviceContent,
		Integer adviceType,
		Integer status,
		Date createTime,
		Integer isDeal,
		String resContent,
		Integer dealBy,
		Date dealTime,
		Integer audit1By,
		Date audit1Time,
		Integer audit2By,
		Date audit2Time,
		Integer audit3By,
		Date audit3Time) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.adviceTitle = adviceTitle;
		this.adviceContent = adviceContent;
		this.adviceType = adviceType;
		this.status = status;
		this.createTime = createTime;
		this.isDeal = isDeal;
		this.resContent = resContent;
		this.dealBy = dealBy;
		this.dealTime = dealTime;
		this.audit1By = audit1By;
		this.audit1Time = audit1Time;
		this.audit2By = audit2By;
		this.audit2Time = audit2Time;
		this.audit3By = audit3By;
		this.audit3Time = audit3Time;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"name\":").append("\"").append(name).append("\"").append(",");
		sb.append("\"mobile\":").append("\"").append(mobile).append("\"").append(",");
		sb.append("\"email\":").append("\"").append(email).append("\"").append(",");
		sb.append("\"adviceTitle\":").append("\"").append(adviceTitle).append("\"").append(",");
		sb.append("\"adviceContent\":").append("\"").append(adviceContent).append("\"").append(",");
		sb.append("\"adviceType\":").append("\"").append(adviceType).append("\"").append(",");
		sb.append("\"status\":").append("\"").append(status).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append(",");
		sb.append("\"isDeal\":").append("\"").append(isDeal).append("\"").append(",");
		sb.append("\"resContent\":").append("\"").append(resContent).append("\"").append(",");
		sb.append("\"dealBy\":").append("\"").append(dealBy).append("\"").append(",");
		sb.append("\"dealTime\":").append("\"").append(dealTime).append("\"").append(",");
		sb.append("\"audit1By\":").append("\"").append(audit1By).append("\"").append(",");
		sb.append("\"audit1Time\":").append("\"").append(audit1Time).append("\"").append(",");
		sb.append("\"audit2By\":").append("\"").append(audit2By).append("\"").append(",");
		sb.append("\"audit2Time\":").append("\"").append(audit2Time).append("\"").append(",");
		sb.append("\"audit3By\":").append("\"").append(audit3By).append("\"").append(",");
		sb.append("\"audit3Time\":").append("\"").append(audit3Time).append("\"").append("}");
        return sb.toString();
    }
}
