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

    @CrossOrigin
    @PostMapping("/riskprofile")
    public PortfolioWeighting postRisk(@RequestBody RiskProfile riskProfile) {
        return new RiskAnalyser().analyseRisk(riskProfile);
    }

    @CrossOrigin
    @PostMapping("/addproduct")
    public void addProductToPortfolio(@RequestBody String isin) {
        System.out.println(isin);
        //return new RiskAnalyser().analyseRisk(riskProfile);
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

}

