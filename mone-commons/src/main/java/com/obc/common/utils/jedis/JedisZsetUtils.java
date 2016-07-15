package com.obc.common.utils.jedis;

import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;

public class JedisZsetUtils{
	
	public static Long zadd(Jedis jedis,String key,Map<String,Double> scoreMembers){
		return jedis.zadd(key,scoreMembers);
	}
	
	public static Long zcard(Jedis jedis,String key){
		return jedis.zcard(key);
	}
	
	public static Long zcount(Jedis jedis,String key,String min,String max){
		return jedis.zcount(key,min,max);
	}
	
	public static Double zincrby(Jedis jedis,String key,double score,String member){
		return jedis.zincrby(key,score,member);
	}
	
	public static Long zinterstore(Jedis jedis,String dstkey,String...sets){
		return jedis.zinterstore(dstkey,sets);
	}
	
	public static Long zlexcount(Jedis jedis,String key,String min,String max){
		return jedis.zlexcount(key,min,max);
	}
	
	public static Set<String> zrange(Jedis jedis,String key,long start,long end){
		return jedis.zrange(key,start,end);
	}
	
	public static Set<String> zrangebylex(Jedis jedis,String key,String min,String max){
		return jedis.zrangeByLex(key,min,max);
	}
	
	public static Set<String> zrangebyscore(Jedis jedis,String key,double min,double max,int offset,int count){
		return jedis.zrangeByScore(key,min,max,offset,count);
	}
	
	public static Long zrank(Jedis jedis,String key,String member){
		return jedis.zrank(key,member);
	}
	
	public static Long zrem(Jedis jedis,String key,String...members){
		return jedis.zrem(key,members);
	}
	
	public static Long zremrangebylex(Jedis jedis,String key,String min,String max){
		return jedis.zremrangeByLex(key,min,max);
	}
	
	public static Long zremrangebyrank(Jedis jedis,String key,long start,long end){
		return jedis.zremrangeByRank(key,start,end);
	}
	
	public static Long zremrangebyscore(Jedis jedis,String key,String start,String end){
		return jedis.zremrangeByScore(key,start,end);
	}
	
	public static Set<String> zrevrange(Jedis jedis,String key,long start,long end){
		return jedis.zrevrange(key,start,end);
	}
	
	public static Set<String> zrevrangebyscore(Jedis jedis,String key,String max,String min){
		return jedis.zrevrangeByScore(key,max,min);
	}
	
	public static Long zrevrank(Jedis jedis,String key,String member){
		return jedis.zrevrank(key,member);
	}
	
	public static Double zscore(Jedis jedis,String key,String member){
		return jedis.zscore(key,member);
	}
	
	public static Long zunionstore(Jedis jedis,String dstkey,String...sets){
		return jedis.zunionstore(dstkey,sets);
	}
	
	public static ScanResult<Tuple> zscan(Jedis jedis,String key,String cursor){
		return jedis.zscan(key,cursor);
	}
}
