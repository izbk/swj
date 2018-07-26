package cn.com.yuanwei.center.enums;

/**
 * Title:BuildStatusEnum
 * Desc:建设状态
 * @author zbk
 * @date 2017-06-01 15:17:00
 */
public enum BuildStatusEnum {
	nijian(0, "拟建"),
	zaijian(1, "在建"),
    wangong(2, "完工");
	private Integer code;
	private String desc;
	
	BuildStatusEnum(Integer code, String desc) {
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
        for (BuildStatusEnum c : BuildStatusEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
