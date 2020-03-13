package de.nsasse.microadvisor.contract;

import de.nsasse.microadvisor.database.ConnectionTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.ManagedBean;

@SpringBootApplication
@ManagedBean
public class ContractApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContractApplication.class, args);
        ConnectionTest connect = new ConnectionTest();
        connect.connectToSqlServer();

    }
}
