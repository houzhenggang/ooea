package com.obc.mq;

/**
 * <br>类名： MqService 
 *
 * <br>公司名称： 【】
 * <br>描述：【mq消息接口】
 * <br>创建时间： 2016年7月5日 下午7:35:36 
 * @author FC
 */
public interface MqService<T, E> {
	
	/**
	 * <br>方法名： exec
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年7月5日 下午7:35:32 
	 * @param param E消息体
	 * @return T消息响应
	 */
	T exec ( E param );
	
}
