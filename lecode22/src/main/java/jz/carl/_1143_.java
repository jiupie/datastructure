package jz.carl;

public class _1143_ {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars = text1.toCharArray();
        char[] chars1 = text2.toCharArray();



        int res = -1;
        int[][] dp = new int[chars.length + 1][chars1.length + 1];
        for (int i = 1; i <= chars.length; i++) {
            for (int j = 1; j <= chars1.length; j++) {
                if (chars[i - 1] == chars1[j - 1]) {
                    int i1 = dp[i - 1][j - 1];
                    dp[i][j] = i1 + 1;
                    if (res == -1 || res < dp[i][j]) {
                        res = dp[i][j];
                    }
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return res == -1 ? 0 : res;
    }
}
