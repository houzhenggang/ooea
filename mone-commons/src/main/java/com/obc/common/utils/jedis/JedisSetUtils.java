package com.obc.common.utils.jedis;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;

public class JedisSetUtils{
	
	public static Long sadd(Jedis jedis,String key,String...members){
		return jedis.sadd(key,members);
	}
	
	public static Long scard(Jedis jedis,String key){
		return jedis.scard(key);
	}
	
	public static Set<String> sdiff(Jedis jedis,String...keys){
		return jedis.sdiff(keys);
	}
	
	public static Long sdiffstore(Jedis jedis,String dstkey,String...keys){
		return jedis.sdiffstore(dstkey,keys);
	}
	
	public static Set<String> sinter(Jedis jedis,String...keys){
		return jedis.sinter(keys);
	}
	
	public static Long sinterstore(Jedis jedis,String dstkey,String...keys){
		return jedis.sinterstore(dstkey,keys);
	}
	
	public static Boolean sismember(Jedis jedis,String key,String member){
		return jedis.sismember(key,member);
	}
	
	public static Set<String> smembers(Jedis jedis,String key){
		return jedis.smembers(key);
	}
	
	public static Long smove(Jedis jedis,String srckey,String dstkey,String member){
		return jedis.smove(srckey,dstkey,member);
	}
	
	public static String spop(Jedis jedis,String key){
		return jedis.spop(key);
	}
	
	public static String srandmember(Jedis jedis,String key){
		return jedis.srandmember(key);
	}
	
	public static Long srem(Jedis jedis,String key,String...members){
		return jedis.srem(key,members);
	}
	
	public static Set<String> sunion(Jedis jedis,String...keys){
		return jedis.sunion(keys);
	}
	
	public static Long sunionstore(Jedis jedis,String dstkey,String...keys){
		return jedis.sunionstore(dstkey,keys);
	}
	
	public static ScanResult<String> sscan(Jedis jedis,String key,String cursor){
		return jedis.sscan(key,cursor);
	}
}
