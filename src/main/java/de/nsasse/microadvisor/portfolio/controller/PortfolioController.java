package de.nsasse.microadvisor.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.ManagedBean;

@ManagedBean
@RestController
@RequestMapping("/portfolio/")
public class PortfolioController {

    //TODO - NOT WORKING
    @GetMapping("/risk")
    public void getRisk(@RequestParam(name = "id") String string) {
        //System.out.println(riskProfile.getExpectedYield());
        //System.out.println(riskProfile.getDuration());
        //System.out.println(riskProfile.getRiskTolerance());
        System.out.println(string);
    }
}

