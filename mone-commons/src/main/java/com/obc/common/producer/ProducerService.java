package com.obc.common.producer;

import java.util.Map;

public interface ProducerService {
	
	void smsSendMessage ( Map<String, Object> obj );
	
}
