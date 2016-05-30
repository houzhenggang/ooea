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
import com.obc.common.constant.TemplateFileName;
import com.obc.common.enumeration.Code;
import com.obc.common.security.EncryptUtil;
import com.obc.common.utils.EmailUtils;
import com.obc.common.utils.FreemarkerUtils;
import com.obc.common.utils.MoneStringUtils;
import com.obc.common.utils.ValidateCode;
import com.obc.modules.LoginPojo;
import com.obc.modules.sys.entity.BcSysUser;
import com.obc.modules.sys.service.BcSysUserService;

/**
 * 
 * <br>类名： ConsumerController 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:21:13 
 * @author FC
 */
@RequestMapping( "/consumer" )
@Controller
public class ConsumerController {

	@Autowired
	@Qualifier( "bcSysUserServiceImpl" )
	private BcSysUserService bcSysUserService;

	/**
	 * 
	 * <br>方法名： register
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:21:17 
	 * @param request
	 * @param user
	 * @param code
	 * @return
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
			if (StringUtils.isNotEmpty(code) && StringUtils.equals(code.toLowerCase(), validateCode.toLowerCase())
					&& code.length() == Canonical.num6) {
				bcSysUserService.addBcSysUser(user);
				em.addCuePhrases(Code.SuccesssMessage.getDesc()).addIsBool(true);
			} else {
				throw new Exception(Canonical.validateCodeMessage);
			}

		}
		catch (Exception e) {
			em.addCuePhrases(e.getMessage()).addIsBool(false);
			MoneStringUtils.log(e.getMessage(), ConsumerController.class);
		}
		return em;
	}

	/**
	 * 
	 * <br>方法名： register
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:21:23 
	 * @return
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
	 * <br>方法名： validateCode
	 * 
	 * <br>描述：【图片证码】 
	 * <br>创建时间： 2016年5月31日 上午2:46:55 
	 * @param request
	 * @param response
	 * @param user
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
		catch (IOException e) {}

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
		ExceptionMessage em = ExceptionMessage.newInstance();
		try {
			HttpSession session = request.getSession();
			int count = (int) (session.getAttribute("count") == null ? 0 : session.getAttribute("count"));
			if (count >= Canonical.num6) {//发件数控制
				em.addCuePhrases("请等会儿再发。");
				return em;
			}

			String emailCode = ValidateCode.createCode(Canonical.num6);
			Map<String, String> param = new HashMap<String, String>();
			String addressee = user.getEmail();//收件人

			param.put("addressee", addressee);
			param.put("validateCode", emailCode);
			String msg = FreemarkerUtils.genStrFormTemplate(TemplateFileName.registerCode, param);
			//发送邮件
			EmailUtils.send(addressee, msg, null);
			session.setAttribute("validateCode", emailCode);
			session.setAttribute("count", count + Canonical.num1);
			session.setMaxInactiveInterval(300);
			MoneStringUtils.log("验证码：" + emailCode, ConsumerController.class);
		}
		catch (Exception e) {
			MoneStringUtils.log("验证码获取异常：" + e.getMessage(), ConsumerController.class);
		}
		em.addCuePhrases("验证码发送成功。");
		return em;
	}
}
