package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;


/**
 * 自动回复
 * 
 * @author zbk
 * @date 2017-06-05 11:09:43
 */
public class WeixinAutoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//关键字
	 @Excel(name = "关键字",isImportField="true")
	private String keyWord;
	//消息类型
	 @Excel(name = "消息类型",replace={"推送_event","图片_image","链接_link","位置_location","图文_news","小视频_shortvideo","文本_text","视频_video","音频_voice"},isImportField="true")
	private String msgType;
	//回复内容
	 @Excel(name = "回复内容",isImportField="true")
	private String resContent;
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
