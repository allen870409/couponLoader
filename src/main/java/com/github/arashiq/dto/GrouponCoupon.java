package com.github.arashiq.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by arashiQ on 2016/03/14.
 */
@TargetUrl("http://www.groupon.jp/db/\\?cid=[\\w]+")
@HelpUrl("http://www.groupon.jp/deal-all_deal/area/travel*")
public class GrouponCoupon {
    @ExtractBy("//h1[@class=\"shop_name\"]/text()")
    private String name;
    @ExtractBy("//h2[@class=\"h_deal_title\"]/span[@id=\"change_title\"]/text()")
    private String title;
    @ExtractBy("//ul[@id=\"main_img\"]/li[@class=\"default\"]/img/@src")
    private String image;
    @ExtractBy("//var[@id=\"change_price\"]/text()")
    private String price;
    @ExtractBy("//var[@id=\"change_price_info_cut_rate\"]/text()")
    private String discount;
    @ExtractByUrl
    private String url;
    @ExtractBy("//table[@class=\"deal_use_day\"]/tbody/tr[2]/td[@class=\"saturday\"]/text()")
    private String usableDateSat;
    @ExtractBy("//div[@class=\"deal_content_v3 mb0\"]/text()")
    private String usableDateInfo;
    @ExtractBy("//div[@class=\"deal_content_v3\"]/html()")
    private String access;
    @ExtractBy("//div[@class=\"separator_line separator_bordernone\"]/html()")
    private String address;
    @ExtractBy("//div[@class=\"smail_map_link\"]/a/@href")
    private String latAndLon;

    @Override
    public String toString() {
        return "GrouponCoupon{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price='" + price + '\'' +
                ", discount='" + discount + '\'' +
                ", url='" + url + '\'' +
                ", usableDateSat='" + usableDateSat + '\'' +
                ", usableDateInfo='" + usableDateInfo + '\'' +
                ", access='" + access + '\'' +
                ", address='" + address + '\'' +
                ", latAndLon='" + latAndLon + '\'' +
                '}';
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

    public String getLatAndLon() {
        return latAndLon;
    }

    public void setLatAndLon(String latAndLon) {
        this.latAndLon = latAndLon;
    }
}


