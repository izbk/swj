package cn.com.yuanwei.center.enums;

/**
 * Title:InTypeEnum
 * Desc:入库类型（0:已入库 1:新增入库 2:未入库 3:已出库 4:破产吊销出库）
 * @author zbk
 * @date 2017-06-16 14:55:57
 */
public enum InTypeEnum {
	yiruku(0, "已入库"),
	xinzengruku(1, "新增入库"),
	weiruku(2, "未入库"),
	yichuku(3, "已出库"),
    pochandiaoxiaochuku(4, "破产吊销出库");
	private Integer code;
	private String desc;
	
	InTypeEnum(Integer code, String desc) {
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
        for (InTypeEnum c : InTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
