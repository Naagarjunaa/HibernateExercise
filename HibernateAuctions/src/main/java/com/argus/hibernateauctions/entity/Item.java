
package com.argus.hibernateauctions.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author naagarjunaa
 */
@Entity
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Id
    private long itemid;
    private String name;
    private String description;
    private BigDecimal initialPrice;
    private BigDecimal reservePrice;
    private Date startDate;
    private Date endDate;
    private String state;
    private Date approvalDatetime;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    @OneToOne(cascade = CascadeType.ALL)
    private User user; 
    @OneToMany(mappedBy = "item",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Bid> bids = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Bid successbid ;
    @OneToMany(mappedBy = "item",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Shipment shipment;

    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public BigDecimal getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getApprovalDatetime() {
        return approvalDatetime;
    }

    public void setApprovalDatetime(Date approvalDatetime) {
        this.approvalDatetime = approvalDatetime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public Bid getSuccessbid() {
        return successbid;
    }

    public void setSuccessbid(Bid successbid) {
        this.successbid = successbid;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

}
