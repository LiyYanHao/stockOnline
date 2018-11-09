package com.MultiThreading.Synchronized;

import java.util.Random;

public class Philosopher extends Thread {
    private Chopstick left,reigt;
    private Random random;

    public Philosopher(Chopstick left,Chopstick right){
        random = new Random();
    }

    public void run() {
        try{
            while (true){
                Thread.sleep(random.nextInt(1000));
                synchronized (left){
                    synchronized (reigt){
                        Thread.sleep(random.nextInt(1000));
                    }
                }
            }
        }catch (Exception e){

        }
    }
}
