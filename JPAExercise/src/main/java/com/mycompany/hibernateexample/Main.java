
package com.mycompany.hibernateexample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author naagarjunaa
 */

public class Main {
    private static EntityManager em;
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence
                .createEntityManagerFactory("HelloWorld");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        HelloWorld hw = new HelloWorld(6,"Amma");
        em.persist(hw);
//        System.out.println("hello" +hw);
        em.getTransaction().commit();
//        System.out.println("INSERTED");
    }
    
}
