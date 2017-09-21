package com.stockonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.stockonline.util.QueryStockByCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by liyanhao on 02/05/2017.
 */
@RestController
public class WebmagicController {

    @Autowired
    private QueryStockByCode queryStockByCode;


    @RequestMapping(value = "/stock/webmagic/queryInfo", method = RequestMethod.GET)
    public String getRealtimeKBystockCode() {

        return "";
    }





}
