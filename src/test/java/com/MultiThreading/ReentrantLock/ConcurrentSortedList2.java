package com.MultiThreading.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSortedList2 {
   private class Node{
       public int value;
       public Node prev;
       public Node next;
       ReentrantLock lock = new ReentrantLock();
       public Node(){};
       public Node(int value,Node prev,Node next){
           this.value = value;
           this.prev = prev;
           this.next = next;
       }
   }

   public Node tail;
   public Node head;
   public ConcurrentSortedList2(){
       tail = new Node();
       head = new Node();
       tail.prev = head;
       tail.next = tail;
   }
   public void insert(int value){
        Node current = head;
        Node next = current.next;
        current.lock.lock();
       try{
           while (true){
               next.lock.lock();
               try {
                   if (next == tail || next.value < value){
                       Node node = new Node(value,current,next);
                       next.prev = node;
                       current.next = node;
                   }
               }finally {

               }
           }


       }finally {
           current.lock.lock();
       }
   }

}
