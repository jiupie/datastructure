package jz.carl;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author 南顾北衫
 * @date 2023/4/11
 */
public class _23_ {
    public static void main(String[] args) {
        _23_ v = new _23_();

//        int[] arr = {1, 2, 5};
        int[] arr = {186, 419, 83, 408};
        System.out.println(v.coinChange(arr, 6249));
//        System.out.println(v.coinChange(arr, 500));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        //组合
        //先物品
        for (int i = 0; i < coins.length; i++) {
            //包
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
