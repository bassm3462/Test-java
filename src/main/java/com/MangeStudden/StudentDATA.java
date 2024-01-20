package com.MangeStudden;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDATA {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://Localhost:3306/logiandregisterjava";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle errors appropriately in a real application
        }

        return connection;
    }
}
