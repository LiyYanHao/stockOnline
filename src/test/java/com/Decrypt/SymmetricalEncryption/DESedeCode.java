package com.Decrypt.SymmetricalEncryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;

/**
 * DESede安全编码组件
 * @author lyh on 2019/5/10
 */
public abstract class DESedeCode {


    /**
     * 密钥算法
     * java6支持密钥长度112位和168位
     * Bouncy Castle支持密钥长度位128位和192位
     */
    public static final String KEY_ALGORITHM="DESede";

    /**
     * 加密/解密算法/工作模式/填充方式
     * java6支持PKCS5Padding 填充方式
     * Bouncy Castle 支持PKCS7Padding 填充方式
     */
    public static final String CIPHER_ALGORITHM="DESede/ECB/PKCS5Padding";

    /**
     * 转换密钥
     * @param key
     * @return
     * @throws Exception
     */
    public static Key toKey(byte[] key)throws Exception{
        //实例化DES密钥材料
        DESKeySpec desKeySpec = new DESKeySpec(key);
        //实例化密钥工厂
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        //生成密钥
        return secretKeyFactory.generateSecret(desKeySpec);
    }

    /**
     * 解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,byte[] key)throws Exception{
        //还原密钥
        Key k = toKey(key);
        /**
         * 实例化
         * 使用PKCS7Padding填充方式，按如下代码实现
         * Cipher.getInstance(CIPHER_ALGORIHTM,"BC")
         *
         */
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE,k);
        return cipher.doFinal(data);
    }

    /**
     * 加密
     * @param data
     * @param key
     * @return
     */
    public static byte[] encrypt(byte[] data,byte[] key)throws Exception{
        //还原密钥
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,k);
        return cipher.doFinal(data);
    }

    /**
     * 初始化秘钥
     * @return
     * @throws Exception
     */
    public static byte[] initKey()throws Exception{
        /**
         * 使用128位或192位密钥，按如下代码实现
         * KeyGenerator.getInstance(KEY_ALGORITHM,"BC");
         */
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(168);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }


    



























}
