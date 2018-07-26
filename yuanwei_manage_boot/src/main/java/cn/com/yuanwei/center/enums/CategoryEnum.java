package cn.com.yuanwei.center.enums;

/**
 * Title:CategoryEnum
 * Desc:所属品类
 * @author zbk
 * @date 2017-05-26 15:48:16
 */
public enum CategoryEnum {
	dianzishangwu(0, "电子商务"),
	wuliu(1, "物流"),
	shichang(2, "市场"),
	zongheti(3, "综合体"),
	shangyesheshishengjigaizao(4, "商业设施升级改造"),
	kuodaxiaofeihuodong(5, "扩大消费活动"),
	pinpaichuangjianjituiguang(6, "品牌创建及推广"),
	jiazhengfuwu(7, "家政服务"),
	jiankangyanglao(8, "健康养老"),
    wenhualvyou(9, "文化旅游");
	private Integer code;
	private String desc;
	
	CategoryEnum(Integer code, String desc) {
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
        for (CategoryEnum c : CategoryEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
