package com.obc.modules.sys.entity;

import com.obc.common.persistence.mybatis.BaseEntity;

public class BcSysRole extends BaseEntity<BcSysRole> {

	private static final long serialVersionUID = 3905063886850190481L;
	private Long sys_role_id;// '角色ID'
	private String name;// '角色名'
	private String sn;// '角色标识'

	public Long getSys_role_id() {
		return sys_role_id;
	}

	public void setSys_role_id(Long sys_role_id) {
		this.sys_role_id = sys_role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

}
