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

/**
 * 抓取天气的页面解析
 * Created by lyh on 17-9-18.
 */
public class WeatherRepoPageProcessor implements PageProcessor{

    //部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private String [] tit ={"最高天气：\t","最低气温:\t","天气:\t","风向:\t","\"风力:\\t"};
    public void process(Page page){
        // 部分二：定义如何抽取页面信息，并保存下来
        String url = page.getUrl().toString();
        if(!url.endsWith("index.html")&&url.endsWith("html")){
            Html html = page.getHtml();
            //获取城市
            String city = html.xpath("//*[@id=\"tool_site\"]/div[1]/h3").toString();
            city = city.substring(city.indexOf(">") + 1, city.indexOf("20"));

            String content = html.toString();
            Document docList = Jsoup.parse(content);
            //定位class
            Elements es = docList.getElementsByClass("tqtongji2");
            //定位到URl
            Elements ultag = es.get(0).getElementsByTag("ul");
            for (int j = 1; j < ultag.size(); j++){
                Element obj = ultag.get(j);
                Elements liTag = obj.getElementsByTag("li");
                Element li1 = liTag.get(0);
                //获取某日天气详情链接
                String ss = li1.getElementsByTag("a").get(0).html();
                System.out.println(city+"\t"+ss);
                //获取每个li标签数据
                for(int i = 1;i<liTag.size();i++){
                    System.out.println(tit[i-1]+liTag.get(i).html());
                }
            }
        }
        // 部分三：从页面发现后续的url地址来抓取
        //爬取杭州历年的天气数据
        page.addTargetRequests(page.getHtml().links().regex("http://lishi\\.tianqi\\.com/[a-z]+/[\\d]+\\.html").all());
        page.addTargetRequests(page.getHtml().links().regex("http://lishi\\.tianqi\\.com/hangzhou/index\\.html").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args){
        //添加种子url，并打开5个线程开始爬虫
        Spider.create(new WeatherRepoPageProcessor2()).addUrl("http://lishi.tianqi.com").thread(5).run();
    }

}
