package cn.com.yuanwei.center.enums;

/**
 * Title:ResTypeEnum
 * Desc:资源类型（1-栏目 2-文章 3-图片 4-链接）
 * @author zbk
 * @date 2017-05-22 11:54:20
 */
public enum ResTypeEnum {
	lanmu(1, "栏目"),
	wenzhang(2, "文章"),
	tupian(3, "图片"),
    lianjie(4, "链接"),
    fuwenben(5,"富文本"),
    mianzhuzao(6,"绵竹造");
	private Integer code;
	private String desc;
	
	ResTypeEnum(Integer code, String desc) {
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
        for (ResTypeEnum c : ResTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
