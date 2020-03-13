package de.nsasse.microadvisor.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

    public void connectToSqlServer() {

        //DbPasswords are not included in this project. You can replace it with the the correct password string or copy the java class from cd.
        String connectionUrl = "jdbc:sqlserver://microadvisor.database.windows.net;databaseName=db01ba;user=nico;password=" + DbPasswords.getPassword();

        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                System.out.println("Done.");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}
