package jz.carl;

/**
 * @author 南顾北衫
 * @date 2023/4/11
 */
public class _19_ {
    public static void main(String[] args) {
        _19_ v = new _19_();

        int[] arr = {1, 2, 5};
        System.out.println(v.change(5, arr));
        System.out.println(v.change(500, arr));
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        dp[0][0] = 1;
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
        }


        //组合
        //先物品
        for (int i = 1; i < coins.length; i++) {
            //在包
            for (int j = 0; j <= amount; j++) {
                if (coins[i] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length - 1][amount];
    }
}
