package com.java8.lambda;

import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args){

        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);
//        players.forEach((player) -> System.out.println(player));
        players.forEach(System.out::println);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world!");
            }
        });

        new Thread(() -> System.out.println("Hello world")).start();
        Arrays.sort(atp,(String s1,String s2) -> (s1.compareTo(s2)));


    }

}
