package de.nsasse.microadvisor.contract;

import de.nsasse.microadvisor.dao.impl.ProductTypeDao;
import de.nsasse.microadvisor.database.ConnectionTest;
import de.nsasse.microadvisor.portfolio.model.ProductType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.ManagedBean;
import java.util.List;

@SpringBootApplication
@ManagedBean
public class ContractMicroservice {
    public static void main(String[] args) {
        SpringApplication.run(ContractMicroservice.class, args);
        ConnectionTest connect = new ConnectionTest();
        connect.connectToSqlServer();

        ProductTypeDao productTypeDao = new ProductTypeDao();
        List<ProductType> productTypeDaoList = productTypeDao.findAll();
        productTypeDaoList
                .stream()
                .forEach(productType -> {
                    System.out.println(productType.getName());
                });
    }
}
