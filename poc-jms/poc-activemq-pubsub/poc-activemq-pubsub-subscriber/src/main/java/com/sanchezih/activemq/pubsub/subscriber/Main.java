package com.sanchezih.activemq.pubsub.subscriber;

import java.util.concurrent.TimeUnit;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Main {

	// Nombre de usuario predeterminado
	public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

	// Password predeterminada
	public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

	// Direccion de conexion predeterminada
	public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) {

		// Crear conexion
		Connection connection;

		// Crea una fabrica de conexiones
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);

		try {
			connection = connectionFactory.createConnection();

			// Crea una sesion sin transaccion
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Crear tema
			Topic topic = session.createTopic("activemq-topic-test1");

			// Consumidor 01 se suscribe al topico activemq-topic-test1
			MessageConsumer consumer1 = session.createConsumer(topic);
			consumer1.setMessageListener(new ConsumerMessageListener("Consumidor 01"));

			// Consumidor 02 se suscribe al topico activemq-topic-test1
			MessageConsumer consumer2 = session.createConsumer(topic);
			consumer2.setMessageListener(new ConsumerMessageListener("Consumidor 02"));

			// Abre la conexion
			connection.start();

			// Freno el hilo 2 minutos
			TimeUnit.SECONDS.sleep(120);

			// Cerrar recursos
			session.close();
			connection.close();

		} catch (JMSException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
