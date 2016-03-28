package com.obc.common.filter.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;

import com.obc.modules.sys.entity.BcSysUser;

/**
 * 
 * @ClassName: CustomUserFilter 
 *
 * @author FC
 * @Description: TODO 【这里用一句话描述这个类的作用】
 * @date 2016年3月28日 下午6:10:05
 */
public class CustomUserFilter extends UserFilter {

	@Override
	protected boolean isAccessAllowed (	ServletRequest arg0 ,
										ServletResponse arg1 ,
										Object arg2 ) {
		Subject subject = getSubject(arg0, arg1);
		BcSysUser principal = (BcSysUser) subject.getPrincipal();
		if (!subject.isAuthenticated() || principal == null) {
			return false;
		}
		return super.isAccessAllowed(arg0, arg1, arg2);
	}

	@Override
	protected boolean onAccessDenied (	ServletRequest request ,
										ServletResponse response ) throws Exception {
		return super.onAccessDenied(request, response);
	}

}
