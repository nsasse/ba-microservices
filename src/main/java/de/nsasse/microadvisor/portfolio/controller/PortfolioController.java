package de.nsasse.microadvisor.portfolio.controller;

import de.nsasse.microadvisor.portfolio.model.RiskProfile;
import de.nsasse.microadvisor.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio/")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @CrossOrigin
    @PostMapping("/riskprofile")
    public void postRisk(@RequestBody RiskProfile riskProfile) {
        System.out.println(riskProfile.getExpectedYield());
    }
}

