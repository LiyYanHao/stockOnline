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





public class WeatherRepoPageProcessor2 implements PageProcessor {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    private String [] tit = {"最高气温:\t","最低气温:\t","天气:\t","风向:\t","\"风力:\t"};
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        String url = page.getUrl().toString();
        if(!url.endsWith("index.html")&&url.endsWith("html")){
            Html html = page.getHtml();
            //获取城市名
            String city = html.xpath("//*[@id=\"tool_site\"]/div[1]/h3").toString();
            city = city.substring(city.indexOf(">") + 1, city.indexOf("20"));

            //System.out.println(city);
            String content = html.toString();
            Document docList = Jsoup.parse(content);
            //定位到class
            Elements es = docList.getElementsByClass("tqtongji2");
            //定位到ul
            Elements UlTag = es.get(0).getElementsByTag("ul");

            for (int j = 1; j < UlTag.size(); j++) {
                Element obj = UlTag.get(j);
                Elements LiTag = obj.getElementsByTag("li");
                Element li1 = LiTag.get(0);
                //获取某日天气详情链接
                String ss = li1.getElementsByTag("a").get(0).html();
                System.out.println(city+"\t"+ss);
                //获取每个li标签数据
                for(int i = 1;i<LiTag.size();i++){
                    System.out.println(tit[i-1]+LiTag.get(i).html());
                }
                System.out.println("*******************");
                // System.out.println(LiTag.html());
            }

        }
        // 部分三：从页面发现后续的url地址来抓取

        //爬取杭州历年的天气数据
        page.addTargetRequests(page.getHtml().links().regex("http://lishi\\.tianqi\\.com/[a-z]+/[\\d]+\\.html").all());
        page.addTargetRequests(page.getHtml().links().regex("http://lishi\\.tianqi\\.com/hangzhou/index\\.html").all());
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        //添加种子url，并打开5个线程开始爬虫
        Spider.create(new WeatherRepoPageProcessor2()).addUrl("http://lishi.tianqi.com").thread(5).run();
    }
}