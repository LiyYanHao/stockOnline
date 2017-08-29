package com;

/**
 * Created by lyh on 17-5-25.
 */
public class Main {
    public static void main(String[] args){
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类装载器:"+appClassLoader);
        ClassLoader extensionClassLoader = appClassLoader.getParent();
        System.out.println("系统类装载器的父类加载器——扩展类加载器:"+extensionClassLoader);
        ClassLoader bootStrapClassLoader = extensionClassLoader.getParent();
        System.out.println("扩展类加载器的父类加载器——引导类加载器:"+bootStrapClassLoader);
    }
}
