package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 会展备案信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-03 11:39:30
 */
@ApiModel
public class ExhibitionRecordReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//会展名称
	@ApiModelProperty(value = "会展名称",dataType="String")
	private String exhibitionName;
	//会展地点
	@ApiModelProperty(value = "会展地点",dataType="String")
	private String address;
	//开始时间
	@ApiModelProperty(value = "开始时间",dataType="Date")
	private Date startDate;
	//结束时间
	@ApiModelProperty(value = "结束时间",dataType="Date")
	private Date endDate;
	//主办单位
	@ApiModelProperty(value = "主办单位",dataType="String")
	private String organizer;
	//承办单位
	@ApiModelProperty(value = "承办单位",dataType="String")
	private String exhibitor;
	//协办单位
	@ApiModelProperty(value = "协办单位",dataType="String")
	private String coorganizer;
	//会展类别
	@ApiModelProperty(value = "会展类别",dataType="String")
	private String exhibitionType;
	//会展内容
	@ApiModelProperty(value = "会展内容",dataType="String")
	private String introduction;
	//负责人
	@ApiModelProperty(value = "负责人",dataType="String")
	private String charge;
	//负责人联系方式
	@ApiModelProperty(value = "负责人联系方式",dataType="String")
	private String chargeMobile;
	//联系人
	@ApiModelProperty(value = "联系人",dataType="String")
	private String contact;
	//联系人联系方式
	@ApiModelProperty(value = "联系人联系方式",dataType="String")
	private String contactMobile;
	//展位数
	@ApiModelProperty(value = "展位数",dataType="Integer")
	private Integer stands;
	//展位面积（m2）
	@ApiModelProperty(value = "展位面积（m2）",dataType="BigDecimal")
	private BigDecimal standArea;
	//参展人数
	@ApiModelProperty(value = "参展人数",dataType="Integer")
	private Integer numbers;
	//申请单位
	@ApiModelProperty(value = "申请单位",dataType="String")
	private String applicant;
	//申请时间
	@ApiModelProperty(value = "申请时间",dataType="Date")
	private Date applyTime;
	//备案登记机关意见
	@ApiModelProperty(value = "备案登记机关意见",dataType="String")
	private String recordOpinion;
	//备案时间
	@ApiModelProperty(value = "备案时间",dataType="Date")
	private Date recordTime;
	//备注
	@ApiModelProperty(value = "备注",dataType="String")
	private String remark;
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
}
