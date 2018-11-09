package com.MultiThreading.ReentrantLock;

public class Uninterruptible {
    public static void main(String[] args)throws Exception{
        final Object o1 = new Object();
        final Object o2 = new Object();

        Thread t1 = new Thread(){
            public void run(){
                try{
                    synchronized (o1){
                        Thread.sleep(1000);
                        synchronized (o2){}
                    }
                }catch (InterruptedException e){
                    System.out.println("t1 InterruptedException");
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                try{
                    synchronized (o2){
                        Thread.sleep(1000);
                        synchronized (o1){}
                    }
                }catch (InterruptedException e2){
                    System.out.println("t2 InterruptedException");
                }
            }
        };
        t1.start();t2.start();
        Thread.sleep(2000);
        t1.interrupt();t2.interrupt();
        t1.join();t2.join();
    }
}
