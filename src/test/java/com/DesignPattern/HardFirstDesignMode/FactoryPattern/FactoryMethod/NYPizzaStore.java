package com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod;


import com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod.Pojo.Inteface.Pizza;
import com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod.Pojo.NYStyleCheesePizza;
import com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod.Pojo.NYStyleClamPizza;
import com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod.Pojo.NYStylePeperonPizza;
import com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod.Pojo.NYStyleVeggiePizza;

/**
 * 纽约披萨
 *
 * @author lyh on 2019/5/29
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza orderPizza(String type) {
        Pizza pizza = null;
        if ("Cheese".equals(type)) {
            pizza = new NYStyleCheesePizza();
        } else if ("Clam".equals(type)) {
            pizza = new NYStyleClamPizza();
        } else if ("Peperon".equals(type)) {
            pizza = new NYStylePeperonPizza();
        } else if ("Veggie".equals(type)) {
            pizza = new NYStyleVeggiePizza();
        }
        return pizza;
    }
}
