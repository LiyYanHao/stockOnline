package com.DesignPattern.HardFirstDesignMode.matcherAppearancePattern;

/**
 * @author lyh on 2019/5/30
 */
public class TurkeyApapter implements Duck{

    Turkey turkey;

    public TurkeyApapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public void quack(){
        turkey.gooble();
    }

    public void fly(){
        for (int i=0;i<5;i++){
            turkey.fly();
        }
    }
}
