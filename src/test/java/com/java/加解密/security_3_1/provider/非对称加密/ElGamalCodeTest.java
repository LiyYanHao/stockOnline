package com.java.加解密.security_3_1.provider.非对称加密;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * @author lyh on 2019/5/15
 */
public class ElGamalCodeTest {

    private byte[] publicKey;
    private byte[] privateKey;

    @Before
    public void initKey()throws Exception{
        Map<String, Object> keyMap = ElGamalCoder.initKey();
        privateKey = ElGamalCoder.getPrivateKey(keyMap);
        publicKey = ElGamalCoder.getPublicKey(keyMap);
        System.out.println("公钥：\t"+ Base64.encodeBase64String(publicKey));
        System.out.println("私钥：\t"+ Base64.encodeBase64String(privateKey));
    }

    @Test
    public void testElGamal()throws Exception{
        String inputStr ="ElGamalStr加密";
        System.out.println("原文:\t"+inputStr);
        byte[] inputStrBytes = inputStr.getBytes();
        byte[] encrypt = ElGamalCoder.encrypt(inputStrBytes, publicKey);
        System.out.println("密文: \t"+Base64.encodeBase64String(encrypt));
        byte[] decrypt = ElGamalCoder.decrypt(encrypt, privateKey);
        System.out.println("明文: \t"+new String(decrypt));
    }


















}
