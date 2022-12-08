package jz.datastructure;

import java.util.Arrays;

/**
 * @author 南顾北衫
 * @date 2022/12/8
 */
public class Sort {

    void mergeSort(int[] arr) {
        spilt(arr, 0, arr.length);
    }

    void spilt(int[] arr, int left, int right) {
        if (right - left < 2) {
            return;
        }
        int mid = (left + right) >> 1;
        spilt(arr, left, mid);
        spilt(arr, mid, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int ai = left;
        int rightIndex = mid;
        int l = 0;

        int leftLen = mid - left;

        int[] leftArr = new int[arr.length / 2];
        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = arr[left + i];
        }

        while (l < leftLen) {
            if (rightIndex < right && leftArr[l] >= arr[rightIndex]) {
                arr[ai] = arr[rightIndex];
                ai++;
                rightIndex++;
            } else {
                arr[ai] = leftArr[l];
                ai++;
                l++;
            }
        }


    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 0, 2, 7, 1, 9, 3, 10};
        Sort sort = new Sort();
        sort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
