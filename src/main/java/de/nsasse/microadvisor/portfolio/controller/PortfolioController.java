package de.nsasse.microadvisor.portfolio.controller;

import org.springframework.web.bind.annotation.*;

import javax.annotation.ManagedBean;

@ManagedBean
@RestController
@RequestMapping(value = "/portfolio/", method = RequestMethod.POST)
public class PortfolioController {

    @CrossOrigin
    @GetMapping("/riskprofile")
    public String getRisk(String test) {
        System.out.println("GET");
        System.out.println(test);
        return "posting";
    }
}

