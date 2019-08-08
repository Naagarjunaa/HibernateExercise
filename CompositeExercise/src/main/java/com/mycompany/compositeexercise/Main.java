/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.compositeexercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author naagarjunaa
 */
public class Main {

    public static void main(String[] args) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Userprofile.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Userprofile up = new Userprofile(2, "prabakaran", "7339011438", "abc@gmail.com");
//        Userprofile up = new Userprofile(null, "", "", "abc@gmail.com");

        session.save(up);
        session.getTransaction().commit();
        System.out.println(up);
    }
}
