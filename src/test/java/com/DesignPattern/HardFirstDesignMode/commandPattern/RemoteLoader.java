package com.DesignPattern.HardFirstDesignMode.commandPattern;

/**
 * @author lyh on 2019/5/30
 */
public class RemoteLoader {
    public static void main(String[] args){
        RemoteControl remoteControl = new RemoteControl();

        Light living_roomLight = new Light("Living Room");
        Light kithchen = new Light("Kithchen");
        CellingFan living_room = new CellingFan("Living Room");

    }
}
