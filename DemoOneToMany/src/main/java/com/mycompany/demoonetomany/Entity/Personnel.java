
package com.mycompany.demoonetomany.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author naagarjunaa
 */
@Entity
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int p_id;
    @Column(length = 60)
    private String name;
    private String QualificationLevel;
    private String phone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proposal_docid")
    private Proposal proposal;
    @OneToMany(mappedBy = "personnel",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Attachment> attachment;

    public Personnel() {
    }

    public Personnel(String name, String QualificationLevel, String phone) {
        this.name = name;
        this.QualificationLevel = QualificationLevel;
        this.phone = phone;
    }

    public Personnel(int p_id, String name, String QualificationLevel, String phone) {
        this.p_id = p_id;
        this.name = name;
        this.QualificationLevel = QualificationLevel;
        this.phone = phone;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualificationLevel() {
        return QualificationLevel;
    }

    public void setQualificationLevel(String QualificationLevel) {
        this.QualificationLevel = QualificationLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public void add(Proposal propl){
//    if (proposal == null){
//    proposal = new ArrayList<>();
//    }
//}
@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    

}
