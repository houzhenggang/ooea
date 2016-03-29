package test;

import com.obc.modules.sys.entity.BcSysUser;
import com.obc.modules.sys.service.BcSysUserService;
import com.obc.modules.sys.service.impl.BcSysUserServiceImpl;

public class DBTest extends BaseTest {

	public void test() {
		BcSysUserService bsys = CTX.getBean(BcSysUserServiceImpl.class);
		BcSysUser bsu = bsys.findBcSysUser("11");
		bsu.setPlain_text("ssss");
		bsys.addBcSysUser(bsu);
		
		bsys.addBcSysUser(bsu);
		bsu.setEmail("128689990e9@qq.com");
		bsu.setIs_valid(null);
		bsys.updateBcSysUser(bsu);
		
		
		System.out.println(bsu);
		System.out.println();
		System.out.println();
	}

}
