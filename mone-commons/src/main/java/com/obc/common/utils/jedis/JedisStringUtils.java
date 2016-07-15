package com.obc.common.utils.jedis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class JedisStringUtils{
	
	public static String set(Jedis jedis,String key,String value){
		return jedis.set(key,value);
	}
	
	public static String get(Jedis jedis,String key){
		return jedis.get(key);
	}
	
	public static String getrange(Jedis jedis,String key,Long startOffset,Long endOffset){
		return jedis.getrange(key,startOffset,endOffset);
	}
	
	public static String getset(Jedis jedis,String key,String value){
		return jedis.getSet(key,value);
	}
	
	public static Boolean getbit(Jedis jedis,String key,Long offset){
		return jedis.getbit(key,offset);
	}
	
	public static List<String> mget(Jedis jedis,String...keys){
		return jedis.mget(keys);
	}
	
	public static Boolean setbit(Jedis jedis,String key,Long offset,Boolean value){
		return jedis.setbit(key,offset,value);
	}
	
	public static Boolean setbit(Jedis jedis,String key,Long offset,String value){
		return jedis.setbit(key,offset,value);
	}
	
	public static String setex(Jedis jedis,String key,Integer seconds,String value){
		return jedis.setex(key,seconds,value);
	}
	
	public static Long setnx(Jedis jedis,String key,String value){
		return jedis.setnx(key,value);
	}
	
	public static Long setrange(Jedis jedis,String key,Long offset,String value){
		return jedis.setrange(key,offset,value);
	}
	
	public static Long strlen(Jedis jedis,String key){
		return jedis.strlen(key);
	}
	
	public static String mset(Jedis jedis,String...keysvalues){
		return jedis.mset(keysvalues);
	}
	
	public static Long msetnx(Jedis jedis,String...keysvalues){
		return jedis.msetnx(keysvalues);
	}
	
	public static String psetex(Jedis jedis,String key,Long milliseconds,String value){
		return jedis.psetex(key,milliseconds,value);
	}
	
	public static Long incr(Jedis jedis,String key){
		return jedis.incr(key);
	}
	
	public static Long incrby(Jedis jedis,String key,Integer Integer){
		return jedis.incrBy(key,Integer);
	}
	
	public static Double incrbyfloat(Jedis jedis,String key,Double value){
		return jedis.incrByFloat(key,value);
	}
	
	public static Long decr(Jedis jedis,String key){
		return jedis.decr(key);
	}
	
	public static Long decrby(Jedis jedis,String key,Long integer){
		return jedis.decrBy(key,integer);
	}
	
	public static Long append(Jedis jedis,String key,String value){
		return jedis.append(key,value);
	}
}
