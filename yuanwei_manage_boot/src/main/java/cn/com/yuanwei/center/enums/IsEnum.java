package cn.com.yuanwei.center.enums;

/**
 * 是否枚举
 * @author sky
 *
 */
public enum IsEnum {
	no(0, "否"),
	yes(1, "是");
	
	private Integer code;
	private String desc;
	
	IsEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
