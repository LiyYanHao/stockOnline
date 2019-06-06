package com;

import org.junit.Test;

import java.util.*;

/**
 * Created by lyh on 17-5-25.
 */
public class Main {
    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("1", "a");
//        map.put("2", "b");
//        map.put("3", "c");
//        map.put("4", "d");
//        map.put("5", "e");
//        processMap(map, "3");
//        System.out.println(map);


            System.out.println(txt());




    }

    static int txt(){
                     int a=1;
                     try {

                                a++;
                                 return a;

                           }finally{
                            System.out.println("adasdasdasd");

                          }
                }

    public static void processMap(Map map, String key) {
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String keyTmp = iter.next();
            if (keyTmp.equals(key)) {
                iter.remove();
            }

        }
    }
    @Test
    public void testRemoveIntInList(){
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        System.out.println(ints.size());
        Integer integer = 1;
        ints.remove(integer);
        System.out.println(ints.size());
    }

    @Test
    public void testAdd() {
        Course c1 = new Course("1", "数据结构");//创建课程对象的实例
        Course c2 = new Course("2", "C语言");
        Course c3 = new Course("3", "离散数学");
        Course c4 = new Course("4", "汇编语言");
        Course c5 = new Course("5", "数据结构");
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
        courses.add(c5);
        System.out.println(courses.size());
        Course cc3 = new Course("2", "C语言");
        courses.remove(cc3);
        System.out.println(courses.size());
        int i = courses.indexOf(cc3);
        courses.remove(i);
        System.out.println(courses.size());

    }

    class Course {
        String s1;
        String s2;

        public Course(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }


}
