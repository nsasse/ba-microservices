package de.nsasse.microadvisor.portfolio.service.impl;

import de.nsasse.microadvisor.database.HibernateUtils;
import de.nsasse.microadvisor.portfolio.model.Region;
import de.nsasse.microadvisor.portfolio.service.RegionService;
import org.hibernate.Session;

import java.util.List;

public class RegionServiceImpl implements RegionService {

    Session session = HibernateUtils.getSessionFactory().openSession();

    @Override
    public void create(Region region) {
        session.beginTransaction();
        session.save(region);
    }

    @Override
    public void update(Region region) {
        session.beginTransaction();
        session.saveOrUpdate(region);
    }

    @Override
    public void delete(Region region) {
        session.beginTransaction();
        session.delete(region);
    }

    @Override
    public List<Region> findAll() {
        session.beginTransaction();
        return session.createQuery("SELECT p FROM Region p", Region.class).getResultList();
    }

    @Override
    public Region findById(long id) {
        session.beginTransaction();
        return session.createQuery("SELECT p FROM Region p WHERE p.id = id", Region.class).getSingleResult();
    }
}
