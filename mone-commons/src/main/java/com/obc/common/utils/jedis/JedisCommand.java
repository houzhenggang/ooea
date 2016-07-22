package com.obc.common.utils.jedis;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class JedisCommand{
	
	public static Long del(Jedis jedis,String key){
		return jedis.del(key);
	}
	
	public static byte[] dump(Jedis jedis,String key){
		return jedis.dump(key);
	}
	
	public static Boolean exists(Jedis jedis,String key){
		return jedis.exists(key);
	}
	
	public static Long expire(Jedis jedis,String key,int seconds){
		return jedis.expire(key,seconds);
	}
	
	public static Long expireat(Jedis jedis,String key,long unixTime){
		return jedis.expireAt(key,unixTime);
	}
	
	public static Long pexpireat(Jedis jedis,String key,long millisecondsTimestamp){
		return jedis.pexpireAt(key,millisecondsTimestamp);
	}
	
	public static Set<String> keys(Jedis jedis,String pattern){
		return jedis.keys(pattern);
	}
	
	public static Long move(Jedis jedis,String key,int dbIndex){
		return jedis.move(key,dbIndex);
	}
	
	public static Long persist(Jedis jedis,String key){
		return jedis.persist(key);
	}
	
	public static Long pttl(Jedis jedis,String key){
		return jedis.pttl(key);
	}
	
	public static Long ttl(Jedis jedis,String key){
		return jedis.ttl(key);
	}
	
	public static String randomkey(Jedis jedis){
		return jedis.randomKey();
	}
	
	public static String rename(Jedis jedis,String oldkey,String newkey){
		return jedis.rename(oldkey,newkey);
	}
	
	public static Long renamenx(Jedis jedis,String oldkey,String newkey){
		return jedis.renamenx(oldkey,newkey);
	}
	
	public static String type(Jedis jedis,String key){
		return jedis.type(key);
	}
}
