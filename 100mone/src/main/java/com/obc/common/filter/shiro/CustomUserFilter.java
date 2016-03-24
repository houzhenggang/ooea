package com.obc.common.filter.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.UserFilter;

public class CustomUserFilter extends UserFilter {

	@Override
	protected boolean isAccessAllowed (	ServletRequest arg0 ,
										ServletResponse arg1 ,
										Object arg2 ) {
		return super.isAccessAllowed(arg0, arg1, arg2);
	}

	@Override
	protected boolean onAccessDenied (	ServletRequest request ,
										ServletResponse response ) throws Exception {
		return super.onAccessDenied(request, response);
	}

}
