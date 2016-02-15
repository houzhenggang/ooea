package com.obc.modules.sys.entity;

import com.obc.common.persistence.mybatis.DataEntity;

public class BcSysUserRole extends DataEntity<BcSysUserRole> {

	private static final long serialVersionUID = -5302468075953464824L;
	private Long sys_user_role_id;// '用户角色ID',
	private Long sys_user_id;// '用户ID',
	private Long sys_role_id;// '角色ID',

	public Long getSys_user_role_id() {
		return sys_user_role_id;
	}

	public void setSys_user_role_id(Long sys_user_role_id) {
		this.sys_user_role_id = sys_user_role_id;
	}

	public Long getSys_user_id() {
		return sys_user_id;
	}

	public void setSys_user_id(Long sys_user_id) {
		this.sys_user_id = sys_user_id;
	}

	public Long getSys_role_id() {
		return sys_role_id;
	}

	public void setSys_role_id(Long sys_role_id) {
		this.sys_role_id = sys_role_id;
	}

}
