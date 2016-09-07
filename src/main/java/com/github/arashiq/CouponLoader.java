package com.github.arashiq;

import com.github.arashiq.service.ClearOldService;
import com.github.arashiq.service.GrouponCrawlerService;
import com.github.arashiq.service.GrouponLoaderService;
import com.github.arashiq.service.PonpareLoaderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by arashiQ on 2016/03/14.
 */
public class CouponLoader {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/*-config.xml");
        ClearOldService clearOldService = applicationContext.getBean(ClearOldService.class);
        PonpareLoaderService ponpareLoaderService = applicationContext.getBean(PonpareLoaderService.class);
        GrouponLoaderService grouponLoaderService = applicationContext.getBean(GrouponLoaderService.class);
        GrouponCrawlerService grouponCrawlerService = applicationContext.getBean(GrouponCrawlerService.class);

        clearOldService.clearOldCoupon();
        ponpareLoaderService.loadCoupon();
        grouponLoaderService.loadCoupon();
        grouponCrawlerService.loadCoupon();
    }
}
