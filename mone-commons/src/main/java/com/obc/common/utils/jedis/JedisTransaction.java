package com.obc.common.utils.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class JedisTransaction{
	
	public static Transaction multi(Jedis jedis){
		return jedis.multi();
	}
	
	public static String unwatch(Jedis jedis){
		return jedis.unwatch();
	}
	
	public static String watch(Jedis jedis,String...keys){
		return jedis.watch(keys);
	}
}
