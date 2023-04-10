package jz.carl;

/**

 * @author 南顾北衫
 * @date 2023/4/10
 */
public class _13_ {
    public static void main(String[] args) {
        _13_ v = new _13_();
        int[] ints = {1, 5, 11, 5};
        System.out.println(v.canPartition(ints));
        System.out.println(v.canPartition1(ints));

    }

    public boolean canPartition1(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        int[][] dp = new int[nums.length][target + 1];

        for (int i = nums[0]; i <= target; i++) {
            dp[0][i] = nums[0];
        }
        //物品
        for (int i = 1; i < nums.length; i++) {
            //背包容量
            for (int j = 1; j <= target; j++) {
                //dp[i-1][j]:不放物品
                //dp[i-1][j-nums[i]]+nums[i]
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length-1][target]==target;

    }


    public boolean canPartition(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        int[] dp = new int[target + 1];

        //物品
        for (int i = 0; i < nums.length; i++) {
            //背包容量
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;

    }
}
