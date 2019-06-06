package com.DesignPattern.HardFirstDesignMode.commandPattern;

/**
 * @author lyh on 2019/5/30
 */
public class StereoOnWithCDCommand implements Command{
    Stereo stereo;
    public StereoOnWithCDCommand(Stereo stereo){
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);

    }
}
