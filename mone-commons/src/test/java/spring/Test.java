package spring;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.obc.common.enumeration.DateFormat;
import com.obc.common.utils.DateUtils;
import com.obc.common.utils.jedis.JedisZset;

import examples.构造方法注入.ApplicationUtil;
import examples.构造方法注入.ClientService;
import junit.framework.TestCase;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.Transaction;

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
		// JedisStringUtils.set(jedis,"123132","dsad");
		
		for(int i=0;i<50000;i++){
			String[] m=new String[500];
			Map<String,Double> scoreMembers=new HashMap<String,Double>();
			scoreMembers.put("zset_:"+i,(double)i);
			// JedisSetUtils.sadd(jedis,"test",m);
			JedisZset.zadd(jedis,"test",scoreMembers);
		}
		// for(int i=0;i<50000;i++){
		// System.out.println(JStringUtils.get(jedis,"test:"+i));
		// }
		// for(int i=0;i<50000;i++){
		// jedis.del("test:"+i);
		// }
	}
	
	public void test03(){
		Jedis jedis=new Jedis("10.10.11.86",6379);
		Transaction transaction=jedis.multi();
		
		// 二选一
		transaction.exec();// 提交事务
		transaction.discard();// 终止事务
	}
	
}
