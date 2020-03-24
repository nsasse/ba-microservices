package de.nsasse.microadvisor.portfolio.service;

import de.nsasse.microadvisor.dao.Dao;
import de.nsasse.microadvisor.database.HibernateUtils;
import de.nsasse.microadvisor.portfolio.model.Region;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService implements Dao<Region> {

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
