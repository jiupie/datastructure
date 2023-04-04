package jz.jz9;

/**
 * @author 南顾北衫
 * @date 2023/4/3
 */
public class _14_ {
    public static void main(String[] args) {
        System.out.println(cuttingRope(18));
    }

    //10
    //1 1
    //2 2
    //3 3
    //4 2*2 3*1
    //5

    public static int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }

        return dp[n];
    }
}
