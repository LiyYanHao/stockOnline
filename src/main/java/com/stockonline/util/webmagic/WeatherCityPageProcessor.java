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
 */
public class WeatherCityPageProcessor implements PageProcessor{
    //部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    public static List<Map<String,String>> provinceList = new ArrayList<Map<String,String>>();
    public void process(Page page) {
        //部分二：定义如何抽取页面信息，并保存下来
        String url = page.getUrl().toString();
        if(!url.endsWith("index.html")){
            Html html = page.getHtml();
            String cityUrl = html.xpath("//*[@class=\"sheng_rukou\"]").toString();
            Document docList = Jsoup.parse(cityUrl);
            Elements es = docList.getElementsByClass("sheng_rukou");
            Elements li = es.get(0).getElementsByTag("li");
            System.out.println(li.size());
            for (int i = 0; i < li.size(); i++){
                Element element = li.get(i);
                Element a = element.getElementsByTag("a").get(0);
                String href =a.attr("href");
                String cityName = a.text();
                System.out.println(href+"城市："+cityName);
                Map<String,String>  provinceCityList = new HashMap<>();
                provinceCityList.put(cityName,href);
                provinceList.add(provinceCityList);
            }
        }
    }
    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args){
        Spider.create(new WeatherCityPageProcessor()).addUrl("https://pan.baidu.com/s/1skOu2LJ").thread(1).run();
        for (Map<String,String> map:provinceList ){
            Set<String> entries = map.keySet();
            Iterator<String> iterator = entries.iterator();
            String cityName = iterator.next();
            System.out.println(cityName+"url"+map.get(cityName));
        }
    }

}
