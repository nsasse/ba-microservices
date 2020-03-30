package de.nsasse.microadvisor.portfolio.service;

import de.nsasse.microadvisor.portfolio.model.Product;

import java.util.List;

public interface ProductService {
    void create(Product product);

    void update(Product product);

    void delete(Product product);

    List<Product> findAll();

    Product findById(long id);

    Product findByName(String name);
}
