package cn.com.yuanwei.center.enums;

/**
 * Title:AccountTypeEnum
 * Desc:用户角色类型
 * @author zbk
 * @date 2017-05-23 16:13:36
 */
public enum RoleTypeEnum {
	normal(0, "普通会员"),
	admin(1, "管理员"),
    service(2, "服务业"),
	statistician(3,"统计员"),
	subservice(4,"重点服务业"),
	shbxpjc(27,"生活必需品监测"),
	zysczljc(28,"重要生产资料监测");
	private Integer code;
	private String desc;
	
	RoleTypeEnum(Integer code, String desc) {
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
        for (RoleTypeEnum c : RoleTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
