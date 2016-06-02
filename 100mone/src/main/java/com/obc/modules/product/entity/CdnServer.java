package com.obc.modules.product.entity;

import java.io.Serializable;
import java.util.Date;

public class CdnServer implements Serializable {
	
	/**
	 * <br>
	 * 创建时间： 2016年6月3日 上午1:52:00
	 * @Fields serialVersionUID : TODO 【】
	 */
	private static final long serialVersionUID = -4622505497191387385L;
											   
	private Integer			  server_id;							   /* 服务器id */
	private String			  server_name;							   /* 服务器名称 */
	private String			  description;							   /* 描述 */
	private String			  server_use;							   /* 用途 */
	private String			  project_name;							   /* 来自项目 */
	private String			  server_url;							   /* 配置地址 */
	private Date			  conf_time;							   /* 配置时间 */
																	   
	public Integer getServer_id ( ) {
		return server_id;
	}
	
	public void setServer_id ( Integer server_id ) {
		this.server_id = server_id;
	}
	
	public String getServer_name ( ) {
		return server_name;
	}
	
	public void setServer_name ( String server_name ) {
		this.server_name = server_name;
	}
	
	public String getDescription ( ) {
		return description;
	}
	
	public void setDescription ( String description ) {
		this.description = description;
	}
	
	public String getServer_use ( ) {
		return server_use;
	}
	
	public void setServer_use ( String server_use ) {
		this.server_use = server_use;
	}
	
	public String getProject_name ( ) {
		return project_name;
	}
	
	public void setProject_name ( String project_name ) {
		this.project_name = project_name;
	}
	
	public String getServer_url ( ) {
		return server_url;
	}
	
	public void setServer_url ( String server_url ) {
		this.server_url = server_url;
	}
	
	public Date getConf_time ( ) {
		return conf_time;
	}
	
	public void setConf_time ( Date conf_time ) {
		this.conf_time = conf_time;
	}
	
}
