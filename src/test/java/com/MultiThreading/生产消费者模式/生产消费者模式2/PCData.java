package com.MultiThreading.生产消费者模式.生产消费者模式2;


/**
 * 容器数据类型
 * @author ctk
 *
 */
public class PCData {
    private final int intData;
    public PCData(int d){
        intData = d;
    }
    public PCData(String d){
        intData = Integer.valueOf(d);
    }
    public int getData(){
        return intData;
    }
    @Override
    public String toString(){
        return "data:"+intData;
    }
}