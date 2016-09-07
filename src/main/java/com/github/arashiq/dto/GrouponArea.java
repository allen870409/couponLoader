package com.github.arashiq.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by arashiQ on 2016/03/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GrouponArea {
    private String code;
    private String name;
    private String cid;
    private String category;
    private String lat;
    private String lon;

    public GrouponArea(String cid) {
        this.cid = cid;
    }

    public GrouponArea() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "GrouponArea{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cid='" + cid + '\'' +
                ", category='" + category + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
