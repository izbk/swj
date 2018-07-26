package cn.com.yuanwei.center.redis.service.impl;


import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import cn.com.yuanwei.center.redis.base.AbstractBaseRedisDao;
import cn.com.yuanwei.center.redis.base.RedisExpire;
import cn.com.yuanwei.center.redis.base.RedisKey;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
public class OnLineService extends AbstractBaseRedisDao<String, String> {
	private int dbIndex = 5;

	/**
	 * 添加在线用户
	 * 
	 * @param sid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean add(final String sid, final UserInfo user,
			final String source) throws Exception {
		if (user != null && sid.trim().length() > 0) {
			final String key = getKeyBySource(source, sid);
			Boolean falg = redisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection)
						throws DataAccessException {
					connection.select(dbIndex);
					@SuppressWarnings("unchecked")
					RedisSerializer<UserInfo> valueSerializer = (RedisSerializer<UserInfo>) redisTemplate
							.getValueSerializer();

					connection.set(key.getBytes(),
							valueSerializer.serialize(user));
					if (source.equals("android") || source.equals("ios")) {
						connection.expire(key.getBytes(),
								RedisExpire.OneMonthSecend);
					} else {
						connection.expire(key.getBytes(),
								RedisExpire.ThreeHourSecend);
					}

					return true;
				}
			});

			return falg;
		}
		return false;
	}

	/**
	 * 获取在线用户信息
	 * 
	 * @param sid
	 * @return
	 * @throws Exception
	 */
	public UserInfo get(String voucher, final String source) throws Exception {
		final String key = getKeyBySource(source, voucher);
		UserInfo userInfo = redisTemplate
				.execute(new RedisCallback<UserInfo>() {
					@SuppressWarnings("unchecked")
					public UserInfo doInRedis(RedisConnection connection)
							throws DataAccessException {
						connection.select(dbIndex);
						RedisSerializer<UserInfo> valueSerializer = (RedisSerializer<UserInfo>) redisTemplate
								.getValueSerializer();
						UserInfo userinfo = (UserInfo) valueSerializer
								.deserialize(connection.get(key.getBytes()));
						if (userinfo != null) {
							// 如果用户已登录，则增加在线时间
							if (source.equals("android")
									|| source.equals("ios")) {
								// connection.expire(key.getBytes(),
								// RedisExpire.OneMonthSecend); 不做时间推迟
							} else {
								connection.expire(key.getBytes(),
										RedisExpire.ThreeHourSecend);
							}
							return userinfo;
						}

						return null;
					}
				});
		return userInfo;
	}
	
	/**
	 * 移除在线登陆用户
	 * 
	 * @param sid
	 * @return
	 * @throws Exception
	 */
	public boolean remove(final String voucher, final String source)
			throws Exception {
		if (voucher != null) {
			final String key = getKeyBySource(source, voucher);
			Boolean falg = redisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection)
						throws DataAccessException {
					connection.select(dbIndex);
					connection.expire(key.getBytes(), 0);
					return true;
				}
			});

			return falg;
		}
		return false;
	}
	/**
	 * Desc:获取redis key
	 * @param @param source
	 * @param @param voucher
	 * @param @return
	 * @return String
	 * @author sky
	 * @date 2017年2月28日  下午3:02:04
	 */
	private String getKeyBySource(final String source, final String voucher) {
		String key = RedisKey.OnLineUserKey + "." + voucher;// 默认为网站用户
		if (source.equals("mag")) {
			key = RedisKey.OnLineMagUserKey + "." + voucher;// app客户端
		}
		return key;
	}
	
}
