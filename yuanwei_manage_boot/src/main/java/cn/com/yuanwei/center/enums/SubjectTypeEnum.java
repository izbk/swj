package cn.com.yuanwei.center.enums;

/**
 * Title:SubjectTypeEnum
 * Desc:主体类型
 * @author zbk
 * @date 2017-05-26 15:48:16
 */
public enum SubjectTypeEnum {
	faren(0, "法人"),
	geti(1, "个体"),
    gongshangweizhuce(2, "工商未注册");
	private Integer code;
	private String desc;
	
	SubjectTypeEnum(Integer code, String desc) {
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
	
	 // 普通方法  
    public static String getDesc(Integer code) {  
        for (SubjectTypeEnum c : SubjectTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
