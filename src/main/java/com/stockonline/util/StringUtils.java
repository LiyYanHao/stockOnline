package com.stockonline.util;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @author lyh on 2019/5/15
 */
public class StringUtils {
    /**
     * 判断str是否一个int数字
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    @Test
    public void test()throws Exception{
        System.out.println(isInteger("1.1"));
    }

}
