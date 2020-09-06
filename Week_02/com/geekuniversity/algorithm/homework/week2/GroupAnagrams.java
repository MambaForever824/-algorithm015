package com.geekuniversity.algorithm.homework.week2;

import java.util.*;

/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * Leetcode: https://leetcode-cn.com/problems/group-anagrams/
 *
 * 解题思路
 * 这道题目可以理解为【字母异位】的升级版，只是需要遍历数组
 *
 * 1、使用排序进行暴力解法
 * 时间复杂度：O(N* K * logN），其中K为字符串长度
 *
 * 2、使用数组计数器比较
 * 时间复杂度：O(N* K），其中K为字符串长度
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagramsBySort(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new LinkedList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsByCounter(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new LinkedList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counter = new int[26];
            for (char c : str.toCharArray()) {
                counter[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int val : counter) {
                sb.append("#");
                sb.append(val);
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList());
            }
            map.get(sb.toString()).add(str);
        }
        return new ArrayList(map.values());
    }
}
