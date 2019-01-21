package com.算法.数据结构与算法分析java.chapter_1.chapter_3.ch3_5.练习;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author lyh on 2019/1/16
 */
public class Class3_6 {
    public static void main(String[] args) {
        ArrayList josephus = josephus(2, 5);
        yuesefu(5, 2);
        System.out.println(josephus.toString());
        System.out.println();
    }

    public static void yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        //从第K个开始计数
        int k = 0;
        while (start.size() > 0) {
            k = k + countNum;
            //第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }

    public static ArrayList josephus(int n, int m) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        ArrayList<Person> personArrayOut = new ArrayList<>();
        ArrayList<Person> personArrayTmp = new ArrayList<>();
        Person person = null;
        for (int i = 1; i < m + 1; i++) {
            person = new Person(false, i);
            personArrayList.add(person);
        }
        int index = 0;
        int count = 0;
        Person p = null;
        while (true) {
            p = personArrayList.get(index);
            index++;
            if (count == 0) {
                personArrayOut.add(p);
                System.out.println("p.bh=" + p.bh);
                count = n;
            } else {
                personArrayList.add(p);
            }
            ++count;
            if (m == personArrayOut.size()) {
                break;
            }
        }

        return personArrayOut;
    }

}

class Person {
    public Person(boolean isHavepoto, int bh) {
        this.isHavepoto = isHavepoto;
        this.bh = bh;
    }

    boolean isHavepoto;
    int bh;
}