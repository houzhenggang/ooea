package com.obc.modules.goods.entity;

import java.io.Serializable;

public class MoneGoods implements Serializable {
	
	/** 
	 * <br>创建时间： 2016年6月25日 下午9:34:06 
	 * @Fields serialVersionUID : TODO 【】
	 */ 
	private static final long serialVersionUID = 6680177384170063337L;
	
	private Integer	goods_id;	  /* 商品id */
	private String	goods_name;	  /* 商品名称 */
	private String	goods_title;  /* 标题 */
	private String	trade_id;	  /* 分类id */
	private String	image;		  /* 商品图 */
	private String	server_code;  /* 图片服务器name */
	private Integer	goods_attr_id;/* 商品属性集id */
	private String	status;		  /* 商品状态 */
	private String	audit_status; /* 审核状态 */
	private String	update_time;  /* 操作时间 */
	private String	create_time;  /* 创建时间 */
	private Integer	order_id;	  /* 设计创建id */
								  
	public Integer getGoods_id ( ) {
		return goods_id;
	}
	
	public void setGoods_id ( Integer goods_id ) {
		this.goods_id = goods_id;
	}
	
	public String getGoods_name ( ) {
		return goods_name;
	}
	
	public void setGoods_name ( String goods_name ) {
		this.goods_name = goods_name;
	}
	
	public String getGoods_title ( ) {
		return goods_title;
	}
	
	public void setGoods_title ( String goods_title ) {
		this.goods_title = goods_title;
	}
	
	public String getTrade_id ( ) {
		return trade_id;
	}
	
	public void setTrade_id ( String trade_id ) {
		this.trade_id = trade_id;
	}
	
	public String getImage ( ) {
		return image;
	}
	
	public void setImage ( String image ) {
		this.image = image;
	}
	
	public String getServer_code ( ) {
		return server_code;
	}
	
	public void setServer_code ( String server_code ) {
		this.server_code = server_code;
	}
	
	public Integer getGoods_attr_id ( ) {
		return goods_attr_id;
	}
	
	public void setGoods_attr_id ( Integer goods_attr_id ) {
		this.goods_attr_id = goods_attr_id;
	}
	
	public String getStatus ( ) {
		return status;
	}
	
	public void setStatus ( String status ) {
		this.status = status;
	}
	
	public String getAudit_status ( ) {
		return audit_status;
	}
	
	public void setAudit_status ( String audit_status ) {
		this.audit_status = audit_status;
	}
	
	public String getUpdate_time ( ) {
		return update_time;
	}
	
	public void setUpdate_time ( String update_time ) {
		this.update_time = update_time;
	}
	
	public String getCreate_time ( ) {
		return create_time;
	}
	
	public void setCreate_time ( String create_time ) {
		this.create_time = create_time;
	}
	
	public Integer getOrder_id ( ) {
		return order_id;
	}
	
	public void setOrder_id ( Integer order_id ) {
		this.order_id = order_id;
	}
	
}
