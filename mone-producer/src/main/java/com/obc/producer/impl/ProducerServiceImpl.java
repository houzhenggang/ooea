package com.obc.producer.impl;

import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.obc.producer.ProducerService;


public class ProducerServiceImpl implements ProducerService {
	
	private Destination	smsDestination;
	private JmsTemplate	jmsTemplate;
	
	public void setSmsDestination ( Destination smsDestination ) {
		this.smsDestination = smsDestination;
	}
	
	public void setJmsTemplate ( JmsTemplate jmsTemplate ) {
		this.jmsTemplate = jmsTemplate;
	}
	
	@Override
	public void smsSendMessage ( final Map<String, Object> obj ) {
		// 消息发送
		jmsTemplate.send(smsDestination, new MessageCreator() {
			@Override
			public Message createMessage ( Session session ) throws JMSException {
				MapMessage mm = session.createMapMessage();
				for (String key : obj.keySet()) {
					mm.setObject(key, obj.get(key));
				}
				return mm;
			}
		});
		
	}
	
}
