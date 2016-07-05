package a.b.c;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Session;

import org.springframework.jms.listener.SessionAwareMessageListener;

public class EmailConsumerSessionAwareMessageListener implements
		SessionAwareMessageListener<MapMessage> {

	@Override
	public void onMessage ( MapMessage mapMessage ,
	                        Session session ) throws JMSException {
		
	}
}