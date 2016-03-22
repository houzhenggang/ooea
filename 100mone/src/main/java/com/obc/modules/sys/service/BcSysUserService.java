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
	
	/**
	 * 
	 * @Title: updateBcSysUser
	 * 
	 * @author FC
	 * @Description: TODO 【更新】
	 * @param bcSysUser
	 * @return
	 * @date 2016年3月22日 下午7:05:00
	 */
	public BcSysUser updateBcSysUser ( BcSysUser bcSysUser );

	/**
	 * 
	 * @Title: addBcSysUser
	 * 
	 * @author FC
	 * @Description: TODO 【新增】
	 * @param bcSysUser
	 * @return
	 * @date 2016年3月22日 下午7:05:04
	 */
	public BcSysUser addBcSysUser ( BcSysUser bcSysUser );
}
