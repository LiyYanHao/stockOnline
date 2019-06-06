package com.DesignPattern.HardFirstDesignMode.StrategyPattern.BaseOnInterface;


/**
 * 注意，抽象类也是有构造方法的，不过不能创建对象，
 * 抽象类的构造方法是用来初始化变量的
 * @author lyh on 2019/5/27
 */
public abstract class Duck {
    //针对接口编程
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    //设置一个默认的行为
    public Duck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    public void swim(){
        System.out.println("游泳");
    }

    //每个鸭子的外观不同，在子类中实现
    public abstract void display();

    //执行飞行的方法
    public void performfly(){
        flyBehavior.fly();
    }

    //执行叫的方法
    public void performQuack(){
        quackBehavior.quack();
    }
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
