package com.算法.数据结构与算法分析java.chapter_1.chapter_3.ch3_5.练习;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author lyh on 2019/1/16
 */
public class Class3_4 {
    public static void main(String[] args){

    }
    public static <T extends Comparable<? super T>>
    void intersection(List<T> L1,List<T> L2,List<T> intersect) {
        ListIterator<T> tListIteratorL1 = L1.listIterator();
        ListIterator<T> tListIteratorL2 = L2.listIterator();
        if (intersect == null) {
            intersect = new ArrayList<>();
        }
        T itemL1 = null, itemL2 = null;
        if (tListIteratorL1.hasNext() && tListIteratorL2.hasNext()) {
            itemL1 = tListIteratorL1.next();
            itemL2 = tListIteratorL2.next();
        }
        while (itemL1 !=null && itemL2 !=null){
            int compareResult = itemL1.compareTo(itemL2);
            if(compareResult == 0){
                intersect.add(itemL1);
                itemL1=tListIteratorL1.hasNext()?tListIteratorL1.next():null;
                itemL2=tListIteratorL2.hasNext()?tListIteratorL2.next():null;

            }else if(compareResult <0){
                itemL1 = tListIteratorL1.hasNext()?tListIteratorL1.next():null;
            }else {
                itemL2 = tListIteratorL2.hasNext()?tListIteratorL2.next():null;
            }

        }

    }

//            public static <T extends Comparable<? super T>>
//        void intersection(List<T> L1,List<T> L2,List<T> intersect){
//        ListIterator<T> tListIteratorL1 = L1.listIterator();
//        ListIterator<T> tListIteratorL2 = L2.listIterator();
//        if(intersect == null){
//            intersect = new ArrayList<>();
//        }
//        T itemL1 =null,itemL2=null;
//        if(tListIteratorL1.hasNext() && tListIteratorL2.hasNext()){
//            itemL1 = tListIteratorL1.next();
//            itemL2 = tListIteratorL2.next();
//            if(itemL1==itemL2){
//                intersect.add(itemL1);
//            }
//        }
//    }

}
