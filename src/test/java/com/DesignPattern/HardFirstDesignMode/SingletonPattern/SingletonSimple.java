package com.DesignPattern.HardFirstDesignMode.SingletonPattern;

/**
 * @author lyh on 2019/5/30
 */
public class SingletonSimple {

    private static SingletonSimple singletonSimple;

    private SingletonSimple(){}

    public static SingletonSimple getInstance(){
        if(singletonSimple == null){
            singletonSimple = new SingletonSimple();
            return singletonSimple;
        }else {
            return singletonSimple;
        }
    }

}
