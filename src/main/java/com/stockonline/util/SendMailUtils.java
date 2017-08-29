package com.stockonline.util;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

/**
 *
 * @description: 发送邮箱：可以发送文本,可以附加html、图片、附件，支持同时发送多个邮箱
 * 使用：
 * 第一步：在的项目的配置文件(application.properties)中加入邮件配置
 * spring.mail.host=smtp.163.com
 * spring.mail.username=***@163.com
 * spring.mail.password=***
 * spring.mail.port=465
 * spring.mail.default-encoding=UTF-8
 * spring.mail.protocol=smtp
 * spring.mail.properties.mail.debug=true
 * spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
 * spring.mail.properties.mail.smtp.auth=true
 * spring.mail.properties.mail.smtp.timeout=25000
 * 第二步：
 * 在你调用此工具的类中，加入如下：此处利用springboot的feature
 * @Resource
 * private JavaMailSenderImpl mailSender;
 *
 * @company：yy
 * @author: skyler
 * @time: 2016年8月27日 下午6:05:13
 */
public class SendMailUtils {

    public static final String DEFALUT_ENCODING = "UTF-8";


    public static void registerEmail(String userEmail){
        JavaMailSenderImpl sender = initJavaMailSender();
        String[] ss = {userEmail};
        String activeCode = StringRandom.getStringRandom(6);
        String activeCodeEncrypt = EncryptUtilDES.encrypt(activeCode);
        sendTextWithHtml(sender,ss,"股票在线用户激活","" +
                "<span>你的激活码是：</span><br>\n" +
                "    <h2></h2><br>\n" +
                "    <span>你也可以点击连接完成激活:</span> <br>\n" +
                "    <a href=\"http://localhost:8080/user/emailActive?activeCode=123\">点击激活用户</a>");
    }

    public static void main(String[] args) throws Exception {
        JavaMailSenderImpl sender = initJavaMailSender();
        String[] ss = { "1713777256@qq.com","1779077919@qq.com"};

        sendTextWithHtml(sender, ss, "测试简单文本邮件发送！ ", "测试我的简单邮件发送机制！！");

        //sendTextWithImg(sender, ss, "测试邮件中嵌套图片!！", "<html><head></head><body><h1>hello 欢迎你!!spring image html mail</h1><img src='cid:image'/></body> , "image", "d:/compare2.png");

        //sendWithAttament(sender,"yy22@163.com","测试邮件中上传附件!！","<html><head></head><body><h1>你好：附件中有学习资料！</h1></body></html>","c.png","d:/compare2.png");

        //sendWithAll(sender, "yy22@163.com", "测试邮件中嵌套图片!！", "<html><head></head><body><h1>hello 欢迎你!!spring image html ma ", "image", "d:/compare2.png","工作日志.docx","d:/工作日志.docx");
    }

    public static void sendTextWithHtml(JavaMailSenderImpl sender, String[] tos, String subject, String text)
            {
        MimeMessage mailMessage = sender.createMimeMessage();
        try{
            initMimeMessageHelper(mailMessage, tos, sender.getUsername(), subject, text);
        }catch (Exception e){
            e.printStackTrace();
        }

        // 发送邮件
        sender.send(mailMessage);

        System.out.println("邮件发送成功..");
    }

    public static void sendTextWithImg(JavaMailSenderImpl sender, String[] tos, String subject, String text,
                                       String imgId, String imgPath) throws MessagingException {
        MimeMessage mailMessage = sender.createMimeMessage();
        MimeMessageHelper messageHelper = initMimeMessageHelper(mailMessage, tos, sender.getUsername(), subject, text,
                true, true, "GBK");
        // 发送图片
        FileSystemResource img = new FileSystemResource(new File(imgPath));
        messageHelper.addInline(imgId, img);
        // 发送邮件
        sender.send(mailMessage);

        System.out.println("邮件发送成功..");
    }

    public static void sendWithAttament(JavaMailSenderImpl sender, String[] tos, String subject, String text,
                                        String AttachName, String filePath) throws MessagingException {
        MimeMessage mailMessage = sender.createMimeMessage();
        MimeMessageHelper messageHelper = initMimeMessageHelper(mailMessage, tos, sender.getUsername(), subject, text,
                true, true, DEFALUT_ENCODING);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        // 发送邮件
        messageHelper.addAttachment(AttachName, file);
        sender.send(mailMessage);

        System.out.println("邮件发送成功..");

    }

    public static void sendWithAll(JavaMailSenderImpl sender, String[] tos, String from, String subject, String text,
                                   String imgId, String imgPath, String AttachName, String filePath) throws MessagingException {
        MimeMessage mailMessage = sender.createMimeMessage();
        MimeMessageHelper messageHelper = initMimeMessageHelper(mailMessage, tos, sender.getUsername(), subject, text,
                true, true, DEFALUT_ENCODING);

        // 插入图片
        FileSystemResource img = new FileSystemResource(new File(imgPath));
        messageHelper.addInline(imgId, img);
        // 插入附件
        FileSystemResource file = new FileSystemResource(new File(filePath));
        messageHelper.addAttachment(AttachName, file);

        // 发送邮件
        sender.send(mailMessage);

        System.out.println("邮件发送成功..");

    }

    private static MimeMessageHelper initMimeMessageHelper(MimeMessage mailMessage, String[] tos, String from,
                                                           String subject, String text) throws MessagingException {
        return initMimeMessageHelper(mailMessage, tos, from, subject, text, true, false, DEFALUT_ENCODING);
    }


    private static MimeMessageHelper initMimeMessageHelper(MimeMessage mailMessage, String[] tos, String from,
                                                           String subject, String text, boolean isHTML, boolean multipart, String encoding) throws MessagingException {
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, multipart, encoding);
        messageHelper.setTo(tos);
        messageHelper.setFrom(from);
        messageHelper.setSubject(subject);
        // true 表示启动HTML格式的邮件
        messageHelper.setText(text, isHTML);

        return messageHelper;
    }


    /**
     * 这个方法在实际应用中，springboot会通过在配置文件application.xml
     * 中加配置自动实例化JavaMailSenderImpl，本方法只是为了测试使用
     */
    public static JavaMailSenderImpl initJavaMailSender() {

        Properties properties = new Properties();
        properties.setProperty("mail.debug", "true");// 是否显示调试信息(可选)
        properties.setProperty("mail.smtp.starttls.enable", "false");
        properties.setProperty("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.auth", "true");
        properties.put(" mail.smtp.timeout ", " 25000 ");

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setJavaMailProperties(properties);
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setUsername("1779077919@qq.com"); // s根据自己的情况,设置username
        javaMailSender.setPassword("tihhluafotziccga"); // 根据自己的情况, 设置password
        javaMailSender.setPort(465);
        javaMailSender.setDefaultEncoding("UTF-8");

        return javaMailSender;
    }

}