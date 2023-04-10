package jz.carl;

import java.util.Arrays;

/**
 * @author 南顾北衫
 * @date 2023/4/10
 */
public class BinaryTree {
    private int[] nums;
    private int size;

    public void build(int[] nums) {
        this.nums = nums;
        size = nums.length;
        for (int i = (nums.length >> 1) - 1; i >= 0; i--) {
            down(nums, i);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] a = {88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 36, 43, 37};

        binaryTree.build(a);
        System.out.println(Arrays.toString(binaryTree.nums));
        binaryTree.sort();
        System.out.println(Arrays.toString(binaryTree.nums));
    }

    public void sort() {
        while (size > 0) {
            size--;
            int num = nums[0];
            nums[0] = nums[size];
            nums[size] = num;
            down(nums, 0);
        }
    }

    public void down(int[] nums, int index) {
        int half = size >> 1;
        while (half > index) {
            int leftIndex = (index << 1) + 1;
            int rightIndex = (index << 1) + 2;

            int max = nums[leftIndex];
            int maxIndex = leftIndex;

            if (rightIndex < size && nums[rightIndex] > nums[leftIndex]) {
                maxIndex = rightIndex;
                max = nums[rightIndex];
            }

            if (nums[index] > max) {
                break;
            }

            nums[maxIndex] = nums[index];
            nums[index] = max;

            index = maxIndex;
        }

    }
}
