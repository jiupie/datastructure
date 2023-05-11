package jz.carl;

/**
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 *
 * @author 南顾北衫
 * @date 2023/4/13
 */
public class _30_ {
    public static void main(String[] args) {
        _30_ v = new _30_();
        int[] arr = {1, 2, 3, 1};
        System.out.println(v.rob(arr));
     }
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //[1,2,3,1,2]
        return Math.max(robRange(nums, 0, nums.length - 2),
                robRange(nums, 1, nums.length-1));
    }


    public int robRange(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 1];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[end];
    }
}
