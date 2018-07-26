package cn.com.yuanwei.center.enums;

/**
 * Title:BusiTypeEnum
 * Desc:业务类型
 * @author zbk
 * @date 2017-05-22 11:54:20
 */
public enum BusiTypeEnum {
	wenzhang(0, "文章"),
	xiangmu(1, "项目"),
	mianzhuzao(2, "绵竹造"),
    tousujianyi(3, "投诉建议"),
	qiyebeian(4, "企业备案");
	private Integer code;
	private String desc;
	
	BusiTypeEnum(Integer code, String desc) {
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
        for (BusiTypeEnum c : BusiTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
