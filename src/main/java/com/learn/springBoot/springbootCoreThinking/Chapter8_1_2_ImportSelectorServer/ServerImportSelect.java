package com.learn.springBoot.springbootCoreThinking.Chapter8_1_2_ImportSelectorServer;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author lyh on 2019/6/8
 */
public class ServerImportSelect implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //读取EnableServer中的所有属性方法，仅有type属性
        //key为属性方法的名称，value为属性方法的返回对象
        Map<String, Object> annotationAttributes = importingClassMetadata
                .getAnnotationAttributes
                        (EnableServer.class.getName());
        //获取名字为type的属性,并强制转换为Server.type
        Server.Type type = (Server.Type) annotationAttributes.get("type");
        //导入类名字的数组
        String[] importClassNames = new String[0];
        switch (type){
            case HTTP://当前设置HTTP服务器类型时，返回HttpServer组件
                importClassNames = new String[]{HttpServer.class.getName()};
                break;
            case FTP://当前设置FTP服务器类型时，返回FTPServer组件
                importClassNames = new String[]{FtpServer.class.getName()};
                break;
        }
        return importClassNames;
    }
}

