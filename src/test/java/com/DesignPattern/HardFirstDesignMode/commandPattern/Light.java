package com.DesignPattern.HardFirstDesignMode.commandPattern;

/**
 * @author lyh on 2019/5/30
 */
public class Light {
    public Light() {
    }

    String ll ;

    public Light(String ll) {
        this.ll = ll;
    }

    public void on(){
        System.out.println("++++++light on++++++");
    }

    public void off() {
        System.out.println("++++++light off++++++");
    }
}
