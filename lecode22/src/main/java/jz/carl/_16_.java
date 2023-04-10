package jz.carl;

/**
 * @author 南顾北衫
 * @date 2023/4/10
 */
public class _16_ {


    public int findTargetSumWays(int[] nums, int target) {
        //x-(sum-x)=target
        //x=(target+sum)/2
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }
        int x = (target + sum) / 2;
        if ((x & 1) == 1) {
            return 0;
        }
        int[][] dp = new int[nums.length][x + 1];

        dp[0][nums[0]] = 1;


        //物品
        for (int i = 1; i < nums.length; i++) {
            //背包容量
            for (int j = 1; j <= x; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][x];
    }
}
