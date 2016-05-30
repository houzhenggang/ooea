package com.obc.modules.sys.entity;

import java.io.Serializable;

/**
 * 
 * <br>类名： BcSysMeum 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:30:26 
 * @author FC
 */
public class BcSysMeum implements Serializable {
	
	/**
	 * <br>创建时间： 2016年5月31日 上午2:15:36 
	 * @Fields serialVersionUID : TODO 【】
	 */ 
	private static final long serialVersionUID = -679417266901092660L;
	
	private String			  sn;/*菜单标识 */
	private String			  name;/*菜单显示名称 */
	private Long			  priority;/*显示顺序 */
	private Long			  parent_id;/*父菜单 */
	private String			  description;/*菜单描述 */
	private String			  url;/*菜单URL */
							  
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
	
	public Long getPriority ( ) {
		return priority;
	}
	
	public void setPriority ( Long priority ) {
		this.priority = priority;
	}
	
	public Long getParent_id ( ) {
		return parent_id;
	}
	
	public void setParent_id ( Long parent_id ) {
		this.parent_id = parent_id;
	}
	
	public String getDescription ( ) {
		return description;
	}
	
	public void setDescription ( String description ) {
		this.description = description;
	}
	
	public String getUrl ( ) {
		return url;
	}
	
	public void setUrl ( String url ) {
		this.url = url;
	}
	
	public BcSysMeum ( ) {
		super();
	}
	
	public BcSysMeum ( String sn , String name , Long priority , Long parent_id , String description , String url ) {
		super();
		this.sn = sn;
		this.name = name;
		this.priority = priority;
		this.parent_id = parent_id;
		this.description = description;
		this.url = url;
	}
	
}
