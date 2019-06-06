package com.DesignPattern.HardFirstDesignMode.SingletonPattern;

/**
 * @author lyh on 2019/5/30
 */
public class SingletonSimpleSynchronizedDouble {

    //volatile 添加volatile关键字 让其他线程可见 jdk1.4+
    private volatile static SingletonSimpleSynchronizedDouble singletonSimple;

    private SingletonSimpleSynchronizedDouble() {
    }

    //减少方法调用的同步
    public static SingletonSimpleSynchronizedDouble getInstance() {
        if (singletonSimple == null) {
            synchronized (SingletonSimpleSynchronizedDouble.class) {
                if (singletonSimple == null) {
                    singletonSimple = new SingletonSimpleSynchronizedDouble();
                }
            }
        }
        return singletonSimple;
    }
}
