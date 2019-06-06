package com.DesignPattern.HardFirstDesignMode.SingletonPattern;

import org.spark_project.jetty.client.Synchronizable;

import java.util.concurrent.SynchronousQueue;

/**
 * @author lyh on 2019/5/30
 */
public class SingletonSimpleSynchronized {

    private static SingletonSimpleSynchronized singletonSimple;

    private SingletonSimpleSynchronized(){}

    //synchronized 添加同步关键字
    synchronized public static  SingletonSimpleSynchronized getInstance(){
        if(singletonSimple == null){

            singletonSimple = new SingletonSimpleSynchronized();
            return singletonSimple;
        }else {
            return singletonSimple;
        }
    }

}
