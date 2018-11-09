package com.MultiThreading.Synchronized;

import java.util.Random;

/**
 * 按照散列值的方式规定顺序
 * 对象的散列值可能会重复,但是几率和小,不建议使用
 *
 */
public class Philosopher3 extends Thread {
    private Chopstick first,second;
    private Random random;

    public Philosopher3(Chopstick left, Chopstick right){

        if(System.identityHashCode(left) < System.identityHashCode(right))
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
