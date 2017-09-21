package com.stockonline.util.webmagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * Created by lyh on 17-9-20.
 */
public class BaiduYunPageProcessor implements PageProcessor{

    private Site site = Site.me().setRetrySleepTime(3).setSleepTime(100);
    public void process(Page page) {
        Html html = page.getHtml();
        String cityUrl = html.xpath("//*[@class=\"module-share-header\"]").toString();
        Document docList = Jsoup.parse(cityUrl);
        Elements es = docList.getElementsByTag("h2");
        String fileName = docList.attr("title");
        System.out.println(fileName);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args){
        Spider.create(new GithubRepoPageProcessor()).addUrl("https://pan.baidu.com/s/1skOu2LJ").thread(5).run();
    }
}



