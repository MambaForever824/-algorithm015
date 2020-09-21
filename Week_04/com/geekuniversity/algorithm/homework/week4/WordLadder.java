package com.geekuniversity.algorithm.homework.week4;

import java.util.*;

/**
 * 单词接龙(https://leetcode-cn.com/problems/word-ladder/description/)
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的【长度】。
 * 转换需遵循如下规则：
 * 每次转换【只能改变一个字母】。
 * 转换过程的【中间单词】必须是字典中的单词。
 *
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
public class WordLadder {

    /**
     * 单词接龙
     *
     * @param beginWord 开始单词
     * @param endWord   目标单词
     * @param wordList  字典
     * @return 转换序列长度
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordList.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (changeWordEveryLetter(currWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 对 currentWord 修改每一个字符，看是否能与 endWord 匹配
     *
     * @param currentWord 当前单词
     * @param endWord     目标单词
     * @param queue       存放单词的队列
     * @param visited     已访问过的队列
     * @param wordSet    单词字典表
     * @return true-匹配，false-不匹配
     */
    private boolean changeWordEveryLetter(String currentWord,
                                          String endWord,
                                          Queue<String> queue,
                                          Set<String> visited,
                                          Set<String> wordSet) {
        // abc，def
        char[] wordLetters = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            // 先保存，后恢复
            char origin = wordLetters[i];
            for (char letter = 'a'; letter <= 'z'; letter++) {
                if (letter == origin) {
                    continue;
                }
                // 进行字母替换
                wordLetters[i] = letter;
                String nextWord = String.valueOf(wordLetters);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            wordLetters[i] = origin;
        }
        return false;
    }
}