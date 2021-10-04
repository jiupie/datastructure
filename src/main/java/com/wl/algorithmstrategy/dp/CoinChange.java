package com.wl.algorithmstrategy.dp;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class CoinChange {
    public static void main(String[] args) {
        int faces[] = {1, 5, 20, 25};
        System.out.println(coinChange(7));
    }

    /**
     * 暴力递归
     *
     * @return
     */
    public static int coinChange(int n) {
        if (n < 1) {
            return Integer.MAX_VALUE;
        }
        if (n == 1 || n == 5 || n == 20 || n == 25) {
            return 1;
        }
        int min1 = Math.min(coinChange(n - 1), coinChange(n - 5));
        int min2 = Math.min(coinChange(n - 20), coinChange(n - 25));

        return Math.min(min1, min2) + 1;
    }
}
