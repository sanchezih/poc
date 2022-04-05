package com.sanchezih.mq.activemq.queue.consumidor;

import javax.jms.JMSException;

/**
 * Nuestro consumidor procesara los todos mensajes que haya en la cola <a
 * demanda> (cuando se ejecute).
 * 
 * Si quisiesemos que procesase cada mensaje cuando llega a la cola (no es
 * nuestro caso) deberiamos implementar la interface javax.jms.MessageListener y
 * lanzar nuestro proceso como un hilo que se queda en espera (Thread).
 * 
 * @author ihsanch
 *
 */
public class Main {

	public static void main(String[] args) throws JMSException {
		final UserActionConsumer userActionConsumer = new UserActionConsumer();
		userActionConsumer.processMessages();
	}

}
