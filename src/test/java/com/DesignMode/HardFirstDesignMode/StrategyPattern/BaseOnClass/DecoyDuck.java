package com.DesignMode.HardFirstDesignMode.StrategyPattern.BaseOnClass;

/**
 * 诱饵鸭, 不会飞也不会叫
 * @author lyh on 2019/5/27
 */
public class DecoyDuck extends Duck {
    @Override
    public void display() {
        System.out.println("诱饵鸭");
    }
    @Override
    public void quack() {
        System.out.println("什么都不会做, 不会叫");
    }

    @Override
    public void fly() {
        System.out.println("什么都不做, 不会飞");
    }
}
