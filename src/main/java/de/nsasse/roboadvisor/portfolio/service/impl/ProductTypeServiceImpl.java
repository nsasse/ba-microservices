package de.nsasse.roboadvisor.portfolio.service.impl;

import de.nsasse.roboadvisor.database.HibernateUtils;
import de.nsasse.roboadvisor.portfolio.model.ProductType;
import de.nsasse.roboadvisor.portfolio.service.ProductTypeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Override
    public void create(ProductType productType) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(productType);
        session.close();
    }

    @Override
    public void update(ProductType productType) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(productType);
        session.close();
    }

    @Override
    public void delete(ProductType productType) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(productType);
        session.close();
    }

    @Override
    public List<ProductType> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ProductType> productTypeList = session.createQuery("SELECT p FROM ProductType p", ProductType.class).getResultList();
        session.close();
        return productTypeList;
    }

    @Override
    public ProductType findById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ProductType productType = session.createQuery("SELECT p FROM Product p WHERE p.id = :idParam", ProductType.class)
                .setParameter("idParam", id)
                .setMaxResults(1)
                .uniqueResult();
        session.close();
        return productType;
    }
}
