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

import com.obc.common.utils.IStringUtils;
import com.obc.modules.sys.entity.BcSysUser;
import com.obc.modules.sys.service.BcSysUserService;

/**
 * 
 * @ClassName: LoginRealm
 *
 * @author FC
 * @Description: TODO 【登陆时验证】
 * @date 2016年3月21日 下午5:50:11
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
			String name = IStringUtils.replaceV(user.getUsername());
			authenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword(), getName());
		}
		return authenticationInfo;
	}

}
