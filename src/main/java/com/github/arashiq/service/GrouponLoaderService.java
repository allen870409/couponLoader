package com.github.arashiq.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arashiq.dao.CouponDao;
import com.github.arashiq.dto.GrouponArea;
import com.github.arashiq.model.CouponInfo;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Service
public class GrouponLoaderService {
    @Autowired
    CouponDao couponDao;
    Logger log = LoggerFactory.getLogger(GrouponLoaderService.class);
    List<GrouponArea> areas;
    Pattern pattern = Pattern.compile("※土.*?((\\d,)?\\d+)円");
    @Value("${groupon.list}")
    String grouponListUrl;
    @Value("${groupon.cidUrl}")
    String grouponCidUrl;
    Document doc;
    ObjectMapper mapper = new ObjectMapper();
    public void loadCoupon() throws Exception  {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(grouponListUrl);
        System.out.println("Executing area request " + httpget.getURI());
        CloseableHttpResponse response = httpclient.execute(httpget);
        areas = mapper.readValue(response.getEntity().getContent(), new TypeReference<List<GrouponArea>>(){});
        Stream<GrouponArea> areasStream = areas.stream()
                .filter(c -> c.getCategory().equals("トラベル・レジャー"))
                .filter(c -> !c.getLat().equals("0.000000"));
            areasStream.forEach( area ->
            {
                String url = String.format(grouponCidUrl, area.getCid());
                try {
                    doc = Jsoup.connect(url).get();
                } catch (IOException e) {
                    doc = null;
                    e.printStackTrace();
                }
                if(doc != null && doc.getElementById("change_price_info_cut_rate") != null && !doc.select("div.deal_content_v3 b:containsOwn(アクセス)").isEmpty() &&
                        !doc.select("div.deal_content_v3:contains(アクセス):contains(駅)").isEmpty() &&
                        !doc.select("div.deal_content_v3.mb0 table.deal_use_day tr td.saturday").text().trim().equals("×")){
                    String access = Arrays.stream(doc.select("div.deal_content_v3:contains(アクセス)").html().split("<br>")).filter(n -> n.contains("駅")).findFirst().get().replace("・" , "");
                    String[] addressArray = doc.select("div.separator_line.separator_bordernone").html().split("<br>");
                    String address = addressArray[addressArray.length -1];
                    System.out.println("count_d_" + area.getCid());
                    CouponInfo couponInfo = new CouponInfo(-1, 2, area.getCid(), 1,
                            doc.select("h1.shop_name").first().text(),
                            doc.getElementById("change_title").text().replaceFirst("^.*円】", ""),
                            doc.select("#layout_1st.content_body img.shop_img").first().attr("src"),
                            new Date(),
                            DateUtils.parseDate(doc.getElementById("count_d_" + area.getCid()).attr("value")),
                            parseFloat(doc.getElementById("change_price").text()),
                            parseFloat(doc.getElementById("change_price_info_cut_rate").text()),
                            url,
                            getExtraFee(doc.select("div.deal_content_v3.mb0").first().text()),
                            access,
                            address,
                            area.getLat(), area.getLon());
                    couponDao.add(couponInfo);
                }
            });
   }

    private float getExtraFee(String usableDateInfo){
       Matcher m = pattern.matcher(usableDateInfo);
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
