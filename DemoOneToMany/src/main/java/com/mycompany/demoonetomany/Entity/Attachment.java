
package com.mycompany.demoonetomany.Entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author naagarjunaa
 */
@Entity
public class Attachment {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int a_id;
    private String fileName;
    private String fileSize;
    private Timestamp Created;
    private byte AttachmentBytes;
    @ManyToOne()
    @JoinColumn(name = "proposal_docid")
    private Proposal proposal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pesonnel_p_id")
    private Personnel personnel;

    public Attachment() {
    }

    public Attachment(String fileName, String fileSize, Timestamp Created, byte AttachmentBytes) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.Created = Created;
        this.AttachmentBytes = AttachmentBytes;
    }

    public Attachment(int a_id, String fileName, String fileSize, Timestamp Created, byte AttachmentBytes) {
        this.a_id = a_id;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.Created = Created;
        this.AttachmentBytes = AttachmentBytes;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Timestamp getCreated() {
        return Created;
    }

    public void setCreated(Timestamp Created) {
        this.Created = Created;
    }

    public byte getAttachmentBytes() {
        return AttachmentBytes;
    }

    public void setAttachmentBytes(byte AttachmentBytes) {
        this.AttachmentBytes = AttachmentBytes;
    }
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    
}
