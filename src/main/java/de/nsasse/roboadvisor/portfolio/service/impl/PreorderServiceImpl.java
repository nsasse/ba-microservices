package de.nsasse.roboadvisor.portfolio.service.impl;

import de.nsasse.roboadvisor.database.HibernateUtils;
import de.nsasse.roboadvisor.portfolio.model.Preorder;
import de.nsasse.roboadvisor.portfolio.service.PreorderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreorderServiceImpl implements PreorderService {

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Override
    public void create(Preorder preorder) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(preorder);
        session.close();
    }

    @Override
    public void update(Preorder preorder) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(preorder);
        session.close();
    }

    @Override
    public void delete(Preorder preorder) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(preorder);
        session.close();
    }

    @Override
    public List<Preorder> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Preorder> preorderList = session.createQuery("SELECT p FROM Preorder p", Preorder.class).getResultList();
        session.close();
        return preorderList;
    }
}
