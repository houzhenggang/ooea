package spring;

import examples.构造方法注入.ApplicationUtil;
import examples.构造方法注入.ClientService;
import junit.framework.TestCase;

public class Test extends TestCase {
	
	public void test01(){
		ClientService clientService= (ClientService) ApplicationUtil.getApplication().getBean("clientService");
	}
}
