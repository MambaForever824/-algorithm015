package com.geekuniversity.algorithm.homework.week4;

import java.util.*;

/**
 * 最小基因变化
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 *
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了【一次】基因变化。
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个【基因库】。
 *
 * 现在给定3个参数 — start, end, bank，分别代表【起始基因序列】，【目标基因序列】及【基因库】，
 * 请找出能够使 起始基因序列 变化为 目标基因序列 所需的最少变化次数。
 * 如果无法实现目标变化，请返回 -1。
 *
 * 注意:
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 */
public class MinimumGeneticMutation {

    private int count = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        return bfs(start, end, bank);
//        Set<String> visited = new HashSet<>();
//        dfs(0, start, end, bank, visited);
//        return count == Integer.MAX_VALUE ? -1 : count;
    }

    /**
     * 广度优先搜索，通过维护一个queue，保存在【基因库】中的序列
     * 1、出队，当前队列中所有的元素；
     * 2、如果当前的字符串变化正好是【目标值】就返回count的值；
     * 3、如果不是就将当前的一个字符进行替换，查看是否在【基因库】，是否先前访问过；
     * 4、判断：
     *    A. 当前的字符串【是否被访问过】，被访问过说明陷入了循环，不可能变成目标值；
     *    B. 当前的字符串【是否在基因库】，如果在，就记录这个新的字符串被访问过，并且把这个新字符串加入到【队列】中；
     * 5、把当前层所有的可能性放入到【队列】中，当前层全记录完后当前的count++;
     * 6、进入到下一层，同样的逻辑；
     */
    private int bfs(String start, String end, String[] bank) {
        List<String> geneticBanks = new ArrayList<>();
        for (String str : bank) {
            geneticBanks.add(str);
        }
        char[] genetics = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int count = 0;
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String geneticSeq = queue.poll();
                if (geneticSeq.equals(end))
                    return count;
                char[] arrays = geneticSeq.toCharArray();
                for (int i = 0; i < arrays.length; i++) {
                    char oldGenetic = arrays[i];
                    for (char c : genetics) {
                        arrays[i] = c;
                        String newGenetic = new String(arrays);
                        if (!visited.contains(newGenetic) && geneticBanks.contains(newGenetic)) {
                            visited.add(newGenetic);
                            queue.offer(newGenetic);
                        }
                    }
                    arrays[i] = oldGenetic;
                }
                size--;
            }
            count++;
        }
        return -1;
    }

    /**
     * 深度优先算法
     * 从【基因库】中查看与当前字符串差一个字符的字符串
     * 可能存在这样的情况，一个字符串已经被访问但是【基因库】中没有和当前字符串相差1的字符串
     * 这并不代表基因库中的这个字符串作废，仅仅是针对当前情况失效， 我们必须从已访问中移除，他很可能就是最后和end差1个字符的字符串也未可能
     */
    private void dfs(int stepCount, String start, String end, String[] bank, Set<String> visited) {
        if (start.equals(end)) {
            count = Math.min(count, stepCount);
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            int diff = 0;
            for (int j = 0; j < 8; j++) {
                if (bank[i].charAt(j) != start.charAt(j)) diff++;
                if (diff > 1) break;
            }
            if (diff == 1 && !visited.contains(bank[i])) {
                visited.add(bank[i]);
                dfs(stepCount + 1, bank[i], end, bank, visited);
                visited.remove(bank[i]);
            }
        }
    }
}