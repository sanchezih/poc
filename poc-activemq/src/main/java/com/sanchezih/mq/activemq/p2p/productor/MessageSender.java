package com.sanchezih.mq.activemq.p2p.productor;

import java.util.Random;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {

	private static final Random RANDOM = new Random(System.currentTimeMillis());
	private static final String URL = "tcp://localhost:61616";
	private static final String USER = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String DESTINATION_QUEUE = "APLICATIONPRUEBA.QUEUE";
	private static final boolean TRANSACTED_SESSION = true;
	private static final int MESSAGES_TO_SEND = 20;

	public void sendMessages() throws JMSException {

		final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);

		Connection connection = connectionFactory.createConnection();

		// Llamar a start() para permitir el envio de mensajes
		connection.start();

		// Creamos una sesion sin transaccionalidad y con envio de acuse automatico
		final Session session = connection.createSession(TRANSACTED_SESSION, Session.AUTO_ACKNOWLEDGE);
		final Destination destination = session.createQueue(DESTINATION_QUEUE);

		// Creamos el productor a partir de una cola
		final MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		sendMessages(session, producer);
		session.commit();
		session.close();
		connection.close();
		System.out.println("Mensajes enviados correctamente");
	}

	private void sendMessages(Session session, MessageProducer producer) throws JMSException {
		final MessageSender messageSender = new MessageSender();
		for (int i = 1; i <= MESSAGES_TO_SEND; i++) {
			final UserAction userActionToSend = getRandomUserAction();
			messageSender.sendMessage(userActionToSend.getActionAsString(), session, producer);
		}
	}

	private void sendMessage(String message, Session session, MessageProducer producer) throws JMSException {
		final TextMessage textMessage = session.createTextMessage(message);
		producer.send(textMessage);
	}

	private static UserAction getRandomUserAction() {
		final int userActionNumber = (int) (RANDOM.nextFloat() * UserAction.values().length);
		return UserAction.values()[userActionNumber];
	}

}