
package com.mycompany.compositeexercise;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author naagarjunaa
 */
@Entity
@Table(
       name = "userprofile",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = {"name", "phone"})
       })
public class Userprofile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Id
    @Column(name = "email")
    private String email;
    
    @Id
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    public Userprofile() {
    }

    public Userprofile(Integer id) {
        this.id = id;
    }

    public Userprofile(Integer id, String name, String phone,String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userprofile)) {
            return false;
        }
        Userprofile other = (Userprofile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Userprofile{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + '}';
    }

    
    
}
