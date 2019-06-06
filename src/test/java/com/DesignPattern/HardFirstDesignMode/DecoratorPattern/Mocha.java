package com.DesignPattern.HardFirstDesignMode.DecoratorPattern;

/**
 * 配料
 * @author lyh on 2019/5/29
 */
public class Mocha extends CondimentDecorator{

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }


    @Override
    public String getDescription() {
        return beverage.getDescription()+",Mocha";
    }

    @Override
    public double cost() {
        return 20+beverage.cost();
    }
}
