package com.java.加解密.security_3_1.provider.对称加密;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;

/**
 * 国际加密标准 IDEA
 * @author lyh on 2019/5/10
 */
public abstract class IDEAcoder {

    public static final String KEY_GLORITHM = "IDEA";

    public static final String CIPHER_ALORITHM = "IDEA/ECB/ISO10126Padding";

    public static Key toKey(byte[] k)throws Exception{
        SecretKeySpec secretKeySpec = new SecretKeySpec(k, KEY_GLORITHM);
        return secretKeySpec;
    }

    /**
     * 解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,byte[] key)throws Exception{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALORITHM);
        cipher.init(Cipher.DECRYPT_MODE,k);
        return cipher.doFinal(data);
    }

    /**
     * 加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data,byte[] key)throws Exception{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(KEY_GLORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,k);
        return cipher.doFinal(data);
    }

    /**
     * 初始化密钥
     * @return
     * @throws Exception
     */
    public static byte[] initKey()throws Exception{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_GLORITHM);
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }







}
