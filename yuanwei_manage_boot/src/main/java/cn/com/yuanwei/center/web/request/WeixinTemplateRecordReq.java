package cn.com.yuanwei.center.web.request;

import java.util.Date;
import java.util.List;

import cn.com.yuanwei.center.web.request.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 微信模板消息发送记录
 * 
 * @author zbk
 * @email 
 * @date 2017-06-09 17:41:23
 */
@ApiModel
public class WeixinTemplateRecordReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//模板ID
	@ApiModelProperty(value = "模板ID",dataType="Integer")
	private Integer templateId;
	//通知类型
	@ApiModelProperty(value = "通知类型",dataType="Integer")
	private Integer noticeType;
	//通知内容
	@ApiModelProperty(value = "通知内容",dataType="String")
	private String content;
	//用户ID
	@ApiModelProperty(value = "用户ID",dataType="Integer")
	private Integer userId;
	//OPENID
	@ApiModelProperty(value = "OPENID",dataType="String")
	private String openId;
	//用户名称
	@ApiModelProperty(value = "用户名称",dataType="String")
	private String nickName;
	//创建人
	@ApiModelProperty(value = "创建人",dataType="Integer")
	private Integer createBy;
	//创建人姓名
	@ApiModelProperty(value = "创建人姓名",dataType="String")
	private String createName;
	//创建时间
	@ApiModelProperty(value = "创建时间",dataType="Date")
	private Date createTime;
	
	private List<Date> range;

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
	public List<Date> getRange() {
		return range;
	}
	public void setRange(List<Date> range) {
		this.range = range;
	}
	
}
