
package com.mycompany.hibernateexample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author naagarjunaa
 */
@Entity
@Table(name = "hello")
public class HelloWorld {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "message")
    private String Message;

    public HelloWorld() {
    }

    public HelloWorld(int id, String Message) {
        this.id = id;
        this.Message = Message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
    
    
    
}
