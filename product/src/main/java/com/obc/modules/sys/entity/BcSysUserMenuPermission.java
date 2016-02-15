package com.obc.modules.sys.entity;

import com.obc.common.persistence.mybatis.DataEntity;

public class BcSysUserMenuPermission extends DataEntity<BcSysUserMenuPermission> {

	private static final long serialVersionUID = 5638390700383305444L;

	private Long sys_user_menu_permission_id;// '角色菜单权限关联表ID'
	private Long sys_user_id;// '角色ID'
	private Long sys_menu_id;// '菜单ID'
	private Long sys_menu_permission_id;// '权限ID'

	public Long getSys_user_menu_permission_id() {
		return sys_user_menu_permission_id;
	}

	public void setSys_user_menu_permission_id(Long sys_user_menu_permission_id) {
		this.sys_user_menu_permission_id = sys_user_menu_permission_id;
	}

	public Long getSys_user_id() {
		return sys_user_id;
	}

	public void setSys_user_id(Long sys_user_id) {
		this.sys_user_id = sys_user_id;
	}

	public Long getSys_menu_id() {
		return sys_menu_id;
	}

	public void setSys_menu_id(Long sys_menu_id) {
		this.sys_menu_id = sys_menu_id;
	}

	public Long getSys_menu_permission_id() {
		return sys_menu_permission_id;
	}

	public void setSys_menu_permission_id(Long sys_menu_permission_id) {
		this.sys_menu_permission_id = sys_menu_permission_id;
	}

}
