package com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod;

import com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod.Pojo.Inteface.Pizza;

/**
 * @author lyh on 2019/5/29
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago style Sauce and cheese pizza";
        dough = "Extra crust Dough";
        sauce = "Plum Tomato sauce";
        toppings.add("Shreded Mozzarella Cheese");
    }

    @Override
    protected void cut() {
        System.out.println("Cutting the pizza into square silces");
    }
}
