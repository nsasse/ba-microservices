package de.nsasse.roboadvisor.portfolio.service;

import de.nsasse.roboadvisor.portfolio.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    void create(ProductType productType);

    void update(ProductType productType);

    void delete(ProductType productType);

    List<ProductType> findAll();

    ProductType findById(long id);
}
