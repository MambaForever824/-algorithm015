package com.geekuniversity.algorithm.homework.week7;

import java.util.*;

/**
 * 单词接龙(https://leetcode-cn.com/problems/word-ladder/)
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
public class WordLadder {

    private Set<String> words = new HashSet<>();

    private Set<String> visited = new HashSet();

    private Queue<String> queue = new LinkedList<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        words.addAll(wordList);
        if (words.size() == 0 || !words.contains(endWord)) {
            return 0;
        }
        words.remove(beginWord);
        queue.offer(beginWord);
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();
                if (changeWord(currentWord, endWord)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean changeWord(String currentWord, String endWord) {
        char[] letters = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char origin = letters[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == origin) {
                    continue;
                }
                letters[i] = c;
                String nextWord = String.valueOf(letters);
                if (words.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            letters[i] = origin;
        }
        return false;
    }
}