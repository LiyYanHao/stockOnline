package com.算法.数据结构与算法分析java.chapter_1.chapter_3.ch3_5.练习;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author lyh on 2019/1/16
 */
public class Class3_1 {
    public static void main(String[] args) {
        Integer[] L = {1, 3, 4, 6};
        Integer[] P = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        printLots(Arrays.asList(L),Arrays.asList(P));

    }

    public static <T> void printLots(List<Integer> L, List<T> P) {
        Iterator<Integer> iteratorL = L.iterator();
        Iterator<T> iteratorP = P.iterator();

        T  itemP= null;
        Integer itemL = 0;
        int stat = 0;

        while (iteratorL.hasNext() && iteratorP.hasNext()) {
            itemL = iteratorL.next();
            while (stat < itemL && iteratorP.hasNext()) {
                itemP = iteratorP.next();
                stat++;
            }
            System.out.println(itemP);
        }
    }
}
