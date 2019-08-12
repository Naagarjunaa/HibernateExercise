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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author naagarjunaa
 */
public class MainClass {

    private static final Logger LOG = Logger.getLogger(MainClass.class.getName());

    public static void main(String[] args) {
        
        String sDate = "12/05/2019";
        String eDate = "12/06/2019";
        String aDate1 = "12/05/2019";
        String aDate2 = "10/06/2019";
        String bDate1 = "17/05/2019";
        String bDate2 = "18/05/2019";
        String cDate1 = "18/06/2019";
        String cDate2 = "17/06/2019";
        String shDate = "18/06/2019";

        java.util.Date sdate = null;
        java.util.Date edate = null;
        java.util.Date adate1 = null;
        java.util.Date adate2 = null;
        java.util.Date bdate1 = null;
        java.util.Date bdate2 = null;
        java.util.Date cdate1 = null;
        java.util.Date cdate2 = null;
        java.util.Date shdate = null;

        try {
            sdate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            edate = new SimpleDateFormat("dd/MM/yyyy").parse(eDate);
            adate1 = new SimpleDateFormat("dd/MM/yyyy").parse(aDate1);
            adate2 = new SimpleDateFormat("dd/MM/yyyy").parse(aDate2);
            bdate1 = new SimpleDateFormat("dd/MM/yyyy").parse(bDate1);
            bdate2 = new SimpleDateFormat("dd/MM/yyyy").parse(bDate2);
            cdate1 = new SimpleDateFormat("dd/MM/yyyy").parse(cDate1);
            cdate2 = new SimpleDateFormat("dd/MM/yyyy").parse(cDate2);
            shdate = new SimpleDateFormat("dd/MM/yyyy").parse(shDate);

        } catch (ParseException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }

//        Insertion of data
        Category category = new Category("Soap");
        Category subcat1 = new Category("Detergent");
        Category subcat2 = new Category("Bathing");
//       using recursion and providing category under subcategories
        subcat1.setParent(category);
        category.getChildren().add(subcat1);
        subcat2.setParent(category);
        category.getChildren().add(subcat2);

        Item item1 = new Item();
        item1.setName("Cinthol");
        item1.setDescription("Nice Soap");
        item1.setInitialPrice(new BigDecimal(100));
        item1.setReservePrice(new BigDecimal(120));
        item1.setStartDate(sdate);
        item1.setEndDate(edate);
        item1.setState("ONSALE");
        item1.setApprovalDatetime(adate2);

        Item item2 = new Item();
        item2.setName("Margo");
        item2.setDescription("Nice Soap");
        item2.setInitialPrice(new BigDecimal(90));
        item2.setReservePrice(new BigDecimal(110));
        item2.setStartDate(sdate);
        item2.setEndDate(edate);
        item2.setState("ONSALE");
        item2.setApprovalDatetime(adate1);

        User user = new User();
        user.setFirstname("Naagarjunaa");
        user.setLastname("Ravikkumar");
        user.setUsername("Naagarjunaa Ravikkumar");
        user.setPassword("argusadmin");
        user.setEmail("123@gmail.com");
        user.setRanking(5);
        user.setAdmin(true);

        Address address = new Address();
        address.setStreet("Marriamman street");
        address.setZipcode("636006");
        address.setCity("salem");

        Comment comment = new Comment();
        comment.setRating(3);
        comment.setText("Good soap");
        comment.setCommentcreated(cdate1);

        Comment comment1 = new Comment();
        comment1.setRating(2);
        comment1.setText("Avg soap");
        comment1.setCommentcreated(cdate2);

        BillingDetails bill1 = new BillingDetails();
        bill1.setOwnername("Naagarjunaa Ravikkumar");

        CreditCard card = new CreditCard();
        card.setType("DebitCard");
        card.setNumber("1234-5678-9123-4567");
        card.setExpmonth("12");
        card.setExpyear("25");

//        BankAccount account = new BankAccount();
//        account.setBankname("canara");
//        account.setNumber("12345678912345");
//        account.setSwift("Morning");

        Bid bid1 = new Bid();
        bid1.setAmount(new BigDecimal(140));
        bid1.setBidcreated(bdate1);

        Bid bid2 = new Bid();
        bid2.setAmount(new BigDecimal(150));
        bid2.setBidcreated(bdate2);

        Shipment shipment = new Shipment();
        shipment.setInspectionperioddays(2);
        shipment.setState("product Shippped");
        shipment.setShipmentcreated(shdate);

//       Mapping Configuration
        subcat2.getItems().add(item1);
        category.getItems().add(item2);

        item1.setCategory(subcat2);
        item2.setCategory(subcat2);
        item1.setUser(user);
        item2.setUser(user);
        item1.getBids().add(bid1);
        item1.getBids().add(bid2);
        item2.getBids().add(bid1);
        item2.getBids().add(bid2);
        item1.setSuccessbid(bid1);
        item2.setSuccessbid(bid2);
        item1.setShipment(shipment);
        item2.setShipment(shipment);
        item1.getComments().add(comment);
        item2.getComments().add(comment1);

        address.setUser(user);
        address.setShipment(shipment);

        comment.setItem(item1);
        comment.setItem(item2);
        comment.setUser(user);

        user.getItems().add(item1);
        user.getItems().add(item2);
        user.getComments().add(comment);
        user.getComments().add(comment1);
        user.getBids().add(bid1);
        user.getBids().add(bid2);
        user.getBiilingBillingDetailses().add(bill1);
        user.setAddress(address);
        user.setShipment(shipment);

        bill1.setUser(user);
        bill1.setCreditcard(card);
//        bill1.setBankaccount(account);

        bid1.setUser(user);
        bid2.setUser(user);
        bid1.setItem(item1);
        bid2.setItem(item2);
        bid1.setSuccessitem(item1);
        bid2.setSuccessitem(item2);

        shipment.setItem(item1);
        shipment.setItem(item2);
        shipment.setUser(user);
        shipment.setAddress(address);

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
        session.save(category);
        tx.commit();
        sf.close();
    }
}
