package com.DesignPattern.headfirst.mySample.factory.absortFactory;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 21:01
 * Description: No Description
 */
public class CHPizzStore extends PizzOrder {

    @Override
    public Pizz createPizz(String t) {
        Pizz pizz = null;
        switch (t) {
            case "A":
            case "a":
                pizz = new CHPizzA();
                break;
            case "b":
            case "B":
                pizz = new CHPizzB();
                break;
            case "c":
            case "C":
                pizz = new CHPizzC();
            default:
        }
        return pizz;
    }
}
