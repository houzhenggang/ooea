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

public class SMSConsumerSessionAwareMessageListener implements SessionAwareMessageListener<MapMessage> {
	
	private Map<String, ConsumerService<MessageResp, MessageReq>> taskMap;
	private Map<String, Integer>								 exeTimeMap;
	
	public void setTaskMap ( Map<String, ConsumerService<MessageResp, MessageReq>> taskMap ) {
		this.taskMap = taskMap;
	}
	
	public void setExeTimeMap ( Map<String, Integer> exeTimeMap ) {
		this.exeTimeMap = exeTimeMap;
	}
	
	@Override
	public void onMessage ( MapMessage message ,
	                        Session session ) throws JMSException {
		String task = message.getString("taskId");
		final ConsumerService<MessageResp, MessageReq> ms = taskMap.get(task);
		Date now = new Date();
		MessageResp resp = ms.exec(new MessageReq());
		
		Date curDate = new Date();
		int mustTime = exeTimeMap.get(task);
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