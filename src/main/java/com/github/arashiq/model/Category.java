package com.github.arashiq.model;

import java.util.Date;

/**
 * Created by arashiQ on 2016/03/10.
 */
public class Category {

    private int id;
    private String name;
    private Date created;
    private Date updated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.created = new Date();
        this.updated =  new Date();
    }

    public Category() {
    }
}
