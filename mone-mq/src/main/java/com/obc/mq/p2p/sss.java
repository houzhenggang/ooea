package com.obc.mq.p2p;

import com.obc.mq.MqService;
import com.obc.mq.p2p.entity.MessageReq;
import com.obc.mq.p2p.entity.MessageResp;

public class sss implements SK {
	
	@Override
	public MessageReq dkem ( MqService s ) {
		// TODO Auto-generated method stub
		
		return new MessageReq();
	}
	
	public static void main ( String[] args ) {
		MessageReq s = new sss().dkem(new MqService<MessageResp, MessageReq>() {
			@Override
			public MessageResp exec ( MessageReq param ) {
				// TODO Auto-generated method stub
				System.out.println("ssdfsa"+param);
				return new MessageResp();
			}
			
			
		});
		
		
		KeyBroad kb = new KeyBroad();
		NetCardBroad ncb = new NetCardBroad();
		CheckBroad cb = new CheckBroad();
		cb.getMainMessage(kb);
		cb.getMainMessage(ncb);
	}
}
