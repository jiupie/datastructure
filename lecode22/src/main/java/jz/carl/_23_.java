package jz.carl;

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

        int[][] dp = new int[coins.length][amount + 1];

        dp[0][0] = 0;
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[0][i] = dp[0][i - coins[0]] + 1;
        }

        //组合
        //先物品
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i] <= j) {
                    if (dp[i - 1][j] == 0) {
                        dp[i][j] = dp[i][j - coins[i]] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - coins[i]] + 1, Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1));
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length - 1][amount] == 0 ? -1 : dp[coins.length - 1][amount];
    }
}
