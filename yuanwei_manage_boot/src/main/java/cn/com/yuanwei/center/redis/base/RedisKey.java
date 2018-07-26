package cn.com.yuanwei.center.redis.base;

public class RedisKey {
	/**
	 * redis基础key
	 */
	private static final String BaseKey = "Redis";
	
	/**
	 * redis在线用户的key
	 */
	public static final String OnLineUserKey = BaseKey+".onLineUser";
	
	/**
	 * redis在线管理用户的key
	 */
	public static final String OnLineMagUserKey = BaseKey+".onLineMagUser";
	
	/**
	 * redis移动端在线用户的key
	 */
	public static final String OnLineAppUserKey = BaseKey+".onLineAppUser";
	
	/**
	 * 手机注册验证码
	 */
	public static final String PhoneRegAuthCodeKey = BaseKey+".regAuthCodeKey";
	
	/**
	 * 邮件注册验证码
	 */
	public static final String EmailRegAuthCodeKey = BaseKey+".emailAuthCodeKey";

	/**
	 * 绑定手机验证码 
	 */
	public static final String BINGING = BaseKey+".BindIng";

	/**
	 * 修改绑定手机号 
	 */
	public static final String CHANGE = BaseKey+".Change";
	
	
}
