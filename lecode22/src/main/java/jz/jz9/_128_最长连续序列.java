package jz.jz9;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * <p>
 * 输出：4
 * <p>
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * @author 南顾北衫
 */
public class _128_最长连续序列 {
    public static void main(String[] args) {
//        int nums[] = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int nums[] = {1, 2, 0, 1};
//        int nums[] = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 1;
        int count = 1;


        int k = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == (nums[i - 1] + 1) && nums[i] != k) {
                count++;
            } else if (nums[i] == nums[i - 1]) {
                k = nums[i];
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }

        return res;
    }


}
