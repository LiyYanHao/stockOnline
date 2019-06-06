package com.DesignPattern.HardFirstDesignMode.ObserverMode.Impl;


import com.DesignPattern.HardFirstDesignMode.ObserverMode.definitionInterface.Observer;
import com.DesignPattern.HardFirstDesignMode.ObserverMode.definitionInterface.Subject;

import java.util.ArrayList;

/**
 * 天气对象
 *
 * @author lyh on 2019/5/28
 */
public class WeatherData implements Subject {

    private ArrayList<Observer> observers;//观察者对象集合
    private float temperature;
    private float humidity;
    private float perssure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    //list删除对象 使用index索引
    @Override
    public void removeRegisterOberver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i > 0) {
            observers.remove(i);
        }

    }

    public void removetest(){
        ArrayList<Observer> arrayList= new ArrayList<>();
       // arrayList.add(new )
    }

    //通知所有的观察者
    @Override
    public void notifyOberver() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, perssure);
        }
    }

    //天气改变
    public void measurementChanged() {
        notifyOberver();
    }

    //设置天气数据
    public void setMeasurements(float temperature,
                                float humidity, float perssure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.perssure = perssure;
        measurementChanged();
    }


}
