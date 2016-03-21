package com.obc.modules.sys.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: BcSysRole
 *
 * @author FC
 * @Description: TODO 【这里用一句话描述这个类的作用】
 * @date 2016年2月20日 下午9:03:18
 */
public class BcSysRole implements Serializable {

	private static final long serialVersionUID = 3905063886850190481L;
	private Long sys_role_id;// '角色ID'
	private String name;// '角色名'
	private String sn;// '角色标识'

	public Long getSys_role_id ( ) {
		return sys_role_id;
	}

	public void setSys_role_id ( Long sys_role_id ) {
		this.sys_role_id = sys_role_id;
	}

	public String getName ( ) {
		return name;
	}

	public void setName ( String name ) {
		this.name = name;
	}

	public String getSn ( ) {
		return sn;
	}

	public void setSn ( String sn ) {
		this.sn = sn;
	}

	public BcSysRole ( ) {
		super();
	}

	public BcSysRole ( Long sys_role_id , String name , String sn ) {
		super();
		this.sys_role_id = sys_role_id;
		this.name = name;
		this.sn = sn;
	}

}
