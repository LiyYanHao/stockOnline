package com.Arithmetic.leetcode.DataStructure.queue;

import com.Arithmetic.PrintUtil;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: lyh
 * Date: 2019/6/30
 * Time: 11:43
 * Description: No Description
 * 循环队列是一种线性数据结构，
 * 其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，
 * 我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 */
public class MyCircularQueue {
    private int[] data = null;
    private int k;
    private int tail;
    private int head;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.k = k;
        data = new int[k];
        tail = -1;
        head = -1;

    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        ++tail;
        tail = tail % k;
        data[tail] = value;
        return true;

    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        ++head;
        head = head % k;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];

    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {

        return head == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return ((tail + 1) % k) == head;
    }


}





















