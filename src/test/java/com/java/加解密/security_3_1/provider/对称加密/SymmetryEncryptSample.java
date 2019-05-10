package com.java.加解密.security_3_1.provider.对称加密;

import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;

import java.security.Security;

/**
 * @author lyh on 2019/5/9
 */
public class SymmetryEncryptSample {



    /**
     * DES使用例子
     * @throws Exception
     */
    @Test
    public void useDES()throws Exception{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        String input = "password";
        byte[] inputData = input.getBytes();
        System.out.println("原文\t"+input);
        //初始化秘钥
        byte[] key = DESCoder.initKey();
        System.out.println("秘钥\t"+ Base64.toBase64String(key));
        //加密
        inputData = DESCoder.encrypt(inputData, key);
        System.out.println("加密后\t"+ Base64.toBase64String(inputData));
        //解密
        byte[] outputData = DESCoder.decrypt(inputData, key);
        String s = new String(outputData);
        System.out.println("解密后\t"+s);
    }

}
