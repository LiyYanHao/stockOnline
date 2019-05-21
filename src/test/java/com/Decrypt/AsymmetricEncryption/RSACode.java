package com.Decrypt.AsymmetricEncryption;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA非对称加密算法实现
 * @author lyh on 2019/5/15
 */
public class RSACode {

    public static final String KEY_ALGORITHM = "RSA";
    private static final String PUBLIC_KEY="RSAPublicKey";
    private static final String PRIVATE_KEY="RSAPrivateKey";
    private static final int KEY_SIZE = 512;//512~65536

    /**
     * 私钥解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivate(byte[] data,byte[] key)
            throws Exception{
        //取得私钥
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 公钥加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data,byte[] key)
        throws Exception{
        //取得公钥
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        //对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return cipher.doFinal(data);
    }


    /**
     *获得私钥
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static byte[] getPrivateKey(Map<String,Object> keyMap)throws Exception{
        Key key = (Key)keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }


    /**
     *获得公钥
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static byte[] getPubliceKey(Map<String,Object> keyMap)throws Exception{
        Key key = (Key)keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }

    /**
     * 初始化密钥
     * @return
     * @throws Exception
     */
    public static Map<String, Object> initKey()throws Exception{
        //实例化密钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPrivateKey aPrivate = (RSAPrivateKey)keyPair.getPrivate();
        RSAPublicKey aPublic = (RSAPublicKey)keyPair.getPublic();
        HashMap<String, Object> keyMap = new HashMap<>();
        keyMap.put(PUBLIC_KEY,aPublic);
        keyMap.put(PRIVATE_KEY,aPrivate);
        return keyMap;
    }

















}
