package com.DesignPattern.HardFirstDesignMode.commandPattern;

/**
 * @author lyh on 2019/5/30
 */
public class LitghtOnCommand implements Command {

    Light light;

    public LitghtOnCommand(Light light) {
        this.light = light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    //使用执行 调用light的on方法
    @Override
    public void execute() {
        light.on();
    }
}
