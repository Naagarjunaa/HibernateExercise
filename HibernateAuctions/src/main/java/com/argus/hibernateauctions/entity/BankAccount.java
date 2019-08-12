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
@Table(name = "bankaccount")
@PrimaryKeyJoinColumn(name = "billid")
public class BankAccount extends BillingDetails {

    private String number;
    private String bankname;
    private String swift;
    @OneToOne(mappedBy = "bankaccount",cascade = CascadeType.ALL)
   private BillingDetails billingDetails;
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

}
