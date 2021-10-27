package com.sanchezih.mq.activemq.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicPublisher {

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

			// Abre la conexión
			connection.start();

			// Crea una sesión sin transaccion
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Crear tema, utilizado como mensaje de suscripcion al consumidor
			Topic myTestTopic = session.createTopic("activemq-topic-test1");

			// Productor de mensajes
			MessageProducer producer = session.createProducer(myTestTopic);

			for (int i = 1; i <= 3; i++) {
				TextMessage message = session.createTextMessage("Enviar un mensaje " + i);
				producer.send(myTestTopic, message);
			}

			// Cerrar recursos
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
