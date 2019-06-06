package com.DesignPattern.HardFirstDesignMode.DecoratorPattern;

/**
 * 测试
 * @author lyh on 2019/5/29
 */
public class StarbuzzCoffee {

    public static void main(String[] args)throws Exception{
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+"$"+beverage.cost());

        Beverage houseBlend2 = new HouseBlend();
        houseBlend2 = new Soy(houseBlend2);
        System.out.println(houseBlend2.getDescription()+"$"+beverage.cost());


    }

}
