package com.obc.modules.sys.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.obc.common.ExceptionMessage;
import com.obc.common.constant.PageUrl;
import com.obc.common.enumeration.Code;
import com.obc.common.utils.IStringUtils;
import com.obc.modules.sys.service.BcSysUserService;

/**
 * 
 * @ClassName: BcSysUserController
 *
 * @author FC
 * @Description: TODO 【系统注册】
 * @date 2016年3月27日 下午5:57:05
 */
@RequestMapping( "/sys" )
@Controller
public class SysController {

	@Autowired
	@Qualifier( "bcSysUserServiceImpl" )
	private BcSysUserService bcSysUserService;

	/**
	 * 
	 * @Title: login
	 * 
	 * @author FC
	 * @Description: TODO 【这里用一句话描述这个方法的作用】
	 * @return
	 * @date 2016年3月19日 下午10:12:53
	 */
	@RequestMapping( "/login.do" )
	public String login ( ) {
		return PageUrl.ConsumerLogin;
	}

	/**
	 * 
	 * @Title: loginout
	 * 
	 * @author FC
	 * @Description: TODO 【退出登录（后台）】
	 * @return
	 * @date 2016年3月19日 下午10:30:44
	 */
	@RequestMapping( "/loginout.do" )
	public String loginout ( String loginSalt ) {
		if (StringUtils.equals(Code.i000LoginSalt.getDesc(), loginSalt)) { return PageUrl.SysIndex; }
		return PageUrl.ConsumerIndex;
	}

}
