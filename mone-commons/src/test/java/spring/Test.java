package spring;

import java.util.Date;

import com.obc.common.enumeration.DateFormat;
import com.obc.common.utils.DateUtils;

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
		jedis.incr("string01");
		jedis.set("string02", "2");
		String sds = jedis.get("string01");
		String sde = jedis.get("string02");
		jedis.zadd("paiming", Double.valueOf(sds), "string01");
		jedis.zadd("paiming", Double.valueOf(sde), "string02");
		
	}
	
}
