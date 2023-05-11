package jz.carl.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author 南顾北衫
 * @date 2023/4/21
 */
public class _8_ {
    public static void main(String[] args) {
        _8_ v = new _8_();
        int[] arr = {-2, 0, 1, 1, 2};
//        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(v.threeSum(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        ArrayList<List<Integer>> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        int left = 1;
        int right = nums.length - 1;
        int sum = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            sum = 0;
            sum += nums[i];
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int res = sum + nums[left] + nums[right];
                if (res == 0) {
                    String s = nums[i] + "" + nums[left] + "" + nums[right];
                    if (!set.contains(s)) {
                        list.add(List.of(nums[i], nums[left], nums[right]));
                        set.add(s);
                    }
//                    left++;
                    right--;
                } else if (res < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
