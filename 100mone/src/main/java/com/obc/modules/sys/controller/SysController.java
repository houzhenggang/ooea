package com.obc.modules.sys.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.obc.common.ExceptionMessage;
import com.obc.common.constant.PageUrl;
import com.obc.common.enumeration.Code;
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

	private static Logger log = Logger.getLogger(SysController.class);

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

	public String login ( ) {
		ExceptionMessage em = ExceptionMessage.newInstance();
		try {
			bcSysUserService.findBcSysUser("");
			em.addCuePhrases(Code.SuccesssMessage.getDesc()).addIsBool(true);
		} catch (Exception e) {
			log.info(e.getMessage());
			em.addCuePhrases(Code.i000010002EM.getDesc()).addIsBool(false);
		}
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
	public String loginout ( String loginSalt ) {
		if (StringUtils.equals(Code.loginSalt.getDesc(), loginSalt)) {
			return PageUrl.SysIndex;
		}
		return PageUrl.ConsumerIndex;
	}

}
