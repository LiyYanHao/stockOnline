package com.DesignPattern.HardFirstDesignMode.commandPattern;

/**
 * 远程控制开关命令
 * @author lyh on 2019/5/30
 */
public class SimpleRemoteCntrol {
    Command slot;

    public SimpleRemoteCntrol() {}

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
