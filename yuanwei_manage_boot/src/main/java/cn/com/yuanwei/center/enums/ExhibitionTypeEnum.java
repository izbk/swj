package cn.com.yuanwei.center.enums;

/**
 * Title:ExhibitionTypeEnum
 * Desc:会展类别
 * @author zbk
 * @date 2017-07-03 15:37:09
 */
public enum ExhibitionTypeEnum {
	wanqichuguomen(0, "万企出国门"),
	chuanhuoquanguoxing(1, "川货全国行"),
    huimingouwuquanchuanxing(2, "惠民购物全川行");
	private Integer code;
	private String desc;
	
	ExhibitionTypeEnum(Integer code, String desc) {
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
        for (ExhibitionTypeEnum c : ExhibitionTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
