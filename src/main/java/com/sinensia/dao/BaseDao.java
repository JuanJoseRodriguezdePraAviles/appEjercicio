package com.sinensia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getconnection() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://192.168.201.55:3306/appejercicio",
					"root", "root");
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return connection;
	}
}
