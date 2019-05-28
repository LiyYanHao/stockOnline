package com.DesignMode.HardFirstDesignMode.ObserverMode;

import com.DesignMode.HardFirstDesignMode.ObserverMode.Impl.CurrentConditionDisplay;
import com.DesignMode.HardFirstDesignMode.ObserverMode.Impl.ForcastDisplay;
import com.DesignMode.HardFirstDesignMode.ObserverMode.Impl.StatisticsDisplay;
import com.DesignMode.HardFirstDesignMode.ObserverMode.Impl.WeatherData;

/**
 * 气象站测试程序
 *
 * @author lyh on 2019/5/28
 */
public class WaetherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay
                = new CurrentConditionDisplay(weatherData);
        StatisticsDisplay statisticsDisplay
                = new StatisticsDisplay(weatherData);
        ForcastDisplay forcastDisplay = new ForcastDisplay(weatherData);

        weatherData.setMeasurements(37.5f, 1231.2f, 12312f);
        weatherData.setMeasurements(37.5f, 1231.2f, 12312f);
        weatherData.setMeasurements(37.5f, 1231.2f, 12312f);

        //        ForcastDisplay forcastDisplay = new ForcastDisplay(weatherData);

    }
}
