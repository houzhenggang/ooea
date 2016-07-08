package com.obc.mq.p2p;

import org.springframework.stereotype.Service;

import com.obc.mq.ConsumerService;
import com.obc.mq.p2p.entity.MessageReq;
import com.obc.mq.p2p.entity.MessageResp;

@Service("smsMessageService")
public class SmsMessageService implements ConsumerService<MessageResp, MessageReq> {
	
	@Override
	public MessageResp exec ( MessageReq param ) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
