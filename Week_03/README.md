递归代码处理代码模板
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        // process result
        return;
    }
    // process current level logic
    process(level, param);
    // drill down
    recur(level + 1, newParam);
    // restore current status
}

回溯的相关题目汇总
https://leetcode-cn.com/problems/combination-sum-iii/
https://leetcode-cn.com/problems/combination-sum-ii/
https://leetcode-cn.com/problems/combination-sum/
https://leetcode-cn.com/problems/combinations/
https://leetcode-cn.com/problems/bracket-lcci/
https://leetcode-cn.com/problems/generate-parentheses/
https://leetcode-cn.com/problems/permutations/
https://leetcode-cn.com/problems/permutations-ii/