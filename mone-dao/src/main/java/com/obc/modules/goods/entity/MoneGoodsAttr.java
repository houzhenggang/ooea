package com.obc.modules.goods.entity;

import java.io.Serializable;

public class MoneGoodsAttr implements Serializable {
	
	/** 
	 * <br>创建时间： 2016年6月25日 下午9:34:06 
	 * @Fields serialVersionUID : TODO 【】
	 */ 
	private static final long serialVersionUID = 668017738410633399L;
	
	private Integer	goods_attr_id;/* 商品属性集ID */
	private String	image_json;	  /* 图片集合{"NAME":"OJU8JKO0NHH.JPG","DESCRIPTION":"黑色"} */
	private String	update_time;  /* 操作时间 */
	private String	create_time;  /* 创建时间 */
	private String	is_valid;	  /* 是否有效 */
								  
	public Integer getGoods_attr_id ( ) {
		return goods_attr_id;
	}
	
	public void setGoods_attr_id ( Integer goods_attr_id ) {
		this.goods_attr_id = goods_attr_id;
	}
	
	public String getImage_json ( ) {
		return image_json;
	}
	
	public void setImage_json ( String image_json ) {
		this.image_json = image_json;
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
	
	public String getIs_valid ( ) {
		return is_valid;
	}
	
	public void setIs_valid ( String is_valid ) {
		this.is_valid = is_valid;
	}
	
}
