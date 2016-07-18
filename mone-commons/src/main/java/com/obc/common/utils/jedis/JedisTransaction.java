package com.obc.common.utils.jedis;

import redis.clients.jedis.Jedis;

public class JedisTransaction{
	StringRedisTemplate
	
	public static Object multi(Jedis jedis,String key){
		return jedis.multi();
	}
	
	public static Object unwatch(Jedis jedis,String key){
		return jedis.unwatch();
	}
	
	public static Object watch(Jedis jedis,String...keys){
		return jedis.watch(keys);
	}
}
