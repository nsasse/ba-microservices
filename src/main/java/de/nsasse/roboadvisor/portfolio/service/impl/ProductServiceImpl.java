package de.nsasse.roboadvisor.portfolio.service.impl;

import de.nsasse.roboadvisor.database.HibernateUtils;
import de.nsasse.roboadvisor.portfolio.model.Product;
import de.nsasse.roboadvisor.portfolio.service.ProductService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Override
    public void create(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(product);
        session.close();
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.close();
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(product);
        session.close();
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Product> productList = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        session.close();
        return productList;
    }

    @Override
    public Product findById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.createQuery("SELECT p FROM Product p WHERE p.id = :idParam", Product.class)
                .setParameter("idParam", id)
                .setMaxResults(1)
                .uniqueResult();
        session.close();
        return product;
    }

    @Override
    public Product findByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.createQuery("SELECT p FROM Product p WHERE p.name = :nameParam", Product.class)
                .setParameter("nameParam", name)
                .setMaxResults(1)
                .uniqueResult();
        session.close();
        return product;
    }

    @Override
    public Product findByIsin(String isin) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.createQuery("SELECT p FROM Product p WHERE p.isin = :isinParam", Product.class)
                .setParameter("isinParam", isin)
                .setMaxResults(1)
                .uniqueResult();
        session.close();
        return product;
    }
}
