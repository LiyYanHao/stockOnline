package com.DesignMode.HardFirstDesignMode.ObserverMode.Impl;

import com.DesignMode.HardFirstDesignMode.ObserverMode.definitionInterface.DisplayElement;
import com.DesignMode.HardFirstDesignMode.ObserverMode.definitionInterface.Observer;
import com.DesignMode.HardFirstDesignMode.ObserverMode.definitionInterface.Subject;

/**
 *布告板StatisticsDisplay：显示最小、平均和最大的温度观测值
 * @author lyh on 2019/5/28
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private float maxTemperature=0.0f;
    private float minTemperature=200;
    private float tmpTemperature=0.0f;
    private int numReadings;//记录观测的次数以便计算平均温度值
    private Subject weatherData;


    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float perssure) {
        temperature +=temperature;
        numReadings++;
        if(tmpTemperature>maxTemperature){
            maxTemperature=temperature;
        }else if(temperature<minTemperature){
            minTemperature=tmpTemperature;
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tmpTemperature / numReadings)
                + "/" + maxTemperature + "/" + minTemperature);
    }
}
