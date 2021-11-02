package com.sanchezih.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	private static Connection connection = null;
	private static DbUtil instance = null;

	private DbUtil() {
	}

	public static DbUtil getInstance() {
		if (instance == null) {
			instance = new DbUtil();
		}
		return instance;
	}

	public Connection connect() {
		Connection conexion = null;
		try {
			Properties prop = new Properties();
			InputStream inputStream = DbUtil.class.getResourceAsStream("./db.properties");
			prop.load(inputStream);

			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");

			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return conexion;
	}

//	public static Connection getConnection() {
//		if (connection != null)
//			return connection;
//		else {
//			try {
//				Properties prop = new Properties();
//				InputStream inputStream = DbUtil.class.getResourceAsStream("./db.properties");
//				prop.load(inputStream);
//				String driver = prop.getProperty("driver");
//				String url = prop.getProperty("url");
//				String user = prop.getProperty("user");
//				String password = prop.getProperty("password");
//				Class.forName(driver);
//				connection = DriverManager.getConnection(url, user, password);
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			return connection;
//		}
//
//	}
}
