package com.DesignPattern.headfirst.mySample.factory.FactoryMethod;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 21:01
 * Description: No Description
 */
public class PizzStore extends PizzOrder {

    @Override
    public Pizz createPizz(String t) {
        Pizz pizz = null;
        switch (t) {
            case "A":
            case "a":
                pizz = new PizzA();
                break;
            case "b":
            case "B":
                pizz = new PizzB();
                break;
            case "c":
            case "C":
                pizz = new PizzC();
            default:
        }
        return pizz;
    }
}
