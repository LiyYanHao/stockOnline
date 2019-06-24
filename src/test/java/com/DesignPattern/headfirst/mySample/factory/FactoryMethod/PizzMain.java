package com.DesignPattern.headfirst.mySample.factory.FactoryMethod;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 21:18
 * Description: No Description
 */
public class PizzMain {
    public static void main(String[] args){
        NYPizzStore nyPizzStore = new NYPizzStore();
        Pizz a = nyPizzStore.orderPizz("A");


    }
}
