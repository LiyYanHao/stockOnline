package com.java.加解密.security_3_1.provider.数字签名算法;

import com.java.加解密.security_3_1.provider.非对称加密.RSACode;
import com.spire.ms.System.Security.Cryptography.RSA;
import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import sun.security.krb5.internal.crypto.RsaMd5CksumType;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
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
