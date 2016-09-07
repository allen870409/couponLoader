package com.github.arashiq.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arashiq.dao.CouponDao;
import com.github.arashiq.dto.PonpareCoupon;
import com.github.arashiq.model.CouponInfo;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PonpareLoaderService {
    @Autowired
    CouponDao couponDao;
    Logger log = LoggerFactory.getLogger(PonpareLoaderService.class);
    List<PonpareCoupon> couponList;
    List<String> areas = Arrays.asList("1", "5", "8");

    @Value("${ponpare.coupons}")
    String ponpareCouponUrl;
    ObjectMapper mapper = new ObjectMapper();
    public void loadCoupon() throws Exception  {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            for (String area : areas) {
                String url = String.format(ponpareCouponUrl, area);
                HttpGet httpget = new HttpGet(url);
                CloseableHttpResponse response = httpclient.execute(httpget);
                JsonNode jsonNode = mapper.readTree(response.getEntity().getContent()).get("results").get("ticket");
                couponList = mapper.readValue(jsonNode.traverse(), new TypeReference<List<PonpareCoupon>>(){});
                couponList.stream().filter(
                        c -> (c.getSaleStatus().equals("1") && c.getLargeCategoryId().equals("3") && (c.getUsableDateSat().equals("2") || c.getUsableDateSat().equals("1"))
                                && c.getAccess().contains("駅") && c.getDiscount().length() > 0 && getExtraFee(c.getUsableDateInfo()) < parseFloat(c.getPrice()) / 3)
                ).forEach(c -> saveCouponInfo(c));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
   }

   private void saveCouponInfo(PonpareCoupon c){
       CouponInfo couponInfo = new CouponInfo(-1, 1, c.getCid(), 1, c.getName(), c.getTitle(), c.getImage(), DateUtils.parseDate(c.getStarted(), new String[]{"yyyy-MM-dd HH:mm:ss"}),
               DateUtils.parseDate(c.getExpired(), new String[]{"yyyy-MM-dd HH:mm:ss"}), parseFloat(c.getPrice()), parseFloat(c.getDiscount()), c.getUrl(),
               getExtraFee(c.getUsableDateInfo()) ,c.getAccess() ,c.getAddress(), c.getLat(), c.getLon());
       couponDao.add(couponInfo);
   }

    private float getExtraFee(String usableDateInfo){
       Matcher m = Pattern.compile("土.*?((\\d,)?\\d+)円").matcher(usableDateInfo);
       if(m.find()){
           return parseFloat(m.group(1));
       }else{
           return 0F;
       }
    }

    private float parseFloat(String currency){
        return Float.parseFloat(currency.replaceAll(",", ""));
    }

}
