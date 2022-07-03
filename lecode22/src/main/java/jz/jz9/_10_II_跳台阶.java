package jz.jz9;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/7/3
 */
public class _10_II_跳台阶 {
    public static void main(String[] args) {
        numWays(7);
    }

    public static int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n] > 1000000007 ? dp[n] : dp[n] % 1000000007;
    }
}
