package examples.构造方法注入;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 获悉application 上下文对象
 * 创建时间2014-12-30
 * @author llfeng
 * version 1.0.0
 */
public class ApplicationUtil {
	
	private static ApplicationContext CTX;
	
	public synchronized static ApplicationContext getApplication()
	{
		if(CTX == null)
		{
			String[] paths = {"classpath:spring.xml"};
			CTX = new ClassPathXmlApplicationContext(paths);
		}
		
		return CTX;
	}
	
}
