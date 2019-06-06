package com.DesignPattern.HardFirstDesignMode.matcherAppearancePattern;

/**
 * @author lyh on 2019/5/30
 */
public class WildTurkey implements Turkey{


    public void fly(){
        System.out.println("I am flying a short distance");
    }

    @Override
    public void gooble() {
        System.out.println("Gooble gobble");
    }
}
