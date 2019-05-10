package com.java.加解密.security_3_1.provider.对称加密;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.security.Key;
import java.security.Security;

/**
 * 测试DEScoder加密算法
 *
 * @author lyh on 2019/5/10
 */
public class TestDEScoder {

    /**
     * @throws Exception
     */
    @Test
    public void testDEScoder() throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        String inputStr = "password";
        System.out.println("原文：\t"+inputStr);
        byte[] inputData = inputStr.getBytes();
        byte[] key = DESCoder.initKey();
        System.out.println("秘钥: \t" + Base64.encodeBase64String(key));
        byte[] encrypt = DESCoder.encrypt(inputData, key);
        System.out.println("加密：\t"+Base64.encodeBase64String(encrypt));
        byte[] decrypt = DESCoder.decrypt(encrypt, key);
        System.out.println("解密：\t"+new String(decrypt));
    }


}
