package cn.com.yuanwei.center.enums;

/**
 * Title:IsSeedEnum
 * Desc:是否培育企业
 * @author zbk
 * @date 2017-06-01 17:42:25
 */
public enum IsSeedEnum {
	fou(0, "否"),
    shi(1, "是");
	private Integer code;
	private String desc;
	
	IsSeedEnum(Integer code, String desc) {
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
        for (IsSeedEnum c : IsSeedEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
