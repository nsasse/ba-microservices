package de.nsasse.microadvisor.portfolio.service;

import de.nsasse.microadvisor.portfolio.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    void create(ProductType productType);

    void update(ProductType productType);

    void delete(ProductType productType);

    List<ProductType> findAll();

    ProductType findById(long id);
}
