package jz.jz9;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p/>
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * <p/>
 * 示例2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * @author 南顾北衫
 */
public class _53_II_中缺失的数字 {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int[] nums = { 1,2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(missingNumber1(nums));
    }

    public int missingNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums[0] != 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            index = i;
            if (nums[i] != nums[i + 1] + 1) {
                return nums[i] + 1;
            }
        }
        return index == 0 && nums[index] > 0 ? nums[nums.length - 1] - 1 : nums[nums.length - 1] + 1;
    }

    /**
     * 二分 左右区分
     * @param nums
     * @return
     */
    public static int missingNumber1(int[] nums) {

        int mid = nums.length / 2;
        int tempMid = mid;
        if (tempMid == nums[mid]) {
            while (tempMid < nums.length) {
                if (nums[tempMid] == tempMid) {
                    tempMid++;
                } else {
                    return tempMid;
                }
            }
            int leftMid = mid;
            while (leftMid >= 0) {
                if (nums[leftMid] == leftMid) {
                    leftMid--;
                } else {
                    return leftMid;
                }
            }
        } else {
            if (tempMid <nums[mid]) {
                //左边
                for (int i = 0; i <= mid; i++) {
                    if (nums[i] != i) {
                        return i;
                    }
                }
            }else {
                //左边
                for (int i = nums.length-1; i <= mid; i--) {
                    if (nums[i] != i) {
                        return i;
                    }
                }
            }
        }
        return tempMid;
    }


}
