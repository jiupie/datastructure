package jz.carl;

/**
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * <p>
 * 输出：4
 *
 * @author 南顾北衫
 * @date 2023/4/13
 */
public class _29_ {
    public static void main(String[] args) {
        _29_ v = new _29_();
        int[] arr = {1, 2, 3, 1};
        System.out.println(v.rob(arr));
        System.out.println(v.rob1(arr));
    }

    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return backtrack(nums, nums.length - 1);
    }

    public int backtrack(int[] nums, int index) {
        if (index <= 0) {
            return nums[0];
        }
        return Math.max(backtrack(nums, index - 1), backtrack(nums, index - 2) + nums[index]);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }
}
