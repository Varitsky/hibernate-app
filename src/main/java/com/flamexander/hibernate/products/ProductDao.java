package com.flamexander.hibernate.products;

import com.flamexander.hibernate.PrepareDataApp;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Component
public class ProductDao {

//      private static SessionFactory factory;

    @Autowired
    public AuxSessionFactory factory;

//    public static SessionFactory factory;
//    static AuxSessionFactory factory;

//    @Autowired
//    public static AuxSessionFactory auxSessionFactory;

//    private String config = "configs/products/hibernate.cfg.xml";




//    public static void init() {
//        PrepareDataApp.forcePrepareData();
//        factory = new Configuration()
//                .configure("configs/products/hibernate.cfg.xml")
//                .buildSessionFactory();
//    }



//    public static void init() {
//        String config = "configs/products/hibernate.cfg.xml";
//        factory = new AuxSessionFactory(config);
//    }

        public void shutdown () {
            factory.close();
        }

        public void createExample () {
            try (Session session = factory.get().getCurrentSession()) {
                session.beginTransaction();
                Product dragonStatue = new Product("Cat Statue2", 12000);
                System.out.println(dragonStatue);
                session.save(dragonStatue);
                session.getTransaction().commit();
                System.out.println(dragonStatue);
            }
        }

        public void showManyItems () {
            try (Session session = factory.get().getCurrentSession()) {
                session.beginTransaction();

                List<Product> items = session.createQuery("from SimpleItem").getResultList();
                System.out.println(items + "\n");

                Product product = session.createQuery("select s from SimpleItem s where s.id = 3", Product.class).getSingleResult();
                System.out.println(product + "\n");

                List<Product> cheapItems = session.createQuery("select s from SimpleItem s where s.price < 180").getResultList();
                System.out.println(cheapItems + "\n");

                session.getTransaction().commit();
            }
        }

        public void updateExample () {
            try (Session session = factory.get().getCurrentSession()) {
                session.beginTransaction();
                Product product = session.get(Product.class, 1L);
                product.setPrice(10000);
                product.setPrice(10);
                session.getTransaction().commit();
            }
        }

        public void deleteExample () {
            try (Session session = factory.get().getCurrentSession()) {
                session.beginTransaction();
                Product product = session.get(Product.class, 1L);
                session.delete(product);
                session.getTransaction().commit();
            }
        }

        public void readAndPrintExample () {
            try (Session session = factory.get().getCurrentSession()) {
                session.beginTransaction();
                Product product = session.get(Product.class, 1L);
                System.out.println(product);
                session.getTransaction().commit();
            }
        }

//        public static void main (String[]args){
//            try {
////            init();
//                createExample();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                shutdown();
//            }
//        }

    }