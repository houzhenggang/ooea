package com.obc.listener;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Session;

import org.springframework.jms.listener.SessionAwareMessageListener;

import com.obc.mq.ConsumerService;
import com.obc.mq.p2p.entity.MessageReq;
import com.obc.mq.p2p.entity.MessageResp;

public class SmsConsumerSessionAwareMessageListener implements SessionAwareMessageListener<MapMessage> {
	
	private Map<String, ConsumerService<MessageResp, MessageReq>> taskMap;
	private Map<String, Integer>								  taskExeTimeMap;
																  
	public void setTaskMap ( Map<String, ConsumerService<MessageResp, MessageReq>> taskMap ) {
		this.taskMap = taskMap;
	}
	
	public void setTaskExeTimeMap ( Map<String, Integer> taskExeTimeMap ) {
		this.taskExeTimeMap = taskExeTimeMap;
	}
	
	@Override
	public void onMessage ( MapMessage message ,
	                        Session session ) throws JMSException {
		String task = message.getString("taskId");
		final ConsumerService<MessageResp, MessageReq> consumer = taskMap.get(task);
		Date now = new Date();
		MessageResp resp = consumer.exec(new MessageReq());
		
		Date curDate = new Date();
		int mustTime = taskExeTimeMap.get(task);
		Calendar ca = Calendar.getInstance();
		ca.setTime(now);
		ca.add(Calendar.MINUTE, mustTime);
		Date gsDate = ca.getTime();
		
		if (curDate.after(gsDate)) {
			// 记录超时信息
			return;
		}
	}
}