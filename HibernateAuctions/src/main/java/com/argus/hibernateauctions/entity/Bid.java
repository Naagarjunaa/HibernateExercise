
package com.argus.hibernateauctions.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author naagarjunaa
 */
@Entity
public class Bid {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Id
    private long bidid;
    private BigDecimal amount;
    private Date bidcreated;
    @ManyToOne
    private Item item;
    @OneToOne
    private Item successitem;
    @ManyToOne
    private User user;

    public long getBidid() {
        return bidid;
    }

    public void setBidid(long bidid) {
        this.bidid = bidid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getBidcreated() {
        return bidcreated;
    }

    public void setBidcreated(Date bidcreated) {
        this.bidcreated = bidcreated;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getSuccessitem() {
        return successitem;
    }

    public void setSuccessitem(Item successitem) {
        this.successitem = successitem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
