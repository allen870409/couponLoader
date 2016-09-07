package com.github.arashiq.service;

import com.github.arashiq.dao.CouponDao;
import com.github.arashiq.dto.GrouponCoupon;
import com.github.arashiq.model.CouponInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GrouponCrawlerService {
    @Autowired
    CouponDao couponDao;
    private PageModelPipeline couponInfoDaoPipeline = new CouponInfoDaoPipeline();
    Logger log = LoggerFactory.getLogger(GrouponCrawlerService.class);
    Pattern pattern = Pattern.compile("※土.*?((\\d,)?\\d+)円");
    @Value("${groupon.list}")
    String grouponListUrl;
    @Value("${groupon.cidUrl}")
    String grouponCidUrl;

    public void loadCoupon() throws Exception  {
        OOSpider.create(us.codecraft.webmagic.Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36")
                        .addCookie("__gads", "ID=313547b2bb961ad1:T=1452745731:S=ALNI_Ma9mQLza2C5E-KRk7J0oDHCzSXxSw")
                        .addCookie("__is_access", "YES")
                        .addCookie("__qaf", "OGNC_101_1001")
                        .addCookie("__subscribing_area", "13")
                        .addCookie("_mainarea_subarea_", "13-0")
                        .addCookie("b", "7931104a-99a3-9770-d779-cc6cff34e25c")
                        .addCookie("b", "7931104a-99a3-9770-d779-cc6cff34e25c")
                        .addCookie("b", "7931104a-99a3-9770-d779-cc6cff34e25c")
                        .addCookie("s", "733a46a5-2d21-0d6c-8f9d-499d2afc4b13")
                        .addCookie("__qaf", "OGNC_101_1001")
                        .addCookie("cart_cache", "a%3A2%3A%7Bs%3A6%3A%22expire%22%3Bi%3A1458811395%3Bs%3A4%3A%22data%22%3BO%3A8%3A%22stdClass%22%3A0%3A%7B%7D%7D")
                        .addCookie("__u", "rBACClaXJAJGxlFS0eA8Ag==")
                        .addCookie("__utma", "118864854.1977493418.1458811100.1458811100.1458811100.1")
                        .addCookie("__utmb", "118864854.2.10.1458811100")
                        .addCookie("__utmt", "1")
                        .addCookie("__utmz", "118864854.1458811100.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)")
                        .addCookie("__utmc", "118864854")
                        .addCookie("_msuuid_21630c8s37773", "3F2FE61B-C29D-49A0-9384-C68889A8FCA9")
                        .addCookie("_ses_id_", "ee3bd41ae8bd85d778098b3fb692e98")
                        .addCookie("expandable", "-1c")
                        .addCookie("bh-last-page-id", "733a46a5-2d21-0d6c-8f9d-499d2afc4b13-1458804336992-TH0")
                        .addCookie("_ses_data_", "a%253A18%253A%257Bs%253A2%253A%2522ua%2522%253Bs%253A109%253A%2522Mozilla%252F5.0%2B%2528Windows%2BNT%2B6.1%253B%2BWOW64%2529%2BAppleWebKit%252F537.36%2B%2528KHTML%252C%2Blike%2BGecko%2529%2BChrome%252F48.0.2564.116%2BSafari%252F537.36%2522%253Bs%253A2%253A%2522ip%2522%253Bs%253A14%253A%2522122.212.156.18%2522%253Bs%253A4%253A%2522area%2522%253Bs%253A2%253A%252213%2522%253Bs%253A7%253A%2522subarea%2522%253Bi%253A0%253Bs%253A10%253A%2522local_area%2522%253Bs%253A2%253A%252213%2522%253Bs%253A13%253A%2522local_subarea%2522%253Bi%253A0%253Bs%253A11%253A%2522revisit_chk%2522%253Bs%253A3%253A%2522YES%2522%253Bs%253A10%253A%2522h_discount%2522%253Bs%253A12%253A%2522109231769644%2522%253Bs%253A8%253A%2522h_ticket%2522%253Bs%253A8%253A%252230919606%2522%253Bs%253A8%253A%2522areaLink%2522%253Bs%253A0%253A%2522%2522%253Bs%253A7%253A%2522ctgLink%2522%253Bs%253A81%253A%2522%2525E3%252583%252588%2525E3%252583%2525A9%2525E3%252583%252599%2525E3%252583%2525AB%2525E3%252583%2525BB%2525E3%252583%2525AC%2525E3%252582%2525B8%2525E3%252583%2525A3%2525E3%252583%2525BC%2522%253Bs%253A8%253A%2522sctgLink%2522%253Bs%253A54%253A%2522%2525E5%2525AE%2525BF%2525E6%2525B3%25258A%2525E3%252583%2525BB%2525E3%252583%25259B%2525E3%252583%252586%2525E3%252583%2525AB%2522%253Bs%253A8%253A%2522dateLink%2522%253Bb%253A0%253Bs%253A9%253A%2522user_from%2522%253Bs%253A13%253A%2522OGNC_101_1001%2522%253Bs%253A13%253A%2522selected_area%2522%253Bs%253A2%253A%252213%2522%253Bs%253A16%253A%2522selected_subarea%2522%253Ba%253A0%253A%257B%257Ds%253A17%253A%2522selected_category%2522%253BN%253Bs%253A13%253A%2522selected_page%2522%253Bi%253A1%253B%257D"),
                couponInfoDaoPipeline, GrouponCoupon.class).addUrl("http://www.groupon.jp/db/?cid=294542").thread(5).run();
   }

    private float getExtraFee(String usableDateInfo){
       Matcher m = pattern.matcher(usableDateInfo);
       if(m.find()){
           return parseFloat(m.group(1));
       }else{
           return 0F;
       }
    }

    private String[] getLatAndLon(String usableDateInfo){
        Matcher m = Pattern.compile("q=(\\d+.\\d+,\\d+.\\d+)").matcher(usableDateInfo);
        if(m.find()){
            return m.group(1).split(",");
        }else{
            return new String[]{"0.0","0.0"};
        }
    }

    private float parseFloat(String currency){
        return Float.parseFloat(currency.replaceAll(",", ""));
    }

    private class CouponInfoDaoPipeline implements PageModelPipeline<GrouponCoupon> {

        @Override
        public void process(GrouponCoupon grouponCoupon, Task task) {
            if(grouponCoupon.getDiscount() != null && !grouponCoupon.getUsableDateSat().trim().equals("×") && grouponCoupon.getAccess().contains("駅")){
                String access = Arrays.stream(grouponCoupon.getAccess().split("<br>")).filter(n -> n.contains("駅")).findFirst().get().replace("・" , "");
                String[] addressArray = grouponCoupon.getAddress().split("<br>");
                String address = addressArray[addressArray.length - 1];
                CouponInfo couponInfo = new CouponInfo(-1, 2, grouponCoupon.getUrl().replace("http://www.groupon.jp/db/?cid=", ""), 1,
                        grouponCoupon.getName(),
                        grouponCoupon.getTitle().replaceFirst("^.*円】", ""),
                        grouponCoupon.getImage(),
                        new Date(),
                        new Date(2100, 0, 0),
                        parseFloat(grouponCoupon.getPrice()),
                        parseFloat(grouponCoupon.getDiscount()),
                        grouponCoupon.getUrl(),
                        getExtraFee(grouponCoupon.getUsableDateInfo()),
                        access,
                        address,
                        getLatAndLon(grouponCoupon.getLatAndLon())[0],
                        getLatAndLon(grouponCoupon.getLatAndLon())[1]);
                couponDao.add(couponInfo);
            }

        }

    }


}
