package jz.jz9;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 *  
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * <p>
 * 输出: 6
 * <p>
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author 南顾北衫
 * @date 2023/4/3
 */
public class _42_ {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    //[-2,1,-3,4,-1,2,1,-5,4]
    //[-2]                      a[0]  sum(0)
    //[-2,1]                    a[1]  sum(0,1)
    //[-2,1,-3]                 a[2]  sum(0,2) sum(1,2)
    //[-2,1,-3,4]               a[3]  sum(0,3) sum(1,3)  sum(2,3)

    //dp[i-1]<0 nums[i]
    //       >0 sum(2,3)


    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
