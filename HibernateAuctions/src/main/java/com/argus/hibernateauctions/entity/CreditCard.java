package com.argus.hibernateauctions.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author naagarjunaa
 */
@Entity
@Table(name="creditcard")  
@PrimaryKeyJoinColumn(name="billid")  
public class CreditCard extends BillingDetails{
 
    private String type;
    private String cnumber;
    private String expmonth;
    private String expyear;

    @OneToOne(mappedBy = "creditcard", cascade = CascadeType.ALL)
    private BillingDetails billingdetails;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return cnumber;
    }

    public void setNumber(String number) {
        this.cnumber = number;
    }

    public String getExpmonth() {
        return expmonth;
    }

    public void setExpmonth(String expmonth) {
        this.expmonth = expmonth;
    }

    public String getExpyear() {
        return expyear;
    }

    public void setExpyear(String expyear) {
        this.expyear = expyear;
    }

}
