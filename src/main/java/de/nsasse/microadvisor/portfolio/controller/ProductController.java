package de.nsasse.microadvisor.portfolio.controller;

import de.nsasse.microadvisor.portfolio.model.Product;
import de.nsasse.microadvisor.portfolio.service.ProductService;
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
        System.out.println("Get request /product/all");
        return productService.findAll();
    }

    @CrossOrigin
    @GetMapping("/all/string")
    public List<String> getProductStrings() {
        System.out.println("Get request /product/all");
        return productService
                .findAll()
                .stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @GetMapping("/by/name")
    public Product getProductByName(@RequestParam String search) {
        System.out.println("Get request /by/name");
        System.out.println(search);
        System.out.println(productService.findByName(search));
        return productService.findByName(search);
    }
}
