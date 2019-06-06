package com.DesignPattern.HardFirstDesignMode.commandPattern;

/**
 * 遥控器
 *
 * @author lyh on 2019/5/30
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        NoCommand noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int solt, Command onCommand, Command offCommand) {
        onCommands[solt] = onCommand;
        offCommands[solt] = offCommand;
    }

    public void onButtonWasPushed(int solt) {
        onCommands[solt].execute();
    }

    public void offButtonWasPushed(int solt) {
        offCommands[solt].execute();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\b----------Remote Control-----------");
        for (int i = 0; i<onCommands.length;i++){
            sb.append("[solt"+i+"]"+onCommands[i].getClass().getName()
                    +" "+offCommands[i].getClass().getName()+"\n");
        }
            return sb.toString();
    }
}
