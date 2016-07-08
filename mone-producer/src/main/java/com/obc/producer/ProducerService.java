package com.obc.producer;

import java.util.Map;

/**
 * 
 * <br>类名： ProducerService 
 *
 * <br>公司名称： 【】
 * <br>描述：【生产者、根据不同的方法生产不同的消息】
 * <br>创建时间： 2016年7月9日 上午12:35:27 
 * @author FC
 */
public interface ProducerService {
	
	/**
	 * 
	 * <br>方法名： smsSendMessage
	 * 
	 * <br>描述：【短信】 
	 * <br>创建时间： 2016年7月9日 上午12:35:15 
	 * @param obj
	 */
	void smsSendMessage ( Map<String, Object> obj );
	
	/**
	 * 
	 * <br>方法名： emailSendMessage
	 * 
	 * <br>描述：【email】 
	 * <br>创建时间： 2016年7月9日 上午12:35:19 
	 * @param obj
	 */
	void emailSendMessage ( Map<String, Object> obj );
}
