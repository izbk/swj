package cn.com.yuanwei.center.web.vo;

import java.io.Serializable;

public class ArticleVo implements Serializable {

    private String src;

    private String title;

    private String desc;

    private String url;

    private static final long serialVersionUID = 1L;

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

 
}