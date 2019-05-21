package com.Decrypt.DigitalSignatureAlgorithm;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * RSA数字签名组件测试
 * @author lyh on 2019/5/15
 */
public class RSASignatureCodeTest {

    private static byte[] publicKey;
    private static byte[] privateKey;

    @Before
    public void initKey()throws Exception{
        Map<String, Object> keyMap = RSASignatureCode.initKey();
        publicKey = RSASignatureCode.getPublicKey(keyMap);
        privateKey = RSASignatureCode.getPrivateKey(keyMap);
        System.out.println("公钥: \t"+ Base64.encodeBase64String(publicKey));
        System.out.println("私钥: \t"+ Base64.encodeBase64String(privateKey));
    }

    @Test
    public void goRSASign()throws Exception{
        String inputStr = "RSA数字签名算法！";
        System.out.println("原文：\t"+inputStr);
        String inputStr2 = "RSA数字签名算法！,";
        byte[] bytes = inputStr2.getBytes();
        byte[] inputStrBytes = inputStr.getBytes();
        byte[] sign = RSASignatureCode.sign(inputStrBytes, privateKey);
        System.out.println("签名: \t"+Base64.encodeBase64String(sign));
        boolean verify = RSASignatureCode.verify(inputStrBytes, publicKey, sign);
        System.out.println("状态: \t"+verify);
        verify = RSASignatureCode.verify(bytes, publicKey, sign);
        System.out.println("状态: \t"+verify);
    }











}
