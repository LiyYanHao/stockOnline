package com.DesignMode.HardFirstDesignMode.ObserverMode.JavaUtilOberver;



/**
 * 气象站测试程序
 *
 * @author lyh on 2019/5/28
 */
public class WaetherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        CurrentConditionsDisplay currentConditionDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(1231f,1231f,123123f);

    }
}
