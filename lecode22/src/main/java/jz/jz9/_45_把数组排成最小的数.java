package jz.jz9;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * 3 5 9 30 34
 *
 * @author 南顾北衫
 */
public class _45_把数组排成最小的数 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        minNumber(nums);
    }

    public static String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return null;
    }


    static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;

        int value = nums[left];

        while (l!= r) {
            while (l < r && nums[r] >= value) {
                r--;
            }

            while (l < r && nums[l] <= value) {
                l++;
            }

            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }

        nums[left] = nums[l];
        nums[l] = value;
        quickSort(nums, left, l-1);
        quickSort(nums, l + 1, right);

    }
}
