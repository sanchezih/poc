package com.sanchezih.activemq.pubsub.publisher;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
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

			// Abre la conexion
			connection.start();

			// Crea una sesion sin transaccion
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Crear tema, utilizado como mensaje de suscripcion al consumidor
			Topic topic = session.createTopic("activemq-topic-test1");

			// Productor de mensajes
			MessageProducer producer = session.createProducer(topic);

			for (int i = 1; i <= 5; i++) {
				Date d = new Date();
				String msgText = "Un mensaje creado el " + d.toString();
				System.out.println("Se crea y se envia el mensaje: [" + msgText + "]");
				TextMessage message = session.createTextMessage(msgText);
				producer.send(topic, message);
				TimeUnit.SECONDS.sleep(3);
			}

			// Cerrar recursos
			session.close();
			connection.close();

		} catch (JMSException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
