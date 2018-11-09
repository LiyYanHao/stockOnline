package com.MultiThreading.Synchronized;

public class Puzzle {
    static boolean answerReady = false;
    static int answer = 0;
    static Thread myThread = new Thread(){
        public void run(){
            answer = 42;
            answerReady = true;
        }
    };
    static Thread myThread2 = new Thread(){
        public void run(){
            if(answerReady)
                System.out.println("the meaning of life is:"+answer);
            else
                System.out.println("I don't know the answer");
        }
    };
    public static void main(String[] args)throws InterruptedException{
        myThread.start();myThread2.start();
        myThread.join();myThread2.join();
    }
}
