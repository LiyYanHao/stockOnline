package com.Arithmetic.leetcode;

import com.Arithmetic.PrintUtil;
import com.DesignPattern.headfirst.designpatterns.combining.adapter.GooseAdapter;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyh on 2019/6/27
 */
public class LeetCodeCH1078 {
    /**
     * 14
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     */
    @Test
    public void longestCommonPrefixTest() {
        String[] strs = {"flower", "flow", "flight"};
        String s = longestCommonPrefix(strs);
        PrintUtil.toMyString(s);

    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder r = new StringBuilder();
        HashMap<Character, Integer> m = new HashMap<>();
        flag:
        while (true) {
            int a = 0;
            boolean b = false;
            for (int i = 1; i < strs.length; i++) {
                if (strs[0].charAt(a) == strs[i].charAt(a)) {
                    if ( 0 > r.indexOf("" + (strs[i].charAt(a)))){
                        r.append(strs[i].charAt(a));
                    }
                } else {
                    b = true;
                    break flag;
                }
            }
            if (b) {
                break;
            }
            a++;
            if (a <= strs[0].length()) {
                break;
            }
        }
        return r.toString();
    }

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，
     * 即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
     * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
     * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，
     * 数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     */

    @Test
    public void romanToIntTest() {
        int xxvii = romanToInt("XXVII");
        PrintUtil.toMyString(xxvii);

    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> romeTOArabic = new HashMap<>();
        romeTOArabic.put('I', 1);
        romeTOArabic.put('V', 5);
        romeTOArabic.put('X', 10);
        romeTOArabic.put('L', 50);
        romeTOArabic.put('C', 100);
        romeTOArabic.put('D', 500);
        romeTOArabic.put('M', 1000);
        int r = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            Integer d = romeTOArabic.get(c[i]);
            Integer e = 0;
            if (i + 1 < c.length) {
                e = romeTOArabic.get(c[i + 1]);
            }
            if (d < e) {
                r = r - d;
            } else {
                r = r + d;
            }
        }
        return r;

    }


    /**
     * 9
     * 判断一个整数是否是回文数。
     * 回文数是指正序（从左向右）
     * 和倒序（从右向左）读都是一样的整数。
     */
    @Test
    public void isPalindromeTest() {
        isPalindrome(123456789);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        boolean a = true;
        int b = 0;
        while (x != 0) {
            int c = x % 10;
            if (b == 0) {
                b = c;
            } else {
                b = b * 10 + c;
            }
            x = x / 10;
        }
        if (tmp == b) {
            return true;
        }
        System.out.println(b);
        return false;


    }


    /**
     * 2.
     * 给出两个 非空 的链表用来表示两个非负的整数。
     * 其中，它们各自的位数是按照 逆序 的方式存储的，
     * 并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，
     * 则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，
     * 这两个数都不会以 0 开头。
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    @Test
    public void addTwoNumberstest() {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);


        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        while (true) {
            int val = listNode.val;
            System.out.println(val);
            listNode = listNode.next;
            if (listNode == null) {
                break;
            }
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode nodeAdd(ListNode tmpL) {
        if (tmpL == null) {
            tmpL = new ListNode(1);
            return tmpL;
        }
        int i1 = tmpL.val + 1;
        if (i1 >= 10) {
            tmpL.val = i1 % 10;
            tmpL.next = nodeAdd(tmpL.next);
        } else {
            tmpL.val = i1;
        }
        return tmpL;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = l1.val;
        int num2 = l2.val;
        int nodeNum = num1 + num2;
        int i = nodeNum % 10;
        //ListNode nextl1 = l1.next;
        //ListNode nextl2 = l2.next;
        if (i != nodeNum) {
            if (l1.next == null) {
                l1.next = new ListNode(1);
                l1.val = i;
            } else {
                if (nodeNum == i) {
                    l1.val = i;
                } else {
                    l1.val = i;
                    l1.next = nodeAdd(l1.next);
                }
            }
        } else {
            l1.val = nodeNum;
        }
        if (l1.next == null) {
            if (l2.next == null) {
                return l1;
            }
            l1.next = new ListNode(l2.next.val);
            l2.next.val = 0;
        }
        if (l2.next == null) {
            return l1;
        }
        ListNode listNode = addTwoNumbers(l1.next, l2.next);
        l1.next = listNode;
        return l1;
    }


    /**
     * 1.
     * 给定一个整数数组 nums 和一个目标值 target，
     * 请你在该数组中找出和 为目标值的那两个整数，
     * 并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。
     * 但是，你不能重复利用这个数组中同样的元素
     */
    @Test
    public void TestTwoSum() {
        LeetCodeCH1078 leetCodeCH1078 = new LeetCodeCH1078();
        int[] nums = {3, 2, 4};
        int[] ints = leetCodeCH1078.twoSum2(nums, 6);
        PrintUtil.toMyString(ints);
    }

    /**
     * 方法一：暴力法
     * 暴力法很简单，遍历每个元素 xx，并查找是否存在一个值与 target - xtarget−x 相等的目标元素。
     * 时间复杂度：O(n^2)O(n
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，
     * 这将耗费 O(n)O(n) 的时间。因此时间复杂度为 O(n^2)O(n
     * 空间复杂度：O(1)O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int othHalf = 0;
        for (int i = 0; i < nums.length; i++) {
            othHalf = target - nums[i];
            result[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == othHalf) {
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 方法三：一遍哈希表
     * 事实证明，我们可以一次完成。
     * 在进行迭代并将元素插入到表中的同时，
     * 我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     * 如果它存在，那我们已经找到了对应解，并立即将其返回。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int othHalf = target - nums[i];
            if (hash.containsKey(othHalf)) {
                result[0] = hash.get(othHalf);
                result[1] = i;
            }
            hash.put(nums[i], i);
        }
        return result;
    }


}
















