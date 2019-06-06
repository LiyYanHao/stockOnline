package com.DesignPattern.HardFirstDesignMode.FactoryPattern.FactoryMethod.Pojo.Inteface;

import java.util.ArrayList;

/**
 * @author lyh on 2019/5/29
 */
public abstract class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected ArrayList toppings = new ArrayList();

    protected void prepare(){
        System.out.println("preparing "+name);
        System.out.println("Tossing dough..");
        System.out.println("adding sause...");
        System.out.println("adding topping...");
        for (int i=0;i<toppings.size();i++){
            System.out.println(" "+toppings.get(i));
        }
    }
    protected void bake(){
        System.out.println("Bake for 25 minutes...");
    }
    protected void cut(){
        System.out.println("cut for 25 minutes...");
    }
    protected void box(){
        System.out.println("box for 25 minutes...");
    }
    public String getName(){
        return name;
    }
}
