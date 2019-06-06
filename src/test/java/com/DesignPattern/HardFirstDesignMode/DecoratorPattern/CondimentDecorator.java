package com.DesignPattern.HardFirstDesignMode.DecoratorPattern;

/**
 * 调料类
 * @author lyh on 2019/5/29
 *
 */
public abstract class CondimentDecorator extends Beverage {
    @Override
    public abstract String getDescription();
}
