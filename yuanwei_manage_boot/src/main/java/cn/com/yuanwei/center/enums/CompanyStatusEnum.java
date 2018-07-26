package cn.com.yuanwei.center.enums;

/**
 * Title:CompanyStatusEnum
 * Desc:状态
 * @author zbk
 * @date 2017-07-04 17:09:31
 */
public enum CompanyStatusEnum {
	yiruyuan(0, "已入园"),
    yichuyuan(1, "已出园");
	private Integer code;
	private String desc;
	
	CompanyStatusEnum(Integer code, String desc) {
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
        for (CompanyStatusEnum c : CompanyStatusEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
