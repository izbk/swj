package cn.com.yuanwei.center.redis.service.impl;

import java.io.UnsupportedEncodingException;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Service;

import cn.com.yuanwei.center.redis.base.AbstractBaseRedisDao;
import cn.com.yuanwei.center.redis.base.RedisExpire;
import cn.com.yuanwei.center.redis.base.RedisKey;
import cn.com.yuanwei.center.util.PaaswordUtil;

/**
 * 
 * Title:AuthCodeService
 * Desc:验证码服务类
 * @author sky
 * @date 2017年2月27日  下午3:41:25
 */
@Service
public class AuthCodeService extends AbstractBaseRedisDao<String, String>{

	private int pwdLength = 4;
	
	private int dbIndex = 5;

	/**
	 * 获取验证码并放入redis
	 * 
	 * @param keyword
	 *            手机号获取其他唯一关键字
	 * @return
	 */
	public String getAuthCode(String keyword, String type) throws Exception {
		final String pwd = PaaswordUtil.genNumPwd(pwdLength).toUpperCase();

		final String key = getRedisKey(type + "." + keyword);

		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.select(dbIndex);
				connection.set(key.getBytes(), pwd.getBytes());
				connection.expire(key.getBytes(), RedisExpire.FiveMinuteSecend);
				return pwd;
			}
		});

		return pwd;
	}

	/**
	 * 获取redis的key
	 * 
	 * @param keyword
	 * @return
	 */
	public String getRedisKey(String keyword) {
		return RedisKey.PhoneRegAuthCodeKey + "." + keyword;
	}

	public boolean getAuthCodeIsExest(String keyword, String type)
			throws Exception {
		final String key = getRedisKey(type + "." + keyword);
		Boolean flag = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.select(dbIndex);
				byte[] bs = connection.get(key.getBytes());
				if (bs != null && bs.length > 0) {
					return true;
				}
				return false;
			}
		});

		return flag;
	}

	/**
	 * 检验验证码是否正确！ 正确返回真，错误或者已失效返回假
	 * 
	 * @param keyword
	 *            手机号获取其他唯一标示
	 * @param authCode
	 *            验证码
	 * @return
	 */
	public boolean verifyAuthCode(final String keyword, final String authCode,
			final String type) {
		if (keyword != null && keyword.trim().length() > 0) {
			Boolean flaBoolean = redisTemplate
					.execute(new RedisCallback<Boolean>() {
						public Boolean doInRedis(RedisConnection connection)
								throws DataAccessException {
							connection.select(dbIndex);
							String key = getRedisKey(type + "." + keyword);
							byte[] sysAuthcode = connection.get(key.getBytes());
							if (sysAuthcode != null && sysAuthcode.length > 0) {

								String s;
								try {
									s = new String(sysAuthcode, "utf-8");
									if (s.toLowerCase().equals(
											authCode.toLowerCase()))
										return true;
								} catch (UnsupportedEncodingException e) {
									e.printStackTrace();
								}

							}
							return false;
						}
					});
			return flaBoolean;
		} else {
			return false;
		}

	}

	public int getPwdLength() {
		return pwdLength;
	}

	public void setPwdLength(int pwdLength) {
		this.pwdLength = pwdLength;
	}

}
