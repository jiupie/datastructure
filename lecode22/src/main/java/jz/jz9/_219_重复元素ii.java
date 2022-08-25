package jz.jz9;

import java.util.HashMap;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *
 * @author 南顾北衫
 * @date 2022/8/25
 */
public class _219_重复元素ii {
    public static void main(String[] args) {
//        int nums[] = {1, 2, 3, 1};
        int nums[] = {1, 0, 1, 1};
//        int nums[] = {1,2,3,1,2,3};
//        int nums[] = {0, 1, 2, 3, 2, 5};

        System.out.println(containsNearbyDuplicate(nums, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                Integer j = hashMap.get(nums[i]);
                if (Math.abs(i - j) <= k) {
                    return true;
                } else {
                    hashMap.put(nums[i], i);
                }
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return false;
    }
}
