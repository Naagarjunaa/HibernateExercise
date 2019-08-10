
package com.argus.hibernateauctions.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToOne
    private Item item;
    @OneToOne
    private User user;

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

    public Item getItems() {
        return item;
    }

    public void setItems(Item items) {
        this.item = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
