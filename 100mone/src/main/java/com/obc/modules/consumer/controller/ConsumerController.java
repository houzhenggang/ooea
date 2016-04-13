package com.obc.modules.consumer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
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
import com.obc.common.constant.Canonical;
import com.obc.common.constant.PageUrl;
import com.obc.common.constant.TemplateFileNames;
import com.obc.common.enumeration.Code;
import com.obc.common.security.EncryptUtil;
import com.obc.common.utils.EmailUtils;
import com.obc.common.utils.FreemarkerUtils;
import com.obc.common.utils.IStringUtils;
import com.obc.common.utils.ValidateCode;
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
										BcSysUser user ,
										String code ) {
		HttpSession session = request.getSession();
		String validateCode = (String) session.getAttribute("validateCode");

		ExceptionMessage em = ExceptionMessage.newInstance();
		try {
			if (StringUtils.isNotEmpty(code)
					&& StringUtils.equals(code, validateCode)) { throw new Exception(Canonical.validateCodeMessage); }

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
	 * 
	 * @Title: validateCode
	 * 
	 * @author FC
	 * @Description: TODO 【图片证码】
	 * @param request
	 * @param user
	 * @date 2016年4月10日 上午12:17:02
	 */
	@RequestMapping( "/validateCode.do" )
	public void validateCode (	HttpServletRequest request ,
								HttpServletResponse response ,
								BcSysUser user ) {

		try {
			ValidateCode validateCode = ValidateCode.newInstance();
			//发件人system@100mone.com
			//密码Fc13
			HttpSession session = request.getSession();
			// 设置响应的类型格式为图片格式  
			response.setContentType("image/jpeg");
			//禁止图像缓存。  
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			session.setAttribute("validateCode", validateCode.getCode());
			session.setMaxInactiveInterval(1800);
			validateCode.write(response.getOutputStream());

		}
		catch (IOException e) {
		}

	}

	/**
	 * 
	 * @Title: emailCode
	 * 
	 * @author FC
	 * @Description: TODO 【发送邮件验证用户邮箱】
	 * @date 2016年4月10日 上午11:56:56
	 */
	@RequestMapping( "/emailCode.do" )
	@ResponseBody
	public Object emailCode (	HttpServletRequest request ,
							BcSysUser user ) {
		try {
			ExceptionMessage exceptionMessage =ExceptionMessage.newInstance();
			HttpSession session = request.getSession();
			
			String validateCode = (String) session.getAttribute("validateCode");
			if(StringUtils.isNotEmpty(validateCode)){
				exceptionMessage.addCuePhrases("请等会儿再发。");
				return exceptionMessage;
			}
			
			String emailCode = ValidateCode.createCode(Canonical.num6);
			Map<String, String> param = new HashMap<String, String>();
			String addressee = user.getEmail();//收件人

			param.put("addressee", addressee);
			param.put("validateCode", emailCode);
			String msg = FreemarkerUtils.genStrFormTemplate(TemplateFileNames.registerCode, param);
			//发送邮件
			EmailUtils.send(addressee, msg, null);
			session.setAttribute("validateCode", emailCode);
			session.setMaxInactiveInterval(1800);
			IStringUtils.log("验证码：" + emailCode, ConsumerController.class);
		}
		catch (Exception e) {
			IStringUtils.log("验证码获取异常：" + e.getMessage(), ConsumerController.class);
		}
		return null;
	}
}
