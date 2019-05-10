package com.java.加解密.security_3_1.provider.对称加密;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;

/**
 * @author lyh on 2019/5/9
 */
public abstract class DESCoder {
    public static final String KEY_ALGORITHM="DES";
    /**
     * 加密/解密算法/工作模式/填充方式
     */
    public static final String CIPHER_ALGORITHM="DES/ECB/PKCS5Padding";

    /**
     * 转换秘钥
     * @param key
     * @return
     * @throws Exception
     */
    public static Key toKey(byte[] key)throws Exception{
        //实例化DES秘钥材料
        DESKeySpec desKeySpec = new DESKeySpec(key);
        //实例化秘钥工厂
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        //生产秘钥
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        return secretKey;
    }

    /**
     * 解密
     * @param dat 加密数据
     * @param key 秘钥
     * @return 解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] dat,byte[] key)throws Exception{
        //还原秘钥
        Key k = toKey(key);
        //实例化
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始胡，设置位解密模式
        cipher.init(Cipher.DECRYPT_MODE,k);
        return cipher.doFinal(dat);
    }

    /**
     * 加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data,byte[] key)throws Exception{
        //还原密钥
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化模式，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE,k);
        return cipher.doFinal(data);
    }

    /**
     * 生成密钥
     * @return
     * @throws Exception
     */
    public static byte[] initKey()throws Exception{
        /**
         * 实例化密钥生成器
         * 若要使用64位密钥注意替换
         * 将下述代码中
         * KeyGenerator.getInstance(CIPHER_ALGORITHM);
         * 替换为
         * KeyGenerator.getInstance(CIPHER_ALGORITHM,"BC");
         * BC为Boucy Calstle
         *
         */
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM,"BC");
        /**
         *
         * 初始化密钥生成器
         * kg.init(56)
         * 替换位
         * kg.init(64)
         * 默认长度
         * kg.init(new SecureRandom())
         */
        kg.init(64);
        //生成密钥
        SecretKey secretKey = kg.generateKey();
        return secretKey.getEncoded();


    }





}










