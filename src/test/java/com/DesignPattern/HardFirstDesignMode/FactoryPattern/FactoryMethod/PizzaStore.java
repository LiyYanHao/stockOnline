package com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod;


import com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod.Pojo.Inteface.Pizza;

/**
 * 披萨商店 抽象
 * @author lyh on 2019/5/29
 */
public abstract class PizzaStore {

    public abstract Pizza orderPizza(String type);
}
