package com.DesignPattern.HardFirstDesignMode.commandPattern;

/**
 * @author lyh on 2019/5/30
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteCntrol simpleRemoteCntrol = new SimpleRemoteCntrol();
        Light light = new Light();
        LitghtOnCommand litghtOnCommand = new LitghtOnCommand(light);
        simpleRemoteCntrol.setCommand(litghtOnCommand);
        simpleRemoteCntrol.buttonWasPressed();


    }
}
