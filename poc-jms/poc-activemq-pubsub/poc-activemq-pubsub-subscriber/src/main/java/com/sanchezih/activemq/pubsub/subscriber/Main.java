package com.sanchezih.activemq.pubsub.subscriber;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
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

		// Crea una fabrica de conexiones
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);

		try {

			// Crear conexion
			Connection connection = connectionFactory.createConnection();

			// Crea una sesión sin transaccion
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Crear tema
			Topic topic = session.createTopic("activemq-topic-test1");

			// Consumer1 subscribes to customerTopic
			MessageConsumer consumer1 = session.createConsumer(topic);
			consumer1.setMessageListener(new ConsumerMessageListener("Consumer1"));

			// Consumer2 subscribes to customerTopic
			MessageConsumer consumer2 = session.createConsumer(topic);
			consumer2.setMessageListener(new ConsumerMessageListener("Consumer2"));

			// Abre la conexion
			connection.start();

			/**
			 * Deje que el hilo principal duerma durante 1000 segundos, para que el objeto
			 * consumidor de mensajes pueda continuar activo durante un período de tiempo
			 * para que el mensaje pueda ser monitoreado
			 */
			Thread.sleep(1000 * 1000);

			// Cerrar recursos
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getRandomTime() {
		int min = 1;
		int max = 10;

		// Generate random int value from 50 to 100
		System.out.println("Random value in int from " + min + " to " + max + ":");
		int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
		System.out.println(random_int);

		return random_int;
	}

}
