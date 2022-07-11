package jz.jz9;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 南顾北衫
 */
public class _57_和为s的两个数字 {

    public static void main(String[] args) {
        int[] ints = {10, 26, 30, 31, 47, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80};
        int target = 90;
        long start = System.currentTimeMillis();
        System.out.println(start);

        int[] ints1 = twoSum1(ints, target);

        int[] ints2 = twoSum(ints, target);


        int[] ints3 = twoSum2(ints, target);


        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));
        System.out.println(Arrays.toString(ints3));
    }


    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int leave = target - nums[i];
            if (leave < 0) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (leave == nums[j]) {
                    ints[0] = nums[i];
                    ints[1] = nums[j];
                }
            }
        }

        return ints;
    }


    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        int[] ints = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int leave = target - nums[i];
            if (leave < 0) {
                break;
            }
            int mid = nums.length >> 1;

            if (nums[mid] > leave) {
                //往左
                while (mid >= 0) {
                    if (mid != i && nums[mid] == leave) {
                        ints[0] = nums[i];
                        ints[1] = nums[mid];
                        return ints;
                    } else {
                        mid--;
                    }
                }
            } else if (nums[mid] < leave) {
                while (mid < nums.length) {
                    if (mid != i && nums[mid] == leave) {
                        ints[0] = nums[i];
                        ints[1] = nums[mid];
                        return ints;
                    } else {
                        mid++;
                    }
                }
            } else {
                ints[0] = nums[i];
                ints[1] = nums[mid];
            }

        }

        return ints;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int[] ints = new int[2];

        while (left < right) {
            int i = nums[left] + nums[right];
            if (i > target) {
                right--;
            }
            if (i < target) {
                left++;
            }
            if (i == target) {
                ints[0] = nums[left];
                ints[1] = nums[right];
                break;
            }
        }
        return ints;
    }

}
