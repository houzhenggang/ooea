package com.obc.modules.product.entity;

import java.io.Serializable;

public class ProductImage implements Serializable {
	
	/**
	 * <br>
	 * 创建时间： 2016年6月3日 上午1:55:30
	 * @Fields serialVersionUID : TODO 【】
	 */
	private static final long serialVersionUID = -1224831006972321659L;
	private String			  UUID;									   /* uuid */
	private String			  img_json;								   /* 图片名称 */
	private String			  server_code;							   /* 服务器ID */
	private String			  product_id;							   /* 商品ID */
	private String			  is_valid;								   /* 是否有效 */
																	   
	public String getUUID ( ) {
		return UUID;
	}
	
	public void setUUID ( String uUID ) {
		UUID = uUID;
	}
	
	public String getImg_json ( ) {
		return img_json;
	}
	
	public void setImg_json ( String img_json ) {
		this.img_json = img_json;
	}
	
	public String getServer_code ( ) {
		return server_code;
	}
	
	public void setServer_code ( String server_code ) {
		this.server_code = server_code;
	}
	
	public String getProduct_id ( ) {
		return product_id;
	}
	
	public void setProduct_id ( String product_id ) {
		this.product_id = product_id;
	}
	
	public String getIs_valid ( ) {
		return is_valid;
	}
	
	public void setIs_valid ( String is_valid ) {
		this.is_valid = is_valid;
	}
	
}
