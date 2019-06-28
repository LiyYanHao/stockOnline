package com.learn.springBoot.springbootCoreThinking.Chapter8_1_2_EnableHelloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * @author lyh on 2019/6/8
 */
@EnableHelloWorld
@Configuration
public class EnableHelloWorldBootstrap {
    public static void main(String[] args){
//        //构建Annotation配置驱动spring上下文
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext();
//        //注册当前引导类
//        context.register(HelloWorldConfiguration.class);
//        context.refresh();
//        //获取名称helloworld的bean对象
//        String helloWorld = context.getBean("helloWorld", String.class);
//        System.out.println("helloWorld="+helloWorld);
//        context.close();
        List urlmapList = new ArrayList();
        HashMap<Object, Object> objectObjectHashMap1 = new HashMap<>();
        objectObjectHashMap1.put("IMG_SORT","1");
        urlmapList.add(objectObjectHashMap1);


        System.out.println(urlmapList.size());
        Collections.sort(urlmapList, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                int img_sort1 = Integer.valueOf(o1.get("IMG_SORT")+"");
                int img_sort2 = Integer.valueOf(o2.get("IMG_SORT")+"");
                return img_sort1-img_sort2;
            }
        });
        System.out.println(urlmapList);
    }
}
