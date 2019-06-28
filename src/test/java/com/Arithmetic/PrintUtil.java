package com.Arithmetic;

import java.util.Arrays;

/**
 * @author lyh on 2019/6/27
 */
public class PrintUtil {

    public static void toMyString(Object x) {
        System.out.println("result:");
        if (x instanceof int[]) {
            int[] xInts = (int[]) x;
            System.out.println(Arrays.toString(xInts));
            return;
        }else if(x instanceof String){
            System.out.println(x);
        }else if(x instanceof Integer){
            System.out.println(x);
        }
        System.out.println("=================");
    }
}
