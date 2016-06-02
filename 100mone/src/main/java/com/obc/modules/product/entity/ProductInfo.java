package com.obc.modules.product.entity;

import java.io.Serializable;

public class ProductInfo implements Serializable {
	
	/**
	 * <br>
	 * 创建时间： 2016年6月3日 上午1:57:42
	 * @Fields serialVersionUID : TODO 【】
	 */
	private static final long serialVersionUID = -4293138853656754184L;
	private Integer			  product_id;							   /* 商品ID */
	private String			  product_name;							   /* 商品名称 */
	private String			  img_url;								   /* 图片url */
	private String			  server_code;							   /* 服务器ID */
	private String			  description;							   /* 描述 */
	private String			  product_status;						   /* 商品状态 */
	private String			  is_valid;								   /* 是否有效[1：有效 0：无效] */
																	   
	public Integer getProduct_id ( ) {
		return product_id;
	}
	
	public void setProduct_id ( Integer product_id ) {
		this.product_id = product_id;
	}
	
	public String getProduct_name ( ) {
		return product_name;
	}
	
	public void setProduct_name ( String product_name ) {
		this.product_name = product_name;
	}
	
	public String getImg_url ( ) {
		return img_url;
	}
	
	public void setImg_url ( String img_url ) {
		this.img_url = img_url;
	}
	
	public String getServer_code ( ) {
		return server_code;
	}
	
	public void setServer_code ( String server_code ) {
		this.server_code = server_code;
	}
	
	public String getDescription ( ) {
		return description;
	}
	
	public void setDescription ( String description ) {
		this.description = description;
	}
	
	public String getProduct_status ( ) {
		return product_status;
	}
	
	public void setProduct_status ( String product_status ) {
		this.product_status = product_status;
	}
	
	public String getIs_valid ( ) {
		return is_valid;
	}
	
	public void setIs_valid ( String is_valid ) {
		this.is_valid = is_valid;
	}
	
}
