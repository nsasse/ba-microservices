package de.nsasse.microadvisor.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

    public void connectToSqlServer() {

        String connectionUrl = "jdbc:sqlserver://microadvisor.database.windows.net;databaseName=db01;user=nico;password=ma0405+#";

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
