package com.stockonline.util.webmagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.*;

/**
 * Created by lyh on 17-9-18.
 * http://bj.weather.com.cn/
 */
public class WeatherCityPageProcessor3 implements PageProcessor{

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    public void process(Page page) {
        page.getUrl().toString();
        //navbox
        Html html = page.getHtml();
        String townUrl = html.xpath("//*[@id=\"7d\"]").toString();
        Document docList = Jsoup.parse(townUrl);
        Elements es = docList.getElementsByClass("clearfix");
        Elements li = es.get(0).getElementsByTag("li");
        for (Element s:li){
            String dataNow = s.getElementsByTag("h1").get(0).text().toString();
            Elements pList = s.getElementsByTag("p");
            String weather = pList.get(0).text().toString();//天气
            Element temperatureAll = pList.get(1);//温度  <span>33</span>/<i>24℃</i>

            String temperatureMax = temperatureAll.getElementsByTag("span").get(0).text().toString();
            String temperatureMin = temperatureAll.getElementsByTag("i").get(0).text().toString();
            String wind = pList.get(2).getElementsByTag("i").first().text().toString();
            System.out.println("今天："+dataNow+"\t"+weather+"最高温度"+"\t"+temperatureMax+
            "最低温度"+temperatureMin+"\t"+wind);
        }


    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider spider = Spider.create(new WeatherCityPageProcessor3());
        spider.addUrl("http://www.weather.com.cn/weather/101300206.shtml").thread(1).run();
    }

}
