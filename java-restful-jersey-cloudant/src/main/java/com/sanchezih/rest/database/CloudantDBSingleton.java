package com.sanchezih.rest.database;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

public class CloudantDBSingleton {

	private static CloudantClient cloudantClient;
	private static CloudantDBSingleton cDbSingleton;
	private static Database db;
	private static final String dbName = "books";
	private static final String dbUser = "ityawantutheyestriterion";
	private static final String dbPassword = "fa24ed56bef6e3fc96b3745df2c65b7e3f35111a";
	private static final String dbHost = "ihsanch";

	private CloudantDBSingleton() {
	};

	public static CloudantDBSingleton getInstance() {
		if (cDbSingleton == null) {
			cDbSingleton = new CloudantDBSingleton();
		}
		return cDbSingleton;
	}

	public Database testDatabase() {
		if (cloudantClient == null) {
			try {
				cloudantClient = new CloudantClient(dbHost, dbUser, dbPassword);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (db == null) {
			try {
				db = cloudantClient.database(dbName, true);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return db;
	}
}
