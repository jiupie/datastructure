package jz.jz9;

import java.util.Arrays;

/**
 * @author 南顾北衫
 */
public class _21_调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] s = {1, 2,3, 5};
        exchange(s);
        System.out.println(Arrays.toString(s));
    }

    public static int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {

            //左 奇数  找到偶数
            while (left<nums.length&&nums[left] % 2 != 0) {
                left++;
            }

            //右偶数   找到奇数
            while (right>0&&nums[right] % 2 == 0) {
                right--;
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        return nums;
    }
}
