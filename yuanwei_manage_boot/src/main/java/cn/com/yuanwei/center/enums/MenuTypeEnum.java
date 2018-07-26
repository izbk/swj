package cn.com.yuanwei.center.enums;

/**
 * Title:TypeEnum
 * Desc:菜单类型
 * @author zbk
 * @date 2017-06-08 15:38:21
 */
public enum MenuTypeEnum {
	click("click", "click类型"),
    view("view", "view类型");
	private String code;
	private String desc;
	
	MenuTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	 // 普通方法  
    public static String getDesc(String code) {  
        for (MenuTypeEnum c : MenuTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
