package com.obc.consumer.p2p;

import org.springframework.stereotype.Service;

import com.obc.consumer.ConsumerService;
import com.obc.consumer.p2p.entity.MessageReq;
import com.obc.consumer.p2p.entity.MessageResp;

@Service("emailMessageService")
public class EmailMessageService implements ConsumerService<MessageResp, MessageReq> {
	
	@Override
	public MessageResp exec ( MessageReq param ) {
		
		return null;
	}
	
}
