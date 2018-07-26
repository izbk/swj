package cn.com.yuanwei.center.enums;

/**
 * Title:InWayEnum
 * Desc:入库方式(0:年审入库)
 * @author zbk
 * @date 2017-06-16 14:55:57
 */
public enum InWayEnum {
    nianshenruku(0, "年审入库");
	private Integer code;
	private String desc;
	
	InWayEnum(Integer code, String desc) {
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
        for (InWayEnum c : InWayEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
