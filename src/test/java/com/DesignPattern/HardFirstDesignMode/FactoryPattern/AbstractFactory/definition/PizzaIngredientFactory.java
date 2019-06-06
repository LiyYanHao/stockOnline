package com.DesignPattern.HardFirstDesignMode.FactoryPattern.AbstractFactory.definition;

import com.DesignPattern.HardFirstDesignMode.FactoryPattern.AbstractFactory.Pojo.*;

/**
 * 原料工厂
 * @author lyh on 2019/5/30
 */
public interface PizzaIngredientFactory {

    public Dougth createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggie[] createVeggie();
    public Peppperoni createPepperoni();
    public Clams createClam();

}
