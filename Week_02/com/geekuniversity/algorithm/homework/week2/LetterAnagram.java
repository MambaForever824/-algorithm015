package com.geekuniversity.algorithm.homework.week2;

/**
 * 字母异位：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * Leetcode地址: https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * 解法分析
 * 1、排序
 * 方法：将两个字符串转换成字符数组，对数组先排序然后进行比较；
 * 时间复杂度：O(nlogn), 因为数组排序时间复杂度是O(logn)，比较的时间复杂度是O(n)；
 * 空间复杂度：O(1), 空间取决于排序实现，如果使用 heapsort，通常需要 O(1)O(1) 辅助空间。
 * 注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n)O(n) 额外的空间
 *
 * 2、使用Hash
 * 方法：创建一个长度为26的数组，用每个字母的ASCII码➖'a'作为下标，使用这个数组计数器来分别记录元素的数量
 * 因为我们可以用一个计数器表计算 s 字母的频率，用 t 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零
 * 时间复杂度：O(n)，因为遍历数组是固定长度
 * 空间复杂度：O(1)，尽管我们使用了额外的空间，但是空间的复杂性是 O(1)O(1)，因为无论 NN 有多大，表的大小都保持不变
 */
import java.util.Arrays;

public class LetterAnagram {

    /**
     * 通过排序方式进行比较
     * 时间复杂度: O(NlogN)
     * 空间复杂度：O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramBySort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }

    /**
     * 使用ASCII码数组计数，判断数组中每个值是否最终等于0
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramByHash(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int num : counter) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
