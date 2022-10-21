package com.sanchezih.activemq.pubsub.subscriber;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener {

	private String consumerName;

	public ConsumerMessageListener(String consumerName) {
		this.consumerName = consumerName;
	}

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println(consumerName + " recibe el mensaje: [" + textMessage.getText() + "]");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}