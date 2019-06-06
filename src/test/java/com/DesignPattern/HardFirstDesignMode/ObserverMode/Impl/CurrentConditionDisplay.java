package com.DesignPattern.HardFirstDesignMode.ObserverMode.Impl;


import com.DesignPattern.HardFirstDesignMode.ObserverMode.definitionInterface.DisplayElement;
import com.DesignPattern.HardFirstDesignMode.ObserverMode.definitionInterface.Observer;
import com.DesignPattern.HardFirstDesignMode.ObserverMode.definitionInterface.Subject;

/**
 * 此时布告板根据WeatherData对象展示当前观测的值
 *
 * @author lyh on 2019/5/28
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temperature;
    private float hunidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float perssure) {
        this.temperature = temperature;
        this.hunidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature +
                "F degrees and" + hunidity + "% hunidity");
    }
}
