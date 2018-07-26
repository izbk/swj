package cn.com.yuanwei.center.enums;

/**
 * Title:NoticeTypeEnum
 * Desc:通知类型
 * @author zbk
 * @date 2017-06-05 16:18:40
 */
public enum NoticeTypeEnum {
	xianshangqiyetongzhi(0, "限上企业通知"),
	fuwuyeqiyetongzhi(1, "服务业企业通知"),
    qiyezhengcetongzhi(2, "企业政策通知");
	private Integer code;
	private String desc;
	
	NoticeTypeEnum(Integer code, String desc) {
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
        for (NoticeTypeEnum c : NoticeTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
