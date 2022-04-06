package jz.jz9;

import java.util.Arrays;

/**
 * 连续数组最大和
 *
 *
 * @author 南顾北衫
 */
public class _53_最大子数组和 {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray(arr);
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(Math.max(nums[0] + nums[1], nums[1]),nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] =Math.max(dp[i-1] + nums[i], nums[i]);
        }
        System.out.println(Arrays.toString(dp));

        return 0;
    }
}
