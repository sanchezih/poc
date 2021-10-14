package com.sanchezih.mq.activemq.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicSubscriber {

	// Nombre de usuario predeterminado
	public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

	// Password predeterminada
	public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

	// Dirección de conexión predeterminada
	public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) {

		// Crea una fábrica de conexiones
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);

		try {
			// Crear conexion
			Connection connection = connectionFactory.createConnection();

			// Abre la conexion
			connection.start();

			// Crea una sesión sin transaccion
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Crear tema
			Topic myTestTopic = session.createTopic("activemq-topic-test1");

			MessageConsumer messageConsumer = session.createConsumer(myTestTopic);
			messageConsumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					try {
						System.out.println("El consumidor 1 recibio el mensaje:" + ((TextMessage) message).getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});

			MessageConsumer messageConsumer2 = session.createConsumer(myTestTopic);
			messageConsumer2.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					try {
						System.out.println("El consumidor 2 recibio el mensaje:" + ((TextMessage) message).getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});

			MessageConsumer messageConsumer3 = session.createConsumer(myTestTopic);
			messageConsumer3.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					try {
						System.out.println("El consumidor 3 recibio el mensaje:" + ((TextMessage) message).getText());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});

			/**
			 * Deje que el hilo principal duerma durante 100 segundos, para que el objeto
			 * consumidor de mensajes pueda continuar activo durante un periodo de tiempo
			 * para que el mensaje pueda ser monitoreado
			 */
			Thread.sleep(100 * 1000);

			// Cerrar recursos
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
