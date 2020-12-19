package com.flamexander.hibernate.crud;

import com.flamexander.hibernate.PrepareDataApp;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

public class CrudApp {
    private static SessionFactory factory;

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/crud/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void shutdown() {
        factory.close();
    }

    public static void createExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem dragonStatue = new SimpleItem("Cat Statue", 1000);
        System.out.println(dragonStatue);
            session.save(dragonStatue);
            session.getTransaction().commit();
            System.out.println(dragonStatue);
        }
    }

    public static void main(String[] args) {
        try {
            init();
            createExample();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }
}