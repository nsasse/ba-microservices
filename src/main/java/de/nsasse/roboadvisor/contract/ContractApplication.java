package de.nsasse.roboadvisor.contract;

import de.nsasse.roboadvisor.database.DbConnectionTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.ManagedBean;

@SpringBootApplication
@ManagedBean
public class ContractApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContractApplication.class, args);
        DbConnectionTest connect = new DbConnectionTest();
        connect.connectToPostgreSQL();

    }
}
