package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public abstract class BaseTest extends TestCase {
	
	public static ApplicationContext CTX;

	static {
		String[] paths = { "classpath:applicationContext-beans.xml" };
		CTX = new ClassPathXmlApplicationContext(paths);
	}
}
