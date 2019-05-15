package com.java.加解密.security_3_1.provider.非对称加密;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import java.security.Security;
import java.util.Map;

/**
 * @author lyh on 2019/5/15
 */
public class RSACodeTest {

    private static byte[] publicKey;
    private static byte[] privateKey;

    /**
     * 初始化密钥
     * @throws Exception
     */
    @Before
    public void initKey()throws Exception{
        Map<String, Object> keyMap = RSACode.initKey();
        publicKey = RSACode.getPubliceKey(keyMap);
        privateKey = RSACode.getPrivateKey(keyMap);
    }


    @Test
    public void testRSA()throws Exception{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        System.out.println("\n ----私钥加密--公钥解密--");
        String input = "你好RSA非对称加密!";
        System.out.println("原文: \t"+input);
        byte[] bytes = RSACode.encryptByPublicKey(input.getBytes(), publicKey);
        System.out.println("密文: \t"+ Base64.encodeBase64String(bytes));
        byte[] outPut = RSACode.decryptByPrivate(bytes, privateKey);
        System.out.println("明文: \t"+new String(outPut));

    }



















}
