package de.nsasse.microadvisor.portfolio;

import de.nsasse.microadvisor.database.ConnectionTest;
import de.nsasse.microadvisor.portfolio.model.Product;
import de.nsasse.microadvisor.portfolio.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PortfolioApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
        ConnectionTest connect = new ConnectionTest();
        connect.connectToSqlServer();

        //DB TEST
        ProductService productService = new ProductService();
        List<Product> productDaoList = productService.findAll();
        productDaoList
                .stream()
                .forEach(product -> {
                    System.out.println(product.getName());
                    System.out.println(product.getRegion().getName());
                    System.out.println(product.getProductType().getType());
                });
    }
}
