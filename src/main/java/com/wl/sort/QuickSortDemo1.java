package com.wl.sort;

import java.util.Arrays;

/**
 * @author 南顾北衫
 */
public class QuickSortDemo1 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 55, 454, 123, 748, 454, 12, 1, 23, 12, 48, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[], int left, int right) {
        if (left > right) {
            return;
        }
        //主键值
        int key = arr[left];

        int l = left;

        int r = right;

        while (l != r) {
            //一定要先从右边找
            while (arr[r] >= key && l < r) { //要有=
                --r;
            }
            while (arr[l] <= key && l < r) {
                ++l;
            }
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = key;
        quickSort(arr, left, r - 1);
        quickSort(arr, l + 1, right);
    }

}
