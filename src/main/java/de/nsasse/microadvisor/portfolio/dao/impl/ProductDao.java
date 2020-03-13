package de.nsasse.microadvisor.portfolio.dao.impl;

import de.nsasse.microadvisor.dao.Dao;
import de.nsasse.microadvisor.portfolio.HibernateUtils;
import de.nsasse.microadvisor.portfolio.model.Product;
import org.hibernate.Session;

import java.util.List;

public class ProductDao implements Dao<Product> {

    Session session = HibernateUtils.getSessionFactory().openSession();

    @Override
    public void create(Product Product) {
        session.beginTransaction();
        session.save(Product);
    }

    @Override
    public void update(Product Product) {
        session.beginTransaction();
        session.saveOrUpdate(Product);
    }

    @Override
    public void delete(Product Product) {
        session.beginTransaction();
        session.delete(Product);
    }

    @Override
    public List<Product> findAll() {
        session.beginTransaction();
        return session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Override
    public Product findById(long id) {
        session.beginTransaction();
        return session.createQuery("SELECT p FROM Product p WHERE p.id = id", Product.class).getSingleResult();
    }
}
