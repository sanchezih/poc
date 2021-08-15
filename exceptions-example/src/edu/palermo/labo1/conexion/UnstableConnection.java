package edu.palermo.labo1.conexion;

import java.util.Random;

import edu.palermo.labo1.exceptions.ConnectionUnavailableException;
import edu.palermo.labo1.exceptions.MessageFailedException;

public class UnstableConnection {
	
	private static int n =0;
	private static Random random = new Random(System.currentTimeMillis());
	private UnstableConnection () {
		invalidate = false;
	}
	
	private boolean invalidate;
	public static UnstableConnection getConnection () throws ConnectionUnavailableException {
		
		if (random.nextInt(100) >50){
			throw new ConnectionUnavailableException("Oops. connection unavailable");
		}
		
		return new UnstableConnection();
		
	}
	
	/**
	 * This method returns a message with a probability of 0.4
	 * @return a message String
	 * @throws MessageFailedException when fails to deliver a message but the connection is still alive
	 * @throws ConnectionUnavailableException when fails to deliver a message but connection is invalidated
	 */
	public String getMessage () throws MessageFailedException, ConnectionUnavailableException {
		
		if (invalidate) {
			throw new RuntimeException("Connection was invalidated");
			
		}
		int num = random.nextInt(100) ;
		if (num >50){
			throw new MessageFailedException("Oops. message failed");
		} else if (num < 10) {
			invalidate = true;
			
			throw new ConnectionUnavailableException("Ooops. connection became unavailable");
			
		} else {
			n++;
			return "mensaje "+n; 
		}
		
		
	}
	
	public void close () {
		
		invalidate = true;
		
	}
}
