package com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod;

import com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod.Pojo.Inteface.Pizza;

/**
 * @author lyh on 2019/5/29
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        NYPizzaStore nyPizzaStore = new NYPizzaStore();
//                = new ChicagoCheesePizza();

        Pizza pizza = nyPizzaStore.orderPizza("Cheese");
        System.out.println("Ethan ordered a "+pizza.getName()+"");
//
//        Pizza pizza2 = chicagoStyleCheesePizza("Cheese");
//        System.out.println("Ethan ordered a "+pizza2.getName()+"");

    }
}
