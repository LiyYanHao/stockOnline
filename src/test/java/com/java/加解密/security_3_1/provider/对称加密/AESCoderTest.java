package com.java.加解密.security_3_1.provider.对称加密;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.security.Security;

/**
 * @author lyh on 2019/5/10
 */
public class AESCoderTest {

    @Test
    public void testAESCoderTest()throws Exception{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        String inputStr ="password";
        System.out.println("原文：\t"+inputStr);
        byte[] key = AESCoder.initKey();
        System.out.println("秘钥: \t"+Base64.encodeBase64String(key));
        byte[] inputBytes = inputStr.getBytes();
        byte[] encrypt = AESCoder.encrypt(inputBytes, key);
        System.out.println("密文：\t"+ Base64.encodeBase64String(encrypt));
        byte[] output = AESCoder.decrypt(encrypt, key);
        System.out.println("解密:\t"+new String(output));
    }

}
