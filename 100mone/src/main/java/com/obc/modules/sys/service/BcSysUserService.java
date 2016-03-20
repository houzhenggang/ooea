package com.obc.modules.sys.service;

import com.obc.modules.sys.entity.BcSysUser;

public interface BcSysUserService {

	/**
	 * 
	 * @Title: findBcSysUser
	 * 
	 * @author FC
	 * @Description: TODO 【登陆】
	 * @param username
	 * @return
	 * @date 2016年3月19日 下午10:08:22
	 */
	public BcSysUser findBcSysUser ( String username );
}
