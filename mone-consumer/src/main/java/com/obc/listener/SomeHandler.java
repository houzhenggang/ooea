package com.obc.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

public class SomeHandler implements ErrorHandler {
	protected Logger log = LoggerFactory.getLogger(SomeHandler.class);
	
	@Override
	public void handleError ( Throwable throwable ) {
		log.error("Error in listener", throwable);
	}
	
}