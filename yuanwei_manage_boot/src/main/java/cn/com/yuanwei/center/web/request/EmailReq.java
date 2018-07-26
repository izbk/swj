package cn.com.yuanwei.center.web.request;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class EmailReq implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String content;

	private Date createTime;

	private String emailType;

	private short isReply;

	private short isShow;

	private String replyContent;

	private String replyName;

	private Date replyTime;

	private String sendAddr;

	private String sendEmail;

	private String sendName;

	private String sendTel;

	private String title;

	private BigInteger viewNum;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public short getIsReply() {
		return isReply;
	}

	public void setIsReply(short isReply) {
		this.isReply = isReply;
	}

	public short getIsShow() {
		return isShow;
	}

	public void setIsShow(short isShow) {
		this.isShow = isShow;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public String getSendAddr() {
		return sendAddr;
	}

	public void setSendAddr(String sendAddr) {
		this.sendAddr = sendAddr;
	}

	public String getSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(String sendEmail) {
		this.sendEmail = sendEmail;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getSendTel() {
		return sendTel;
	}

	public void setSendTel(String sendTel) {
		this.sendTel = sendTel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigInteger getViewNum() {
		return viewNum;
	}

	public void setViewNum(BigInteger viewNum) {
		this.viewNum = viewNum;
	}
}
