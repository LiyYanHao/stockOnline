package com.Decrypt.DigitalSignatureAlgorithm;

import java.security.*;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * DSA数字签名
 * @author lyh on 2019/5/16
 */
public class DSACode {

    public static final String ALGORITHM= "DSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1withDSA";
    private static final String PUBLIC_KEY = "DSAPublicKey";
    private static final String PRIVATE_KEY = "DSAPrivateKey";
    private static final int KEY_SIZE = 512;

    /**
     * 签名
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static byte[] sign(byte[] data,byte[] privateKey)throws Exception{
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PrivateKey aPrivate = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(aPrivate);
        signature.update(data);
        return signature.sign();
    }


    /**
     * 校验
     * @param data
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data,byte[] publicKey,byte[] sign)throws Exception{
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PublicKey publicKey1 = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicKey1);
        signature.update(data);
        return signature.verify(sign);
    }

    /**
     * 生成密钥
     * @return
     * @throws Exception
     */
    public static Map<String,Object> initkey()throws Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE,new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        DSAPrivateKey aPrivate = (DSAPrivateKey)keyPair.getPrivate();
        DSAPublicKey aPublic = (DSAPublicKey)keyPair.getPublic();
        HashMap<String, Object> keyMap = new HashMap<>();
        keyMap.put(PUBLIC_KEY,aPublic);
        keyMap.put(PRIVATE_KEY,aPrivate);
        return keyMap;
    }

    /**
     * 取得私钥
     * @return
     * @throws Exception
     */
    public static byte[] getPrivate(Map<String,Object> keyMap)throws Exception{
        DSAPrivateKey privateKey = (DSAPrivateKey)keyMap.get(PRIVATE_KEY);
        return privateKey.getEncoded();
    }

    /**
     * 取得公钥
     * @return
     * @throws Exception
     */
    public static byte[] getPublic(Map<String,Object> keyMap)throws Exception{
        DSAPublicKey publicKey = (DSAPublicKey)keyMap.get(PUBLIC_KEY);
        return publicKey.getEncoded();
    }
}
