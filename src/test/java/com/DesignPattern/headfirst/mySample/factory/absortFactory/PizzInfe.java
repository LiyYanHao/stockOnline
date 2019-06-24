package com.DesignPattern.headfirst.mySample.factory.absortFactory;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/24
 * Time: 22:43
 * Description: No Description
 */
public abstract class PizzInfe{
    String name;
    A a;
    B b;
    C c[];
    D d;
    E e;

    abstract void prepare();

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("---- " + name + " ----\n");
        if(a != null){
            result.append(a.toString());
            result.append("--------------");
            result.append("\n");
        }
        if(b != null){
            result.append(b.toString());
            result.append("--------------");
            result.append("\n");
        }
        if(c != null){
            for (int i = 0; i < c.length; i++) {
                result.append(c[i]);
                if (i < c.length-1) {
                    result.append(", ");
                }
            }
            result.append("--------------");
            result.append("\n");
        }

        if(d != null){
            result.append(d.toString());
            result.append("--------------");
            result.append("\n");
        }
        if(e != null){
            result.append(e.toString());
            result.append("--------------");
            result.append("\n");
        }
        return result.toString();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
