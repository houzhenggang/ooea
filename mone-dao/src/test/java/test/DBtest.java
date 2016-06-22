package test;

import com.obc.common.utils.ApplicationUtil;
import com.obc.modules.sys.service.BcSysUserService;

import junit.framework.TestCase;

public class DBtest extends TestCase {
	
	public void testdb ( ) {
		BcSysUserService bcSysUserService = (BcSysUserService) ApplicationUtil.getApplication().getBean("bcSysUserServiceImpl");
		bcSysUserService.findBcSysUser("11");
	}
	
}
