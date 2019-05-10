package com.java.加解密.security_3_1.provider.commonCodec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.MD5;

/**
 * @author lyh on 2019/5/9
 * 在实际的应用中，我们经常需要对字符串进行编解码，Apache Commons
 * 家族中的Commons Codec就提供了一些公共的编解码实现，
 * 比如Base64, Hex, MD5,Phonetic and URLs等等。
 */
public class TestCommonCodec {
    @Test
    public void getBase64() throws Exception {
        Base64 base64 = new Base64();
        String str = "你好";
        str = base64.encodeToString(str.getBytes("UTF-8"));
        System.out.println("Base64 编码后：" + str);
        str = new String(Base64.decodeBase64(str));
        System.out.println("Base64 解码后："+str);
    }

    /**
     * Hex 16进制
     */
    @Test
    public void encodeHexTest()throws Exception{
        String str ="你好！";
        str = Hex.encodeHexString(str.getBytes("UTF-8"));
        System.out.println("Hex 编码后：" + str);
        byte[] bytes = Hex.decodeHex(str.toCharArray());
        str = new String(bytes);
        System.out.println("Hex 解码后：" + str);
        System.out.println("MD5 编码后："+
                new String(DigestUtils.md5Hex(str.getBytes("UTF-8"))));
        System.out.println("SHA 编码后："+
                new String(DigestUtils.shaHex(str.getBytes("UTF-8"))));
    }







}
