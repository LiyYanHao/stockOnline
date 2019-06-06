package com.DesignPattern.HardFirstDesignMode.DecoratorPattern;

/**
 * 配料
 * @author lyh on 2019/5/29
 */
public class Whip extends CondimentDecorator{

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }


    @Override
    public String getDescription() {
        return beverage.getDescription()+",Whip";
    }

    @Override
    public double cost() {
        return 21+beverage.cost();
    }
}
