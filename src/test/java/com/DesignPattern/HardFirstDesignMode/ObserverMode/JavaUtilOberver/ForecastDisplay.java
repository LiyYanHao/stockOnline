package com.DesignPattern.HardFirstDesignMode.ObserverMode.JavaUtilOberver;


import com.DesignPattern.HardFirstDesignMode.ObserverMode.definitionInterface.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @author lyh on 2019/5/28
 */
public class ForecastDisplay implements Observer, DisplayElement {

    Observable observable;
    private float currentPressure = 29.2f;
    private float lastPressure;


    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("currentPressure"+currentPressure+
                "lastPressure"+lastPressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        WeatherData weatherData = (WeatherData)o;
        lastPressure=currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    }
}
