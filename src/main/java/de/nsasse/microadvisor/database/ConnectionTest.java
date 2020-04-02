package de.nsasse.microadvisor.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

    public void connectToSqlServer() {

        //DbPasswords are not included in this project. You can replace it with the the correct password string from bachelor thesis.
        String connectionUrl = "jdbc:postgresql://nsasse.de:5432/ba";
        String user = "ba";
        String password = DbPasswords.getPassword();

        try {
            // Load postgres JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl, user, password)) {
                System.out.println("Done.");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}
