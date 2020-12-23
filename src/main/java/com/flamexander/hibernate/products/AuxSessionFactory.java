package com.flamexander.hibernate.products;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class AuxSessionFactory {

    private static SessionFactory sessionFactory;

    public AuxSessionFactory(String config){
        sessionFactory = new Configuration()
                .configure(config)
                .buildSessionFactory();
    }

    public SessionFactory get(){
        return sessionFactory;
    }

    public void close(){
        sessionFactory.close();
    }
}
