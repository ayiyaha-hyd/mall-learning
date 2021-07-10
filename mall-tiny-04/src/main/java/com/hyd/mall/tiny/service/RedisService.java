package com.hyd.mall.tiny.service;

public interface RedisService {
	/**
	 * 存数据
	 * @param key
	 * @param value
	 */
	void set(String key,String value);

	/**
	 * 取数据
	 * @param key
	 * @return
	 */
	String get(String key);

	/**
	 * 设置超时时间
	 * @param key
	 * @param expireTime
	 * @return
	 */
	boolean expire(String key,long expireTime);

	/**
	 * 删除数据
	 * @param key
	 */
	void remove(String key);

	/**
	 * 自增操作
	 * @param key
	 * @param delta
	 * @return
	 */
	Long increment(String key,long delta);
}
