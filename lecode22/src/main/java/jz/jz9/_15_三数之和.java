package jz.jz9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 *
 * @author 南顾北衫
 * @date 2022/8/29
 */
public class _15_三数之和 {
    public static void main(String[] args) {
        //-4 -1 -1 0 1 2
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2, 0, 1, 1, 2};
//        [-2,0,0,2,2]
        System.out.println(threeSum(nums));
        System.out.println(threeSum1(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    String s = nums[i] + "" + nums[left] + nums[right];
                    if (!hashSet.contains(s)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        resultList.add(list);
                        hashSet.add(s);
                    }
                    //注意：为0的时候需要 left right 变量怎么变化 不然会死循环 结束语句
                    left++;
                    right--;
                }
            }
        }
        return resultList;
    }


    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    break;
                }
                int sum = nums[left] + nums[i] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    resultList.add(list);
                    //注意：为0的时候需要 left right 变量怎么变化 不然会死循环 结束语句

                    while (left<right&&nums[left]==nums[++left]){

                    }

                    while(left<right&&nums[right]==nums[--right]){}
                }
            }
        }
        return resultList;
    }
}
