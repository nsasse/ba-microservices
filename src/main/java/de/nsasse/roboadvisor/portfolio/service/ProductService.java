package de.nsasse.roboadvisor.portfolio.service;

import de.nsasse.roboadvisor.portfolio.model.Product;

import java.util.List;

public interface ProductService {
    void create(Product product);

    void update(Product product);

    void delete(Product product);

    List<Product> findAll();

    Product findById(long id);

    Product findByName(String name);
}
