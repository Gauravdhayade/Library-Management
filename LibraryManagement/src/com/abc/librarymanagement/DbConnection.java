package com.abc.librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getconnection() throws SQLException {

		String url = "jdbc:mysql://localhost:3306/library_db";
		String userName = "root";
		String password = "ROOT";

		Connection con = DriverManager.getConnection(url, userName, password);
		return con;

	}
}
