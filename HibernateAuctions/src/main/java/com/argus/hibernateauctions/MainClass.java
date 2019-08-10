
package com.argus.hibernateauctions;

import com.argus.hibernateauctions.entity.Address;
import com.argus.hibernateauctions.entity.BankAccount;
import com.argus.hibernateauctions.entity.Bid;
import com.argus.hibernateauctions.entity.BillingDetails;
import com.argus.hibernateauctions.entity.Category;
import com.argus.hibernateauctions.entity.Comment;
import com.argus.hibernateauctions.entity.CreditCard;
import com.argus.hibernateauctions.entity.Item;
import com.argus.hibernateauctions.entity.Shipment;
import com.argus.hibernateauctions.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author naagarjunaa
 */
public class MainClass {

    public static void main(String[] args) {
       

        Configuration con = new Configuration().configure()
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(BankAccount.class)
                .addAnnotatedClass(Bid.class)
                .addAnnotatedClass(BillingDetails.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(CreditCard.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Shipment.class)
                .addAnnotatedClass(User.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        tx.commit();
        sf.close();
    }
}
