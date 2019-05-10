package com.java.加解密.security_3_1.provider;


import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.PdfImage;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyh on 2019/5/6
 */
public class TestProvider {
    @Test
    public void printAllProvider() {
        //遍历打印提供者的信息
        for (Provider p : Security.getProviders()) {
            System.out.println(p);
            String name = p.getName();
            System.out.println(name);
            for (Map.Entry m : p.entrySet()) {
                System.out.println("t/" + m.getKey() + "t/" + m.getValue());
            }
        }
    }

    @Test
    public void SHADigest() throws Exception {
        byte[] input = "sha".getBytes();
        MessageDigest sha = MessageDigest.getInstance("SHA");
        sha.update(input);
        byte[] digest = sha.digest();
    }

    @Test
    public void DESInit() throws Exception {
        AlgorithmParameterGenerator des = AlgorithmParameterGenerator.getInstance("DES");
        des.init(56);
        AlgorithmParameters algorithmParameters = des.generateParameters();
        byte[] encoded = algorithmParameters.getEncoded();
        System.out.println(new BigInteger(encoded).toString());
    }

    //实例化KeypairGenerator 对象
    @Test
    public void initKeypairGenerator() throws Exception {
        KeyPairGenerator dsa = KeyPairGenerator.getInstance("DSA");
        dsa.initialize(1024);
        KeyPair keyPair = dsa.generateKeyPair();
        System.out.println(keyPair.toString());
    }

    //构建密钥对
    @Test
    public void initKeyPairGeneratorRsa() throws Exception {
        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
        rsa.initialize(1014);
        KeyPair keyPair = rsa.generateKeyPair();
        byte[] encoded = keyPair.getPrivate().getEncoded();
        //由私钥数组获生成得密钥规范
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(encoded);
        //实例化密钥工厂，并指定RSA算法
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        //生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
    }

