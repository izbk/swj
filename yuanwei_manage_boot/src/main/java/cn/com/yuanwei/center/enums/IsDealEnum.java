package cn.com.yuanwei.center.enums;

/**
 * Title:IsDealEnum
 * Desc:处理状态
 * @author zbk
 * @date 2017-05-26 15:48:15
 */
public enum IsDealEnum {
	fou(0, "否"),
    shi(1, "是");
	private Integer code;
	private String desc;
	
	IsDealEnum(Integer code, String desc) {
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
        for (IsDealEnum c : IsDealEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
