package com.DesignPattern.headfirst.mySample.factory.absortFactory;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 21:01
 * Description: No Description
 */
public abstract class PizzOrder {

    public Pizz orderPizz(String t){
        Pizz pizz = createPizz(t);
        pizz.pre();
        pizz.bake();
        pizz.cut();
        pizz.box();
        return pizz;
    }

    public abstract Pizz createPizz(String t);
}
