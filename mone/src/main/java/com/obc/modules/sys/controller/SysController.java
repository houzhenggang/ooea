package com.obc.modules.sys.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.obc.common.constant.PageUrl;
import com.obc.common.enumeration.Code;
import com.obc.modules.sys.service.BcSysUserService;

/**
 * 
 * <br>类名： SysController 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:20:53 
 * @author FC
 */
@RequestMapping( "/sys" )
@Controller
public class SysController {

	@Autowired
	@Qualifier( "bcSysUserServiceImpl" )
	private BcSysUserService bcSysUserService;

	/**
	 * 
	 * <br>方法名： login
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:20:57 
	 * @return
	 */
	@RequestMapping( "/login.do" )
	public String login ( ) {
		return PageUrl.ConsumerLogin;
	}

	/**
	 * 
	 * <br>方法名： loginout
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:21:02 
	 * @param loginSalt
	 * @return
	 */
	@RequestMapping( "/loginout.do" )
	public String loginout ( String loginSalt ) {
		if (StringUtils.equals(Code.i000LoginSalt.getDesc(), loginSalt)) { return PageUrl.SysIndex; }
		return PageUrl.ConsumerIndex;
	}

}
