package cn.com.yuanwei.center.enums;

/**
 * Title:AccountTypeEnum
 * Desc:公众号类型
 * @author zbk
 * @date 2017-05-23 16:13:36
 */
public enum AccountTypeEnum {
	dingyuehao(0, "订阅号"),
	fuwuhao(1, "服务号"),
    xiaochengxu(2, "小程序");
	private Integer code;
	private String desc;
	
	AccountTypeEnum(Integer code, String desc) {
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
        for (AccountTypeEnum c : AccountTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
