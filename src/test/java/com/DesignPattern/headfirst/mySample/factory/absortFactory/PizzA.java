package com.DesignPattern.headfirst.mySample.factory.absortFactory;

import com.DesignPattern.headfirst.designpatterns.factory.pizzaaf.Cheese;
import com.DesignPattern.headfirst.designpatterns.factory.pizzaaf.Dough;
import com.DesignPattern.headfirst.designpatterns.factory.pizzaaf.Pepperoni;
import com.DesignPattern.headfirst.designpatterns.factory.pizzaaf.Sauce;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 21:00
 * Description: No Description
 */
public class PizzA extends PizzInfe {


    private PizzIngredientFactory pizzIngredientFactory;

    public PizzA(PizzIngredientFactory pizzIngredientFactory) {
        this.pizzIngredientFactory = pizzIngredientFactory;
    }

    void prepare() {
        a = pizzIngredientFactory.createA();
        b = pizzIngredientFactory.createB();
        c = pizzIngredientFactory.createC();
        e = pizzIngredientFactory.createE();

    }

    public PizzA() {
        System.out.println(this.getClass().getName() + "实例化");
    }

    public void pre() {
        System.out.println(this.getClass().getName() + "pre()");
    }

    public void bake() {
        System.out.println(this.getClass().getName() + "bake()");
    }

    public void cut() {
        System.out.println(this.getClass().getName() + "cut()");
    }

    public void box() {
        System.out.println(this.getClass().getName() + "box()");
    }
}
