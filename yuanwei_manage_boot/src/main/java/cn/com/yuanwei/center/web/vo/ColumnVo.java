package cn.com.yuanwei.center.web.vo;

import java.io.Serializable;
import java.util.List;

public class ColumnVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 自增id */
	private java.lang.Integer id = 0;
	/** 名称 */
	private java.lang.String name;
	/** 链接图片 */
	private java.lang.String hrefPic;
	/** 栏目类型 */
	private Short resType;
	/** 栏目值 */
	private java.lang.String resValue;
	/** 链接地址 */
	private java.lang.String href;
	/** 数据 */
	private Object data;
	public List<ColumnVo> child;

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getHrefPic() {
		return hrefPic;
	}

	public void setHrefPic(java.lang.String hrefPic) {
		this.hrefPic = hrefPic;
	}

	public java.lang.String getResValue() {
		return resValue;
	}

	public void setResValue(java.lang.String resValue) {
		this.resValue = resValue;
	}

	public java.lang.String getHref() {
		return href;
	}

	public void setHref(java.lang.String href) {
		this.href = href;
	}

	public java.util.List<ColumnVo> getChild() {
		return child;
	}

	public void setChild(java.util.List<ColumnVo> child) {
		this.child = child;
	}

	public Short getResType() {
		return resType;
	}

	public void setResType(Short resType) {
		this.resType = resType;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}