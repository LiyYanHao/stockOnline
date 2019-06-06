package com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod;

import com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod.Pojo.Inteface.Pizza;

/**
 * @author lyh on 2019/5/29
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY style Sauce and cheese pizza";
        dough = "Thin crust Dough";
        sauce = "Marinara sauce";
        toppings.add("Grated Raggiano Cheese");
    }

}
