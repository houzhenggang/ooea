package com.obc.common.utils.jedis;

import redis.clients.jedis.BinaryClient.LIST_POSITION;

import java.util.List;

import redis.clients.jedis.Jedis;

public class JedisListUtils{
	
	public static List<String> blpop(Jedis jedis,String key,String...args){
		return jedis.blpop(args);
	}
	
	public static List<String> brpop(Jedis jedis,String key,String...args){
		return jedis.brpop(args);
	}
	
	public static String brpoplpush(Jedis jedis,String key,String source,String destination,int timeout){
		return jedis.brpoplpush(source,destination,timeout);
	}
	
	public static String lindex(Jedis jedis,String key,Long index){
		return jedis.lindex(key,index);
	}
	
	public static Long linsert(Jedis jedis,String key,LIST_POSITION where,String pivot,String value){
		return jedis.linsert(key,where,pivot,value);
	}
	
	public static Long llen(Jedis jedis,String key){
		return jedis.llen(key);
	}
	
	public static String lpop(Jedis jedis,String key){
		return jedis.lpop(key);
	}
	
	public static Long lpush(Jedis jedis,String key,String...strings){
		return jedis.lpush(key,strings);
	}
	
	public static Long lpushx(Jedis jedis,String key,String...string){
		return jedis.lpushx(key,string);
	}
	
	public static List<String> lrange(Jedis jedis,String key,long start,long end){
		return jedis.lrange(key,start,end);
	}
	
	public static Long lrem(Jedis jedis,String key,long count,String value){
		return jedis.lrem(key,count,value);
	}
	
	public static String lset(Jedis jedis,String key,long index,String value){
		return jedis.lset(key,index,value);
	}
	
	public static String ltrim(Jedis jedis,String key,long start,long end){
		return jedis.ltrim(key,start,end);
	}
	
	public static String rpop(Jedis jedis,String key){
		return jedis.rpop(key);
	}
	
	public static String rpoplpush(Jedis jedis,String srckey,String dstkey){
		return jedis.rpoplpush(srckey,dstkey);
	}
	
	public static Long rpush(Jedis jedis,String key,String...strings){
		return jedis.rpush(key,strings);
	}
	
	public static Long rpushx(Jedis jedis,String key){
		return jedis.rpushx(key);
	}
}
