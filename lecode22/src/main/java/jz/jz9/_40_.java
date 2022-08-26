package jz.jz9;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @author 南顾北衫
 * @date 2022/8/26
 */
public class _40_ {
    public static void main(String[] args) {
        int[] s = {3,2, 1};
//        int[] s = {0, 0, 2, 3, 2, 1, 1, 2, 0, 4};
        System.out.println(Arrays.toString(getLeastNumbers(s, 2)));
    }


    public static int[] getLeastNumbers(int[] arr, int k) {
//        quickSort(0, arr.length - 1, arr);
//        bubble(arr);
//        select(arr);
        return heap(arr, k);
//         return arr;
    }

    //堆
    private static int[] heap(int[] arr, int k) {
        //建堆 下滤
        for (int i = (arr.length >> 1) - 1; i >= 0; i--) {
            swineDown(i, arr, arr.length);
        }


        int[] ints = new int[k];

//        //大顶堆 最大的
        int heapSize = arr.length;
//        while (heapSize > 1 && k >= 0) {
//            --heapSize;
//
//            int temp = arr[0];
//            ints[k--] = temp;
//
//            arr[0] = arr[heapSize];
//            arr[heapSize] = temp;
//
//
//            swineDown(0, arr, heapSize);
//        }

        for (int i = 0; i < k; i++) {

            --heapSize;

            int temp = arr[0];
            ints[i] = temp;

            arr[0] = arr[heapSize];
            arr[heapSize] = temp;


            swineDown(0, arr, heapSize);
        }
        return ints;

    }


    private static void swineDown(int index, int[] arr, int heapSize) {
        //下滤
        int half = heapSize >> 1;
        int ele = arr[index];
        while (index < half) {
            int left = (index << 1) + 1;

            int child = arr[left];
            int childIndex = left;

            int right = childIndex + 1;


            if (right < heapSize && arr[right] < child) {
                child = arr[right];
                childIndex = right;
            }

            if (ele <= child) {
                break;
            }
            arr[index] = child;
            index = childIndex;
        }
        arr[index] = ele;
    }

    //选择
    public static void select(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (temp > nums[j]) {
                    temp = nums[j];
                    index = j;
                }
            }
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    //冒泡
    public static void bubble(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int num = nums[j];
                    nums[j] = nums[i];
                    nums[i] = num;
                }
            }
        }
    }

    //快排
    public static void quickSort(int left, int right, int[] nums) {
        if (left > right) {
            return;
        }
        int key = nums[left];
        int l = left;
        int r = right;
        while (l != r) {
            while (l < r && key <= nums[r]) {
                r--;
            }


            while (l < r && key >= nums[l]) {
                l++;
            }

            if (l != r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        //
        nums[left] = nums[l];
        nums[l] = key;

        quickSort(left, l - 1, nums);
        quickSort(l + 1, right, nums);
    }
}
