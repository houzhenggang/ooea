package com.obc.common.utils.jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class JHashUtils{
	
	public static Long hdel(Jedis jedis,String key,String...fields){
		return jedis.hdel(key,fields);
	}
	
	public static Boolean hexists(Jedis jedis,String key,String field){
		return jedis.hexists(key,field);
	}
	
	public static String hget(Jedis jedis,String key,String field){
		return jedis.hget(key,field);
	}
	
	public static Map<String,String> hgetall(Jedis jedis,String key){
		return jedis.hgetAll(key);
	}
	
	public static Long hincrby(Jedis jedis,String key,String field,Long value){
		return jedis.hincrBy(key,field,value);
	}
	
	public static Double hincrbyfloat(Jedis jedis,String key,String field,Double value){
		return jedis.hincrByFloat(key,field,value);
	}
	
	public static Set<String> hkeys(Jedis jedis,String key){
		return jedis.hkeys(key);
	}
	
	public static Long hlen(Jedis jedis,String key){
		return jedis.hlen(key);
	}
	
	public static List<String> hmget(Jedis jedis,String key,String...fields){
		return jedis.hmget(key,fields);
	}
	
	public static String hmset(Jedis jedis,String key,Map<String,String> hash){
		return jedis.hmset(key,hash);
	}
	
	public static Long hset(Jedis jedis,String key,String field,String value){
		return jedis.hset(key,field,value);
	}
	
	public static Long hsetnx(Jedis jedis,String key,String field,String value){
		return jedis.hsetnx(key,field,value);
	}
	
	public static List<String> hvals(Jedis jedis,String key){
		return jedis.hvals(key);
	}
}
