package com.stockonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.stockonline.domain.City;
import com.stockonline.service.CityService;
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
public class CityRestController {


    @Autowired
    private QueryStockByCode queryStockByCode;

    @RequestMapping(value = "/stock/getRealtimeKBystockCode", method = RequestMethod.GET)
    public String getRealtimeKBystockCode(@RequestParam(value = "stockCode", required = true) String stockCode) {
        //"600004"
        QueryStockByCode queryStockByCode = new QueryStockByCode();
        String body =  queryStockByCode.getRealtimeK("20161101",stockCode,"5","bfq");
        JSONObject BodyJsonObject = JSONObject.parseObject(body);
        Object BodyJsonObject2 = BodyJsonObject.get("showapi_res_body");
        return body;
    }




}
