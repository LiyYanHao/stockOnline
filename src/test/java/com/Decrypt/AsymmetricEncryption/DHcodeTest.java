package com.Decrypt.AsymmetricEncryption;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import java.security.Security;
import java.util.Map;

/**
 * @author lyh on 2019/5/14
 */
public class DHcodeTest {
    //甲方公钥
    private byte[] publicKey1;
    //甲方私钥
    private byte[] privateKey1;
    //甲方本地秘钥
    private byte[] key1;
    //乙方公钥
    private byte[] publicKey2;
    //乙方私钥
    private byte[] privateKey2;
    //乙方本地秘钥
    private byte[] key2;

    @Before
    public final void initKey()throws Exception{
        //生成甲方秘钥对
        Map<String, Object> keyMap = DHcode.initKey();
        privateKey1 = DHcode.getPrivateKey(keyMap);
        publicKey1 = DHcode.getPublicKey(keyMap);
        System.out.println("生成甲方公钥：\t"+ Base64.encodeBase64String(publicKey1));
        System.out.println("生成甲方私钥：\t"+ Base64.encodeBase64String(privateKey1));
        //由甲方公钥生成本地秘钥
        Map<String, Object> keyMap2 = DHcode.initKey(publicKey1);
        publicKey2 = DHcode.getPublicKey(keyMap2);
        privateKey2 = DHcode.getPrivateKey(keyMap2);
        System.out.println("生成乙方公钥：\t"+ Base64.encodeBase64String(publicKey2));
        System.out.println("生成乙方私钥：\t"+ Base64.encodeBase64String(privateKey2));
        key1 = DHcode.getSecretKey(publicKey2, privateKey1);
        System.out.println("甲方的本地秘钥：\t"+Base64.encodeBase64String(key1));
        key2 = DHcode.getSecretKey(publicKey1, privateKey2);
        System.out.println("乙方的本地秘钥：\t"+Base64.encodeBase64String(key2));
    }

    /**
     * 校验
     * @throws Exception
     */
    @Test
    public final void testDH()throws Exception{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        System.out.println("==========甲方向乙方发送加密数据===========");
        String input = "秘钥交换算法";
        System.out.println("原文："+input);
        System.out.println("==使用甲方本地秘钥对数据加密==");
        byte[] encrypt = DHcode.encrypt(input.getBytes(), key1);
        System.out.println("加密：\t"+Base64.encodeBase64String(encrypt));
        System.out.println("==使用乙方本地秘钥对数据解密==");
        byte[] decrypt = DHcode.decrypt(encrypt, key2);
        System.out.println("解密：\t"+new String(decrypt));
    }
















}
