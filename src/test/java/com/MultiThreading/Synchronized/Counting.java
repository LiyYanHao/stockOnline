package com.MultiThreading.Synchronized;

public class Counting {
    public static void main(String[] args)throws InterruptedException{
        class Counter{
            private int count = 0;
            public void increment(){++count;}
            public int getCount(){return count;}
        }
        final Counter counter = new Counter();
        class ContingThread extends Thread{
            public void run(){
                for (int i = 0; i < 10000; ++i){
                    counter.increment();
                }
            }
        }
        ContingThread t1 = new ContingThread();
        ContingThread t2 = new ContingThread();
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(counter.getCount());
    }
}
