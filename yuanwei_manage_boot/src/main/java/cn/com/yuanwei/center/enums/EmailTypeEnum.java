package cn.com.yuanwei.center.enums;

/**
 * 帖子资源类型
 * @author zbk
 *
 */
public enum EmailTypeEnum {
	message("1", "普通留言"),
	complain("2", "投诉"),
	advice("3", "建议");
	
	private String code;
	private String desc;
	
	EmailTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
