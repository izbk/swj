package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;

/**
 * 会展报名信息
 * 
 * @author zbk
 * @date 2017-07-26 18:19:33
 */
public class ExhibitionRegisterVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//会展ID
//	@Excel(name = "会展ID",isImportField="true")
	private Integer exhibitionId;
	//会展名称
	@Excel(name = "会展名称",isImportField="true")
	private String exhibitionName;
	//参展企业名称
	@Excel(name = "参展企业名称",isImportField="true")
	private String enterpiseName;
	//联系人
	@Excel(name = "联系人",isImportField="true")
	private String linkman;
	//联系方式
	@Excel(name = "联系方式",isImportField="true")
	private String contact;
	//参会人数
	@Excel(name = "参会人数",isImportField="true")
	private Integer participantNum;
	//会展产品类别
	@Excel(name = "会展产品类别",isImportField="true")
	private String exhiProductType;
	//展位数量
	@Excel(name = "展位数量",isImportField="true")
	private Integer boothNum;
	//荣誉
	@Excel(name = "荣誉",isImportField="true")
	private String honor;
	//参会时间
	@Excel(name = "参会时间",format="yyyy-MM-dd",isImportField="true")
	private Date enterDate;
	//意见和建议
	@Excel(name = "意见和建议",isImportField="true")
	private String feedback;
	//报名时间
	@Excel(name = "报名时间",format="yyyy-MM-dd",isImportField="true")
	private Date regTime;
	//反馈时间
	@Excel(name = "反馈时间",format="yyyy-MM-dd",isImportField="true")
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
	public void setExhiProductType(String exhiProductType) {
		this.exhiProductType = exhiProductType;
	}
	/**
	 * 获取：会展产品类别
	 */
	public String getExhiProductType() {
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
	public ExhibitionRegisterVo() {
		super();
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"exhibitionId\":").append("\"").append(exhibitionId).append("\"").append(",");
		sb.append("\"exhibitionName\":").append("\"").append(exhibitionName).append("\"").append(",");
		sb.append("\"enterpiseName\":").append("\"").append(enterpiseName).append("\"").append(",");
		sb.append("\"linkman\":").append("\"").append(linkman).append("\"").append(",");
		sb.append("\"contact\":").append("\"").append(contact).append("\"").append(",");
		sb.append("\"participantNum\":").append("\"").append(participantNum).append("\"").append(",");
		sb.append("\"exhiProductType\":").append("\"").append(exhiProductType).append("\"").append(",");
		sb.append("\"boothNum\":").append("\"").append(boothNum).append("\"").append(",");
		sb.append("\"honor\":").append("\"").append(honor).append("\"").append(",");
		sb.append("\"enterDate\":").append("\"").append(enterDate).append("\"").append(",");
		sb.append("\"feedback\":").append("\"").append(feedback).append("\"").append(",");
		sb.append("\"regTime\":").append("\"").append(regTime).append("\"").append(",");
		sb.append("\"feedTime\":").append("\"").append(feedTime).append("\"").append("}");
        return sb.toString();
    }
}
