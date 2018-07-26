package cn.com.yuanwei.center.enums;

/**
 * Title:MsgTypeEnum
 * Desc:消息类型
 * @author zbk
 * @date 2017-05-23 16:13:34
 */
public enum MsgTypeEnum {
	EVENT("event", "推送"),
	IMAGE("image", "图片"),
	LINK("link", "链接"),
	LOCATION("location", "位置"),
	NEWS("news", "图文"),
	SHOETVIDEO("shortvideo", "小视频"),
	TEXT("text", "文本"),
	VIDEO("video", "视频"),
    VOICE("voice", "音频");
	private String code;
	private String desc;
	
	MsgTypeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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
        for (MsgTypeEnum c : MsgTypeEnum.values()) {  
            if (c.getCode().equals(code)) {  
                return c.desc;  
            }  
        }  
        return null;  
    } 
}
