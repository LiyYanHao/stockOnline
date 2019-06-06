package com.DesignPattern.HardFirstDesignMode.StrategyPattern.BaseOnInterface;


import org.junit.Test;

/**
 * @author lyh on 2019/5/27
 */
public class MallardDuck extends Duck {
    @Override
    public void display() {
        System.out.println("绿头鸭");
    }

    @Test
    public void test1()throws Exception{
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performfly();
        mallardDuck.performQuack();
    }
}
