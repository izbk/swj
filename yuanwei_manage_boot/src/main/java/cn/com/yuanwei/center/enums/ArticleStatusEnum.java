package cn.com.yuanwei.center.enums;

/**
 * Title:ArticleStatusEnum
 * Desc:状态 (0:草稿 1:未审核 2:已审核 3:审核不通过)
 * @author zbk
 * @date 2017-05-22 11:54:22
 */
public enum ArticleStatusEnum {
	caogao(0, "草稿"),
	weishenhe(1, "未审核"),
	yishenhe(2, "已审核"),
    shenhebutongguo(3, "审核不通过");
	private Integer code;
	private String desc;
	
	ArticleStatusEnum(Integer code, String desc) {
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
        for (ArticleStatusEnum c : ArticleStatusEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
