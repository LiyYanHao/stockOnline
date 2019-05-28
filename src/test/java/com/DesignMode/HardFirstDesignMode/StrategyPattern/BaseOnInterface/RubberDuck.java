package com.DesignMode.HardFirstDesignMode.StrategyPattern.BaseOnInterface;

import org.junit.Test;

/**
 * 橡皮鸭不会呱呱叫(quack), 而是吱吱叫(squeak)
 * @author lyh on 2019/5/27
 */
public class RubberDuck extends Duck {
    @Override
    public void display() {
        System.out.println("可爱的黄色橡皮鸭");
    }
    @Test
    public void test1() throws Exception {
        //运行时改变状态
        RubberDuck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.setFlyBehavior(new FlyNoWay());
        rubberDuck.setQuackBehavior(new Squeak());
        rubberDuck.performfly();
        rubberDuck.performQuack();

    }

}
