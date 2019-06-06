package com.DesignPattern.HardFirstDesignMode.FactoryPattern.SimpleFactoryPattern;

import com.DesignPattern.HardFirstDesignMode.FactoryPattern.SimpleFactoryPattern.Pojo.CheesePizza;
import com.DesignPattern.HardFirstDesignMode.FactoryPattern.SimpleFactoryPattern.Pojo.ClamPizza;
import com.DesignPattern.HardFirstDesignMode.FactoryPattern.SimpleFactoryPattern.Pojo.Inteface.Pizza;
import com.DesignPattern.HardFirstDesignMode.FactoryPattern.SimpleFactoryPattern.Pojo.PeperonPizza;
import com.DesignPattern.HardFirstDesignMode.FactoryPattern.SimpleFactoryPattern.Pojo.VeggiePizza;

/**
 * @author lyh on 2019/5/29
 */
public class SimplePizzFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if ("Cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("Peperon".equals(type)) {
            pizza = new PeperonPizza();
        } else if ("Clam".equals(type)) {
            pizza = new ClamPizza();
        } else if ("Veggie".equals(type)) {
            pizza = new VeggiePizza();
        }
        return pizza;

    }

}
