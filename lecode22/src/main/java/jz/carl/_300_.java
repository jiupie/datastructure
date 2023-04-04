package jz.carl;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * <p>
 * 输出：4
 * <p>
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * <p>
 * 输出：4
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * <p>
 * 输出：1
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
 *
 * @author 南顾北衫
 * @date 2023/4/4
 */
public class _300_ {

    //[4,10,4,3,8,9]
    //以nums[i]结尾，每次遍历更新
    //以4结尾  [1,2,1,1,2,2]
    //以10结尾 [1,2,1,1,2,2]
    //以4结尾  [1,2,1,1,2,2]
    //以3结尾  [1,2,1,1,2,2]
    //....

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }
            }
        }

        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
