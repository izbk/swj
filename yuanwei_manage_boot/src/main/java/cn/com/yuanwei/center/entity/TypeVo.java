package cn.com.yuanwei.center.entity;

import java.io.Serializable;

public class TypeVo implements Serializable {

    private String label;

    private Object value;

    private static final long serialVersionUID = 1L;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}