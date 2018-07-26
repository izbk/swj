package cn.com.yuanwei.center.enums;

/**
 * Title:OutWayEnum
 * Desc:出库方式（0: 正常出库 1:破产吊销）
 * @author zbk
 * @date 2017-06-16 14:55:57
 */
public enum OutWayEnum {
	zhengchangchuku(0, "正常出库"),
    pochandiaoxiao(1, "破产吊销");
	private Integer code;
	private String desc;
	
	OutWayEnum(Integer code, String desc) {
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
        for (OutWayEnum c : OutWayEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
