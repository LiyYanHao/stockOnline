package com.DesignPattern.HardFirstDesignMode.DecoratorPattern;

/**
 * 具体饮料
 * @author lyh on 2019/5/29
 */
public class HouseBlend extends Beverage{

    public HouseBlend(){
        description = "House Blend Coffee";
    }


    @Override
    public double cost() {
        return 0.89;
    }
}
