package 贪心策略;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class _53_最大子序列和 {
    public static void main(String[] args) {
//        int[] nums = {8};
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-2, -1};

//        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }

    /**
     * 分治求法
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        return maxSubArray2(nums, 0, nums.length);
    }

    public static int maxSubArray2(int[] nums, int begin, int end) {
        if (end - begin < 2) {
            return nums[begin];
        }
        int mid = (begin + end) >> 1;

        int lefMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            lefMax = Math.max(lefMax, leftSum);
        }
        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid ; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return Math.max(lefMax + rightMax,
                Math.max(maxSubArray2(nums, begin, mid),
                        maxSubArray2(nums, mid, end)));
    }


    /**
     * 暴力求解法
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int begin = 0;
        for (begin = 0; begin < nums.length; begin++) {
            int sum = 0;
            for (int end = begin; end < nums.length; end++) {
                sum += nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
