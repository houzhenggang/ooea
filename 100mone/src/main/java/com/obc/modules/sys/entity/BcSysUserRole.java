package com.obc.modules.sys.entity;

import java.io.Serializable;

/**
 * 
 * <br>类名： BcSysUserRole 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:25:51 
 * @author FC
 */
public class BcSysUserRole implements Serializable {
	
	/**
	 * <br>创建时间： 2016年5月31日 上午2:18:07
	 * @Fields serialVersionUID : TODO 【】
	 */
	private static final long serialVersionUID = 743171751539681525L;
											   
	private Long			  sys_user_role_id;						 /* 用户角色ID */
	private Long			  sys_user_id;							 /* 用户ID */
	private Long			  sys_role_id;							 /* 角色ID */
																	 
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
