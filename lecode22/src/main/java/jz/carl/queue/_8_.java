package jz.carl.queue;

import java.util.*;

/**
 * @author 南顾北衫
 * @date 2023/4/27
 */
public class _8_ {
    public static void main(String[] args) {
        _8_ v = new _8_();
        int[] nums = {5, 2, 5, 3, 5, 3, 1, 1, 3};


        int[] ints = v.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Integer[] values = map.values().toArray(new Integer[0]);
        buildHeap(values);


        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = removeTop(values);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < ints.length; i++) {
            for (Map.Entry<Integer, Integer> entry : entries) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if (!set.contains(key) && value == ints[i]) {
                    ints[i] = key;
                    set.add(key);
                    break;
                }
            }
        }
        return ints;

    }

    int size;

    public void buildHeap(Integer[] nums) {
        size = nums.length;
        for (int i = (nums.length >> 1); i >= 0; i--) {
            swiftDown(nums, i);
        }
    }

    public int removeTop(Integer[] nums) {

        int num = nums[0];
        nums[0] = nums[size - 1];
        nums[size - 1] = num;
        --size;
        swiftDown(nums, 0);

        return num;
    }


    public void swiftDown(Integer[] nums, int index) {
        int half = size >> 1;
        while (index < half) {
            int leftIndex = (index << 1) + 1;
            int rightIndex = (index << 1) + 2;

            int maxIndex = leftIndex;
            int max = nums[leftIndex];

            if (rightIndex < size && nums[rightIndex] > nums[leftIndex]) {
                maxIndex = rightIndex;
                max = nums[rightIndex];
            }

            if (max > nums[index]) {
                nums[maxIndex] = nums[index];
                nums[index] = max;
                index = maxIndex;
            } else {
                break;
            }
        }
    }
}
