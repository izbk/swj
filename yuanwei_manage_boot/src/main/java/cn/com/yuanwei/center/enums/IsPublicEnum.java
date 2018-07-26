package cn.com.yuanwei.center.enums;

/**
 * Title:IsPublicEnum
 * Desc:是否公开
 * @author zbk
 * @date 2017-05-22 11:54:22
 */
public enum IsPublicEnum {
	fou(0, "否"),
    shi(1, "是");
	private Integer code;
	private String desc;
	
	IsPublicEnum(Integer code, String desc) {
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
        for (IsPublicEnum c : IsPublicEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
