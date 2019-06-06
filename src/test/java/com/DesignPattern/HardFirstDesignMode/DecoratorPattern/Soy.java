package com.DesignPattern.HardFirstDesignMode.DecoratorPattern;

/**
 * 配料
 * @author lyh on 2019/5/29
 */
public class Soy extends CondimentDecorator{

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }


    @Override
    public String getDescription() {
        return beverage.getDescription()+",Soy";
    }

    @Override
    public double cost() {
        return 22+beverage.cost();
    }
}
