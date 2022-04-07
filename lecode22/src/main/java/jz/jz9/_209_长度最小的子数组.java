package jz.jz9;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * 示例:  输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * @author 南顾北衫
 */
public class _209_长度最小的子数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
//        int[] nums = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};


        System.out.println(minSubArrayLen(11, nums));
        System.out.println(minSubArrayLen2(11, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    res = Math.min(j - i + 1, res);
                }
            }
        }
        if (res != Integer.MAX_VALUE) {
            return res;
        } else {
            return 0;
        }
    }


    public static int minSubArrayLen2(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0;
        int r = -1;

        int res = nums.length+1;
        int sum = 0;

        while (r < nums.length) {
            while (r < nums.length) {
                r++;
                if (r < nums.length) {
                    sum += nums[r];
                }
                if (sum >= target) {
                    res = Math.min(r - l + 1, res);
                    break;
                }
            }
            if (r == nums.length) {
                break;
            }
            while (l < r) {
                sum -= nums[l];
                l++;
                if (sum >= target) {
                    res = Math.min(r - l + 1, res);
                } else {
                    break;
                }
            }
        }

        return res != nums.length+1 ? res : 0;
    }
}
