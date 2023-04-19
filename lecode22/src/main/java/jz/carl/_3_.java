package jz.carl;

/**
 * @author 南顾北衫
 * @date 2023/4/17
 */
public class _3_ {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            while (start < nums.length && nums[start] != val) {
                start++;
                count++;
            }

            while (end >= 0 && nums[end] == val) {
                end--;
            }


            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        return count;
    }

    public int removeElement1(int[] nums, int val) {
        int fastIndex = 0;
        int slowIndex = 0;
        for (; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }

        return slowIndex;
    }

}
