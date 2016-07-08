package com.obc.mq.p2p;

import com.obc.mq.ConsumerService;
import com.obc.mq.p2p.entity.MessageReq;
import com.obc.mq.p2p.entity.MessageResp;

public class EmailMessageService implements ConsumerService<MessageResp, MessageReq> {
	
	@Override
	public MessageResp exec ( MessageReq param ) {
		
		return null;
	}
	
}
