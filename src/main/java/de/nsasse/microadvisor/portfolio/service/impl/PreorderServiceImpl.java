package de.nsasse.microadvisor.portfolio.service.impl;

import de.nsasse.microadvisor.database.HibernateUtils;
import de.nsasse.microadvisor.portfolio.model.Preorder;
import de.nsasse.microadvisor.portfolio.service.PreorderService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreorderServiceImpl implements PreorderService {

    Session session = HibernateUtils.getSessionFactory().openSession();

    @Override
    public void create(Preorder preorder) {
        session.beginTransaction();
        session.save(preorder);
    }

    @Override
    public void update(Preorder preorder) {
        session.beginTransaction();
        session.saveOrUpdate(preorder);
    }

    @Override
    public void delete(Preorder preorder) {
        session.beginTransaction();
        session.delete(preorder);
    }

    @Override
    public List<Preorder> findAll() {
        session.beginTransaction();
        return session.createQuery("SELECT p FROM Preorder p", Preorder.class).getResultList();
    }

    @Override
    public Preorder findById(long id) {
        session.beginTransaction();
        return session.createQuery("SELECT p FROM Preorder p WHERE p.id = id", Preorder.class).setMaxResults(1).uniqueResult();
    }
}
