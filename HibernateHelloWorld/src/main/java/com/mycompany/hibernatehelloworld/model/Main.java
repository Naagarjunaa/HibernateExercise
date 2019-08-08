/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatehelloworld.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author naagarjunaa
 */
public class Main {

    public static void main(String[] args) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Hello.class);
        org.hibernate.SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Hello hm = new Hello(7, "hello world");

        session.save(hm);
        tx.commit();

    }
}
