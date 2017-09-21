package com.stockonline.util.webmagic.StockAnaysis;

import com.stockonline.util.webmagic.WeatherRepoPageProcessor2;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by lyh on 17-9-21.
 */
public class BasicInfoPageProcessor implements PageProcessor{

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return null;
    }

    public static void main(String[] args){
        Spider.create(new WeatherRepoPageProcessor2()).addUrl("http://stock.eastmoney.com/").thread(5).run();
    }


}
