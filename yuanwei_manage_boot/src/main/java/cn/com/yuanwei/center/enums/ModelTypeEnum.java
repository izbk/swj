package cn.com.yuanwei.center.enums;

/**
 * Title:ModelTypeEnum
 * Desc:样本企业类型
 * @author zbk
 * @date 2017-08-22 09:19:28
 */
public enum ModelTypeEnum {
	shenghuobixupinjiance(0, "生活必需品监测"),
    shengchanziliaojiance(1, "生产资料监测");
	private Integer code;
	private String desc;
	
	ModelTypeEnum(Integer code, String desc) {
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
        for (ModelTypeEnum c : ModelTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
