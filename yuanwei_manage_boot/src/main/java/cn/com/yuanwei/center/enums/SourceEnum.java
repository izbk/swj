package cn.com.yuanwei.center.enums;

/**
 * Title:SourceEnum
 * Desc:用户来源
 * @author sky
 * @date 2017年2月27日  上午11:19:15
 */
public enum SourceEnum {
	site(0, "网站"),
	android(1, "android"),
	ios(2, "ios"),
	gongzhong(3, "公众号"),
	xiaochengxu(4, "小程序"),
	manage(5,"mag");
	private Integer code;
	private String desc;
	
	SourceEnum(Integer code, String desc) {
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
        for (SourceEnum c : SourceEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
