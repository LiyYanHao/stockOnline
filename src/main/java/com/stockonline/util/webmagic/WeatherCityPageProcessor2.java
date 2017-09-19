package com.stockonline.util.webmagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
public class WeatherCityPageProcessor2 implements PageProcessor{

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private static List cityList = null;
    public void process(Page page) {
        page.getUrl().toString();
        //navbox
        Html html = page.getHtml();
        String townUrl = html.xpath("//*[@class=\"navbox\"]").toString();
        Document tawnDoc = Jsoup.parse(townUrl);
        //a标签列表 <href="/chongzuo/index.shtml">崇左</a>
        Elements spandoc = tawnDoc.getElementsByTag("span");
        Elements adoc = spandoc.get(0).getElementsByTag("a");
        for (int i = 0; i < adoc.size(); i ++){
            String href =adoc.get(i).attr("href");
            String cityName = adoc.get(i).text();
            System.out.println(href+"城市："+cityName);
            Map map = new HashMap();
            map.put(cityName,href);
            cityList = new ArrayList<Map<String,String>>();
            cityList.add(map);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args){

        Spider.create(new WeatherCityPageProcessor()).addUrl("http://www.weather.com.cn/province/").thread(5).run();

        List<Map<String, String>> provinceList = WeatherCityPageProcessor.provinceList;
        for (Map<String, String> province:provinceList){
        Set<String> entries = province.keySet();
        Iterator<String> iterator2 = entries.iterator();
        String cityName = iterator2.next();
        System.out.println(cityName+"url"+province.get(cityName));

        Spider spider = Spider.create(new WeatherCityPageProcessor2());
        spider.addUrl(province.get(cityName)).thread(1).run();

        for (int i = 0; i < cityList.size(); i++){
            Map<String,String> map = (Map<String,String>)cityList.get(i);
            Set<String> set = map.keySet();
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                if(next.equals("南阳")){
                    System.out.println(next+"+++++++++++++++++++++++++++==");
                }
                String valueUrl = map.get(next);
                if(!valueUrl.endsWith("index.shtml")){
                    spider.addUrl(province.get(cityName)+""+valueUrl).thread(5).run();
                }else {
                    if(next.equals("南阳")){//查询丰台未来七天的天气
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.println(next+"未来七天的天气情况：");
                        Spider spider2 = Spider.create(new WeatherCityPageProcessor3());
                        spider2.addUrl(valueUrl).thread(5).run();
                        return;
                    }
                }
            }
        }
        }
    }

}
