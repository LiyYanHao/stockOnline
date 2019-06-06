package com.DesignPattern.HardFirstDesignMode.DecoratorPattern;

/**
 * 具体饮料  浓缩咖啡
 * @author lyh on 2019/5/29
 */
public class Espresso extends Beverage{

    public Espresso(){
        description = "Espresso";
    }


    @Override
    public double cost() {
        return 1.99;
    }
}
