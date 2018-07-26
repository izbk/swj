package cn.com.yuanwei.center.enums;

/**
 * Title:AgentEnum
 * Desc:是否代报
 * @author zbk
 * @date 2017-06-16 14:55:57
 */
public enum AgentEnum {
	fou(0, "否"),
    shi(1, "是");
	private Integer code;
	private String desc;
	
	AgentEnum(Integer code, String desc) {
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
        for (AgentEnum c : AgentEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
