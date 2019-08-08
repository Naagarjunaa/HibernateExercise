package com.mycompany.hibernatehelloworld.model;

import java.util.List;
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
        Main m = new Main();
//        m.addMessage(sf);
        m.getAllMessage(sf);
    }

    public void addMessage(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        Hello hm = new Hello(14, "Murugan");
        session.save(hm);
        session.getTransaction().commit();
        System.out.println(hm);
        sf.close();
    }

    public List<Hello> getAllMessage(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Hello> messages = (List<Hello>) session.createQuery(
                "FROM hello").list();
        session.getTransaction().commit();
        session.close();
        return messages;
    }
}
