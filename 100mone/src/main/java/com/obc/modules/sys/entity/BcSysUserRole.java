package com.obc.modules.sys.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: BcSysUserRole
 *
 * @author FC
 * @Description: TODO 【这里用一句话描述这个类的作用】
 * @date 2016年2月20日 下午9:03:34
 */
public class BcSysUserRole implements Serializable {

	/**
	 * @author FC
	 * @Fields serialVersionUID : TODO 【用一句话描述这个变量表示什么】
	 * @date 2016年3月21日 下午8:39:21
	 */
	private static final long serialVersionUID = -5302468075953464824L;
	
	private Long sys_user_role_id;// '用户角色ID',
	private Long sys_user_id;// '用户ID',
	private Long sys_role_id;// '角色ID',

	public Long getSys_user_role_id ( ) {
		return sys_user_role_id;
	}

	public void setSys_user_role_id ( Long sys_user_role_id ) {
		this.sys_user_role_id = sys_user_role_id;
	}

	public Long getSys_user_id ( ) {
		return sys_user_id;
	}

	public void setSys_user_id ( Long sys_user_id ) {
		this.sys_user_id = sys_user_id;
	}

	public Long getSys_role_id ( ) {
		return sys_role_id;
	}

	public void setSys_role_id ( Long sys_role_id ) {
		this.sys_role_id = sys_role_id;
	}

	public BcSysUserRole ( ) {
		super();
	}

	public BcSysUserRole ( Long sys_user_role_id , Long sys_user_id , Long sys_role_id ) {
		super();
		this.sys_user_role_id = sys_user_role_id;
		this.sys_user_id = sys_user_id;
		this.sys_role_id = sys_role_id;
	}

}
