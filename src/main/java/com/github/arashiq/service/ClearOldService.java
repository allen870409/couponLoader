package com.github.arashiq.service;

import com.github.arashiq.dao.CouponDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClearOldService {
    @Autowired
    CouponDao couponDao;

    public void clearOldCoupon() throws Exception  {
        couponDao.clear();
   }

}
