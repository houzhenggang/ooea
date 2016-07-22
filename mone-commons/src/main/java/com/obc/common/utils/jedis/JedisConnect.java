package com.obc.common.utils.jedis;

import redis.clients.jedis.Jedis;

public class JedisConnect{
	
	public static String auth(Jedis jedis,String password){
		return jedis.auth(password);
	}
	
	public static String echo(Jedis jedis,String string){
		return jedis.echo(string);
	}
	
	public static String ping(Jedis jedis){
		return jedis.ping();
	}
	
	public static String quit(Jedis jedis){
		return jedis.quit();
	}
	
	public static String select(Jedis jedis,int index){
		return jedis.select(index);
	}
	
}
