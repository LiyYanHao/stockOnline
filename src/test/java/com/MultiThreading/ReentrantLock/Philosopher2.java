package com.MultiThreading.ReentrantLock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher2 extends Thread {
    private boolean eating;
    private ReentrantLock able;
    private Philosopher2 left;
    private Philosopher2 right;
    private Condition condition;
    private Random random;
    public Philosopher2(ReentrantLock able){
        eating = false;
        this.able = able;
        this.condition = able.newCondition();
        random = new Random();
    }

    public Philosopher2 getLeft() {
        return left;
    }

    public void setLeft(Philosopher2 left) {
        this.left = left;
    }

    public void run(){
        try {
            while (true){
                think();
                eat();
            }
        }catch (InterruptedException e){}
    }
    public void think()throws InterruptedException{
        able.lock();
        try {
            eating = false;
            left.condition.signal();
            right.condition.signal();
        }finally {
            able.unlock();
        }
        Thread.sleep(1000);
    }
    private void eat()throws InterruptedException{
        able.lock();
        try {
            while (left.eating || right.eating){
                condition.await();
                eating = true;
            }
        }finally {
            able.unlock();
        }
        Thread.sleep(1000);
    }


}
