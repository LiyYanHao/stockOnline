package com.java.加解密.security_3_1.provider.非对称加密;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * DH算法
 * @author lyh on 2019/5/13
 */
public class DHcode {

    public static final String KEY_ALGORITHM = "DH";

    /**
     * 本地秘钥算法，即对称加密算法
     * 可选 DES、DESede、AES
     */
    public static final String SECRET_ALGORITHM = "AES";

    /**
     * 512~1024
     * 必须是64整数倍
     */
    private static final int KEY_SIZE = 512;


    private static final String PUBLIC_KEY="DHPublicKEY";
    private static final String PRIVATE_KEY="DHPrivateKEY";

    /**
     * 初始化甲方秘钥
     * @return
     * @throws Exception
     */
    public static Map<String,Object> initKey()throws Exception{
        //实例化密钥生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        DHPrivateKey privateKey = (DHPrivateKey)keyPair.getPrivate();
        DHPublicKey publicKey = (DHPublicKey)keyPair.getPublic();
        HashMap<String, Object> keyMap = new HashMap<>();
        keyMap.put(PUBLIC_KEY,publicKey);
        keyMap.put(PRIVATE_KEY,privateKey);
        return keyMap;
    }

    /**
     * 初始化乙方秘钥
     * @param key
     * @return
     * @throws Exception
     */
    public static Map<String,Object> initKey(byte[] key)throws Exception{
        //解析甲方秘钥
        //转换秘钥所需材料
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        //实例化秘钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        PublicKey publicKey1 = keyFactory.generatePublic(x509EncodedKeySpec);
        //由甲方公钥构建乙方秘钥
        DHParameterSpec dhParameterSpec = ((DHPublicKey) publicKey1).getParams();
        //实例化秘钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(keyFactory.getAlgorithm());
        //初始化秘钥对生成器
        keyPairGenerator.initialize(dhParameterSpec);
        //产生秘钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //产生公钥
        DHPublicKey publicKey = (DHPublicKey)keyPair.getPublic();
        //产生私钥
        DHPrivateKey privateKey = (DHPrivateKey)keyPair.getPrivate();
        HashMap<String, Object> keyMap = new HashMap<>();
        keyMap.put(PUBLIC_KEY,publicKey);
        keyMap.put(PRIVATE_KEY,privateKey);
        return keyMap;
    }

    /**
     * 加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data,byte[] key)throws Exception{
        //生产本地秘钥
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, SECRET_ALGORITHM);
        //数据加密
        Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
        return cipher.doFinal(data);
    }

    /**
     * 解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,byte[] key)throws Exception{
        //生成本地秘钥
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, SECRET_ALGORITHM);
        //数据解密
        Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
        return cipher.doFinal(data);
    }

    /**
     * 构建秘钥
     * @param publicKey
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static byte[] getSecretKey(byte[] publicKey,byte[] privateKey)throws Exception{
        //实例化秘钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //初始化公钥
        //秘钥转换材料
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey);
        PublicKey publicKey1 = keyFactory.generatePublic(x509EncodedKeySpec);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey);
        PrivateKey privateKey1 = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        KeyAgreement keyAgreement = KeyAgreement.getInstance(keyFactory.getAlgorithm());
        keyAgreement.init(privateKey1);
        keyAgreement.doPhase(publicKey1,true);
        //生成本地秘钥
        //Unsupported secret key algorithm: AES
        //配置JVM的系统变量 -Djdk.crypto.KeyAgreement.legacyKDF=true
        //jdk8 修改语言版本到7
        SecretKey secretKey = keyAgreement.generateSecret(SECRET_ALGORITHM);
        return secretKey.getEncoded();
    }

    /**
     * 获得私钥
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static byte[] getPrivateKey(Map<String,Object> keyMap)throws Exception{
        Key key = (Key)keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }

    /**
     * 获得公钥
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static byte[] getPublicKey(Map<String,Object> keyMap)throws Exception{
        Key key = (Key)keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }






























































































































}
