package jz.carl;

import java.util.HashSet;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * <p>
 * 输出: true
 * <p>
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * <p>
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * <p>
 * 输出: true
 * <p>
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * <p>
 * 注意，你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * <p>
 * 输出: false
 * <p>
 * 链接：https://leetcode.cn/problems/word-break
 *
 * @author 南顾北衫
 * @date 2023/4/12
 */
public class _26_ {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {

        //排列 先包 再物
        HashSet<String> dictSet = new HashSet<>(wordDict);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && dp[i] == 0; j++) {
                if (dictSet.contains(s.substring(j, i)) && dp[j] == 1) {
                    dp[i] = 1;
                }
            }
        }

        return dp[s.length()] == 1;
    }


}
