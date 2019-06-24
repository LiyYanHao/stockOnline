package com.DesignPattern.headfirst.mySample.factory.absortFactory;

import com.DesignPattern.headfirst.designpatterns.factory.pizzaaf.Pizza;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 21:01
 * Description: No Description
 */
public abstract class PizzInfoStore {

    protected abstract PizzInfe createPizza(String item);

    public PizzInfe orderPizza(String type) {
        PizzInfe pizza = createPizza(type);
        System.out.println("--- Making a " + pizza.getName() + " ---");
        pizza.prepare();

        return pizza;
    }
}
