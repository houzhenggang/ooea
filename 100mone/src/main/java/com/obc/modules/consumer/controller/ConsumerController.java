package com.obc.modules.consumer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.obc.common.ExceptionMessage;
import com.obc.common.constant.PageUrl;
import com.obc.common.enumeration.Code;
import com.obc.common.security.EncryptUtil;
import com.obc.common.utils.IStringUtils;
import com.obc.modules.LoginPojo;
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
		}
		catch (Exception e) {
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

	/**
	 * 
	 * @Title: login
	 * 
	 * @author FC
	 * @Description: TODO 【跳转到登录页面】 
	 * @param request
	 * @param user
	 * @return 
	 * @date 2016年4月10日 上午12:17:45
	 */
	@RequestMapping( value = "/login.do" , method = RequestMethod.POST )
	public String login (	HttpServletRequest request ,
							LoginPojo user ) {
		try {
			String name = user.getUsername();
			Subject subject = SecurityUtils.getSubject();
			BcSysUser bsu = bcSysUserService.findBcSysUser(name);
			String pass = EncryptUtil.encryptBySalt(user.getPassword(), bsu.getSalt());
			AuthenticationToken token = new UsernamePasswordToken(name, pass);
			subject.login(token);
			return PageUrl.ConsumerIndex;
		}
		catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return PageUrl.ConsumerLogin;
	}

	/**
	 * 发送邮件验证用户邮箱
	 * @Title: validateCode
	 * 
	 * @author FC
	 * @Description: TODO 【发送邮箱验证码】
	 * @param request
	 * @param user
	 * @date 2016年4月10日 上午12:17:02
	 */
	@RequestMapping( "/validateCode.do" )
	@ResponseBody
	public void validateCode (	HttpServletRequest request ,
	                          	BcSysUser user ) {
		
		//发件人system@100mone.com
		//密码Fc13
		String code = "code";
		HttpSession session = request.getSession();
		session.setAttribute("validateCode", code);
		session.setMaxInactiveInterval(1800);
		//发送邮件
		//freemacker使用

	}
}
