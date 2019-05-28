package com.DesignMode.HardFirstDesignMode.StrategyPattern.BaseOnInterface;

/** 吱吱叫
 * @author lyh on 2019/5/27
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}
