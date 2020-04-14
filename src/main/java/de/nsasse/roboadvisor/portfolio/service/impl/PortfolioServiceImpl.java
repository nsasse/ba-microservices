package de.nsasse.roboadvisor.portfolio.service.impl;

import de.nsasse.roboadvisor.database.HibernateUtils;
import de.nsasse.roboadvisor.portfolio.model.Portfolio;
import de.nsasse.roboadvisor.portfolio.service.PortfolioService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Override
    public void create(Portfolio portfolio) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(portfolio);
        session.close();
    }

    @Override
    public void update(Portfolio portfolio) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(portfolio);
        session.close();
    }

    @Override
    public void delete(Portfolio portfolio) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(portfolio);
        session.close();
    }

    @Override
    public List<Portfolio> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Portfolio> portfolioList = session.createQuery("SELECT p FROM Portfolio p", Portfolio.class).getResultList();
        session.close();
        return portfolioList;
    }

    @Override
    public Portfolio findById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Portfolio portfolio = session.createQuery("SELECT p FROM Portfolio p WHERE p.id = :idParam", Portfolio.class)
                .setParameter("idParam", id)
                .setMaxResults(1)
                .uniqueResult();
        session.close();
        return portfolio;
    }
}
