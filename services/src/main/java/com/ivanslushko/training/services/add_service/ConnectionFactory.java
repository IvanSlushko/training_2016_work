package com.ivanslushko.training.services.add_service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class ConnectionFactory {
	private static interface Singleton {
		final ConnectionFactory INSTANCE = new ConnectionFactory();
	}

	private final DataSource dataSource;

	private ConnectionFactory() {
		Properties properties = new Properties();
		properties.setProperty("user", "postgres");
		properties.setProperty("password", "postgres"); // or get properties
														// from some
														// configuration file

		System.out.println(222);

		GenericObjectPool pool = new GenericObjectPool();
		DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
				"jdbc:postgresql://localhost:5432/LowCostAir", properties);

		System.out.println(333);

		new PoolableConnectionFactory(connectionFactory, pool, null, "SELECT 1", 3, false, true,
				Connection.TRANSACTION_READ_COMMITTED);

		System.out.println(4444);

		this.dataSource = new PoolingDataSource(pool);
	}

	public static Connection getDatabaseConnection() throws SQLException {
		
		System.out.println(11);
		
		return Singleton.INSTANCE.dataSource.getConnection();
	}
}