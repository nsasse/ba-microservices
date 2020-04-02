package de.nsasse.microadvisor.portfolio.service.impl;

import de.nsasse.microadvisor.database.HibernateUtils;
import de.nsasse.microadvisor.portfolio.model.Product;
import de.nsasse.microadvisor.portfolio.service.ProductService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();


    @Override
    public void create(Product Product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(Product);
        session.close();
    }

    @Override
    public void update(Product Product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(Product);
        session.close();
    }

    @Override
    public void delete(Product Product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(Product);
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
}
