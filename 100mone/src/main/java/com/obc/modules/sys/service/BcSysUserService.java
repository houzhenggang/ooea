package com.obc.modules.sys.service;

import com.obc.modules.sys.entity.BcSysUser;

/**
 * 
 * <br>类名： BcSysUserService 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:18:28 
 * @author FC
 */
public interface BcSysUserService {

	/**
	 * 
	 * <br>方法名： findBcSysUser
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:18:31 
	 * @param username
	 * @return
	 */
	public BcSysUser findBcSysUser ( String username );
	
	/**
	 * 
	 * <br>方法名： updateBcSysUser
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:18:35 
	 * @param bcSysUser
	 * @return
	 */
	public BcSysUser updateBcSysUser ( BcSysUser bcSysUser );

	/**
	 * 
	 * <br>方法名： addBcSysUser
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:18:42 
	 * @param bcSysUser
	 * @return
	 */
	public BcSysUser addBcSysUser ( BcSysUser bcSysUser );
}