    //构建安全随机数对象及秘密密钥对象
    @Test
    public void getSecureRandom() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println(secretKey);
    }

    //数字签名的校验和生成
    @Test
    public void signationSpi() throws Exception {
        byte[] datas = "Data Signature".getBytes();
        KeyPairGenerator dsa = KeyPairGenerator.getInstance("DSA");
        dsa.initialize(1024);
        KeyPair keyPair = dsa.generateKeyPair();
        Signature signature = Signature.getInstance(dsa.getAlgorithm());
        signature.initSign(keyPair.getPrivate());
        signature.update(datas);
        //获得签名，即字节数组 sign
        byte[] sign = signature.sign();
        //私钥完成签名，公钥用于校验
        signature.initVerify(keyPair.getPublic());
        //更新
        signature.update(datas);
        //获得验证结果
        boolean verify = signature.verify(sign);
        System.out.println(verify);
    }

    //SignedObject方式获得签名
    // 数字签名的校验和生成
    @Test
    public void signationSignedObject() throws Exception {
        //待签名的原始信息
        byte[] datas = "Data Signature".getBytes();
        //实例化KeyPairGenerator对象，指定DSA算法
        KeyPairGenerator dsa = KeyPairGenerator.getInstance("DSA");
        dsa.initialize(1024);
        //初始化KeyPair对象
        KeyPair keyPair = dsa.generateKeyPair();
        //实例化Signature
        Signature signature = Signature.getInstance(dsa.getAlgorithm());
        //实例化signedObject 对象
        SignedObject signedObject = new SignedObject(datas, keyPair.getPrivate(), signature);
        byte[] signature1 = signedObject.getSignature();//获得签名
        //校验签名
        boolean verify = signedObject.verify(keyPair.getPublic(), signature);
        System.out.println(verify);
    }

    //获得数字时间戳
    @Test
    public void getTimeStamp() throws Exception {
        //构建CertifiCateFactory对象,并指定证书类型为X.509
        CertificateFactory cf = CertificateFactory.getInstance("X509");
        //生产cerPath对象
        CertPath certPath = cf.generateCertPath(new FileInputStream("C:\\Users\\lyh\\test_pub_cer.cer"));
        //实例化数字时间戳
        Timestamp timestamp = new Timestamp(new Date(), certPath);
    }

    //生成和验证代码签名
    @Test
    public void getCodeSigner() throws Exception {
        //构建CertificateFactory对象，并指定证书类型为X.509
        CertificateFactory cf = CertificateFactory.getInstance("X509");
        //生成CerPath对象
        CertPath certPath = cf.generateCertPath(new FileInputStream("C:\\Users\\lyh\\test_pub_cer.cer"));
        //实例化timestamp
        Timestamp timestamp = new Timestamp(new Date(), certPath);
        //实例化CodeSign
        CodeSigner cs = new CodeSigner(certPath, timestamp);
        //获得比较结果
        boolean status = cs.equals(new CodeSigner(certPath, timestamp));
        System.out.println(status);

    }

    /**
     * 加载密钥库
     */
    @Test
    public void getKeyStore() throws Exception {
        //加载密钥文件C:\Users\lyh\test.keystore
        FileInputStream is = new FileInputStream("C:\\Users\\lyh\\test.keystore");
        //实例化KeyStore对象
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        //加载密钥库，使用密码“passwod”
        ks.load(is, "password".toCharArray());
        is.close();
        //得到密钥对象后，可以获得其对应的私钥
        PrivateKey key = (PrivateKey) ks.getKey("alias", "password".toCharArray());
    }


    /**
     * HmacMD5 消息摘要处理
     */
    @Test
    public void getHMacMD5() throws Exception {
        byte[] input = "MAC".getBytes();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey secretKey = keyGenerator.generateKey();
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        //获得经过消息摘要后的信息
        byte[] bytes = mac.doFinal(input);
    }

    /**
     *
     */
    @Test
    public void getKeyGenerator() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMd5");
        SecretKey secretKey = keyGenerator.generateKey();
    }


    /**
     * 生成DH秘钥对
     *
     * @throws Exception
     */
    @Test
    public void getDH() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
        KeyPair kp1 = kpg.genKeyPair();
        KeyPair kp2 = kpg.genKeyPair();
        KeyAgreement keyAgreement = KeyAgreement.getInstance(kpg.getAlgorithm());
        keyAgreement.init(kp2.getPrivate());
        //执行计划
        keyAgreement.doPhase(kp1.getPublic(), true);
        //生成SecretKey对象
        SecretKey secretKey = keyAgreement.generateSecret("DES");
    }

    /**
     * 密钥字节数组到密钥对象
     *
     * @throws Exception
     */
    @Test
    public void getDESKeySpec() throws Exception {
        KeyGenerator des = KeyGenerator.getInstance("DES");
        SecretKey secretKey = des.generateKey();
        byte[] encoded = secretKey.getEncoded();
        //由获得的密钥编码字节数组构建DESKEySpec
        DESKeySpec desKeySpec = new DESKeySpec(encoded);
        //实例化
        SecretKeyFactory des1 = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey1 = des1.generateSecret(desKeySpec);//生成secretKey对象
    }


    /**
     * @throws Exception
     */
    @Test
    public void getCipher() throws Exception {
        KeyGenerator des = KeyGenerator.getInstance("DES");
        SecretKey secretKey = des.generateKey();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.WRAP_MODE, secretKey);
        byte[] k = cipher.wrap(secretKey);
        cipher.init(Cipher.UNWRAP_MODE, secretKey);
        //解密秘密密钥
        cipher.unwrap(k, "DES", Cipher.SECRET_KEY);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        //加密
        byte[] input = cipher.doFinal("DES DATA".getBytes());
        //解密
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] bytes = cipher.doFinal(input);
    }


    /**
     *
     * 获得输入秘钥流
     * @throws Exception
     */
    public void getCipherInputStream()throws Exception{
        //实例化Keygener
    }


}





