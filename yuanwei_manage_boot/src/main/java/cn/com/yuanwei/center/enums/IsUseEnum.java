package cn.com.yuanwei.center.enums;

/**
 * Title:IsUseEnum
 * Desc:是否投入使用(0:否 1:是)
 * @author zbk
 * @date 2017-06-01 15:17:00
 */
public enum IsUseEnum {
	fou(0, "否"),
    shi(1, "是");
	private Integer code;
	private String desc;
	
	IsUseEnum(Integer code, String desc) {
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
        for (IsUseEnum c : IsUseEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
