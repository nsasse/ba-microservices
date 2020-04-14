package de.nsasse.roboadvisor.portfolio.rest;

import de.nsasse.roboadvisor.portfolio.model.Enum.PortfolioWeighting;
import de.nsasse.roboadvisor.portfolio.model.RiskProfile;
import de.nsasse.roboadvisor.portfolio.service.PortfolioService;
import de.nsasse.roboadvisor.portfolio.service.RiskAnalyser;
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

