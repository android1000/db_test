package dao;

import models.Auto;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class AutoDao {

    public Auto findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    public void save(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(auto);
        tx1.commit();
        session.close();
    }

    public void update(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(auto);
        tx1.commit();
        session.close();
    }

    public void delete(Auto auto) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(auto);
        tx1.commit();
        session.close();
    }

    public User findUserById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public User findUserByAuto(Auto auto) {
        return findUserById(auto.getUser().getId());
    }

    public List<Auto> findAll() {
        List<Auto> autos = (List<Auto>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Auto").list();
        return autos;
    }

    public List<Auto> findByModel(String model) {
        List<Auto> autos = (List<Auto>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Auto where model=:model").setString("model", model).list();;
        return autos;
    }

}