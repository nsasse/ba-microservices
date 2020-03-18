package de.nsasse.microadvisor.portfolio;

import de.nsasse.microadvisor.database.ConnectionTest;
import de.nsasse.microadvisor.portfolio.dao.impl.ProductDao;
import de.nsasse.microadvisor.portfolio.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.ManagedBean;
import java.util.List;

@SpringBootApplication
@ManagedBean
@RestController
@RequestMapping("/portfolio")
public class PortfolioApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
        ConnectionTest connect = new ConnectionTest();
        connect.connectToSqlServer();

        //DB TEST
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

    //private RiskProfile defaultRiskProfile = new RiskProfile(ExpectedYield.OUTSTRIPPING_INFLATION, 5, RiskTolerance.LOW_RISK);

    //TODO - NOT WORKING
    @GetMapping("/api/risk")
    public void getRisk(@RequestParam(name = "id") String string) {
        //System.out.println(riskProfile.getExpectedYield());
        //System.out.println(riskProfile.getDuration());
        //System.out.println(riskProfile.getRiskTolerance());
        System.out.println(string);
    }
}
