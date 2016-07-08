package com.obc.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;


@Component( "someHandler" )
public class SomeHandler implements ErrorHandler {
	protected Logger log = LoggerFactory.getLogger(SomeHandler.class);
	
	@Override
	public void handleError ( Throwable throwable ) {
		log.error("Error in listener", throwable);
	}
	
}