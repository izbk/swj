package cn.com.yuanwei.center.enums;

/**
 * Title:IndustryTypeEnum
 * Desc:行业类型
 * @author zbk
 * @date 2017-06-01 17:42:25
 */
public enum IndustryTypeEnum {
	pifa(0, "批发"),
	lingshou(1, "零售"),
	nongyefuwu(10, "农业服务"),
	zhongjiefuwu(11, "中介服务"),
	jinrongfuwu(12, "金融服务"),
	dianzishangwu(13, "电子商务"),
	yunshuwuliu(14, "运输物流"),
	zhusu(2, "住宿"),
	canyin(3, "餐饮"),
	wenhua(4, "文化"),
	lvyou(5, "旅游"),
	jiaoyu(6, "教育"),
	yiliao(7, "医疗"),
	jiankangyanglao(8, "健康养老"),
    jiazhengfuwu(9, "家政服务");
	private Integer code;
	private String desc;
	
	IndustryTypeEnum(Integer code, String desc) {
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
        for (IndustryTypeEnum c : IndustryTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
