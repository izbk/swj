package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 会展备案信息
 * 
 * @author zbk
 * @date 2017-07-03 11:39:30
 */
public class ExhibitionRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//会展名称
	@Excel(name = "会展名称",isImportField="true")
	private String exhibitionName;
	//会展地点
	@Excel(name = "会展地点",isImportField="true")
	private String address;
	//开始时间
	@Excel(name = "开始时间",format="yyyy-MM-dd",isImportField="true")
	private Date startDate;
	//结束时间
	@Excel(name = "结束时间",format="yyyy-MM-dd",isImportField="true")
	private Date endDate;
	//主办单位
	@Excel(name = "主办单位",isImportField="true")
	private String organizer;
	//承办单位
	@Excel(name = "承办单位",isImportField="true")
	private String exhibitor;
	//协办单位
	@Excel(name = "协办单位",isImportField="true")
	private String coorganizer;
	//会展类别
	@Excel(name = "会展类别",isImportField="true")
	private String exhibitionType;
	//会展内容
	@Excel(name = "会展内容",isImportField="true")
	private String introduction;
	//负责人
	@Excel(name = "负责人",isImportField="true")
	private String charge;
	//负责人联系方式
	@Excel(name = "负责人联系方式",isImportField="true")
	private String chargeMobile;
	//联系人
	@Excel(name = "联系人",isImportField="true")
	private String contact;
	//联系人联系方式
	@Excel(name = "联系人联系方式",isImportField="true")
	private String contactMobile;
	//展位数
	@Excel(name = "展位数",isImportField="true")
	private Integer stands;
	//展位面积（m2）
	@Excel(name = "展位面积（m2）",isImportField="true")
	private BigDecimal standArea;
	//参展人数
	@Excel(name = "参展人数",isImportField="true")
	private Integer numbers;
	//申请单位
	@Excel(name = "申请单位",isImportField="true")
	private String applicant;
	//申请时间
	@Excel(name = "申请时间",format="yyyy-MM-dd",isImportField="true")
	private Date applyTime;
	//备案登记机关意见
	@Excel(name = "备案登记机关意见",isImportField="true")
	private String recordOpinion;
	//备案时间
	@Excel(name = "备案时间",format="yyyy-MM-dd",isImportField="true")
	private Date recordTime;
	//备注
	@Excel(name = "备注",isImportField="true")
	private String remark;
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
	 * 设置：会展名称
	 */
	public void setExhibitionName(String exhibitionName) {
		this.exhibitionName = exhibitionName;
	}
	/**
	 * 获取：会展名称
	 */
	public String getExhibitionName() {
		return exhibitionName;
	}
	/**
	 * 设置：会展地点
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：会展地点
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 设置：主办单位
	 */
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	/**
	 * 获取：主办单位
	 */
	public String getOrganizer() {
		return organizer;
	}
	/**
	 * 设置：承办单位
	 */
	public void setExhibitor(String exhibitor) {
		this.exhibitor = exhibitor;
	}
	/**
	 * 获取：承办单位
	 */
	public String getExhibitor() {
		return exhibitor;
	}
	/**
	 * 设置：协办单位
	 */
	public void setCoorganizer(String coorganizer) {
		this.coorganizer = coorganizer;
	}
	/**
	 * 获取：协办单位
	 */
	public String getCoorganizer() {
		return coorganizer;
	}
	/**
	 * 设置：会展类别
	 */
	public void setExhibitionType(String exhibitionType) {
		this.exhibitionType = exhibitionType;
	}
	/**
	 * 获取：会展类别
	 */
	public String getExhibitionType() {
		return exhibitionType;
	}
	/**
	 * 设置：会展内容
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * 获取：会展内容
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * 设置：负责人
	 */
	public void setCharge(String charge) {
		this.charge = charge;
	}
	/**
	 * 获取：负责人
	 */
	public String getCharge() {
		return charge;
	}
	/**
	 * 设置：负责人联系方式
	 */
	public void setChargeMobile(String chargeMobile) {
		this.chargeMobile = chargeMobile;
	}
	/**
	 * 获取：负责人联系方式
	 */
	public String getChargeMobile() {
		return chargeMobile;
	}
	/**
	 * 设置：联系人
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：联系人
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：联系人联系方式
	 */
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	/**
	 * 获取：联系人联系方式
	 */
	public String getContactMobile() {
		return contactMobile;
	}
	/**
	 * 设置：展位数
	 */
	public void setStands(Integer stands) {
		this.stands = stands;
	}
	/**
	 * 获取：展位数
	 */
	public Integer getStands() {
		return stands;
	}
	/**
	 * 设置：展位面积（m2）
	 */
	public void setStandArea(BigDecimal standArea) {
		this.standArea = standArea;
	}
	/**
	 * 获取：展位面积（m2）
	 */
	public BigDecimal getStandArea() {
		return standArea;
	}
	/**
	 * 设置：参展人数
	 */
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}
	/**
	 * 获取：参展人数
	 */
	public Integer getNumbers() {
		return numbers;
	}
	/**
	 * 设置：申请单位
	 */
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	/**
	 * 获取：申请单位
	 */
	public String getApplicant() {
		return applicant;
	}
	/**
	 * 设置：申请时间
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getApplyTime() {
		return applyTime;
	}
	/**
	 * 设置：备案登记机关意见
	 */
	public void setRecordOpinion(String recordOpinion) {
		this.recordOpinion = recordOpinion;
	}
	/**
	 * 获取：备案登记机关意见
	 */
	public String getRecordOpinion() {
		return recordOpinion;
	}
	/**
	 * 设置：备案时间
	 */
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	/**
	 * 获取：备案时间
	 */
	public Date getRecordTime() {
		return recordTime;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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

	public ExhibitionRecord() {
		super();
	}

	public ExhibitionRecord(
		Integer id,
		String exhibitionName,
		String address,
		Date startDate,
		Date endDate,
		String organizer,
		String exhibitor,
		String coorganizer,
		String exhibitionType,
		String introduction,
		String charge,
		String chargeMobile,
		String contact,
		String contactMobile,
		Integer stands,
		BigDecimal standArea,
		Integer numbers,
		String applicant,
		Date applyTime,
		String recordOpinion,
		Date recordTime,
		String remark,
		Integer createBy,
		Date createTime) {
		super();
		this.id = id;
		this.exhibitionName = exhibitionName;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.organizer = organizer;
		this.exhibitor = exhibitor;
		this.coorganizer = coorganizer;
		this.exhibitionType = exhibitionType;
		this.introduction = introduction;
		this.charge = charge;
		this.chargeMobile = chargeMobile;
		this.contact = contact;
		this.contactMobile = contactMobile;
		this.stands = stands;
		this.standArea = standArea;
		this.numbers = numbers;
		this.applicant = applicant;
		this.applyTime = applyTime;
		this.recordOpinion = recordOpinion;
		this.recordTime = recordTime;
		this.remark = remark;
		this.createBy = createBy;
		this.createTime = createTime;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"exhibitionName\":").append("\"").append(exhibitionName).append("\"").append(",");
		sb.append("\"address\":").append("\"").append(address).append("\"").append(",");
		sb.append("\"startDate\":").append("\"").append(startDate).append("\"").append(",");
		sb.append("\"endDate\":").append("\"").append(endDate).append("\"").append(",");
		sb.append("\"organizer\":").append("\"").append(organizer).append("\"").append(",");
		sb.append("\"exhibitor\":").append("\"").append(exhibitor).append("\"").append(",");
		sb.append("\"coorganizer\":").append("\"").append(coorganizer).append("\"").append(",");
		sb.append("\"exhibitionType\":").append("\"").append(exhibitionType).append("\"").append(",");
		sb.append("\"introduction\":").append("\"").append(introduction).append("\"").append(",");
		sb.append("\"charge\":").append("\"").append(charge).append("\"").append(",");
		sb.append("\"chargeMobile\":").append("\"").append(chargeMobile).append("\"").append(",");
		sb.append("\"contact\":").append("\"").append(contact).append("\"").append(",");
		sb.append("\"contactMobile\":").append("\"").append(contactMobile).append("\"").append(",");
		sb.append("\"stands\":").append("\"").append(stands).append("\"").append(",");
		sb.append("\"standArea\":").append("\"").append(standArea).append("\"").append(",");
		sb.append("\"numbers\":").append("\"").append(numbers).append("\"").append(",");
		sb.append("\"applicant\":").append("\"").append(applicant).append("\"").append(",");
		sb.append("\"applyTime\":").append("\"").append(applyTime).append("\"").append(",");
		sb.append("\"recordOpinion\":").append("\"").append(recordOpinion).append("\"").append(",");
		sb.append("\"recordTime\":").append("\"").append(recordTime).append("\"").append(",");
		sb.append("\"remark\":").append("\"").append(remark).append("\"").append(",");
		sb.append("\"createBy\":").append("\"").append(createBy).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
