package jz.carl;

/**
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * <p>
 * 链接：https://leetcode.cn/problems/combination-sum-iv
 *
 * @author 南顾北衫
 * @date 2023/4/11
 */
public class _21_ {
    public static void main(String[] args) {
        _21_ v = new _21_();
        int[] a = {1, 2, 3};
        System.out.println(v.combinationSum4(a, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }

        //排列
        //先包
        for (int i = 1; i <= target; i++) {
            //在物品
            for (int j = 1; j < nums.length; j++) {
                for (int k = 0; k <= j; k++) {
                    if (i >= nums[k]) {
                        dp[j][i] += dp[j][i - nums[k]];
                    }
                }
            }

        }

        return dp[nums.length - 1][target];
    }
}
