package de.nsasse.microadvisor.portfolio.dao.impl;

import de.nsasse.microadvisor.dao.Dao;
import de.nsasse.microadvisor.database.HibernateUtils;
import de.nsasse.microadvisor.portfolio.model.Portfolio;
import org.hibernate.Session;

import java.util.List;

public class PortfolioDao implements Dao<Portfolio> {

    Session session = HibernateUtils.getSessionFactory().openSession();

    @Override
    public void create(Portfolio portfolio) {
        session.beginTransaction();
        session.save(portfolio);
    }

    @Override
    public void update(Portfolio portfolio) {
        session.beginTransaction();
        session.saveOrUpdate(portfolio);
    }

    @Override
    public void delete(Portfolio portfolio) {
        session.beginTransaction();
        session.delete(portfolio);
    }

    @Override
    public List<Portfolio> findAll() {
        session.beginTransaction();
        return session.createQuery("SELECT p FROM Portfolio p", Portfolio.class).getResultList();
    }

    @Override
    public Portfolio findById(long id) {
        session.beginTransaction();
        return session.createQuery("SELECT p FROM Portfolio p WHERE p.id = id", Portfolio.class).getSingleResult();
    }
}
