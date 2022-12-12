package jz.jz9;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * @author 南顾北衫
 * @description
 * @date 2022/7/9
 */
public class _40_最小的k个数 {

    private int size = 0;

    public static void main(String[] args) {
        _40_最小的k个数 k = new _40_最小的k个数();
        int[] s = {0, 1, 2, 1};
        int[] leastNumbers = k.getLeastNumbers(s, s.length);
        System.out.println(Arrays.toString(leastNumbers));

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        //构建堆
//        for (int i = 1; i < arr.length; i++) {
//            swiftUp(arr, i);
//        }

        this.size = arr.length;

        for (int i = (arr.length >> 1) - 1; i >= 0; i--) {
            swiftDown(arr, i);
        }
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = removeTop(arr);
        }
        return ints;
    }

    public int removeTop(int[] arr) {
        int i = arr[0];
        arr[0] = arr[--size];
        swiftDown(arr, 0);
        return i;
    }

    public void swiftUp(int[] arr, int index) {
        //跟父节点比较，比父节点小上浮
        while (index > 0) {
            int parent = (index - 1) >> 1;
            if (arr[index] < arr[parent]) {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            } else {
                break;
            }
            index = parent;
        }
    }

    public void swiftDown(int[] arr, int index) {
        int leaf = size >> 1;
        while (index < leaf) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;
            int minIndex = 0;
            int minVal = 0;
            if (leftIndex < arr.length && rightIndex < arr.length) {
                if (arr[leftIndex] < arr[rightIndex]) {
                    minVal = arr[leftIndex];
                    minIndex = leftIndex;
                } else {
                    minVal = arr[rightIndex];
                    minIndex = rightIndex;
                }
            } else if (leftIndex < arr.length && rightIndex >= arr.length) {
                minVal = arr[leftIndex];
                minIndex = leftIndex;
            }
            if (arr[index] >= minVal) {
                arr[minIndex] = arr[index];
                arr[index] = minVal;
                index = minIndex;
            } else {
                break;
            }
        }

    }
}
