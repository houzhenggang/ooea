package com.obc.modules.consumer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obc.common.ExceptionMessage;
import com.obc.common.constant.PageUrl;
import com.obc.common.enumeration.Code;
import com.obc.common.utils.IStringUtils;
import com.obc.modules.sys.entity.BcSysUser;
import com.obc.modules.sys.service.BcSysUserService;

/**
 * 
 * @ClassName: ConsumerController
 *
 * @author FC
 * @Description: TODO 【普通用户注册登录】
 * @date 2016年3月27日 下午6:08:15
 */
@RequestMapping( "/consumer" )
@Controller
public class ConsumerController {

	@Autowired
	@Qualifier( "bcSysUserServiceImpl" )
	private BcSysUserService bcSysUserService;

	/**
	 * 
	 * @Title: register
	 * 
	 * @author FC
	 * @Description: TODO 【注册】
	 * @return
	 * @date 2016年3月27日 下午12:39:01
	 */
	@RequestMapping( value = "/register.do" , method = RequestMethod.POST )
	@ResponseBody
	public ExceptionMessage register (	HttpServletRequest request ,
										BcSysUser user ) {
		ExceptionMessage em = ExceptionMessage.newInstance();
		try {
			bcSysUserService.addBcSysUser(user);
			em.addCuePhrases(Code.SuccesssMessage.getDesc()).addIsBool(true);
		} catch (Exception e) {
			em.addCuePhrases(e.getMessage()).addIsBool(false);
			IStringUtils.log(e.getMessage(), ConsumerController.class);
		}
		return em;
	}

	/**
	 * 
	 * @Title: register
	 * 
	 * @author FC
	 * @Description: TODO 【跳转到注册页面】
	 * @return
	 * @date 2016年3月27日 下午12:43:31
	 */
	@RequestMapping( value = "/register.do" , method = RequestMethod.GET )
	public String register ( ) {
		return PageUrl.ConsumerRegister;
	}

	/**
	 * 
	 * @Title: login
	 * 
	 * @author FC
	 * @Description: TODO 【跳转到登录页面】
	 * @return
	 * @date 2016年3月27日 下午6:11:00
	 */
	@RequestMapping( value = "/login.do" , method = RequestMethod.GET )
	public String login ( ) {
		return PageUrl.ConsumerLogin;
	}
}
