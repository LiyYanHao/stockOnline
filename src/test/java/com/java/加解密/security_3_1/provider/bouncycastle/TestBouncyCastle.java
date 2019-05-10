package com.java.加解密.security_3_1.provider.bouncycastle;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.Security;
import java.util.Base64;

/**
 * @author lyh on 2019/5/9
 */
public class TestBouncyCastle {

    /**
     * bouncyCastle简单例子
     * @throws Exception
     */
    @Test
    public void bouncyCastleSimple()throws Exception{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8"), "AES"));
        cipher.doFinal("QWEASDZS".getBytes("UTF-8"));
    }

    /**
     * MD4加密例子
     * @throws Exception
     */
    @Test
    public void bouncyCastleMD4()throws Exception{
        byte[] data = "password".getBytes("GBK");
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        MessageDigest md4 = MessageDigest.getInstance("MD4");
        md4.update(data);
        byte[] digest = md4.digest();
        String string = new String(digest,"GBK");
        System.out.println(digest.length);
        System.out.println(string);
    }

}
