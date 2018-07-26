
package cn.com.yuanwei.center.enums;

/**
 * 返回信息错误编码枚举定义
 * 
 * @author hejiadong
 *
 */
/**
 * 
    * @ClassName: ReturnInfoEnum
    * @Description: 错误代码定义
    * @author 斌可
    * @date 2016年8月15日
    * 编码规则：
    * 000000 成功
    * 01xxxx  通用错误
    * 02xxxx 登录验证错误
    * 03xxxx 个人信息设置错误
    * 04xxxx 下单及支付错误
    * ...
    * 999999 系统忙
    *
 */
public enum ReturnInfoEnum {
	/**
	 * 成功
	 */
	Success("000000", "成功"),
	/**
	 * 失败
	 */
	Fail("000001", "失败"),
	
	/**
	 * 参数缺失或格式错误
	 */
	ParamError("010001", "参数缺失或格式错误"),
	/**
	 * token认证失败
	 */
	TokenError("010002", "token认证失败"),
	/**
	 * sid登录会话超时
	 */
	SidError("010003", "登录会话超时"),
	/**
	 * 服务不存在
	 */
	ServiceNotFound("010004", "服务不存在"),
	/**
	 * 业务异常
	 */
	ServiceFail("010005","业务发生异常"),
	/**
	 * 数据不存在
	 */
	DataNotExists("010006", "数据不存在"),
	/**
	 * redis保存会话
	 */
	RedisSaveFail("010007", "会话保存失败"),
	/**
	 * redis删除会话
	 */
	RedisDelFail("010008", "会话删除失败"),
    /**
     * 发送短信异常
     */
	SMSError("010009", "运营商发送短信出现异常"),
	/**
	 * 短信次数限制
	 */
	OutOfLimit("010010", "短信超出获取次数"),
	/**
	 * 您已经点过赞了，不能再次点赞
	 */
	LikeAlreadyClick("010011", "您已经点过赞了，不能再次点赞"),
	/**
	 * redis保存会话 by yujuncai
	 */
	OnlyMoblie("010012", "暂时只是手机登录"),
	/**
	 * source来源异常
	 */
	SourceError("010013", "source来源异常"),
	/**
	 * 您已经点过赞了，不能再次点赞
	 */
	ShareCodeError("010014", "邀请码错误！"),
	/**
	 * 该商品已经添加到购物车！
	 */
	addCartExist("010015", "该商品已经添加到购物车！"),
	/**
	 * 访问接口频率超限
	 */
	ACCESS_TOO_FAST("010016", "访问接口频率超限"),
	/**
	 * 该手机号已被注册
	 */
	MobilePhoneHasRegister("020001", "该手机号已被注册"),
	/**
	 * 该邮箱已被注册
	 */
	EmailHasRegister("020002", "该邮箱已被注册"),
	/**
	 * 该用户名已被注册
	 */
	LoginNameHasRegister("020003", "该用户名已被注册"),
	/**
	 * 短信验证码错误
	 */
	SMSAuthcodeErr("020004", "短信验证码错误"),
	/**
	 * 新密码1与2不一致
	 */
	PwdNewNotEqu("020005", "新密码1与2不一致"),
	/**
	 * 原密码错误
	 */
	PwdOldErr("020006", "原密码错误"),
	/**
	 * 新密码与老密码不能相同
	 */
	PwdNewOldEqu("020007", "新密码与老密码不能相同"),
	/**
	 * 用户名不存在
	 */
	PwdErr("020008", "用户名不存在"),	
	/**
	 * 登录密码错误
	 */
	pwdError("020009", "登录密码错误"),
	/**
	 * 验证码错误
	 */
	authCodeError("020010", "验证码错误"),
	/**
	 * 第三方登陆失败
	 */
	ThirdPartyLogin("020011", "第三方登陆失败！"),
	/**
	 * 用户名或密码错误
	 */
	LoginFail("020012", "用户名或密码错误！"),

	
	/**
	 * 设置头像失败
	 */
	SetIconErr("030001", "设置头像失败"),
	/**
	 * 重复关注或者收藏
	 */
	Duplicate("030002", "重复关注或者收藏"),
	/**
	 * 您已经赞过了
	 */
	Good("030003", "您已经赞过了"),
	/**
	 * 无权限
	 */
	AuthorityFail("030004", "无权限"),
	/**
	 * 还未注册
	 */
	RegError("030005", "还未注册"),
	/**
	 * 变更角色失败，你已经是该角色了！
	 */
	RoleEquals("030006", "变更角色失败，你已经是该角色了！"),
	
	/**
	 * 消费码不正确
	 */
	AttendCodeFail("040001", "消费码不正确"),
	/**
	 * 支付验证key错误
	 */
	PayKeyFail("040002", "支付验证key错误"),
	/**
	 * 支付密码错误
	 */
	payPwdError("040003", "支付密码错误"),
	/**
	 * 用户积分不够支付
	 */
	PayVCFail("040004", "用户积分不够支付"),
	/**
	 * 取消订单失败
	 */
	OrderCancelFail("040005", "取消订单失败"),
	/**
	 * 手机号与账户手机不一致
	 */
	moblieNotEeq("040006", "手机号与账户手机不一致"),
	
	/**
	 * 退款失败
	 */
	refundFail("040007", "退款失败"),
	
	UnableBuyDel("010017", "该商品处于删除状态，无法购买"),
	
	/**
	 * 系统忙
	 */
	UnknownError("999999", "系统忙");
	
	
	
	

	private String code;

	private String desc;


	ReturnInfoEnum(String code, String desc) {

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

}
