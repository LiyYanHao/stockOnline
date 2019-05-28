package com.DesignMode.HardFirstDesignMode.StrategyPattern.BaseOnClass;

/**
 * 橡皮鸭
 * 橡皮鸭不会呱呱叫(quack), 而是吱吱叫(squeak)
 * @author lyh on 2019/5/27
 */
public class RubberDuck extends Duck {
    @Override
    public void display() {
        System.out.println("可爱的黄色橡皮鸭");
    }

    //橡皮鸭不会呱呱叫(quack), 而是吱吱叫(squeak)
    @Override
    public void quack() {
        System.out.println("橡皮鸭吱吱叫");
    }
    //橡皮鸭不会飞
    @Override
    public void fly() {
    }
}
