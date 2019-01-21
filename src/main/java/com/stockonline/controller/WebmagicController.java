package com.stockonline.controller;

import com.push.Publisher;
import com.stockonline.util.QueryStockByCode;
import com.task.SubThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;


/**
 * Created by liyanhao on 02/05/2017.
 */
@RestController
public class WebmagicController {

    @Autowired
    private QueryStockByCode queryStockByCode;

    @Autowired
    JedisCluster JedisCluster;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/stock/webmagic/queryInfo", method = RequestMethod.GET)
    public String getRealtimeKBystockCode() {


        SubThread subThread = new SubThread(JedisCluster);
        subThread.start();
        Publisher publisher = new Publisher(JedisCluster);
        publisher.start();

//
//        Publisher publisher = new Publisher();
//        publisher.start();

        return "订阅成功";
    }


}
