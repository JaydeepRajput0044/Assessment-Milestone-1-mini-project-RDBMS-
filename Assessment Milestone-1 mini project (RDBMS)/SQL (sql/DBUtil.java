package com.example.jdbc.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
private static final String JDBC_USER = "your_db_user";
private static final String JDBC_PASSWORD = "your_db_password";




public static Connection getConnection() throws SQLException {
return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);


}
}