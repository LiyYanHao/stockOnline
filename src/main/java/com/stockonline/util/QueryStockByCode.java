package com.stockonline.util;

import com.stockonline.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyh on 17-6-15.
 */
@Component
public class QueryStockByCode{

    @Value("${spring.mail.host}")
    private static String mailHost;

    @Value("${aly.host}")
    private String host;
    @Value("${aly.path_sz_sh_stock_history}")
    private  String path_sz_sh_stock_history;
    @Value("${aly.path_realtime_k}")
    private  String path_realtime_k;
    @Value("${aly.appcode}")
    private  String appcode;




    /**
     *
     * @param beginDay 开始时间 开始时间，格式为yyyyMMdd，如果不写则默认是当天。结束时间永远是当前时间
     * @param code 股票代码 沪深、港股股票编码
     * @param time 时间 5 = 5分k线(默认) ，30 = 30分k线，60 = 60分k线，day = 日k线，week = 周k线，month = 月  。注意港股不支持5分、30分和60分k线。
     * @param type 类型 复权方式，支持两种方式 。 bfq =不复权(默认方式) qfq =前复权。当time为[day,week,month]时此字段有效。
     * @return
     */
    public String getRealtimeK(String beginDay,String code,String time,String type){
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("beginDay", beginDay);
        querys.put("code", code);
        querys.put("time", time);
        querys.put("type", type);
        String realtimeInfo = "";
        try {
            HttpResponse response = HttpUtils.doGet(host, path_realtime_k, method, headers, querys);
            System.out.println(response.toString());
            realtimeInfo = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return realtimeInfo;
        }
    }

    /**
     * 实时获取股票数据
     * @param stockCode
     * @param startDate yyyy-mm-dd
     * @param endDate yyyy-mm-dd
     */
    public String getStockInfo(String stockCode,String startDate,String endDate){
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("begin", startDate);
        querys.put("code", stockCode);
        querys.put("end", endDate);
        String body = "";
        try {
            HttpResponse response = HttpUtils.doGet(host,path_realtime_k, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            body = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return body;
        }


    }

/*    public static void way_2() throws Exception{
        File dest = new File("src/wangyi2.html");
        InputStream is;//接收字节输入流
        FileOutputStream fos = new FileOutputStream(dest);//字节输出流

        URL wangyi = new URL("http://hq.sinajs.cn/list=sz002739");
        is = wangyi.openStream();

        BufferedInputStream bis = new BufferedInputStream(is);//为字节输入流加缓冲
        BufferedOutputStream bos = new BufferedOutputStream(fos);//为字节输出流加缓冲

        int length;

        byte[] bytes = new byte[1024*20];
        String stmp = "";
        String resultStr = "";
        while((length = bis.read(bytes, 0, bytes.length)) != -1){
            fos.write(bytes, 0, length);
            String s = new String(bytes, "GB2312");
            if(s.contains("\"")){
                int startStr = s.indexOf("\"");
                int endStart = s.lastIndexOf("\"");
                resultStr = s.substring(startStr+1,endStart);
            }
        }
        bos.close();
        fos.close();
        bis.close();
        is.close();
    }*/


}