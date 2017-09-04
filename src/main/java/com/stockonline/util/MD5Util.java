package com.stockonline.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by lyh on 17-9-4.
 */
public class MD5Util {
    public static String getMD5(String str){
        MessageDigest md5= null;
        String newstr=null;
        BASE64Encoder base64en = new BASE64Encoder();
        try{
            md5=MessageDigest.getInstance("MD5");
            newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return newstr;
    }
}
