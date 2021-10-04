package 剑指offer;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class _42_连续子数组的最大和 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sum(nums));
    }

    public static int sum(int nums[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int end = i; end < nums.length; end++) {
                sum += nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
