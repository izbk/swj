package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 会展报名信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-26 18:19:33
 */
@ApiModel
public class ExhibitionRegisterReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//会展ID
	@ApiModelProperty(value = "会展ID",dataType="Integer")
	private Integer exhibitionId;
	//会展名称
	@ApiModelProperty(value = "会展名称",dataType="String")
	private String exhibitionName;
	//参展企业名称
	@ApiModelProperty(value = "参展企业名称",dataType="String")
	private String enterpiseName;
	//联系人
	@ApiModelProperty(value = "联系人",dataType="String")
	private String linkman;
	//联系方式
	@ApiModelProperty(value = "联系方式",dataType="String")
	private String contact;
	//参会人数
	@ApiModelProperty(value = "参会人数",dataType="Integer")
	private Integer participantNum;
	//会展产品类别
	@ApiModelProperty(value = "会展产品类别",dataType="Integer")
	private Integer exhiProductType;
	//展位数量
	@ApiModelProperty(value = "展位数量",dataType="Integer")
	private Integer boothNum;
	//荣誉
	@ApiModelProperty(value = "荣誉",dataType="String")
	private String honor;
	//参会时间
	@ApiModelProperty(value = "参会时间",dataType="Date")
	private Date enterDate;
	//意见和建议
	@ApiModelProperty(value = "意见和建议",dataType="String")
	private String feedback;
	//报名时间
	@ApiModelProperty(value = "报名时间",dataType="Date")
	private Date regTime;
	//反馈时间
	@ApiModelProperty(value = "反馈时间",dataType="Date")
	private Date feedTime;
	private Integer[] honors;
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
	 * 设置：会展ID
	 */
	public void setExhibitionId(Integer exhibitionId) {
		this.exhibitionId = exhibitionId;
	}
	/**
	 * 获取：会展ID
	 */
	public Integer getExhibitionId() {
		return exhibitionId;
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
	 * 设置：参展企业名称
	 */
	public void setEnterpiseName(String enterpiseName) {
		this.enterpiseName = enterpiseName;
	}
	/**
	 * 获取：参展企业名称
	 */
	public String getEnterpiseName() {
		return enterpiseName;
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
	 * 设置：联系方式
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：联系方式
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：参会人数
	 */
	public void setParticipantNum(Integer participantNum) {
		this.participantNum = participantNum;
	}
	/**
	 * 获取：参会人数
	 */
	public Integer getParticipantNum() {
		return participantNum;
	}
	/**
	 * 设置：会展产品类别
	 */
	public void setExhiProductType(Integer exhiProductType) {
		this.exhiProductType = exhiProductType;
	}
	/**
	 * 获取：会展产品类别
	 */
	public Integer getExhiProductType() {
		return exhiProductType;
	}
	/**
	 * 设置：展位数量
	 */
	public void setBoothNum(Integer boothNum) {
		this.boothNum = boothNum;
	}
	/**
	 * 获取：展位数量
	 */
	public Integer getBoothNum() {
		return boothNum;
	}
	/**
	 * 设置：荣誉
	 */
	public void setHonor(String honor) {
		this.honor = honor;
	}
	/**
	 * 获取：荣誉
	 */
	public String getHonor() {
		return honor;
	}
	/**
	 * 设置：参会时间
	 */
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	/**
	 * 获取：参会时间
	 */
	public Date getEnterDate() {
		return enterDate;
	}
	/**
	 * 设置：意见和建议
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	/**
	 * 获取：意见和建议
	 */
	public String getFeedback() {
		return feedback;
	}
	/**
	 * 设置：报名时间
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	/**
	 * 获取：报名时间
	 */
	public Date getRegTime() {
		return regTime;
	}
	/**
	 * 设置：反馈时间
	 */
	public void setFeedTime(Date feedTime) {
		this.feedTime = feedTime;
	}
	/**
	 * 获取：反馈时间
	 */
	public Date getFeedTime() {
		return feedTime;
	}
	public Integer[] getHonors() {
		return honors;
	}
	public void setHonors(Integer[] honors) {
		this.honors = honors;
	}
	
}
