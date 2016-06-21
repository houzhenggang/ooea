package com.obc.modules.sys.entity;

import java.io.Serializable;

/**
 * 
 * <br>类名： BcSysUserMenuPermission 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:26:52 
 * @author FC
 */
public class BcSysUserMenuPermission implements Serializable {
	
	/**
	 * <br>创建时间： 2016年5月31日 上午2:16:18
	 * @Fields serialVersionUID : TODO 【】
	 */
	private static final long serialVersionUID = -6913888823373584535L;
											   
	private Long			  sys_user_menu_permission_id;			   /* 角色菜单权限关联表ID */
	private Long			  sys_user_id;							   /* 角色ID */
	private Long			  sys_menu_id;							   /* 菜单ID */
	private Long			  sys_menu_permission_id;				   /* 权限ID */
																	   
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
