package com.commerce.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
    private static Connection connection;

    private OracleConnection() {
        // Constructor privado para evitar instanciación directa
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // Configura la conexión a tu base de datos Oracle
            String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
            String dbUser = "system";
            String dbPass = "sys2023";

            connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}