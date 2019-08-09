
package com.mycompany.demoonetoone;

import com.mycompany.demoonetoone.Entity.Address;
import com.mycompany.demoonetoone.Entity.Education;
import com.mycompany.demoonetoone.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author naagarjunaa
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session = sf.openSession();
        session.beginTransaction();
        Student stu = new Student("Naagarjunaa", " ", "Ravikkumar", "Mr", "B.E(EEE)", "arjun@gmail.com", "9787812598");
        Address add = new Address( "17/9", "Gugai", "Salem,Tamilnadu", "India");
        Education edu = new Education("StateBoard" , "10th", "2012", "SVB");
        stu.setId(0);
        edu.setId(0);
        add.setId(0);
        stu.setAddress(add);
        stu.setEducation(edu);
        session.save(stu);
        System.out.println(stu);
        session.getTransaction().commit();
        sf.close();
    }
}
