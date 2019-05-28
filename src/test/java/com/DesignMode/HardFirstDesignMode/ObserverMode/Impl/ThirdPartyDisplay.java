package com.DesignMode.HardFirstDesignMode.ObserverMode.Impl;

import com.DesignMode.HardFirstDesignMode.ObserverMode.definitionInterface.DisplayElement;
import com.DesignMode.HardFirstDesignMode.ObserverMode.definitionInterface.Observer;
import com.DesignMode.HardFirstDesignMode.ObserverMode.definitionInterface.Subject;

/**
 *通过观察者和布告板显示自定义内容
 * @author lyh on 2019/5/28
 */
public class ThirdPartyDisplay implements Observer, DisplayElement {

    private float temperature;
    private float hunidity;
    private Subject weatherData;


    public ThirdPartyDisplay(Subject weatherData) {
        weatherData = this.weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float perssure) {

    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature +
                "F degrees and" + hunidity + "% hunidity");
    }
}
