package cn.com.yuanwei.center.enums;

/**
 * Title:EnterpriseTypeEnum
 * Desc:企业类型（0:法人 1:个体）
 * @author zbk
 * @date 2017-06-16 14:55:57
 */
public enum EnterpriseTypeEnum {
	faren(0, "法人"),
	geti(1, "个体"),
    gongshangweizhuce(2, "工商未注册");
	private Integer code;
	private String desc;
	
	EnterpriseTypeEnum(Integer code, String desc) {
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
        for (EnterpriseTypeEnum c : EnterpriseTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
