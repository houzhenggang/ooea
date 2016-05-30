package com.obc.modules.sys.entity;

import java.io.Serializable;

/**
 * 
 * <br>类名： BcSysMenuPermission 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:30:56 
 * @author FC
 */
public class BcSysMenuPermission implements Serializable {
	
	/**
	 * <br>创建时间： 2016年5月31日 上午2:15:26
	 * @Fields serialVersionUID : TODO 【】
	 */
	private static final long serialVersionUID = 4158879638694457623L;
											   
	private Long			  sys_menu_permission_id;				  /* 权限ID */
	private String			  sn;									  /* 权限关键字 */
	private String			  name;									  /* 权限名称 */
	private String			  is_valid;								  /* 权限有效性【1：有效0：无效】 */
	private Long			  menu_id;								  /* 菜单ID */
																	  
	public Long getSys_menu_permission_id ( ) {
		return sys_menu_permission_id;
	}
	
	public void setSys_menu_permission_id ( Long sys_menu_permission_id ) {
		this.sys_menu_permission_id = sys_menu_permission_id;
	}
	
	public String getSn ( ) {
		return sn;
	}
	
	public void setSn ( String sn ) {
		this.sn = sn;
	}
	
	public String getName ( ) {
		return name;
	}
	
	public void setName ( String name ) {
		this.name = name;
	}
	
	public String getIs_valid ( ) {
		return is_valid;
	}
	
	public void setIs_valid ( String is_valid ) {
		this.is_valid = is_valid;
	}
	
	public Long getMenu_id ( ) {
		return menu_id;
	}
	
	public void setMenu_id ( Long menu_id ) {
		this.menu_id = menu_id;
	}
	
	public BcSysMenuPermission ( ) {
		super();
	}
	
	public BcSysMenuPermission ( Long sys_menu_permission_id ,
	        String sn ,
	        String name ,
	        String is_valid ,
	        Long menu_id ) {
		super();
		this.sys_menu_permission_id = sys_menu_permission_id;
		this.sn = sn;
		this.name = name;
		this.is_valid = is_valid;
		this.menu_id = menu_id;
	}
	
}
