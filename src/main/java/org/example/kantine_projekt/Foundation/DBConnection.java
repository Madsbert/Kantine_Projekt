package org.example.kantine_projekt.Foundation;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:sqlserver://localhost;databaseName=KantineDB";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "Kantine1234"; // replace with your password
    private static Connection conn;

    /**
     * Establishes connection to the Database.
     * @return return the connection to the Database.
     */
    public static Connection getConnection() {
        if (conn == null) {
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connected to the database.");
            }
            catch (Exception e)
            {
                System.out.println("Failed to connect to database.");
            }
        }
        return conn;
    }

}
