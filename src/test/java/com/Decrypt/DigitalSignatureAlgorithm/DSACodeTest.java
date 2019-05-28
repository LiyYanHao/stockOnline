package com.Decrypt.DigitalSignatureAlgorithm;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * @author lyh on 2019/5/16
 */
public class DSACodeTest {

    private byte[] privateKey;
    private byte[] publicKey;

    @Before
    public void initKey()throws Exception{
        Map<String, Object> initkey = DSACode.initkey();
        privateKey = DSACode.getPrivate(initkey);
        publicKey = DSACode.getPublic(initkey);
        System.out.println("��Կ: \t"+Base64.encodeBase64String(privateKey));
        System.out.println("��Կ: \t"+Base64.encodeBase64String(publicKey));
    }
    @Test
    public void DSACodeSample()throws Exception{
        String input = "DSA����ǩ��";
        System.out.println("ԭ��:\t"+input);
        byte[] bytes = input.getBytes();
        byte[] sign = DSACode.sign(bytes, privateKey);
        System.out.println("ǩ��:\t"+ Base64.encodeBase64String(sign));
        boolean verify = DSACode.verify(bytes, publicKey,sign);
        System.out.println("��֤: \t"+verify);
    }







}
