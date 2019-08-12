
package com.mycompany.demoonetomany.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author naagarjunaa
 */
@Entity
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long DocID;
    @Column(length = 100)
    private String Title;
    @Column(length = 1000)
    private String Comment;

    @OneToMany(mappedBy = "proposal",orphanRemoval = true, cascade = CascadeType.ALL)//,cascade = CascadeType.ALL
    private List<Personnel> personnel;

    @OneToMany(mappedBy = "proposal",orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Attachment> attachments;

    public Proposal() {
    }

    public Proposal(String Title, String Comment) {
        this.Title = Title;
        this.Comment = Comment;
    }

    public Proposal(long DocID, String Title, String Comment) {
        this.DocID = DocID;
        this.Title = Title;
        this.Comment = Comment;
    }

    public long getDocID() {
        return DocID;
    }

    public void setDocID(long DocID) {
        this.DocID = DocID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public List<Personnel> getPersonnel() {
        return personnel;
    }

    public void setPersonnel(List<Personnel> personnel) {
        this.personnel = personnel;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
