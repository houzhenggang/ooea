package com.obc.common.utils.jedis;

import redis.clients.jedis.Jedis;

public class JStringUtils {
	
	/** 失败 */
	public static final String Failure = "0";
	
	/**
	 * 
	 * <br>
	 * 方法名： set
	 * 
	 * <br>
	 * 描述：【Redis SET 命令用于设置给定 key 的值。如果 key 已经存储其他值， SET 就覆写旧值，且无视类型。】
	 * <br>
	 * 创建时间： 2016年7月15日 上午10:53:00
	 * @param jedis
	 * @param key
	 * @param value
	 * @return 在 Redis 2.6.12 以前版本， SET 命令总是返回 OK 。从 Redis 2.6.12 版本开始， SET 在设置操作成功完成时，才返回 OK 。
	 */
	public static String set ( Jedis jedis ,
	                           String key ,
	                           String value ) {
		try {
			return jedis.set(key, value);
		}
		catch (Exception e) {
			return Failure;
		}
	}
	
	/**
	 * <br>
	 * 方法名： get<br>
	 * 
	 * 描述：【Redis Get 命令用于获取指定 key 的值。如果 key 不存在，返回 nil 。如果key 储存的值不是字符串类型，返回一个错误。】<br>
	 * 创建时间： 2016年7月15日 上午10:56:42<br>
	 * @param jedis
	 * @param key
	 * @return 返回 key 的值，如果 key 不存在时，返回 nil。 如果 key 不是字符串类型，那么返回一个错误。
	 */
	public static String get ( Jedis jedis ,
	                           String key ) {
		try {
			return jedis.get(key);
		}
		catch (Exception e) {
			return Failure;
		}
	}
	
}
