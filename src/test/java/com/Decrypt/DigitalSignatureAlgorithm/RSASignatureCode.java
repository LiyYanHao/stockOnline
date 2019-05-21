package com.Decrypt.DigitalSignatureAlgorithm;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA数字签名组件
 * @author lyh on 2019/5/15
 */
public abstract class RSASignatureCode {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM="MD5withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    public static final int KEY_ZISE = 512;//512~65536 64倍数

    /**
     * 签名
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static byte[] sign(byte[] data,byte[] privateKey)
            throws Exception{
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey aPrivate = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //实例化Signature对象
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(aPrivate);
        signature.update(data);
        return signature.sign();
    }

    /**
     * 校验签名
     * @param data
     * @param publicKey
     * @param sign
     * @return
     * @throws Exception
     */
    public static boolean verify(
            byte[] data,byte[] publicKey,byte[] sign)
            throws Exception{
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey aPublic = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(aPublic);
        signature.update(data);
        return signature.verify(sign);
    }

    /**
     * 获取私钥
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static byte[] getPrivateKey(Map<String,Object> keyMap)throws Exception{
        Key key = (Key)keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }
    /**
     * 获取公钥
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static byte[] getPublicKey(Map<String,Object> keyMap)throws Exception{
        Key key = (Key)keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }

    /**
     * 初始化密钥
     * @return
     * @throws Exception
     */
    public static Map<String,Object> initKey()throws Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(KEY_ZISE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey aPrivate = keyPair.getPrivate();
        PublicKey aPublic = keyPair.getPublic();
        HashMap<String, Object> keyMap = new HashMap<>();
        keyMap.put(PUBLIC_KEY,aPublic);
        keyMap.put(PRIVATE_KEY,aPrivate);
        return keyMap;
    }






















































}
