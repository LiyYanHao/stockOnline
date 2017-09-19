package com.stockonline.util.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by lyh on 17-9-15.
 */
public class StockPageProcessor implements PageProcessor {
    //部分一：抓取网站相关的配置、包括编码、抓取间隔、重试次数
    private Site site = Site.me().setRetrySleepTime(3).setSleepTime(100);

    /**
     * process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
     * @param page
     */
    @Override
    public void process(Page page) {
        //部分二：定义抽取页面信息，并保存下来
        page.putField("author",page.getUrl().regex("https://github\\\\.com/(\\\\w+)/.*").toString());
        page.putField("name",page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name") == null){
            page.setSkip(true);
        }
        page.putField("readme",page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        //部分三：从页面发现后续的url地址来抓取
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());

    }

    @Override
    public Site getSite() {
        return site;
    }
    //XPath、正则表达式和CSS选择器
    public static void main(String[] args){
        Spider.create(new GithubRepoPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://github.com/code4craft")
                //开启五个线程
                .thread(5)
                //启动爬虫
                .run();
    }
}
