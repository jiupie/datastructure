package com.wl.sort;

import com.wl.sort.utils.Sort;

/**
 * QuickSort class
 *
 * @author 南顾北衫
 * @date 2020/5/16 16:05
 * @email 17674641491@163.com
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    public void quickSort(T arr[], int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return;
        }
        //key
        T key = arr[leftIndex];

        int left = leftIndex;
        int right = rightIndex;

        while (left != right) {
            //右边都是比key大的 为了找出比key小的值
            while (!(cmp(arr[right], key) < 0) && left < right) {
                right--;
            }
            //左边都是比key小的  为了找出比Key大的值
            while (!(cmp(arr[left], key) > 0) && left < right) {
                left++;
            }
            //交换左边跟右边
            if (left < right) {
                swap(left, right);
            }
        }
        //交换key和left
        arr[leftIndex] = arr[left];
        arr[left] = key;
        quickSort(arr, leftIndex, left - 1);
        quickSort(arr, left + 1, rightIndex);
    }

    @Override
    protected void sort() {
        quickSort(array, 0, array.length - 1);
    }
}
