package com.DesignPattern.HardFirstDesignMode.matcherAppearancePattern;

/**
 * @author lyh on 2019/5/30
 */
public class DuckTestDrive {
    public static void main(String[] args){
        MallardDuck mallardDuck = new MallardDuck();

        WildTurkey wildTurkey = new WildTurkey();
        TurkeyApapter turkeyApapter = new TurkeyApapter(wildTurkey);

        System.out.println("The Turkey says...");
        wildTurkey.gooble();
        wildTurkey.fly();

        System.out.println("\n The ");

    }
}
