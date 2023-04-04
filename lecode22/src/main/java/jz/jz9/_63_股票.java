package jz.jz9;

/**
 * @author 南顾北衫
 * @date 2023/4/3
 */
public class _63_股票 {
    //动态规划
    //重叠子问题
    // [7,1,5,3, 6,4]
    // 7 1                              0
    // 7 1  7 5  1 5                    4
    // 7 1  7 5  1 5  7 3  1 3  5 3     4        dp[i-1] > a[i] =   dp[i]=dp[i-1]
    // 7 1  7 5  1 5  7 3  1 3  5 3    7 6  1 6  5 6  3 6    5          dp[i-1] < a[i] =   6-min(a[0:i-1])
    //  dp[i-1] > a[i] =   dp[i]=dp[i-1]
    //  dp[i-1] < a[i] =   6-min(a[0:i-1])

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            if (dp[i - 1] >= prices[i]) {
                dp[i] = dp[i - 1];
            } else {
                int min = -1;
                for (int j = 0; j < i; j++) {
                    if (min == -1) {
                        min = prices[j];
                    } else {
                        if (prices[j] < min) {
                            min = prices[j];
                        }
                    }
                }

                dp[i] = Math.max(dp[i - 1], prices[i] - min);
            }
        }

        return dp[prices.length - 1];
    }
}
