package de.nsasse.microadvisor.portfolio;

import de.nsasse.microadvisor.database.ConnectionTest;
import de.nsasse.microadvisor.portfolio.dao.impl.ProductDao;
import de.nsasse.microadvisor.portfolio.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.ManagedBean;
import java.util.List;

@SpringBootApplication
@ManagedBean
public class PortfolioApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
        ConnectionTest connect = new ConnectionTest();
        connect.connectToSqlServer();

        ProductDao productDao = new ProductDao();
        List<Product> productDaoList = productDao.findAll();
        productDaoList
                .stream()
                .forEach(product -> {
                    System.out.println(product.getName());
                    System.out.println(product.getRegion().getName());
                    System.out.println(product.getProductType().getType());
                });
    }
}
