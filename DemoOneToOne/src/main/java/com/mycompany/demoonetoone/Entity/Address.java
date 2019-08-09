package com.mycompany.demoonetoone.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author naagarjunaa
 */
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private int id;
    @Column(name = "street1")
    private String street1;
    @Column(name = "street2")
    private String street2;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    @JoinColumn(name = "student")
    private Student student;

    public Address(String street1, String street2, String city, String country, Student student) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.country = country;
        this.student = student;
    }

    public Address( String street1, String street2, String city, String country) {
        
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.country = country;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
