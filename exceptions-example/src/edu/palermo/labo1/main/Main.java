package edu.palermo.labo1.main;

import edu.palermo.labo1.conexion.UnstableConnection;
import edu.palermo.labo1.exceptions.ConnectionUnavailableException;
import edu.palermo.labo1.exceptions.MessageFailedException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnstableConnection conn = null;
		for (int i = 0; i < 100; i++) {
			try {
				if (conn == null) {
					System.out.println("new connection established");
					conn = UnstableConnection.getConnection();
				}

			} catch (ConnectionUnavailableException e) {
				System.out.println(e.getMessage());
				conn = null;
			} finally {
			}

			try {

				if (conn != null) {
					String msg = conn.getMessage();
					System.out.println(msg);
				}
			} catch (MessageFailedException mf) {

				System.out.println(mf.getMessage());
			} catch (ConnectionUnavailableException cu) {

				System.out.println(cu.getMessage());
				// conn is invalidated. null it so it gets refreshed
				conn = null;
			}

		}

	}

}
