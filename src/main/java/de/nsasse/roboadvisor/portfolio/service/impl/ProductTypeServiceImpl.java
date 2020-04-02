package de.nsasse.roboadvisor.portfolio.service.impl;

import de.nsasse.roboadvisor.database.HibernateUtils;
import de.nsasse.roboadvisor.portfolio.model.ProductType;
import de.nsasse.roboadvisor.portfolio.service.ProductTypeService;
import org.hibernate.Session;

import java.util.List;

public class ProductTypeServiceImpl implements ProductTypeService {

    Session session = HibernateUtils.getSessionFactory().openSession();

    @Override
    public void create(ProductType productType) {
        session.beginTransaction();
        session.save(productType);
    }

    @Override
    public void update(ProductType productType) {
        session.beginTransaction();
        session.saveOrUpdate(productType);
    }

    @Override
    public void delete(ProductType productType) {
        session.beginTransaction();
        session.delete(productType);
    }

    @Override
    public List<ProductType> findAll() {
        session.beginTransaction();
        return session.createQuery("SELECT p FROM ProductType p", ProductType.class).getResultList();
    }

    @Override
    public ProductType findById(long id) {
        session.beginTransaction();
        return session.createQuery("SELECT p FROM ProductType p WHERE p.id = id", ProductType.class).getSingleResult();
    }
}