package cn.com.yuanwei.center.enums;

/**
 * Title:PayStatusEnum
 * Desc:拨付状态（0：未拨付 1：已拨付）
 * @author zbk
 * @date 2017-05-26 15:48:16
 */
public enum PayStatusEnum {
	weibofu(0, "未拨付"),
    yibofu(1, "已拨付");
	private Integer code;
	private String desc;
	
	PayStatusEnum(Integer code, String desc) {
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
        for (PayStatusEnum c : PayStatusEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
