package de.nsasse.microadvisor.portfolio.controller;

import de.nsasse.microadvisor.portfolio.model.RiskProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.ManagedBean;

@ManagedBean
@RestController
@RequestMapping("/portfolio/")
public class PortfolioController {

    @CrossOrigin
    @PostMapping("/riskprofile")
    public void postRisk(@RequestBody RiskProfile riskProfile) {
        //System.out.println(riskProfile.getExpectedYield());
        //System.out.println(riskProfile.getDuration());
        //System.out.println(riskProfile.getRiskTolerance());
        System.out.println(riskProfile.getExpectedYield());
    }
}

