
package com.argus.hibernateauctions.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author naagarjunaa
 */
@Entity
public class Shipment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Id
    private long shipmentid;
    private int inspectionperioddays;
    private String state;
    private Date shipmentcreated;
    @OneToOne(cascade = CascadeType.ALL)
    private Item item;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    public long getShipmentid() {
        return shipmentid;
    }

    public void setShipmentid(long shipmentid) {
        this.shipmentid = shipmentid;
    }

    public int getInspectionperioddays() {
        return inspectionperioddays;
    }

    public void setInspectionperioddays(int inspectionperioddays) {
        this.inspectionperioddays = inspectionperioddays;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getShipmentcreated() {
        return shipmentcreated;
    }

    public void setShipmentcreated(Date shipmentcreated) {
        this.shipmentcreated = shipmentcreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
