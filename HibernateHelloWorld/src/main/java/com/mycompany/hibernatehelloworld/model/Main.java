package com.mycompany.hibernatehelloworld.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author naagarjunaa
 */
public class Main {

    public static void main(String[] args) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Hello.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Hello hm = new Hello(7, "hello world");

        session.save(hm);
//        hm = (Hello) session.s
        session.getTransaction().commit();

        System.out.println(hm);
    }
}
