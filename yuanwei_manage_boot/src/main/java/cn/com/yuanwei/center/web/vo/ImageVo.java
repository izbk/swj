package cn.com.yuanwei.center.web.vo;

import java.io.Serializable;

public class ImageVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String url;
	
	private String img;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
