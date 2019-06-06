package com.DesignPattern.HardFirstDesignMode.commandPattern;

/**
 * @author lyh on 2019/5/30
 */
public class LightOffCommand implements Command{

    Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
