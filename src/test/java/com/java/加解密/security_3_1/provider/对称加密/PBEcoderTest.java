package com.java.加解密.security_3_1.provider.对称加密;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * @author lyh on 2019/5/13
 */
public class PBEcoderTest {
    @Test
    public void pbeSample()throws Exception{
        String inputStr = "PBE";
        System.out.println("原文：\t"+inputStr);
        byte[] inputStrBytes = inputStr.getBytes();
        String pwd = "liyanhao@qq.com";
        System.out.println("密码: \t"+pwd);
        byte[] salt = PBECoder.initSalt();
        byte[] decrypt = PBECoder.encrypt(inputStrBytes, pwd, salt);
        System.out.println("密文: \t"+ Base64.encodeBase64String(decrypt));
        byte[] out = PBECoder.decrypt(decrypt, pwd, salt);
        System.out.println("明文: \t"+new String(out));

    }
}
