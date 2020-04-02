package de.nsasse.microadvisor.portfolio.controller;

import de.nsasse.microadvisor.portfolio.model.Enum.PortfolioWeighting;
import de.nsasse.microadvisor.portfolio.model.RiskProfile;
import de.nsasse.microadvisor.portfolio.service.PortfolioService;
import de.nsasse.microadvisor.portfolio.service.RiskAnalyser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio/")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;

    @CrossOrigin
    @PostMapping("/riskprofile")
    public PortfolioWeighting postRisk(@RequestBody RiskProfile riskProfile) {
        return new RiskAnalyser().analyseRisk(riskProfile);
    }
}

