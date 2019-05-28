package com.DesignMode.HardFirstDesignMode.StrategyPattern.BaseOnInterface;

/**
 * @author lyh on 2019/5/27
 */
public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
