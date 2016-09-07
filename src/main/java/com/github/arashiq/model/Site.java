package com.github.arashiq.model;

import java.util.Date;

/**
 * Created by arashiQ on 2016/03/10.
 */
public class Site {

    private int id;
    private String name;
    private String url;
    private Date created;
    private Date updated;

    public Site(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.created = new Date();
        this.updated = new Date();
    }

    public Site() {
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return "Site{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
