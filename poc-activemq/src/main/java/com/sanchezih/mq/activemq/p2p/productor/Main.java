package com.sanchezih.mq.activemq.p2p.productor;

import javax.jms.JMSException;

/**
 * Ejemplo tomado de https://www.adictosaltrabajo.com/2012/07/25/active-mq/
 * 
 * El emisor de mensajes envia 20 mensajes a nuestro intermediario con la
 * informacion de las acciones que realizan los usuarios.
 * 
 * Con ActiveMQ arrancado, ejecutamos este metodo main y vemos en la consola de
 * administracion como la cola de mensajes destino (APLICATIONPRUEBA.QUEUE)
 * guarda la informacion de los mensajes que le acabamos de enviar.
 * 
 * @author ihsanch
 *
 */
public class Main {

	public static void main(String[] args) throws JMSException {
		final MessageSender messageSender = new MessageSender();
		messageSender.sendMessages();
	}
}
