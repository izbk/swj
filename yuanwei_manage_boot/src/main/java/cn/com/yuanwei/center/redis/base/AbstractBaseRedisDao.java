package cn.com.yuanwei.center.redis.base;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public class AbstractBaseRedisDao<K extends Serializable, V extends Serializable> {

	@Resource(name="redisTemplate")  
    protected RedisTemplate<K, V> redisTemplate;  
  
    /** 
     * 设置redisTemplate 
     */  
    public void setRedisTemplate(RedisTemplate<K , V> redisTemplate) {  
        this.redisTemplate = redisTemplate;  
    } 
    /** 
     * 获取 RedisSerializer 
     */  
    protected RedisSerializer<String> getRedisSerializer() {  
        return redisTemplate.getStringSerializer();  
    }  
}
