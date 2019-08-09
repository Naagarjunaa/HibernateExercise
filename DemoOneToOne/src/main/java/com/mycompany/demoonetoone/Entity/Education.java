/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_id")
    private int id;
    @Column(name = "degreetype")
    private String degreetype;
    @Column(name = "degreedescription")
    private String degreedescription;
    @Column(name = "graduationyear")
    private String graduationyear;
    @Column(name = "school")
    private String school;
    @OneToOne(mappedBy = "education", cascade = CascadeType.ALL)
    @JoinColumn(name = "student")
    private Student student;

    public Education( String degreetype, String degreedescription, String graduationyear, String school) {

        this.degreetype = degreetype;
        this.degreedescription = degreedescription;
        this.graduationyear = graduationyear;
        this.school = school;
    }

    public Education() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDegreetype() {
        return degreetype;
    }

    public void setDegreetype(String degreetype) {
        this.degreetype = degreetype;
    }

    public String getDegreedescription() {
        return degreedescription;
    }

    public void setDegreedescription(String degreedescription) {
        this.degreedescription = degreedescription;
    }

    public String getGraduationyear() {
        return graduationyear;
    }

    public void setGraduationyear(String graduationyear) {
        this.graduationyear = graduationyear;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
