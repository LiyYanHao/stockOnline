package com.DesignMode.HardFirstDesignMode.StrategyPattern.BaseOnClass;

/**
 * @author lyh on 2019/5/27
 */
public abstract class Duck{
    public void quack(){
        System.out.println("呱呱叫");
    }
    public void swim(){
        System.out.println("游泳");
    }
    //每个鸭子的外观不同, 在子类中实现
    public abstract void display();
    //鸭子飞行
    public void fly(){
        System.out.println("飞行");
    }
}
