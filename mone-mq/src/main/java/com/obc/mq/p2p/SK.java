package com.obc.mq.p2p;

import com.obc.mq.MqService;
import com.obc.mq.p2p.entity.MessageReq;

public interface SK {
	
	MessageReq dkem(MqService s);
	
}
