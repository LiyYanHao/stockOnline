package com.DesignPattern.HardFirstDesignMode.SingletonPattern;

/**
 * @author lyh on 2019/5/30
 */
public class ChocolateBoiler {

    private boolean empty;
    private boolean boiled;

    public ChocolateBoiler() {
        this.empty = true;
        this.boiled = false;
    }

    public void fill(){
        //在锅炉填充巧克力和牛奶的混合物
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    public void drain(){
        if(!isEmpty() && !isBoiled()){
            //将炉内物煮沸腾
            boiled = true;
        }
    }
    public boolean isBoiled(){
        return boiled;
    }
    public boolean isEmpty(){
        return empty;
    }

}
