package com.sanchezih.activemq.p2p.consumidor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class UserActionConsumer {

	private static final String URL = "tcp://localhost:61616";
	private static final String USER = ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String DESTINATION_QUEUE = "APLICATIONPRUEBA.QUEUE";
	private static final boolean TRANSACTED_SESSION = false;
	private static final int TIMEOUT = 1000;
	private final Map<String, Integer> consumedMessageTypes;
	private int totalConsumedMessages = 0;

	public UserActionConsumer() {
		this.consumedMessageTypes = new HashMap<String, Integer>();
	}

	/**
	 * 
	 * @throws JMSException
	 */
	public void processMessages() throws JMSException {

		final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);
		final Connection connection = connectionFactory.createConnection();

		// Llamar a start() para permitir la recepcion de mensajes
		connection.start();

		// Creamos una sesion sin transaccionalidad y con envio de acuse automatico
		final Session session = connection.createSession(TRANSACTED_SESSION, Session.AUTO_ACKNOWLEDGE);
		final Destination destination = session.createQueue(DESTINATION_QUEUE);

		// Creamos el consumidor a partir de una cola
		final MessageConsumer consumer = session.createConsumer(destination);

		processAllMessagesInQueue(consumer);

		// Cerramos los recursos
		consumer.close();
		session.close();
		connection.close();

		showProcessedResults();
	}

	/**
	 * 
	 * @param consumer
	 * @throws JMSException
	 */
	private void processAllMessagesInQueue(MessageConsumer consumer) throws JMSException {
		Message message;
		while ((message = consumer.receive(TIMEOUT)) != null) {
			proccessMessage(message);
		}
	}

	/**
	 * 
	 * @param message
	 * @throws JMSException
	 */
	private void proccessMessage(Message message) throws JMSException {
		if (message instanceof TextMessage) {
			final TextMessage textMessage = (TextMessage) message;
			final String text = textMessage.getText();
			incrementMessageType(text);
			totalConsumedMessages++;
		}
	}

	/**
	 * 
	 * @param message
	 */
	private void incrementMessageType(String message) {
		if (consumedMessageTypes.get(message) == null) {
			consumedMessageTypes.put(message, 1);
		} else {
			final int numberOfTypeMessages = consumedMessageTypes.get(message);
			consumedMessageTypes.put(message, numberOfTypeMessages + 1);
		}
	}

	/**
	 * 
	 */
	private void showProcessedResults() {
		System.out.println("Se procesaron " + totalConsumedMessages + " mensajes");
		for (String messageType : consumedMessageTypes.keySet()) {
			final int numberOfTypeMessages = consumedMessageTypes.get(messageType);
			System.out.println("Tipo " + messageType + " Procesados " + numberOfTypeMessages + " ("
					+ (numberOfTypeMessages * 100 / totalConsumedMessages) + "%)");
		}
	}

}