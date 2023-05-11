package jz.carl.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author 南顾北衫
 * @date 2023/4/21
 */
public class _9_ {
    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        HashSet<String> set = new HashSet<>();
        ArrayList<List<Integer>> list = new ArrayList<>();

        int left, right;
        long sum;
        for (int i = 0; i <= nums.length - 4; i++) {
            for (int j = i + 1; j <= nums.length - 3; j++) {
                left = j + 1;
                right = nums.length - 1;
                sum = nums[i] + nums[j];
                while (left < right) {
                    long sum1 = sum + nums[left] + nums[right];
                    if (sum1 == (long) target) {
                        String s = "" + nums[i] + nums[j] + nums[left] + nums[right];
                        if (!set.contains(s)) {
                            set.add(s);
                            list.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        }
                        left++;
                    } else if (sum1 < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return list;
    }
}
