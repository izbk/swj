package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;


/**
 * 微信模板消息发送记录
 * 
 * @author zbk
 * @date 2017-06-09 17:41:23
 */
public class WeixinTemplateRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//模板ID
	 @Excel(name = "模板ID",isImportField="true")
	private Integer templateId;
	//通知类型
	 @Excel(name = "通知类型",replace={"限上企业通知_0","服务业企业通知_1","企业政策通知_2"},isImportField="true")
	private Integer noticeType;
	//通知内容
	 @Excel(name = "通知内容",isImportField="true")
	private String content;
	//用户ID
	 @Excel(name = "用户ID",isImportField="true")
	private Integer userId;
	//OPENID
	 @Excel(name = "OPENID",isImportField="true")
	private String openId;
	//用户名称
	 @Excel(name = "用户名称",isImportField="true")
	private String nickName;
	//创建人
	 @Excel(name = "创建人",isImportField="true")
	private Integer createBy;
	//创建人姓名
	 @Excel(name = "创建人姓名",isImportField="true")
	private String createName;
	//创建时间
     @Excel(name = "创建时间",format="yyyy-MM-dd",isImportField="true")
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
	 * 设置：模板ID
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：模板ID
	 */
	public Integer getTemplateId() {
		return templateId;
	}
	/**
	 * 设置：通知类型
	 */
	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}
	/**
	 * 获取：通知类型
	 */
	public Integer getNoticeType() {
		return noticeType;
	}
	/**
	 * 设置：通知内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：通知内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：OPENID
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：OPENID
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * 设置：用户名称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：用户名称
	 */
	public String getNickName() {
		return nickName;
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
	 * 设置：创建人姓名
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	/**
	 * 获取：创建人姓名
	 */
	public String getCreateName() {
		return createName;
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
