package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 自动回复
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 11:09:43
 */
@ApiModel
public class WeixinAutoResponseReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//关键字
	@ApiModelProperty(value = "关键字",dataType="String")
	private String keyWord;
	//消息类型
	@ApiModelProperty(value = "消息类型",dataType="String")
	private String msgType;
	//回复内容
	@ApiModelProperty(value = "回复内容",dataType="String")
	private String resContent;
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
	 * 设置：关键字
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	/**
	 * 获取：关键字
	 */
	public String getKeyWord() {
		return keyWord;
	}
	/**
	 * 设置：消息类型
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	/**
	 * 获取：消息类型
	 */
	public String getMsgType() {
		return msgType;
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
