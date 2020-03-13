package de.nsasse.microadvisor.contract;

import de.nsasse.microadvisor.database.ConnectionTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.ManagedBean;

@SpringBootApplication
@ManagedBean
public class ContractMicroservice {
    public static void main(String[] args) {
        SpringApplication.run(ContractMicroservice.class, args);
        ConnectionTest connect = new ConnectionTest();
        connect.connectToSqlServer();

    }
}
