package com.github.arashiq.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by arashiQ on 2016/03/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PonpareCoupon {
    @JsonProperty("id")
    private String cid;
    @JsonProperty("shop_name")
    private String name;
    @JsonProperty("large_category_id")
    private String largeCategoryId;
    @JsonProperty("catchcopy")
    private String title;
    @JsonProperty("dtl_cas1_img")
    private String image;
    @JsonProperty("sales_from")
    private String started;
    @JsonProperty("sales_until")
    private String expired;
    @JsonProperty("sales_status")
    private String saleStatus;
    @JsonProperty("price")
    private String price;
    @JsonProperty("discount_rate")
    private String discount;
    @JsonProperty("ticket_detail_url")
    private String url;
    @JsonProperty("usable_date_sat")
    private String usableDateSat;
    @JsonProperty("usable_date_info")
    private String usableDateInfo;
    @JsonProperty("shop_access")
    private String access;
    @JsonProperty("shop_address")
    private String address;
    @JsonProperty("shop_x")
    private String lat;
    @JsonProperty("shop_y")
    private String lon;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLargeCategoryId() {
        return largeCategoryId;
    }

    public void setLargeCategoryId(String largeCategoryId) {
        this.largeCategoryId = largeCategoryId;
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

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsableDateSat() {
        return usableDateSat;
    }

    public void setUsableDateSat(String usableDateSat) {
        this.usableDateSat = usableDateSat;
    }

    public String getUsableDateInfo() {
        return usableDateInfo;
    }

    public void setUsableDateInfo(String usableDateInfo) {
        this.usableDateInfo = usableDateInfo;
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
        return "PonpareCoupon{" +
                "cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                ", largeCategoryId='" + largeCategoryId + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", started='" + started + '\'' +
                ", expired='" + expired + '\'' +
                ", saleStatus='" + saleStatus + '\'' +
                ", price='" + price + '\'' +
                ", discount='" + discount + '\'' +
                ", url='" + url + '\'' +
                ", usableDateSat='" + usableDateSat + '\'' +
                ", usableDateInfo='" + usableDateInfo + '\'' +
                ", access='" + access + '\'' +
                ", address='" + address + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}


