package com.wl.practice;

import java.util.Arrays;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class FastSort {
    public static void main(String[] args) {
        int[] i = {23, 5, 65, 524, 7, 34, 2};
        sort(i, 0, i.length - 1);
        System.out.println(Arrays.toString(i));

    }

    /**
     * 右边比key小的时候就停下来
     * 左边比key大的时候停下来
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static void sort(int[] nums, int left, int right) {
        //递归基
        if (left > right) {
            return;
        }
        //key
        int key = nums[left];
        int l = left;
        int r=right;
        while (left < right) {
            //右边
            while (nums[right] >=key && left < right) {
                right--;
            }

            //左边
            while (nums[left] <= key && left < right) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        //交换key
        nums[l] = nums[left];
        nums[left] = key;
        sort(nums, l, left - 1);
        sort(nums, left + 1, r);
    }

}
