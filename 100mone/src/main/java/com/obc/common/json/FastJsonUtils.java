package com.obc.common.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 
 * @ClassName: FastJsonUtils
 *
 * @author FC
 * @Description: TODO 【fastJson解析】
 * @date 2016年3月6日 下午8:12:44
 */
public class FastJsonUtils<T> {

	/**
	 * 
	 * @Title: toJSONString
	 * 
	 * @author FC
	 * @Description: TODO 【这里用一句话描述这个方法的作用】
	 * @param object
	 *            【】
	 * @param dateFormat
	 *            【yyyy-MM-dd HH:mm:ss|yyyy-MM-dd】
	 * @param key
	 *            【1|2|3|】
	 * @return
	 * @date 2016年3月6日 下午8:22:03
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
	 * @Title: parseObject
	 * 
	 * @author FC
	 * @Description: TODO 【这里用一句话描述这个方法的作用】
	 * @param text
	 * @param clazz
	 * @return
	 * @date 2016年3月6日 下午8:22:33
	 */
	public Object parseObject (	String text ,
								Class<T> clazz ) {

		Object object = JSON.parseObject(text, clazz);
		return object;
	}
}
