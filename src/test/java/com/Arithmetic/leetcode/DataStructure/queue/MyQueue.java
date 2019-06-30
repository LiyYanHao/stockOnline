package com.Arithmetic.leetcode.DataStructure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/29
 * Time: 19:57
 * Description: No Description
 * 队列是典型的 FIFO 数据结构。插入（insert）操作也称作入队（enqueue），
 * 新元素始终被添加在队列的末尾。 删除（delete）操作也被称为出队（dequeue)。
 * 你只能移除第一个元素。
 */
public class MyQueue<T> {
    private List<T> data;
    private int p_stat;

    public MyQueue() {
        data = new ArrayList<>();
        p_stat = 0;
    }

    public boolean insert(T x) {
        data.add(x);
        return true;
    }

    public boolean delete(T x) {
        if(isEmpty()){
            return false;
        }
        p_stat++;
        return true;
    }

    public boolean isEmpty() {
        return p_stat >= data.size();
    }

    public T front(){
        return data.get(p_stat);
    }


}
