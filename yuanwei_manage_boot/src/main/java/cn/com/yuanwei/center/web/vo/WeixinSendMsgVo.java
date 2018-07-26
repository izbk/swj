package cn.com.yuanwei.center.web.vo;

import java.io.Serializable;
import java.util.List;

public class WeixinSendMsgVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> openIds;
	
	private List<Integer> userIds;
	
	private String content;
	
	private Integer templateId;

	public List<String> getOpenIds() {
		return openIds;
	}

	public void setOpenIds(List<String> openIds) {
		this.openIds = openIds;
	}

	public List<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public WeixinSendMsgVo() {
		super();
	}

	public WeixinSendMsgVo(List<String> openIds, Integer templateId) {
		super();
		this.openIds = openIds;
		this.templateId = templateId;
	}

	public WeixinSendMsgVo(List<String> openIds, String content, Integer templateId) {
		super();
		this.openIds = openIds;
		this.content = content;
		this.templateId = templateId;
	}

}
