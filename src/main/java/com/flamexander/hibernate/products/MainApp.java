package com.flamexander.hibernate.products;

import com.flamexander.hibernate.customers.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static com.flamexander.hibernate.customers.CustomerDao.init;
import static com.flamexander.hibernate.customers.CustomerDao.shutdown;

public class MainApp {

    public static void main (String[]args){
        try {
            init();
            CustomerDao.createExample();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }
}
