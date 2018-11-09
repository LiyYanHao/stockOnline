package com.MultiThreading.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Interruptible {
    final ReentrantLock f1 = new ReentrantLock();
    final ReentrantLock f2 = new ReentrantLock();
    Thread t1 = new Thread(){
      public void run(){
          try{
              f1.lockInterruptibly();
              Thread.sleep(1000);
              f2.lockInterruptibly();
          }catch (InterruptedException e){
              System.out.println("t1 InterruptedException");
          }

      }
    };

}
