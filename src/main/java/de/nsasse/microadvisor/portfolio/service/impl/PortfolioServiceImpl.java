package de.nsasse.microadvisor.portfolio.service.impl;

import de.nsasse.microadvisor.database.HibernateUtils;
import de.nsasse.microadvisor.portfolio.model.Portfolio;
import de.nsasse.microadvisor.portfolio.service.PortfolioService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

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
        return session.createQuery("SELECT p FROM Portfolio p WHERE p.id = id", Portfolio.class).setMaxResults(1).uniqueResult();
    }
}
