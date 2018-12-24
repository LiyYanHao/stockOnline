package com;

import java.util.*;

/**
 * Created by lyh on 17-5-25.
 */
public class Main {
    public static void main(String[] args){
        Map<String,Object> map =  new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");
        map.put("5","e");
        processMap(map,"3");
        System.out.println(map);


    }


    public static void processMap(Map map,String key) {
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            String keyTmp = iter.next();
            if (keyTmp.equals(key)) {
                iter.remove();
            }

        }
    }
}
