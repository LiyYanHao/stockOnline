package com.MultiThreading.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    public static void main(String[] args){
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            //使用共享资源
        }finally {
            lock.unlock();
        }

    }
}
