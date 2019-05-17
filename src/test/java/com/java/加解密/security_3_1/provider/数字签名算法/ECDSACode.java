package com.java.加解密.security_3_1.provider.数字签名算法;

import java.security.Security;
import java.util.Map;

/**
 * ECDSA 椭圆曲线签名算法
 *
 * @author lyh on 2019/5/16
 */
public class ECDSACode {

    private static final String KEY_ALGORITHM = "ECDSA";
    private static final String SIGNATURE_ALGORITHM = "SHA512withECDSA";//7种
    private static final String PUBLIC_KEY = "ECDSApublicKey";
    private static final String private_KEY = "ECDSAprivateKey";

    public static Map<String, Object> initKey() throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        return null;
    }

}
