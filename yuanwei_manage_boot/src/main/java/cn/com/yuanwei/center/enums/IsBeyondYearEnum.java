package cn.com.yuanwei.center.enums;

/**
 * Title:IsBeyondYearEnum
 * Desc:是否跨年度(0:否 1:是)
 * @author zbk
 * @date 2017-06-01 15:17:00
 */
public enum IsBeyondYearEnum {
	fou(0, "否"),
    shi(1, "是");
	private Integer code;
	private String desc;
	
	IsBeyondYearEnum(Integer code, String desc) {
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
        for (IsBeyondYearEnum c : IsBeyondYearEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
