package de.nsasse.roboadvisor.portfolio.service.rest;

import de.nsasse.roboadvisor.portfolio.model.Enum.PortfolioWeighting;
import de.nsasse.roboadvisor.portfolio.model.Portfolio;
import de.nsasse.roboadvisor.portfolio.model.Product;
import de.nsasse.roboadvisor.portfolio.model.RiskProfile;
import de.nsasse.roboadvisor.portfolio.service.PortfolioService;
import de.nsasse.roboadvisor.portfolio.service.PreorderService;
import de.nsasse.roboadvisor.portfolio.service.ProductService;
import de.nsasse.roboadvisor.portfolio.service.RiskAnalyser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/portfolio/")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @Autowired
    PreorderService preorderService;

    @Autowired
    ProductService productService;

    Product productFromOptimizer;

    @CrossOrigin
    @PostMapping("/riskprofile")
    public PortfolioWeighting postRisk(@RequestBody RiskProfile riskProfile) {
        return new RiskAnalyser().analyseRisk(riskProfile);
    }

    @CrossOrigin
    @PostMapping("/addproduct")
    public void addProductToPortfolio(@RequestBody String isin) {
        productFromOptimizer = productService.findByIsin(isin);
    }

    //TODO
    @CrossOrigin
    @PostMapping("/products")
    public void postProducts(@RequestBody String[] isins) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < isins.length; i++) {
            productList.add(productService.findByIsin(isins[i]));
        }
        portfolioService.create(new Portfolio(null, productList, new Timestamp(System.currentTimeMillis()), null));
    }

    @CrossOrigin
    @PostMapping("/interest")
    public void postInterest(@RequestBody String mail) {
        System.out.println(mail);
        //preorderService.create(new Preorder(, mail));
    }

    @CrossOrigin
    @PostMapping("/check-product")
    public Product postProductFromOptimzer() {
        System.out.println("Produkt: " + productFromOptimizer);
        if (productFromOptimizer != null) {
            Product sendproduct = productFromOptimizer;
            productFromOptimizer = null;
            return sendproduct;
        }
        return null;
    }
}

