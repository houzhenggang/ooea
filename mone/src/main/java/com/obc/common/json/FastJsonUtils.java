package com.obc.common.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 
 * <br>类名： FastJsonUtils 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年5月31日 上午2:31:14 
 * @author FC
 */
public class FastJsonUtils<T> {

	/**
	 * 
	 * <br>方法名： toJSONString
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:31:21 
	 * @param object
	 * @param dateFormat 【yyyy-MM-dd HH:mm:ss|yyyy-MM-dd】
	 * @param key 【1|2|3|】
	 * @return
	 * @throws Exception
	 */
	public String toJSONString (	Object object ,
									String dateFormat ,
									Integer key ) throws Exception {
		String json = null;
		switch (key) {
		case 1:
			json = JSON.toJSONStringWithDateFormat(object, dateFormat, SerializerFeature.WriteDateUseDateFormat);
			break;
		default:
			json = JSON.toJSONString(object);
			break;
		}

		return json;
	}

	/**
	 * 
	 * <br>方法名： parseObject
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年5月31日 上午2:31:51 
	 * @param text
	 * @param clazz
	 * @return
	 */
	public Object parseObject (	String text ,
								Class<T> clazz ) {

		Object object = JSON.parseObject(text, clazz);
		return object;
	}
}
