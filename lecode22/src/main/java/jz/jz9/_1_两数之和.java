package jz.jz9;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * @author 南顾北衫
 */
public class _1_两数之和 {
    public static void main(String[] args) {
        int []nums={2,7,11,15};

        System.out.println(Arrays.toString(twoSum(nums,9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }
}
