package com.obc.modules.sys.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: BcSysMeum
 *
 * @author FC
 * @Description: TODO 【这里用一句话描述这个类的作用】
 * @date 2016年2月20日 下午9:03:12
 */
public class BcSysMeum implements Serializable {

	/**
	 * @author FC
	 * @Fields serialVersionUID : TODO 【用一句话描述这个变量表示什么】
	 * @date 2016年3月21日 下午8:39:21
	 */
	private static final long serialVersionUID = -679417266901092660L;

	private String sn;// '菜单标识'
	private String name;// '菜单显示名称'
	private Long priority;// '显示顺序'
	private Long parent_id;// '父菜单'
	private String description;// '菜单描述'
	private String url;// '菜单URL'

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
