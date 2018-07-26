package cn.com.yuanwei.center.enums;

/**
 * Title:CompanyTypeEnum
 * Desc:企业类型
 * @author zbk
 * @date 2017-07-03 17:59:11
 */
public enum CompanyTypeEnum {
	shitishangpinjiaoyidianshang(0, "实体商品交易电商"),
	dianshangfuwu(1, "电商服务"),
	ziyingpingtai(2, "自营平台"),
	dailipingtai(3, "代理平台"),
	weishang(4, "微商"),
	xinmeiti(5, "新媒体"),
	ruanjiankaifa(6, "软件开发"),
    xunichanpinjiaoyidianshang(7, "虚拟产品交易电商");
	private Integer code;
	private String desc;
	
	CompanyTypeEnum(Integer code, String desc) {
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
        for (CompanyTypeEnum c : CompanyTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
