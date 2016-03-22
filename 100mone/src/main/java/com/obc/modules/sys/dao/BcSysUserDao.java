package com.obc.modules.sys.dao;

import java.util.List;

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
	public List<BcSysUser> findBcSysUser ( String username );

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
	public int updateBcSysUser ( BcSysUser bcSysUser );

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
	public int addBcSysUser ( BcSysUser bcSysUser );
}
