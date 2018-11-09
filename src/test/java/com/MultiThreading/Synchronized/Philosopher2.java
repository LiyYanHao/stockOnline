package com.MultiThreading.Synchronized;

import java.util.Random;

/**
 * 按照统一的方式规定顺序
 */
public class Philosopher2 extends Thread {
    private Chopstick first,second;
    private Random random;

    public Philosopher2(Chopstick left, Chopstick right){
        if(left.getId() < right.getId()){
            first = left;second = right;
        }else{
            first = right;second = left;
        }
        random = new Random();
    }

    public void run() {
        try{
            while (true){
                Thread.sleep(random.nextInt(1000));
                synchronized (first){
                    synchronized (second){
                        Thread.sleep(random.nextInt(1000));
                    }
                }
            }
        }catch (Exception e){

        }
    }
}
