package de.nsasse.roboadvisor.portfolio.rest;

import de.nsasse.roboadvisor.portfolio.model.Product;
import de.nsasse.roboadvisor.portfolio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin
    @GetMapping("/all")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @CrossOrigin
    @GetMapping("/all/string")
    public List<String> getProductStrings() {
        return productService
                .findAll()
                .stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @GetMapping("/by/name")
    public Product getProductByName(@RequestParam String search) {
        return productService.findByName(search);
    }
}



