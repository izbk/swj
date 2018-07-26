package cn.com.yuanwei.center.enums;

/**
 * Title:AuditStatusEnum
 * Desc:状态 (0:未审核 1:已审核 2:审核不通过 )
 * @author zbk
 * @date 2017-05-26 15:48:15
 */
public enum AuditStatusEnum {
	weishenhe(0, "未审核"),
	yishenhe(1, "已审核"),
    shenhebutongguo(2, "审核不通过");
	private Integer code;
	private String desc;
	
	AuditStatusEnum(Integer code, String desc) {
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
        for (AuditStatusEnum c : AuditStatusEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
