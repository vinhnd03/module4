package com.vinhnd.quan_ly_san_pham_orm.repository;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class ConnectUtil {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;
    static {
        try{
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }
}
