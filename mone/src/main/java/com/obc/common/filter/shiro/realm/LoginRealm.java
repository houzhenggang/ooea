package com.obc.common.filter.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.obc.modules.sys.entity.BcSysUser;
import com.obc.modules.sys.service.BcSysUserService;

/**
 * 
 * <br>类名： LoginRealm 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:22:44 
 * @author FC
 */
public class LoginRealm extends AuthorizingRealm {

	@Autowired
	@Qualifier( "bcSysUserServiceImpl" )
	private BcSysUserService bcSysUserService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo ( PrincipalCollection principals ) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo ( AuthenticationToken token ) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = String.valueOf(usernamePasswordToken.getUsername());
		BcSysUser user = bcSysUserService.findBcSysUser(username);
		SimpleAuthenticationInfo authenticationInfo = null;
		if (user != null) {
//			String name = MoneStringUtils.replaceV(user.getUsername());
			authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		}
		return authenticationInfo;
	}

}
