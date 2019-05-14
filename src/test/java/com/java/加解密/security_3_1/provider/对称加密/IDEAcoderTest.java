package com.java.加解密.security_3_1.provider.对称加密;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;


/**
 * @author lyh on 2019/5/10
 */
public class IDEAcoderTest {
    @Test
    public void ideaSimple()throws Exception{
        String inputStr = "password";
        System.out.println("原文：\t"+inputStr);
        byte[] key = IDEAcoder.initKey();
        System.out.println("密钥:\t"+ Base64.encodeBase64String(key));
        byte[] encrypt = IDEAcoder.encrypt(inputStr.getBytes(), key);
        System.out.println("密文：\t"+Base64.encodeBase64String(encrypt));
        byte[] decrypt = IDEAcoder.decrypt(encrypt, key);
        System.out.println("解密：\t"+new String(decrypt));
    }





}
