package jz.carl;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * <p>
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * 链接：https://leetcode.cn/problems/is-subsequence
 *
 * @author 南顾北衫
 * @date 2023/4/6
 */
public class _392_ {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int i = 0;
        int j = 0;
        while (i < sChars.length && j < tChars.length) {
            if (tChars[j] == sChars[i]) {
                i++;
                j++;
            } else {
                j++;
            }
        }


        return i == sChars.length;
    }


    //s = "abc"
    //t = "ahbgdc"
    public boolean isSubsequence1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();


        int res = 0;
        int[][] dp = new int[sChars.length + 1][tChars.length + 1];
        for (int i = 1; i <= sChars.length; i++) {
            for (int j = 1; j <= tChars.length; j++) {
                if (sChars[i - 1] == tChars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                if (res < dp[i][j]) {
                    res = dp[i][j];
                }
            }
        }


        return res== sChars.length;
    }
}
