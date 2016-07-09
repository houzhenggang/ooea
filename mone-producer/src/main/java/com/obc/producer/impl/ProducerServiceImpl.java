package com.obc.producer.impl;

import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.obc.producer.ProducerService;

/**
 * 
 * <br>
 * 类名： ProducerServiceImpl
 *
 * <br>
 * 公司名称： 【】
 * <br>
 * 描述：【消息发送】
 * <br>
 * 创建时间： 2016年7月9日 上午12:40:52
 * @author FC
 */
@Service( "producerServiceImpl" )
public class ProducerServiceImpl implements ProducerService {
	
	/* 消息模板 */
	private JmsTemplate	jmsTemplate;
	
	/* 短信消息标记 */
	private Destination	smsDestination;
	
	/* email消息标记 */
	private Destination	emailDestination;
						
	public void setJmsTemplate ( JmsTemplate jmsTemplate ) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void setSmsDestination ( Destination smsDestination ) {
		this.smsDestination = smsDestination;
	}
	
	public void setEmailDestination ( Destination emailDestination ) {
		this.emailDestination = emailDestination;
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
	
	@Override
	public void emailSendMessage ( Map<String, Object> obj ) {
		jmsTemplate.send(emailDestination, new MessageCreator() {
			
			@Override
			public Message createMessage ( Session session ) throws JMSException {
				Topic Topic = session.createTopic("");
				MessageConsumer consumer = session.createConsumer(Topic);
				consumer.receive();
				return null;
			}
			
		});
		
	}
	
}
