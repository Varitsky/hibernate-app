package com.flamexander.hibernate.customers;

import com.flamexander.hibernate.PrepareDataApp;
import com.flamexander.hibernate.products.AuxSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


public class CustomerDao {

//    public static SessionFactory factory;

    private static AuxSessionFactory factory;


//    public static void init() {
//        PrepareDataApp.forcePrepareData();
//        factory = new Configuration()
//                .configure("configs/products/hibernate.cfg.xml")
//                .buildSessionFactory();
//    }

    public static void init(){
        String config = "configs/customers/hibernate.cfg.xml";
        factory = new AuxSessionFactory(config);
    }

    public static void shutdown() {
        factory.close();
    }

    public static void createExample() {
        try (Session session = factory.get().getCurrentSession()) {
            session.beginTransaction();
            Customer dragon = new Customer("Dragon2");
            System.out.println(dragon);
            session.save(dragon);
            session.getTransaction().commit();
            System.out.println(dragon);
        }
    }

    public static void showManyItems() {
        try (Session session = factory.get().getCurrentSession()) {
            session.beginTransaction();

            List<Customer> items = session.createQuery("from Customer").getResultList();
            System.out.println(items + "\n");

            Customer customer = session.createQuery("select c from Customer c where c.id = 3", Customer.class).getSingleResult();
            System.out.println(customer + "\n");

            session.getTransaction().commit();
        }
    }

    public static void updateExample() {
        try (Session session = factory.get().getCurrentSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, 1L);
            customer.setName("Cat");
            customer.setName("Cat");
            session.getTransaction().commit();
        }
    }

    public static void deleteExample() {
        try (Session session = factory.get().getCurrentSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, 1L);
            session.delete(customer);
            session.getTransaction().commit();
        }
    }

    public static void readAndPrintExample() {
        try (Session session = factory.get().getCurrentSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, 1L);
            System.out.println(customer);
            session.getTransaction().commit();
        }
    }

    public static void main(String[] args) {
        try {
            init();
            createExample();
            showManyItems();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
