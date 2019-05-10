package com.java.加解密.security_3_1.provider.对称加密;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * AES加密方法
 * @author lyh on 2019/5/10
 */
public class AESCoder {

    public static final String KEY_ALGORITHM = "AES";

    public static final String CIPHER_ALGORITHM="AES/ECB/PKCS7Padding";

    public static Key toKey(byte[] key)throws Exception{
        SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
        return secretKey;
    }

    /**
     * 解密
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,byte[] key)throws Exception{
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
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
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
        cipher.init(Cipher.ENCRYPT_MODE,k);
        return cipher.doFinal(data);
    }

    /**
     * 生成秘钥
     * @return
     * @throws Exception
     */
    public static byte[] initKey()throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }



























}
