package com.argus.hibernateauctions.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author naagarjunaa
 */
@Entity
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Id
    private long categoryid;
    private String categoryname;
    
   // These 4 lines are performing recursion declaring parent and children....
    @ManyToOne
//    @JoinColumn(name = "parent_id")
    private Category parent;
    
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Category> children = new HashSet<Category>();
    //
    
    @OneToMany(mappedBy = "category", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    public Category(String categoryname) {
        this.categoryname = categoryname;
    }

    public Category() {
    }
    
    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public void setChildren(Set<Category> children) {
        this.children = children;
    }


    public Category getParent() {
        return parent;
    }

    public Set<Category> getChildren() {
        return children;
    }

    public long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
