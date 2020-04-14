package de.nsasse.roboadvisor.portfolio.service.impl;

import de.nsasse.roboadvisor.database.HibernateUtils;
import de.nsasse.roboadvisor.portfolio.model.Region;
import de.nsasse.roboadvisor.portfolio.service.RegionService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Override
    public void create(Region region) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(region);
        session.close();
    }

    @Override
    public void update(Region region) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(region);
        session.close();
    }

    @Override
    public void delete(Region region) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(region);
        session.close();
    }

    @Override
    public List<Region> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Region> regionList = session.createQuery("SELECT p FROM Region p", Region.class).getResultList();
        session.close();
        return regionList;
    }

    @Override
    public Region findById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Region region = session.createQuery("SELECT p FROM Region p WHERE p.id = :idParam", Region.class)
                .setParameter("idParam", id)
                .setMaxResults(1)
                .uniqueResult();
        session.close();
        return region;
    }
}
