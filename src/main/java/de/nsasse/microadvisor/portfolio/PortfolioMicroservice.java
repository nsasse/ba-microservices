package de.nsasse.microadvisor.portfolio;

import de.nsasse.microadvisor.dao.impl.ProductTypeDao;
import de.nsasse.microadvisor.database.ConnectionTest;
import de.nsasse.microadvisor.portfolio.model.ProductType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.ManagedBean;
import java.util.List;

@SpringBootApplication
@ManagedBean
public class PortfolioMicroservice {
    public static void main(String[] args) {
        SpringApplication.run(PortfolioMicroservice.class, args);
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
