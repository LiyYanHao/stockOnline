package com.DesignPattern.HardFirstDesignMode.StrategyPattern.BaseOnInterface;


/**
 * @author lyh on 2019/5/27
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("什么都不做, 不能飞");
    }
}
