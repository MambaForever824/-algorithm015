package com.geekuniversity.algorithm.homework.week1;

/**
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位，数组中每个元素只存储单个数字。
 *
 * 可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 解题思路：
 * 1、暴力解法
 * 先遍历整个数组，将数组串联成一个整数，对整数+1，然后在把这个整数拆分成数组
 * 时间复杂度是O(2N)，相当于遍历数组两次
 *
 * 2、进位解法
 * 从后往前遍历数组，最后一位加1，如果结果等于10，就进行进位，给前一个数字进行加法
 *
 * 注意 ，如果数组为[9]或者全9的数组，数组长度增加1，第一位放1
 */
public class OnePlus {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int carry = 1;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            int val = sum % 10;
            digits[i] = val;
            carry = sum / 10;
        }
        if (carry > 0) {
            digits = new int[len + 1];
            digits[0] = carry;
        }
        return digits;
    }
}