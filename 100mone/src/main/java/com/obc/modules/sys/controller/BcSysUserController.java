package com.obc.modules.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obc.common.ExceptionMessage;
import com.obc.common.constant.PageUrl;
import com.obc.common.enumeration.Code;
import com.obc.modules.sys.entity.BcSysUser;
import com.obc.modules.sys.service.BcSysUserService;

@RequestMapping( "/login" )
@Controller
public class BcSysUserController {

	@Autowired
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
	public String login ( ) {
		bcSysUserService.findBcSysUser("");
		return "";
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
	public String loginout ( ) {
		System.out.println(123);
		return PageUrl.SysIndex;
	}

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
			em.addCuePhrases(Code.i000010002EM.getDesc()).addIsBool(false);
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
}
