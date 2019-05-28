package com.DesignMode.HardFirstDesignMode.StrategyPattern.BaseOnInterface;

/**
 * @author lyh on 2019/5/27
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("用翅膀飞行");
    }
}
