
package com.mycompany.demoonetomany;

import com.mycompany.demoonetomany.Entity.Attachment;
import com.mycompany.demoonetomany.Entity.Personnel;
import com.mycompany.demoonetomany.Entity.Proposal;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
enum QualificationLevel {
    Beginner, Intermediate, Pro;
}

public class Main {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Main m = new Main();
        int i;
        i = Integer.parseInt(args[0]);

        Configuration con = new Configuration().configure().addAnnotatedClass(Proposal.class).addAnnotatedClass(Attachment.class).addAnnotatedClass(Personnel.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        switch (i) {
            case 1:
                m.fetchData(session);
                break;
            case 2:
                m.saveData(session);
                break;
            case 3:
                m.deleteData(session);
                break;
            case 4:
                m.updateData(session);
                break;
            default:
                LOG.info("Please enter arguments to choose operation");
                break;
        }
        tx.commit();
        sf.close();
    }

    public void fetchData(Session session) {
        //to fetch data
        List<Proposal> s = session.createQuery("from Proposal").list();
        for (Proposal proposal : s) {
            LOG.log(Level.INFO, "DOC ID: {0}", proposal.getDocID());
            LOG.log(Level.INFO, " DOC Name: {0}", proposal.getTitle());
            LOG.log(Level.INFO, "  COMMENT: {0}", proposal.getComment());
            List personnel = proposal.getPersonnel();
            for (Iterator iterator2 = personnel.iterator(); iterator2.hasNext();) {
                Personnel person = (Personnel) iterator2.next();
                LOG.log(Level.INFO, "Name: {0}", person.getName());
                LOG.log(Level.INFO, "Qualification level: {0}", person.getQualificationLevel());
                LOG.log(Level.INFO, "PhoneNumber: {0}", person.getPhone());
                List attachper = person.getAttachment();
                for (Iterator iterator4 = attachper.iterator(); iterator4.hasNext();) {
                    Attachment attach = (Attachment) iterator4.next();
                    LOG.log(Level.INFO, "Attach File Name: {0}", attach.getFileName());
                    LOG.log(Level.INFO, "Filesize: {0}", attach.getFileSize());
                    LOG.log(Level.INFO, "Created: {0}", attach.getCreated());
                    LOG.log(Level.INFO, "Attachment: {0}", attach.getAttachmentBytes());
                }
            }
            List attachment = proposal.getAttachments();
            for (Iterator iterator3 = attachment.iterator(); iterator3.hasNext();) {
                Attachment attach = (Attachment) iterator3.next();
                LOG.log(Level.INFO, "Attach File Name: {0}", attach.getFileName());
                LOG.log(Level.INFO, "Filesize: {0}", attach.getFileSize());
                LOG.log(Level.INFO, "Created: {0}", attach.getCreated());
                LOG.log(Level.INFO, "Attachment: {0}", attach.getAttachmentBytes());
            }
        }
    }

    public void deleteData(Session session) {
//    to delete data

        Attachment ad = session.get(Attachment.class, 9);
        session.delete(ad);
        Personnel pd = session.get(Personnel.class, 2);
        session.delete(pd);
        Proposal prod = session.get(Proposal.class, new Long(2));
        session.delete(prod);
    }

    public void saveData(Session session) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Proposal prop = new Proposal("Aug-2019", "It Contains one month data");
        prop.setDocID(0);

        Attachment att1 = new Attachment("Mahabharat", "10000", timestamp, (byte) 9091);
        att1.setA_id(0);

        Attachment att2 = new Attachment("Mahasfsafsf", "10220", timestamp, (byte) 2091);
        att1.setA_id(0);

        Personnel per1 = new Personnel("Naagarjunaa", QualificationLevel.Beginner + "", "9787812598");
        per1.setP_id(0);

        att1.setPersonnel(per1);
        att1.setProposal(prop);
        att2.setPersonnel(per1);
        att2.setProposal(prop);

        per1.setProposal(prop);
        List<Attachment> alist = new ArrayList<>();
        alist.add(att1);
        alist.add(att2);
        per1.setAttachment(alist);

        List<Attachment> alist1 = new ArrayList<>();
        alist1.add(att1);
        alist1.add(att2);
        prop.setAttachments(alist1);

        List<Personnel> plist = new ArrayList<>();
        plist.add(per1);
        prop.setPersonnel(plist);

        //to save data
        session.save(prop);
    }

    public void updateData(Session session) {
        //to update data from one person to another person
        Attachment attU = session.get(Attachment.class, 9);
        Personnel perU = session.get(Personnel.class, 5);
        attU.setPersonnel(perU);
        session.update(attU);
        //to update data ...manually
        Attachment attU1 = session.get(Attachment.class, 9);
        attU1.setFileName("Ramayana");
        session.update(attU1);
    }
}
