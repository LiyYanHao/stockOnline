package com.java.加解密.security_3_1.provider.对称加密;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * PBE算法
 * @author lyh on 2019/5/10
 */
public abstract class PBECoder {

    public final static String ALGORITHM="PBEWITHMD5andDES";

    /**
     * 迭代次数
     */
    public final static int ITERATION_COUNT=100;

    /**
     * 加盐
     * 盐长度为8位
     * @return
     * @throws Exception
     */
    public static byte[] initSalt()throws Exception{
        //实例化安全随机数
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.generateSeed(8);
    }

    /**
     * 秘钥转换
     * @param password
     * @return
     * @throws Exception
     */
    private static Key toKey(String password)throws Exception{
        //秘钥材料转换
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
        //实例化
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        //生成密钥
        SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
        return secretKey;
    }

    /**
     * 加密
     * @param data
     * @param password
     * @param salt
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data,String password,byte[] salt)throws Exception{
        Key key = toKey(password);
        PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,key,pbeParameterSpec);
        return cipher.doFinal(data);
    }

    /**
     * 解密
     * @param data
     * @param password
     * @param salt
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,String password,byte[] salt)throws Exception{
        //转换秘钥
        Key key = toKey(password);
        //实例化PBE参数材料
        PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE,key,pbeParameterSpec);
        return cipher.doFinal(data);
    }

    








































    /**
     * java6支持一下任意一种算法
     * PBEWithMD5AndDES
     * 56
     * 56
     * CBC
     * PKCS5Padding
     * java6实现
     *
     *
     * PBEWithMD5AndTripeDES
     * 112、168
     * 168
     * CBC
     * PKCS6Padding
     * java7实现
     *
     *
     * PBEWithSHA1AndDESede
     * 112、168
     * 168
     * CBC
     * PKCS7Padding
     * java8实现
     *
     *
     * PBEWithSHA1AndRC2_40
     * 40至1024
     * 128
     * CBC
     * PKCS8Padding
     * java9实现
     *
     *
     * PBEWithMD5AndDES
     * 64
     * 64
     * CBC
     * PKCS5Padding/PKCS7Padding/ISO10126Padding/ZeroBytePadding
     * BouncyCastle实现
     *
     *
     * PBEWithMD5AndRC2
     * 128
     * 128
     * CBC
     * PKCS5Padding/PKCS7Padding/ISO10127Padding/ZeroBytePadding
     * BouncyCastle实现
     *
     *
     * PBEWithSHA1AndDES
     * 64
     * 64
     * CBC
     * PKCS5Padding/PKCS7Padding/ISO10128Padding/ZeroBytePadding
     * BouncyCastle实现
     *
     *
     * PBEWithSHA1AndRC2
     * 128
     * 128
     * CBC
     * PKCS5Padding/PKCS7Padding/ISO10129Padding/ZeroBytePadding
     * BouncyCastle实现
     *
     *
     * PBEWithSHAAndIDEA-CBC
     * 128
     * 128
     * CBC
     * PKCS5Padding/PKCS7Padding/ISO10130Padding/ZeroBytePadding
     * BouncyCastle实现
     *
     *
     * PBEWithSHAAnd2-KeyTripleDES-CBC
     * 128
     * 128
     * CBC
     * PKCS5Padding/PKCS7Padding/ISO10131Padding/ZeroBytePadding
     * BouncyCastle实现
     *
     *
     * PBEWithSHAAnd3-KeyTripleDES-CBC
     * 192
     * 192
     * CBC
     * PKCS5Padding/PKCS7Padding/ISO10132Padding/ZeroBytePadding
     * BouncyCastle实现
     *
     *
     * PBEWithSHAAnd128BitRC2-CBC
     * 128
     * 128
     * CBC
     * PKCS5Padding/PKCS7Padding/ISO10133Padding/ZeroBytePadding
     * BouncyCastle实现
     *
     *
     * PBEWithSHAAnd40BitRC2-CBC
     * 40
     * 40
     * CBC
     * PKCS5Padding/PKCS7Padding/ISO10134Padding/ZeroBytePadding
     * BouncyCastle实现
     *
     *
     * PBEWithSHAAnd128BitRC4
     * 128
     * 128
     * CBC
     * PKCS5Padding/PKCS7Padding/ISO10135Padding/ZeroBytePadding
     * BouncyCastle实现
     *
     *
     * PBEWithSHAAnd40BitRC4  40
     * 40
     * CBC
     * PKCS5Padding/PKCS7Padding/ISO10136Padding/ZeroBytePadding
     * BouncyCastle实现
     *
     *
     * PBEWithSHAAndTwofish-CBC
     *
     * 作者：K1024
     * 链接：https://www.jianshu.com/p/7cf083d93c3f
     * 来源：简书
     * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
     *
     */
}
