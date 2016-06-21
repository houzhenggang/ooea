package spring;

import java.util.Date;

import com.aliyun.oss.common.utils.DateUtil;
import com.obc.common.enumeration.DateFormat;
import com.obc.common.utils.DateUtils;

import examples.构造方法注入.ApplicationUtil;
import examples.构造方法注入.ClientService;
import junit.framework.TestCase;

public class Test extends TestCase {
	
	public void test01 ( ) {
		String str = DateUtils.dateToStr(new Date(), DateFormat.f01);
		System.out.println(str);
		ClientService clientService = (ClientService) ApplicationUtil.getApplication().getBean("clientService");
	}
}
