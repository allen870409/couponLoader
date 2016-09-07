package com.github.arashiq.model;

import java.util.Date;

/**
 * Created by arashiQ on 2016/03/09.
 */

public class CouponInfo {

    private int id;
    private int site;
    private String cid;
    private int category;
    private String name;
    private String title;
    private String image;
    private Date started;
    private Date expired;
    private float price;
    private float discount;
    private String url;
    private Float extraFee;
    private String access;
    private String address;
    private String lat;
    private String lon;

    public CouponInfo(int id, int site, String cid, int category, String name, String title, String image, Date started, Date expired, float price, float discount, String url, Float extraFee, String access, String address, String lat, String lon) {
        this.id = id;
        this.site = site;
        this.cid = cid;
        this.category = category;
        this.name = name;
        this.title = title;
        this.image = image;
        this.started = started;
        this.expired = expired;
        this.price = price;
        this.discount = discount;
        this.url = url;
        this.extraFee = extraFee;
        this.access = access;
        this.address = address;
        this.lat = lat;
        this.lon = lon;
    }

    public CouponInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Float getExtraFee() {
        return extraFee;
    }

    public void setExtraFee(Float extraFee) {
        this.extraFee = extraFee;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "CouponInfo{" +
                "id=" + id +
                ", site=" + site +
                ", cid=" + cid +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", started=" + started +
                ", expired=" + expired +
                ", price=" + price +
                ", discount=" + discount +
                ", url='" + url + '\'' +
                ", extraFee='" + extraFee + '\'' +
                ", access='" + access + '\'' +
                ", address='" + address + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
