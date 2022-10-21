package com.sanchezih.activemq.p2p.productor;

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

	/**
	 * 
	 * @throws JMSException
	 */
	public void sendMessages(int messagesQty) throws JMSException {

		/*
		 * ActiveMQConnectionFactory se utiliza para crear una conexion con el
		 * proveedor, encapsulando un conjunto de parametros de configuracion de la
		 * conexion que han sido previamente definidos por el administrador del servidor
		 * de mensajes
		 */
		final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);

		// Mediante una Connection se crean una o mas sesiones en las que se producen y
		// se consumen mensajes.
		Connection connection = connectionFactory.createConnection();

		// Llamada a start() para permitir el envio de mensajes
		connection.start();

		// Se crea una sesion transaccional
		final Session session = connection.createSession(TRANSACTED_SESSION, Session.AUTO_ACKNOWLEDGE);

		final Destination destination = session.createQueue(DESTINATION_QUEUE);

		// Se crea el productor a partir de una cola
		final MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		sendMessages(session, producer, messagesQty);
		session.commit();

		// Al finalizar se cierra toda conexion
		session.close();
		connection.close();

		System.out.println(messagesQty + " mensajes enviados correctamente");
	}

	/**
	 * 
	 * @param session
	 * @param producer
	 * @throws JMSException
	 */
	private void sendMessages(Session session, MessageProducer producer, int messagesQty) throws JMSException {
		final MessageSender messageSender = new MessageSender();
		for (int i = 1; i <= messagesQty; i++) {
			final UserAction userActionToSend = getRandomUserAction();
			messageSender.sendMessage(userActionToSend.getActionAsString(), session, producer);
		}
	}

	/**
	 * 
	 * @param message
	 * @param session
	 * @param producer
	 * @throws JMSException
	 */
	private void sendMessage(String message, Session session, MessageProducer producer) throws JMSException {
		final TextMessage textMessage = session.createTextMessage(message);
		producer.send(textMessage);
	}

	/**
	 * 
	 * @return
	 */
	private static UserAction getRandomUserAction() {
		final int userActionNumber = (int) (RANDOM.nextFloat() * UserAction.values().length);
		return UserAction.values()[userActionNumber];
	}

}