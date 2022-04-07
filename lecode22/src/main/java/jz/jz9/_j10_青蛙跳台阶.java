package jz.jz9;

/**
 * @author 南顾北衫
 */
public class _j10_青蛙跳台阶 {
    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

    public static int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1])%1000000007;
        }
        return dp[n - 1];
    }
}
