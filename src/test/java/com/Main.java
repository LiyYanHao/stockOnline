package com;

import org.apache.spark.sql.sources.In;
import org.junit.Test;
import sun.awt.SunHints;

import java.math.BigDecimal;
import java.util.*;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;

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
//            int i=0;
//            ++i;
//            System.out.println(i);


        int reverse = reverse(1231);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {//实现反转
            int pop = x % 10;
            x = x / 10;
            //判断是否越界
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            } else if (res < Integer.MIN_VALUE / 10
                    || (res == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            res = res * 10 + pop;
        }

        return res;
    }


    static int txt() {
        int a = 1;
        try {

            a++;
            return a;

        } finally {
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
    public void testRemoveIntInList() {
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
