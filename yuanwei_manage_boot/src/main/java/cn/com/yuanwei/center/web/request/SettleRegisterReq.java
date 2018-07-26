package cn.com.yuanwei.center.web.request;

import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 入园申请登记表
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:28:04
 */
@ApiModel
public class SettleRegisterReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//
	@ApiModelProperty(value = "",dataType="Integer")
	private Integer id;
	//身份证号码
	@ApiModelProperty(value = "身份证号码",dataType="String")
	private String idNumber;
	//姓名
	@ApiModelProperty(value = "姓名",dataType="String")
	private String name;
	//性别
	@ApiModelProperty(value = "性别",dataType="Integer")
	private Integer sex;
	//年龄
	@ApiModelProperty(value = "年龄",dataType="Integer")
	private Integer age;
	//政治面貌
	@ApiModelProperty(value = "政治面貌",dataType="String")
	private String political;
	//籍贯
	@ApiModelProperty(value = "籍贯",dataType="String")
	private String nativePlace;
	//民族
	@ApiModelProperty(value = "民族",dataType="Integer")
	private Integer nation;
	//联系电话
	@ApiModelProperty(value = "联系电话",dataType="String")
	private String mobile;
	//电子邮箱
	@ApiModelProperty(value = "电子邮箱",dataType="String")
	private String email;
	//现住址
	@ApiModelProperty(value = "现住址",dataType="String")
	private String address;
	//照片
	@ApiModelProperty(value = "照片",dataType="String")
	private String pic;
	//经营主体全称
	@ApiModelProperty(value = "经营主体全称",dataType="String")
	private String businessSubject;
	//法人（负责人）
	@ApiModelProperty(value = "法人（负责人）",dataType="String")
	private String legalPerson;
	//营业执照号码
	@ApiModelProperty(value = "营业执照号码",dataType="String")
	private String businessLicense;
	//企业类型（0:实体商品交易电商 1:电商服务 2:自营平台 3:代理平台 4:微商 5:新媒体 6:软件开发 7:虚拟产品交易电商）
	@ApiModelProperty(value = "企业类型（0:实体商品交易电商 1:电商服务 2:自营平台 3:代理平台 4:微商 5:新媒体 6:软件开发 7:虚拟产品交易电商）",dataType="Integer")
	private Integer companyType;
	//经营收入
	@ApiModelProperty(value = "经营收入",dataType="BigDecimal")
	private BigDecimal businessIncome;
	//营业地点
	@ApiModelProperty(value = "营业地点",dataType="String")
	private String businessPlace;
	//已入驻平台（0:淘宝 1:天猫 2:京东 3:拍拍 4:微商 5:阿里巴巴 6:其他平台 7:未入驻）
	@ApiModelProperty(value = "已入驻平台（0:淘宝 1:天猫 2:京东 3:拍拍 4:微商 5:阿里巴巴 6:其他平台 7:未入驻）",dataType="Integer")
	private Integer settledPlatform;
	//平台店铺名称
	@ApiModelProperty(value = "平台店铺名称",dataType="String")
	private String shopName;
	//网店地址
	@ApiModelProperty(value = "网店地址",dataType="String")
	private String shopUrl;
	//目前信誉等级
	@ApiModelProperty(value = "目前信誉等级",dataType="String")
	private String creditRating;
	//公司官网
	@ApiModelProperty(value = "公司官网",dataType="String")
	private String companyWebsite;
	//经营品类
	@ApiModelProperty(value = "经营品类",dataType="String")
	private String category;
	//平均月销售额
	@ApiModelProperty(value = "平均月销售额",dataType="String")
	private String averageMonthlySales;
	//申请办公室数量
	@ApiModelProperty(value = "申请办公室数量",dataType="Integer")
	private Integer applicationRoom;
	//申请仓储面积
	@ApiModelProperty(value = "申请仓储面积",dataType="String")
	private String applicationArea;
	//设备来源（0:自购 1:租赁 3:其它）
	@ApiModelProperty(value = "设备来源（0:自购 1:租赁 3:其它）",dataType="Integer")
	private Integer equipmentSource;
	//申请经营范围
	@ApiModelProperty(value = "申请经营范围",dataType="String")
	private String businessScope;
	//入驻团队人数
	@ApiModelProperty(value = "入驻团队人数",dataType="Integer")
	private Integer teamNumber;
	//是否愿意成为电商协会会员
	@ApiModelProperty(value = "是否愿意成为电商协会会员",dataType="Integer")
	private Integer joinAssociation;
	//
	@ApiModelProperty(value = "",dataType="String")
	private String projectIntroduction;
	//审核状态（0：未审核 1：审核通过 2：审核不通过）
	@ApiModelProperty(value = "审核状态（0：未审核 1：审核通过 2：审核不通过）",dataType="Integer")
	private Integer status;
	//备注
	@ApiModelProperty(value = "备注",dataType="String")
	private String remark;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：身份证号码
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	/**
	 * 获取：身份证号码
	 */
	public String getIdNumber() {
		return idNumber;
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
	 * 设置：性别
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：政治面貌
	 */
	public void setPolitical(String political) {
		this.political = political;
	}
	/**
	 * 获取：政治面貌
	 */
	public String getPolitical() {
		return political;
	}
	/**
	 * 设置：籍贯
	 */
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	/**
	 * 获取：籍贯
	 */
	public String getNativePlace() {
		return nativePlace;
	}
	/**
	 * 设置：民族
	 */
	public void setNation(Integer nation) {
		this.nation = nation;
	}
	/**
	 * 获取：民族
	 */
	public Integer getNation() {
		return nation;
	}
	/**
	 * 设置：联系电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：联系电话
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：现住址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：现住址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：照片
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * 获取：照片
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * 设置：经营主体全称
	 */
	public void setBusinessSubject(String businessSubject) {
		this.businessSubject = businessSubject;
	}
	/**
	 * 获取：经营主体全称
	 */
	public String getBusinessSubject() {
		return businessSubject;
	}
	/**
	 * 设置：法人（负责人）
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	/**
	 * 获取：法人（负责人）
	 */
	public String getLegalPerson() {
		return legalPerson;
	}
	/**
	 * 设置：营业执照号码
	 */
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	/**
	 * 获取：营业执照号码
	 */
	public String getBusinessLicense() {
		return businessLicense;
	}
	/**
	 * 设置：企业类型（0:实体商品交易电商 1:电商服务 2:自营平台 3:代理平台 4:微商 5:新媒体 6:软件开发 7:虚拟产品交易电商）
	 */
	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}
	/**
	 * 获取：企业类型（0:实体商品交易电商 1:电商服务 2:自营平台 3:代理平台 4:微商 5:新媒体 6:软件开发 7:虚拟产品交易电商）
	 */
	public Integer getCompanyType() {
		return companyType;
	}
	/**
	 * 设置：经营收入
	 */
	public void setBusinessIncome(BigDecimal businessIncome) {
		this.businessIncome = businessIncome;
	}
	/**
	 * 获取：经营收入
	 */
	public BigDecimal getBusinessIncome() {
		return businessIncome;
	}
	/**
	 * 设置：营业地点
	 */
	public void setBusinessPlace(String businessPlace) {
		this.businessPlace = businessPlace;
	}
	/**
	 * 获取：营业地点
	 */
	public String getBusinessPlace() {
		return businessPlace;
	}
	/**
	 * 设置：已入驻平台（0:淘宝 1:天猫 2:京东 3:拍拍 4:微商 5:阿里巴巴 6:其他平台 7:未入驻）
	 */
	public void setSettledPlatform(Integer settledPlatform) {
		this.settledPlatform = settledPlatform;
	}
	/**
	 * 获取：已入驻平台（0:淘宝 1:天猫 2:京东 3:拍拍 4:微商 5:阿里巴巴 6:其他平台 7:未入驻）
	 */
	public Integer getSettledPlatform() {
		return settledPlatform;
	}
	/**
	 * 设置：平台店铺名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * 获取：平台店铺名称
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * 设置：网店地址
	 */
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
	/**
	 * 获取：网店地址
	 */
	public String getShopUrl() {
		return shopUrl;
	}
	/**
	 * 设置：目前信誉等级
	 */
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	/**
	 * 获取：目前信誉等级
	 */
	public String getCreditRating() {
		return creditRating;
	}
	/**
	 * 设置：公司官网
	 */
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}
	/**
	 * 获取：公司官网
	 */
	public String getCompanyWebsite() {
		return companyWebsite;
	}
	/**
	 * 设置：经营品类
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：经营品类
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 设置：平均月销售额
	 */
	public void setAverageMonthlySales(String averageMonthlySales) {
		this.averageMonthlySales = averageMonthlySales;
	}
	/**
	 * 获取：平均月销售额
	 */
	public String getAverageMonthlySales() {
		return averageMonthlySales;
	}
	/**
	 * 设置：申请办公室数量
	 */
	public void setApplicationRoom(Integer applicationRoom) {
		this.applicationRoom = applicationRoom;
	}
	/**
	 * 获取：申请办公室数量
	 */
	public Integer getApplicationRoom() {
		return applicationRoom;
	}
	/**
	 * 设置：申请仓储面积
	 */
	public void setApplicationArea(String applicationArea) {
		this.applicationArea = applicationArea;
	}
	/**
	 * 获取：申请仓储面积
	 */
	public String getApplicationArea() {
		return applicationArea;
	}
	/**
	 * 设置：设备来源（0:自购 1:租赁 3:其它）
	 */
	public void setEquipmentSource(Integer equipmentSource) {
		this.equipmentSource = equipmentSource;
	}
	/**
	 * 获取：设备来源（0:自购 1:租赁 3:其它）
	 */
	public Integer getEquipmentSource() {
		return equipmentSource;
	}
	/**
	 * 设置：申请经营范围
	 */
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	/**
	 * 获取：申请经营范围
	 */
	public String getBusinessScope() {
		return businessScope;
	}
	/**
	 * 设置：入驻团队人数
	 */
	public void setTeamNumber(Integer teamNumber) {
		this.teamNumber = teamNumber;
	}
	/**
	 * 获取：入驻团队人数
	 */
	public Integer getTeamNumber() {
		return teamNumber;
	}
	/**
	 * 设置：是否愿意成为电商协会会员
	 */
	public void setJoinAssociation(Integer joinAssociation) {
		this.joinAssociation = joinAssociation;
	}
	/**
	 * 获取：是否愿意成为电商协会会员
	 */
	public Integer getJoinAssociation() {
		return joinAssociation;
	}
	/**
	 * 设置：
	 */
	public void setProjectIntroduction(String projectIntroduction) {
		this.projectIntroduction = projectIntroduction;
	}
	/**
	 * 获取：
	 */
	public String getProjectIntroduction() {
		return projectIntroduction;
	}
	/**
	 * 设置：审核状态（0：未审核 1：审核通过 2：审核不通过）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：审核状态（0：未审核 1：审核通过 2：审核不通过）
	 */
	public Integer getStatus() {
		return status;
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
}
