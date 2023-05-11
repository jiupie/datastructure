package jz.carl.hash;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author 南顾北衫
 * @date 2023/4/21
 */
public class _5_ {
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] temNum = new int[nums.length];
        System.arraycopy(nums, 0, temNum, 0, nums.length);

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        int[] targetArr = null;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                targetArr = new int[2];
                targetArr[0] = nums[left];
                targetArr[1] = nums[right];
            }
            if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        if (targetArr != null) {
            int[] arr = new int[]{-1, -1};
            for (int i = 0; i < temNum.length; i++) {
                if (temNum[i] == targetArr[0] && arr[0] == -1) {
                    if (!set.contains(i)) {
                        set.add(i);
                        arr[0] = i;
                    }
                }
                if (temNum[i] == targetArr[1] && arr[1] == -1) {
                    if (!set.contains(i)) {
                        set.add(i);
                        arr[1] = i;
                    }
                }
            }
            return arr;
        }

        return targetArr;
    }
}
