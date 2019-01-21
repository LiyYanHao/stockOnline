package com.算法.数据结构与算法分析java.chapter_1;

/**
 * @author lyh on 2018/12/29
 */
public class chapter_1 {


    public static int bad(int n) {
        if (n == 0) {
            return 0;
        } else {
            return bad(n / 3 + 1) + n - 1;
        }

    }

    //原始递归方法
    public static long fib(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    //优化递归方法
    public static int maxSubSuml(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubSuml2(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubSuml3(int[] a) {
        int maxSum = 0;
        int thisMax = 0;
        for (int i = 0; i < a.length; i++) {
            thisMax += a[i];
            if (maxSum < thisMax) {
                maxSum = thisMax;
            } else if (thisMax < 0) {
                thisMax = 0;
            }
        }
        return maxSum;
    }

    private static int maxSumRec(int[] a, int left, int right) {
        int maxSum = 0;
        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }
        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (maxLeftBorderSum < leftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center; i < right; i++) {
            rightBorderSum += a[i];
            if (maxRightBorderSum < rightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max3(maxLeftBorderSum, maxRightBorderSum, leftBorderSum + rightBorderSum);
    }

    public static int max3(int a, int b, int c) {
        int max = a > b ? a : b;
        max = max > c ? max : c;
        return max;
    }

    /**
     * 折半查找
     *
     * @param a
     * @param x
     * @param <AnyType>
     * @return
     */
    public static <AnyType extends Comparable<? super AnyType>>
    int binarySearch(AnyType[] a, AnyType x) {
        int low = 0, high = a.length - 1;
        while (low == high) {
            int mid = (low + high) / 2;
            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0){
                high = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 欧几里得求两个数的最大公约数
     * @param m
     * @param n
     * @return
     */
    public static long gcd(long m,long n){
        while (n != 0){
            long rem=m%n;
            m=n;
            n=rem;
        }
        return m;
    }

//    public static long pow(long x,int n){
//        if(n==0){
//            return 1;
//        }
//        if(n == 1){
//            return x;
//        }
//        if (isE)
//    }


    public static void main(String[] args) {
//        bad(10);
//        System.out.println(fib(30));
//        System.out.println(improve_fib(30));11
//        String name = "李艳好";
//        System.out.println(name.substring(0, 1) + "*" + name.substring(name.length() - 1, name.length()));
        int arr2[] = {1, 2, 3, 4, 45, 566, -110, 8, -100, 120, 9, -11, 20};
        int a = maxSubSuml(arr2);
        int a2 = maxSubSuml2(arr2);
        int a3 = maxSubSuml3(arr2);

        System.out.println(a + "++++" + a2 + "+++" + a3);

    }
}
