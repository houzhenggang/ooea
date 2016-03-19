package com.obc.modules.sys.service;

import com.obc.modules.sys.entity.BcSysUser;

public interface BcSysUserService {

	/**
	 * 登陆
	 * 
	 * @Title: findBcSysUser
	 * 
	 * @author FC
	 * @Description: TODO 【这里用一句话描述这个方法的作用】
	 * @param username
	 * @return
	 * @date 2016年3月19日 下午10:08:22
	 */
	public BcSysUser findBcSysUser ( String username );
}
