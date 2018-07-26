package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 绵竹造产品表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-14 17:57:07
 */
@ApiModel
public class SpecialtyReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//产品所属主体名称
	@ApiModelProperty(value = "产品所属主体名称",dataType="String")
	private String subject;
	//主体类型
	@ApiModelProperty(value = "主体类型",dataType="Integer")
	private Integer subjectType;
	//产品名称
	@ApiModelProperty(value = "产品名称",dataType="String")
	private String productName;
	//产品简介
	@ApiModelProperty(value = "产品简介",dataType="String")
	private String intro;
	//年生产或种植规模
	@ApiModelProperty(value = "年生产或种植规模",dataType="String")
	private String scale;
	//所属品类
	@ApiModelProperty(value = "所属品类",dataType="Integer")
	private Integer category;
	//原产地
	@ApiModelProperty(value = "原产地",dataType="String")
	private String origin;
	//产品季节性情况
	@ApiModelProperty(value = "产品季节性情况",dataType="String")
	private String seasonal;
	//销售渠道
	@ApiModelProperty(value = "销售渠道",dataType="String")
	private String saleChannel;
	//销售情况评价
	@ApiModelProperty(value = "销售情况评价",dataType="String")
	private String salesStatus;
	//价格区间
	@ApiModelProperty(value = "价格区间",dataType="String")
	private String priceRange;
	//产品认证情况
	@ApiModelProperty(value = "产品认证情况",dataType="String")
	private String accreditation;
	//商标注册情况
	@ApiModelProperty(value = "商标注册情况",dataType="String")
	private String trademark;
	//电商销售情况
	@ApiModelProperty(value = "电商销售情况",dataType="String")
	private String onlineSale;
	//联系电话
	@ApiModelProperty(value = "联系电话",dataType="String")
	private String contact;
	//产品销售的意见及建议
	@ApiModelProperty(value = "产品销售的意见及建议",dataType="String")
	private String proposal;
	//产品展示形象
	@ApiModelProperty(value = "产品展示形象",dataType="String")
	private String productPic;
	//状态 (0:未审核 1:已审核 2:审核不通过 )
	@ApiModelProperty(value = "状态 (0:未审核 1:已审核 2:审核不通过 )",dataType="Integer")
	private Integer status;
	//创建时间
	@ApiModelProperty(value = "创建时间",dataType="Date")
	private Date createTime;
	//一级审核人
	@ApiModelProperty(value = "一级审核人",dataType="Integer")
	private Integer audit1By;
	//一级审核时间
	@ApiModelProperty(value = "一级审核时间",dataType="Date")
	private Date audit1Time;
	//二级审核人
	@ApiModelProperty(value = "二级审核人",dataType="Integer")
	private Integer audit2By;
	//二级审核时间
	@ApiModelProperty(value = "二级审核时间",dataType="Date")
	private Date audit2Time;
	//三级审核人
	@ApiModelProperty(value = "三级审核人",dataType="Integer")
	private Integer audit3By;
	//三级审核时间
	@ApiModelProperty(value = "三级审核时间",dataType="Date")
	private Date audit3Time;

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
	 * 设置：产品所属主体名称
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 获取：产品所属主体名称
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * 设置：主体类型
	 */
	public void setSubjectType(Integer subjectType) {
		this.subjectType = subjectType;
	}
	/**
	 * 获取：主体类型
	 */
	public Integer getSubjectType() {
		return subjectType;
	}
	/**
	 * 设置：产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：产品简介
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：产品简介
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：年生产或种植规模
	 */
	public void setScale(String scale) {
		this.scale = scale;
	}
	/**
	 * 获取：年生产或种植规模
	 */
	public String getScale() {
		return scale;
	}
	/**
	 * 设置：所属品类
	 */
	public void setCategory(Integer category) {
		this.category = category;
	}
	/**
	 * 获取：所属品类
	 */
	public Integer getCategory() {
		return category;
	}
	/**
	 * 设置：原产地
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * 获取：原产地
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * 设置：产品季节性情况
	 */
	public void setSeasonal(String seasonal) {
		this.seasonal = seasonal;
	}
	/**
	 * 获取：产品季节性情况
	 */
	public String getSeasonal() {
		return seasonal;
	}
	/**
	 * 设置：销售渠道
	 */
	public void setSaleChannel(String saleChannel) {
		this.saleChannel = saleChannel;
	}
	/**
	 * 获取：销售渠道
	 */
	public String getSaleChannel() {
		return saleChannel;
	}
	/**
	 * 设置：销售情况评价
	 */
	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
	}
	/**
	 * 获取：销售情况评价
	 */
	public String getSalesStatus() {
		return salesStatus;
	}
	/**
	 * 设置：价格区间
	 */
	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}
	/**
	 * 获取：价格区间
	 */
	public String getPriceRange() {
		return priceRange;
	}
	/**
	 * 设置：产品认证情况
	 */
	public void setAccreditation(String accreditation) {
		this.accreditation = accreditation;
	}
	/**
	 * 获取：产品认证情况
	 */
	public String getAccreditation() {
		return accreditation;
	}
	/**
	 * 设置：商标注册情况
	 */
	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}
	/**
	 * 获取：商标注册情况
	 */
	public String getTrademark() {
		return trademark;
	}
	/**
	 * 设置：电商销售情况
	 */
	public void setOnlineSale(String onlineSale) {
		this.onlineSale = onlineSale;
	}
	/**
	 * 获取：电商销售情况
	 */
	public String getOnlineSale() {
		return onlineSale;
	}
	/**
	 * 设置：联系电话
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：联系电话
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：产品销售的意见及建议
	 */
	public void setProposal(String proposal) {
		this.proposal = proposal;
	}
	/**
	 * 获取：产品销售的意见及建议
	 */
	public String getProposal() {
		return proposal;
	}
	/**
	 * 设置：产品展示形象
	 */
	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}
	/**
	 * 获取：产品展示形象
	 */
	public String getProductPic() {
		return productPic;
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
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
}
