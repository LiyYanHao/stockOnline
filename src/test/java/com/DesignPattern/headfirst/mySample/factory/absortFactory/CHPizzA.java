package com.DesignPattern.headfirst.mySample.factory.absortFactory;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 21:00
 * Description: No Description
 */
public class CHPizzA implements Pizz {

    public CHPizzA() {
        System.out.println(this.getClass().getName()+"实例化");
    }

    @Override
    public void pre() {
        System.out.println(this.getClass().getName()+"pre()");
    }

    @Override
    public void bake() {
        System.out.println(this.getClass().getName()+"bake()");
    }

    @Override
    public void cut() {
        System.out.println(this.getClass().getName()+"cut()");
    }

    @Override
    public void box() {
        System.out.println(this.getClass().getName()+"box()");
    }
}
