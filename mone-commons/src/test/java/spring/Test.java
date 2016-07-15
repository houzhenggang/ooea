package spring;

import java.util.Date;

import com.obc.common.enumeration.DateFormat;
import com.obc.common.utils.DateUtils;
import com.obc.common.utils.jedis.JStringUtils;

import examples.构造方法注入.ApplicationUtil;
import examples.构造方法注入.ClientService;
import junit.framework.TestCase;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@SuppressWarnings( "unused" )
public class Test extends TestCase {
	
	public void test01 ( ) {
		String str = DateUtils.dateToStr(new Date(), DateFormat.f01);
		System.out.println(str);
		
		ClientService clientService = (ClientService) ApplicationUtil.getApplication().getBean("clientService");
	}
	
	public void test02 ( ) {
		
		Jedis jedis = new Jedis("139.196.24.209", 6379);
		jedis.set("string01", "1");
		System.out.println(jedis.get("string01"));
		Long l = JStringUtils.setnx(jedis, "string01", "100");
		System.out.println(l);
	}
	
}
