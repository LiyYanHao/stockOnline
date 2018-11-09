package com.MultiThreading.ReentrantLock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher extends Thread {
    private ReentrantLock leftChopstick,reightChopsticK;
    private Random random;
    public  Philosopher(ReentrantLock leftChopstick,ReentrantLock reightChopsticK){
        this.leftChopstick = leftChopstick;
        this.reightChopsticK = reightChopsticK;
        random = new Random();
    }
    public void run(){
        try{
            while (true){
                Thread.sleep(random.nextInt(1000));//思考一段时间
                leftChopstick.lock();
                try{
                    if(reightChopsticK.tryLock(1000,TimeUnit.MILLISECONDS)){
                        //获取右手的筷子
                        try{
                            Thread.sleep(random.nextInt(1000));//进餐一段时间
                        }finally {
                            reightChopsticK.unlock();
                        }

                    }else{
                        //没有获取到筷子,继续思考
                    }
                }finally {

                }
            }

        }catch (InterruptedException e){

        }
    }
}
