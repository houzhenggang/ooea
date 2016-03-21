package test;

import com.obc.modules.sys.service.BcSysUserService;
import com.obc.modules.sys.service.impl.BcSysUserServiceImpl;

public class DBTest extends BaseTest {

	public void test() {
		BcSysUserService bsys = CTX.getBean(BcSysUserServiceImpl.class);
		bsys.findBcSysUser("1");
	}

}
