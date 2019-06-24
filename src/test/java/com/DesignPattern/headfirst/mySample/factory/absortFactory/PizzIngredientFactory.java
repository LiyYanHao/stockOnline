package com.DesignPattern.headfirst.mySample.factory.absortFactory;

import com.DesignPattern.headfirst.designpatterns.factory.pizzaaf.*;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 22:32
 * Description: No Description
 */
public interface PizzIngredientFactory {
    public A createA();
    public B createB();
    public C[] createC();
    public D creaD();
    public E createE();
}
