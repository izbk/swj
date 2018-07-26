package cn.com.yuanwei.center.enums;

/**
 * Title:AdviceTypeEnum
 * Desc:意见类型
 * @author zbk
 * @date 2017-06-06 17:56:58
 */
public enum AdviceTypeEnum {
	zixun(0, "咨询"),
	qiuzhu(1, "求助"),
	yijianjianyi(2, "意见建议"),
	tousujubao(3, "投诉举报"),
    biaoyang(4, "表扬");
	private Integer code;
	private String desc;
	
	AdviceTypeEnum(Integer code, String desc) {
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
        for (AdviceTypeEnum c : AdviceTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
