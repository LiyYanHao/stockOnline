package com.MultiThreading.ReentrantLock;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    public static void main(String[] args){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("a","111");
        if("111".equals(stringObjectHashMap.get("a"))){
            System.out.println("asdasda");
        }else {

        }

    }
}
