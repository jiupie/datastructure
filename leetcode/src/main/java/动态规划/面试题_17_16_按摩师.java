package 动态规划;

/**
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 * <p>
 * <p>
 * 示例 1：
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * <p>
 * 示例 2：
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * <p>
 * 示例 3：
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 */
public class 面试题_17_16_按摩师 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        System.out.println(massage(nums));
    }


    public static int massage(int[] nums) {

//        return recu(nums, nums.length - 1);
//        return dp(nums, nums.length - 1);
        return dp2(nums, nums.length - 1);
    }

    /**
     * 动态规划
     * 状态压缩使用滚动数组
     *
     * @param nums
     * @return
     */
    public static int dp2(int[] nums, int index) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[1];
        }
        int[] temp = new int[2];
        temp[0] = nums[0];
        temp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < temp.length; i++) {
            int a = nums[i] + temp[i - 2];
            int b = temp[i - 1];
            temp[1] = Math.max(a, b);
            temp[0] = b;
        }
        return temp[1];
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int dp(int[] nums, int index) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[1];
        }
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        temp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < temp.length; i++) {
            int a = nums[i] + temp[i - 2];
            int b = temp[i - 1];
            temp[i] = Math.max(a, b);
        }
        return temp[index];
    }


    /**
     * 递归
     *
     * @param nums
     * @return
     */
    public static int recu(int[] nums, int index) {
        if (nums.length == 0) {
            return 0;
        }
        if (index == 0) {
            return nums[0];
        } else if (index == 1) {
            return Math.max(nums[0], nums[1]);
        } else {
            int a = nums[index] + recu(nums, index - 2);
            int b = recu(nums, index - 1);
            return Math.max(a, b);
        }
    }
}
