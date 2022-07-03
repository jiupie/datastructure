package jz.jz9;

/**
 * class Solution {
 * public int maxValue(int[][] grid) {
 * int[][] ints = new int[grid.length][grid[0].length];
 * ints[0][0]= grid[0][0];
 * for (int i = 1; i < grid.length; i++) {
 * ints[i][0] = ints[i - 1][0] + grid[i][0];
 * }
 * for (int i = 1; i < grid[0].length; i++) {
 * ints[0][i] = ints[0][i - 1] + grid[0][i];
 * }
 * for (int i = 1; i < grid.length; i++) {
 * for (int j = 1; j < grid[0].length; j++) {
 * ints[i][j] = Math.max(ints[i - 1][j],ints[i][j - 1]) + grid[i][j];
 * }
 * }
 * return ints[grid.length - 1][grid[0].length - 1];
 * }
 * }
 *
 * @author 南顾北衫
 * @description
 * @date 2022/7/3
 */
public class _22_礼物最大价值 {

    public static void main(String[] args) {
        int[][] s = {
                {1, 2,5},
                {3, 2, 1}
        };
        maxValue(s);
    }


    public static int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public int maxValue1(int[][] grid) {
        int[][] ints = new int[grid.length][grid[0].length];
        ints[0][0]= grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            ints[i][0] = ints[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            ints[0][i] = ints[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                ints[i][j] = Math.max(ints[i - 1][j],ints[i][j - 1]) + grid[i][j];
            }
        }
        return ints[grid.length - 1][grid[0].length - 1];
    }
}
