package spring;

import java.util.Date;
import java.util.Iterator;

import com.obc.common.enumeration.DateFormat;
import com.obc.common.utils.DateUtils;
import com.obc.common.utils.jedis.JedisStringUtils;

import examples.构造方法注入.ApplicationUtil;
import examples.构造方法注入.ClientService;
import junit.framework.TestCase;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@SuppressWarnings("unused")
public class Test extends TestCase{
	
	// public void test01(){
	// String str=DateUtils.dateToStr(new Date(),DateFormat.f01);
	// System.out.println(str);
	//
	// ClientService clientService=(ClientService)ApplicationUtil.getApplication().getBean("clientService");
	// }
	
	public void test02() throws InterruptedException{
		
		Jedis jedis=new Jedis("10.10.11.86",6379);
		
		// for(int i=0;i<50000;i++){
		// JedisStringUtils.set(jedis,"test:"+i,i+"");
		// }
		// for(int i=0;i<50000;i++){
		// System.out.println(JStringUtils.get(jedis,"test:"+i));
		// }
		for(int i=0;i<50000;i++){
			jedis.del("test:"+i);
		}
	}
	
}
