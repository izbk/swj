package cn.com.yuanwei.center.component;

import java.util.HashMap;


@SuppressWarnings("serial")
public class CacheManager extends HashMap<String, Object>{

	// 定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
	private static volatile CacheManager instance;

	private CacheManager() {
	}

	// 定义一个共有的静态方法，返回该类型实例
	public static CacheManager getInstance() {
		// 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
		if (instance == null) {
			// 同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
			synchronized (CacheManager.class) {
				// 未初始化，则初始instance变量
				if (instance == null) {
					instance = new CacheManager();
				}
			}
		}
		return instance;
	}

	public Object getValue(Object key) {
		return instance.get(key);
	}

	// 根据key更新缓存中的记录// 根据 key 来删除缓存中的一条记录
	public void addOrUpdateCache(String key, Object value) {
		instance.put(key, value);
	}

	// 根据 key 来删除缓存中的一条记录
	public void evictCache(String key) {
		if (instance.containsKey(key)) {
			instance.remove(key);
		}
	}

	// 清空缓存中的所有记录
	public void evictCache() {
		instance.clear();
	}
}
