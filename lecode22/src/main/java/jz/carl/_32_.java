package jz.carl;

/**
 * @author 南顾北衫
 * @date 2023/4/14
 */
public class _32_ {
    //[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        //0:第i天持有
        //1:第i天不持有
        // -7 0
        // -1 0
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
            if (dp[i][1] > max) {
                max = dp[i][1];
            }
        }
        return max;

    }
}
