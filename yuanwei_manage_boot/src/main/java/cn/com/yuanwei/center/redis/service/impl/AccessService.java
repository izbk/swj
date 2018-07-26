package cn.com.yuanwei.center.redis.service.impl;


import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Service;

import cn.com.yuanwei.center.redis.base.AbstractBaseRedisDao;
import cn.com.yuanwei.center.redis.base.RedisExpire;

@Service
public class AccessService extends AbstractBaseRedisDao<String, String> {
	private int dbIndex = 6;
	private int limit=15;

	/**
	 * 添加ip访问接口记录
	 * @param ip
	 * @param addr
	 * @return
	 * @throws Exception
	 */
	public boolean VerifyIp(String ip) throws Exception {
			final String key = ip;
			Boolean flag = redisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection)
						throws DataAccessException {
					connection.select(dbIndex);
					Boolean checkExists = connection.exists(key.getBytes());
					if(checkExists){
						Long count = connection.incr(key.getBytes());
						if(count>limit){
							return false;
						}
					}else{
						connection.multi();
						connection.incr(key.getBytes());
						connection.expire(key.getBytes(), RedisExpire.OneSecend);
						connection.exec();
					}
					return true;
				}
			});
			return flag;
	}

}
