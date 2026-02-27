package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDb {

    private static final String URL = "jdbc:mysql://localhost:3306/world";
    private static final String USER = "root";
    private static final String PASSWORD = "@Aa528804";

    public static void main(String[] args) {

        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("✅ Connected to database successfully!");

            // Close connection
            connection.close();
            System.out.println("🔒 Connection closed.");

        } catch (SQLException e) {
            System.out.println("❌ Connection Failed!");
            e.printStackTrace();
        }
    }
}
