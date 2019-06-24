package com.DesignPattern.headfirst.mySample.factory.absortFactory;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 21:18
 * Description: No Description
 */
public class PizzMain {
    public static void main(String[] args){
        PizzStore pizzStore = new PizzStore();
        Pizz a = pizzStore.createPizz("A");
        System.out.println("Ethan ordered a " + a + "\n");


    }
}
