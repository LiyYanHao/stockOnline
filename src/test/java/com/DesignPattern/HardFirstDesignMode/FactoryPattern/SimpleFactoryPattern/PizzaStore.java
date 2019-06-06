package com.DesignPattern.HardFirstDesignMode.FactoryPattern.SimpleFactoryPattern;

import com.DesignPattern.HardFirstDesignMode.FactoryPattern.SimpleFactoryPattern.Pojo.Inteface.Pizza;

/**
 * 披萨商店
 * @author lyh on 2019/5/29
 */
public class PizzaStore {

    SimplePizzFactory simplePizzFactory;

    public PizzaStore(SimplePizzFactory simplePizzFactory) {
        this.simplePizzFactory = simplePizzFactory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = simplePizzFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
