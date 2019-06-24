package com.DesignPattern.headfirst.mySample.factory.absortFactory;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 23:09
 * Description: No Description
 */
public class PizzAIngredientFactory implements PizzIngredientFactory{
    @Override
    public A createA() {
        return new A1();
    }

    @Override
    public B createB() {
        return new B1();
    }

    @Override
    public C[] createC() {
        C[] cs = new C[1];
        cs[0] = new C1();
        return cs;
    }

    @Override
    public D creaD() {
        return new D1();
    }

    @Override
    public E createE() {
        return new E1();
    }
}
