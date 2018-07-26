package cn.com.yuanwei.center.enums;

/**
 * Title:SettledPlatformEnum
 * Desc:已入驻平台
 * @author zbk
 * @date 2017-07-03 17:59:11
 */
public enum SettledPlatformEnum {
	taobao(0, "淘宝"),
	tianmao(1, "天猫"),
	jingdong(2, "京东"),
	suning(3, "苏宁"),
	weishang(4, "微商"),
	alibaba(5, "阿里巴巴"),
	weiruzhu(6, "未入驻"),
    qitapingtai(7, "其它平台");
	private Integer code;
	private String desc;
	
	SettledPlatformEnum(Integer code, String desc) {
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
        for (SettledPlatformEnum c : SettledPlatformEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
