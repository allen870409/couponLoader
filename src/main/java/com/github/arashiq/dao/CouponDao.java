package com.github.arashiq.dao;

import com.github.arashiq.model.CouponInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * Created by arashiQ on 2016/03/22.
 */
@Repository
public interface CouponDao {
    @Insert ("INSERT IGNORE INTO m_coupon_info (site, cid, category, name, title, image, started, expired, price,discount, url, extra_fee, access, address, lat, lon) " +
            "values (#{site}, #{cid}, #{category}, #{name}, #{title}, #{image}, #{started}, #{expired}, #{price},#{discount}, #{url}, #{extraFee}, #{access}, #{address}, #{lat}, #{lon})")
    public int add(CouponInfo couponInfo);

    @Delete("DELETE FROM m_coupon_info")
    public void clear();
}
