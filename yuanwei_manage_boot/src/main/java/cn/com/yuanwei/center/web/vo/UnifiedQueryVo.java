package cn.com.yuanwei.center.web.vo;

import java.io.Serializable;

public class UnifiedQueryVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String busiType;
	
	private String status;
	
	private String content;
	
	private String resContent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResContent() {
		return resContent;
	}

	public void setResContent(String resContent) {
		this.resContent = resContent;
	}

	public UnifiedQueryVo() {
		super();
	}

	public UnifiedQueryVo(String name, String busiType, String status) {
		super();
		this.name = name;
		this.busiType = busiType;
		this.status = status;
	}
	
	public UnifiedQueryVo(String name, String busiType, String status, String content, String resContent) {
		super();
		this.name = name;
		this.busiType = busiType;
		this.status = status;
		this.content = content;
		this.resContent = resContent;
	}

}
