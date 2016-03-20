package com.obc.modules.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.obc.common.constant.PageUrl;
import com.obc.modules.sys.service.BcSysUserService;

@RequestMapping( "/login" )
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
	 * @Title: outlogin
	 * 
	 * @author FC
	 * @Description: TODO 【退出登录（后台）】
	 * @return
	 * @date 2016年3月19日 下午10:30:44
	 */
	@RequestMapping( "/outlogin.do" )
	public String outlogin ( ) {

		return PageUrl.SYSINDEX;
	}
}
