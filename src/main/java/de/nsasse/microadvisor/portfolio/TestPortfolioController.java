package de.nsasse.microadvisor.portfolio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example")
public class TestPortfolioController {

    @GetMapping("/portfolio-test")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Hello Portfolio!");
    }
}
