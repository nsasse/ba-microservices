package de.nsasse.roboadvisor.contract.service.impl;

import de.nsasse.roboadvisor.contract.model.User;
import de.nsasse.roboadvisor.contract.service.UserService;
import de.nsasse.roboadvisor.database.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Override
    public void create(User User) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(User);
        session.close();
    }

    @Override
    public void update(User User) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(User);
        session.close();
    }

    @Override
    public void delete(User User) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(User);
        session.close();
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> userList = session.createQuery("SELECT p FROM User p", User.class).getResultList();
        session.close();
        return userList;
    }

    @Override
    public User findById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.createQuery("SELECT p FROM User p WHERE p.id = id", User.class).getSingleResult();
        session.close();
        return user;
    }
}
