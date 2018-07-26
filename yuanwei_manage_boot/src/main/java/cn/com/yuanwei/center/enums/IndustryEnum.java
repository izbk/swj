package cn.com.yuanwei.center.enums;

/**
 * Title:IndustryEnum
 * Desc:业态（0:批发 1:零售 2:餐饮 3:住宿 ）
 * @author zbk
 * @date 2017-06-16 14:55:57
 */
public enum IndustryEnum {
	pifa(0, "批发"),
	lingshou(1, "零售"),
	canyin(2, "餐饮"),
    zhusu(3, "住宿");
	private Integer code;
	private String desc;
	
	IndustryEnum(Integer code, String desc) {
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
        for (IndustryEnum c : IndustryEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
