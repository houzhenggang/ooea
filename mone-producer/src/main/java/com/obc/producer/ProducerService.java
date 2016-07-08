package com.obc.producer;

import java.util.Map;

public interface ProducerService {
	
	void smsSendMessage ( Map<String, Object> obj );
	
}
