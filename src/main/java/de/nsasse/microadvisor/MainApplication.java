package de.nsasse.microadvisor;

import de.nsasse.microadvisor.dao.impl.ProductTypeDao;
import de.nsasse.microadvisor.database.ConnectionTest;
import de.nsasse.microadvisor.database.HibernateUtils;
import de.nsasse.microadvisor.model.ProductType;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@ManagedBean
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
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
