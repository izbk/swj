package cn.com.yuanwei.center.enums;

/**
 * Title:EquipmentSourceEnum
 * Desc:设备来源
 * @author zbk
 * @date 2017-07-03 17:59:11
 */
public enum EquipmentSourceEnum {
	zigou(0, "自购"),
	zulin(1, "租赁"),
    qita(2, "其它");
	private Integer code;
	private String desc;
	
	EquipmentSourceEnum(Integer code, String desc) {
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
        for (EquipmentSourceEnum c : EquipmentSourceEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
