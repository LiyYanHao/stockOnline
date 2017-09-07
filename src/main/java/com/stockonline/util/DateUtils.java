package com.stockonline.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by lyh on 17-5-25.
 */
public class DateUtils {

    /**
     *  date格式的时间转UTC格式的时间字符串
     * @param date
     */
    public static String DateConvertUTCString(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        String s = "";
        try{
            Long var = df.parse(df.format("2014-08-23 09:20:05").toString()).getTime();
            s = var.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return s;
        }
    }

    /**
     * 获取当前时间
     * yyyyMMddHHmiss
     * @return
     */
    public static String getNowDateTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(new Date());
    }

}
