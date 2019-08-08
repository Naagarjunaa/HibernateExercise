
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
        Userprofile up = new Userprofile(3, "yogeswaran", "7339011438", "abc@gmail.com");
//        Userprofile up = new Userprofile(null, "", "", "abc@gmail.com");
//ConstraintViolationException
        session.save(up);
        session.getTransaction().commit();
        System.out.println(up);
        sf.close();
    }
}
