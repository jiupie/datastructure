package 动态规划;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class _198_打家劫舍 {
    public static void main(String[] args) {
        int n[] = {2, 7, 9, 3, 1};
        System.out.println(rob(n));
    }

    public static int rob(int[] nums) {
        return rob1(nums, nums.length);
    }

    public static int rob1(int[] nums, int n) {
        if (n <= 3) {
            return Math.max(Math.max(nums[0] + nums[2], nums[1] + nums[3]), nums[0] + nums[3]);
        }

        int sum1 = rob1(nums, n - 2);
        int sum2 = rob1(nums, n - 3);

        return Math.max(sum1, sum2);
    }

}
