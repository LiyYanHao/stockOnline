package com.DesignPattern.headfirst.mySample.factory.FactoryMethod;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 21:01
 * Description: No Description
 */
public class NYPizzStore extends PizzOrder {

    @Override
    public Pizz createPizz(String t) {
        Pizz pizz = null;
        switch (t) {
            case "A":
            case "a":
                pizz = new NYPizzA();
                break;
            case "b":
            case "B":
                pizz = new NYPizzB();
                break;
            case "c":
            case "C":
                pizz = new NYPizzC();
            default:
                pizz = new NYPizzA();
        }
        return pizz;
    }
}
