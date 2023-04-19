package jz.carl;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 南顾北衫
 * @date 2023/4/18
 */
public class _4_ {
    public static void main(String[] args) {
        _4_ v = new _4_();
        int[] arr = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(v.sortedSquares(arr)));
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left <= right && Math.abs(nums[left]) < Math.abs(nums[right])) {
                nums[right] = nums[right] * nums[right];
                right--;
            }
            int temp = nums[left] * nums[left];
            for (int i = left + 1; i <= right; i++) {
                nums[i - 1] = nums[i];
            }
            nums[right] = temp;
            right--;
        }

        return nums;
    }
}
