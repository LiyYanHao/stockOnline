package com.DesignMode.HardFirstDesignMode.StrategyPattern.BaseOnInterface;

/**
 * @author lyh on 2019/5/27
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
            System.out.println("什么都不做, 不会叫");
    }
}
