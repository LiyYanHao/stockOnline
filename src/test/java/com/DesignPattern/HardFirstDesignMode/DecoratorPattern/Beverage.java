package com.DesignPattern.HardFirstDesignMode.DecoratorPattern;

/**
 * 饮料基类
 * @author lyh on 2019/5/29
 */
public abstract class Beverage {

    String description ="Unknown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
