package com.obc.modules.sys.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: BcSysUserMenuPermission
 *
 * @author FC
 * @Description: TODO 【这里用一句话描述这个类的作用】
 * @date 2016年2月20日 下午9:03:28
 */
public class BcSysUserMenuPermission implements Serializable {

	/**
	 * @author FC
	 * @Fields serialVersionUID : TODO 【用一句话描述这个变量表示什么】
	 * @date 2016年3月21日 下午8:38:05
	 */
	private static final long serialVersionUID = -6913888823373584535L;

	private Long sys_user_menu_permission_id;// '角色菜单权限关联表ID'
	private Long sys_user_id;// '角色ID'
	private Long sys_menu_id;// '菜单ID'
	private Long sys_menu_permission_id;// '权限ID'

	public Long getSys_user_menu_permission_id ( ) {
		return sys_user_menu_permission_id;
	}

	public void setSys_user_menu_permission_id ( Long sys_user_menu_permission_id ) {
		this.sys_user_menu_permission_id = sys_user_menu_permission_id;
	}

	public Long getSys_user_id ( ) {
		return sys_user_id;
	}

	public void setSys_user_id ( Long sys_user_id ) {
		this.sys_user_id = sys_user_id;
	}

	public Long getSys_menu_id ( ) {
		return sys_menu_id;
	}

	public void setSys_menu_id ( Long sys_menu_id ) {
		this.sys_menu_id = sys_menu_id;
	}

	public Long getSys_menu_permission_id ( ) {
		return sys_menu_permission_id;
	}

	public void setSys_menu_permission_id ( Long sys_menu_permission_id ) {
		this.sys_menu_permission_id = sys_menu_permission_id;
	}

	public BcSysUserMenuPermission ( ) {
		super();
	}

	public BcSysUserMenuPermission ( Long sys_user_menu_permission_id ,
			Long sys_user_id ,
			Long sys_menu_id ,
			Long sys_menu_permission_id ) {
		super();
		this.sys_user_menu_permission_id = sys_user_menu_permission_id;
		this.sys_user_id = sys_user_id;
		this.sys_menu_id = sys_menu_id;
		this.sys_menu_permission_id = sys_menu_permission_id;
	}

}
