package com.Decrypt.AsymmetricEncryption;

import javax.crypto.Cipher;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * ElGamal算法实现
 * @author lyh on 2019/5/15
 */
public class ElGamalCoder {

    public static final String KEY_ALGORITHM = "ElGamal";
    private static final int KEY_SIZE = 256;//160~16384 8整数倍
    private static final String KEY_PUBLICE = "ElGamalPublicKey";
    private static final String KEY_Private = "ElGamalPrivateKey";

    /**
     * 用私钥解密
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,byte[] key)throws Exception{
        //加入bouncy Castle支持
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        //私钥材料转换
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
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
    public static byte[] encrypt(byte[] data,byte[] key)throws Exception{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 初始化密钥
     * @return
     * @throws Exception
     */
    public static Map<String,Object> initKey()throws Exception{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        AlgorithmParameterGenerator algorithmParameterGenerator =
                AlgorithmParameterGenerator.getInstance(KEY_ALGORITHM);
        algorithmParameterGenerator.init(KEY_SIZE);
        AlgorithmParameters algorithmParameters =
                algorithmParameterGenerator.generateParameters();
        DHParameterSpec parameterSpec =
                algorithmParameters.getParameterSpec(DHParameterSpec.class);
        //实例化密钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(parameterSpec,new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey aPublic = keyPair.getPublic();
        PrivateKey aPrivate = keyPair.getPrivate();
        HashMap<String, Object> keyMap = new HashMap<>();
        keyMap.put(KEY_PUBLICE,aPublic);
        keyMap.put(KEY_Private,aPrivate);
        return keyMap;
    }

    /**
     * 取得公钥
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static byte[] getPublicKey(Map<String,Object> keyMap)throws Exception{
        PublicKey publicKey = (PublicKey)keyMap.get(KEY_PUBLICE);
        return publicKey.getEncoded();
    }

    /**
     * 取得私钥
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static byte[] getPrivateKey(Map<String,Object> keyMap)throws Exception{
        PrivateKey privateKey = (PrivateKey)keyMap.get(KEY_Private);
        return privateKey.getEncoded();
    }

































































}
