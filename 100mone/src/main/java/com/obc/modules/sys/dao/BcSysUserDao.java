package com.obc.modules.sys.dao;

import com.obc.modules.sys.entity.BcSysUser;

public interface BcSysUserDao {

	/**
	 * 
	 * @Title: findBcSysUser
	 * 
	 * @author FC
	 * @Description: TODO 【查找当前用户信息:登陆】
	 * @param username
	 * @return
	 * @date 2016年3月19日 下午9:55:01
	 */
	public BcSysUser findBcSysUser ( String username );
}
