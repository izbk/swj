package cn.com.yuanwei.center.enums;

/**
 * Title:PointTypeEnum
 * Desc:得分类型
 * @author zbk
 * @date 2017-06-15 15:17:36
 */
public enum PointTypeEnum {
	koufen(0, "扣分"),
    jiafen(1, "加分");
	private Integer code;
	private String desc;
	
	PointTypeEnum(Integer code, String desc) {
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
        for (PointTypeEnum c : PointTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
