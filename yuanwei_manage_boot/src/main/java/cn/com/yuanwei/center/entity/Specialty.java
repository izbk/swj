package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;

/**
 * 绵竹造产品表
 * 
 * @author zbk
 * @date 2017-07-03 18:34:15
 */
public class Specialty implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//产品所属主体名称
	@Excel(name = "产品所属主体名称",isImportField="true")
	private String subject;
	//主体类型
	@Excel(name = "主体类型",replace={"法人_0","个体_1","工商未注册_2"},isImportField="true")
	private Integer subjectType;
	//产品名称
	@Excel(name = "产品名称",isImportField="true")
	private String productName;
	//产品简介
	@Excel(name = "产品简介",isImportField="true")
	private String intro;
	//年生产或种植规模
	@Excel(name = "年生产或种植规模",isImportField="true")
	private String scale;
	//所属品类
	@Excel(name = "所属品类",replace={"工业品类_0","农（副）产品_1","文化产品_2","旅游产品_3","创意原创_4","其它_5"},isImportField="true")
	private Integer category;
	//原产地
	@Excel(name = "原产地",isImportField="true")
	private String origin;
	//产品季节性情况
	@Excel(name = "产品季节性情况",isImportField="true")
	private String seasonal;
	//销售渠道
	@Excel(name = "销售渠道",isImportField="true")
	private String saleChannel;
	//销售情况评价
	@Excel(name = "销售情况评价",isImportField="true")
	private String salesStatus;
	//价格区间
	@Excel(name = "价格区间",isImportField="true")
	private String priceRange;
	//产品认证情况
	@Excel(name = "产品认证情况",isImportField="true")
	private String accreditation;
	//商标注册情况
	@Excel(name = "商标注册情况",isImportField="true")
	private String trademark;
	//电商销售情况
	@Excel(name = "电商销售情况",isImportField="true")
	private String onlineSale;
	//联系人
	@Excel(name = "联系人",isImportField="true")
	private String linkman;
	//联系电话
	@Excel(name = "联系电话",isImportField="true")
	private String contact;
	//产品销售的意见及建议
	@Excel(name = "产品销售的意见及建议",isImportField="true")
	private String proposal;
	//产品展示形象
//	@Excel(name = "产品展示形象",isImportField="true")
	private String productPic;
	//状态 (0:未审核 1:已审核 2:审核不通过 )
	@Excel(name = "状态 (0:未审核 1:已审核 2:审核不通过 )",replace={"未审核_0","已审核_1","审核不通过_2"},isImportField="true")
	private Integer status;
	//创建时间
	private Date createTime;
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
	 * 设置：联系人
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	/**
	 * 获取：联系人
	 */
	public String getLinkman() {
		return linkman;
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
	public Specialty() {
		super();
	}

	public Specialty(
		Integer id,
		String subject,
		Integer subjectType,
		String productName,
		String intro,
		String scale,
		Integer category,
		String origin,
		String seasonal,
		String saleChannel,
		String salesStatus,
		String priceRange,
		String accreditation,
		String trademark,
		String onlineSale,
		String linkman,
		String contact,
		String proposal,
		String productPic,
		Integer status,
		Date createTime,
		Integer audit1By,
		Date audit1Time,
		Integer audit2By,
		Date audit2Time,
		Integer audit3By,
		Date audit3Time) {
		super();
		this.id = id;
		this.subject = subject;
		this.subjectType = subjectType;
		this.productName = productName;
		this.intro = intro;
		this.scale = scale;
		this.category = category;
		this.origin = origin;
		this.seasonal = seasonal;
		this.saleChannel = saleChannel;
		this.salesStatus = salesStatus;
		this.priceRange = priceRange;
		this.accreditation = accreditation;
		this.trademark = trademark;
		this.onlineSale = onlineSale;
		this.linkman = linkman;
		this.contact = contact;
		this.proposal = proposal;
		this.productPic = productPic;
		this.status = status;
		this.createTime = createTime;
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
		sb.append("\"subject\":").append("\"").append(subject).append("\"").append(",");
		sb.append("\"subjectType\":").append("\"").append(subjectType).append("\"").append(",");
		sb.append("\"productName\":").append("\"").append(productName).append("\"").append(",");
		sb.append("\"intro\":").append("\"").append(intro).append("\"").append(",");
		sb.append("\"scale\":").append("\"").append(scale).append("\"").append(",");
		sb.append("\"category\":").append("\"").append(category).append("\"").append(",");
		sb.append("\"origin\":").append("\"").append(origin).append("\"").append(",");
		sb.append("\"seasonal\":").append("\"").append(seasonal).append("\"").append(",");
		sb.append("\"saleChannel\":").append("\"").append(saleChannel).append("\"").append(",");
		sb.append("\"salesStatus\":").append("\"").append(salesStatus).append("\"").append(",");
		sb.append("\"priceRange\":").append("\"").append(priceRange).append("\"").append(",");
		sb.append("\"accreditation\":").append("\"").append(accreditation).append("\"").append(",");
		sb.append("\"trademark\":").append("\"").append(trademark).append("\"").append(",");
		sb.append("\"onlineSale\":").append("\"").append(onlineSale).append("\"").append(",");
		sb.append("\"linkman\":").append("\"").append(linkman).append("\"").append(",");
		sb.append("\"contact\":").append("\"").append(contact).append("\"").append(",");
		sb.append("\"proposal\":").append("\"").append(proposal).append("\"").append(",");
		sb.append("\"productPic\":").append("\"").append(productPic).append("\"").append(",");
		sb.append("\"status\":").append("\"").append(status).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append(",");
		sb.append("\"audit1By\":").append("\"").append(audit1By).append("\"").append(",");
		sb.append("\"audit1Time\":").append("\"").append(audit1Time).append("\"").append(",");
		sb.append("\"audit2By\":").append("\"").append(audit2By).append("\"").append(",");
		sb.append("\"audit2Time\":").append("\"").append(audit2Time).append("\"").append(",");
		sb.append("\"audit3By\":").append("\"").append(audit3By).append("\"").append(",");
		sb.append("\"audit3Time\":").append("\"").append(audit3Time).append("\"").append("}");
        return sb.toString();
    }
}
