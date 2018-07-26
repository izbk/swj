package cn.com.yuanwei.center.enums;

/**
 * Title:ApproveStatusEnum
 * Desc:审核状态（0:未审核 1:已审核）
 * @author zbk
 * @date 2017-05-26 15:48:16
 */
public enum ApproveStatusEnum {
	weishenhe(0, "未审核"),
    yishenhe(1, "已审核");
	private Integer code;
	private String desc;
	
	ApproveStatusEnum(Integer code, String desc) {
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
        for (ApproveStatusEnum c : ApproveStatusEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
