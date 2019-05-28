package com.DesignMode.HardFirstDesignMode.ObserverMode.JavaUtilOberver;

import java.util.Observable;

/**
 * @author lyh on 2019/5/28
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }
    public void measurementChanged(){
        setChanged();
        notifyObservers();
    }
    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
