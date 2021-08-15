package com.daniel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.daniel.dao.UserDao;
import com.daniel.model.User;

public class App {

	public static void main(String[] args) {
		UserDao dao = new UserDao();

		/**
		 * AGREGO UN NUEVO USUARIO
		 */
		User user = new User();
		user.setFirstName("Daniel");
		user.setLastName("Niko");
		try {
			Date dob = new SimpleDateFormat("yyyy-MM-dd").parse("1986-01-02");
			user.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setEmail("daniel@example.com");
		dao.addUser(user);

		/**
		 * ACTUALIZO UN USUARIO
		 */

		// user.setEmail("daniel@EMAILACTUALIZADO.com");
		// dao.updateUser(user);

		/**
		 * BORRO UN USUARIO
		 */
		// dao.deleteUser(1);

		// Get all users
		for (User u : dao.getAllUsers()) {
			System.out.println(u);
		}

		/**
		 * OBTENGO UN USUARIO POR ID
		 */
		// System.out.println(dao.getUserById(2));
	}

}