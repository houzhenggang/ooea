package com.obc.modules.sys.entity;

import java.io.Serializable;

/**
 * 
 * <br>类名： BcSysRole 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:29:46 
 * @author FC
 */
public class BcSysRole implements Serializable {
	
	/**
	 * <br>创建时间： 2016年5月31日 上午2:15:08
	 * @Fields serialVersionUID : TODO 【】
	 */
	private static final long serialVersionUID = -3945025576243746482L;
											   
	private Long			  sys_role_id;							   /* 角色ID */
	private String			  name;									   /* 角色名 */
	private String			  sn;									   /* 角色标识 */
																	   
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
