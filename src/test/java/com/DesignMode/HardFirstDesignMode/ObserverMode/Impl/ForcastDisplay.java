package com.DesignMode.HardFirstDesignMode.ObserverMode.Impl;

import com.DesignMode.HardFirstDesignMode.ObserverMode.definitionInterface.DisplayElement;
import com.DesignMode.HardFirstDesignMode.ObserverMode.definitionInterface.Observer;
import com.DesignMode.HardFirstDesignMode.ObserverMode.definitionInterface.Subject;

/**
 * 布告板ForecastDisplay：天气预报
 *
 * @author lyh on 2019/5/28
 */
public class ForcastDisplay implements Observer, DisplayElement {

    private float currentPressure = 29.24f;
    private float lastPressure;
    private Subject weatherData;


    public ForcastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }

    @Override
    public void update(float temperature, float humidity, float perssure) {
        lastPressure = currentPressure;
        currentPressure = perssure;
        display();
    }


}
