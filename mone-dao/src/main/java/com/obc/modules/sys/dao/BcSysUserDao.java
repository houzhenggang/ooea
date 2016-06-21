package com.obc.modules.sys.dao;

import java.util.List;

import com.obc.modules.sys.entity.BcSysUser;
/**
 * 
 * <br>类名： BcSysUserDao 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:19:55 
 * @author FC
 */
public interface BcSysUserDao {

	/**
	 * 
	 * <br>方法名： findBcSysUser
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:19:52 
	 * @param username
	 * @return
	 */
	public List<BcSysUser> findBcSysUser ( String username );

	/**
	 * 
	 * <br>方法名： updateBcSysUser
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:19:59 
	 * @param bsu
	 * @return
	 */
	public int updateBcSysUser ( BcSysUser bsu );

	/**
	 * 
	 * <br>方法名： addBcSysUser
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:20:03 
	 * @param bsu
	 * @return
	 */
	public int addBcSysUser ( BcSysUser bsu );
}
